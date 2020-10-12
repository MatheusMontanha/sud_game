package sud.map;

import lombok.val;
import sud.exceptions.NoManaException;
import sud.models.elements.Element;
import sud.models.Player;
import sud.models.Targetable;
import sud.models.enemies.Enemy;
import sud.models.items.Item;
import sud.screen.Interface;
import sud.utils.Random;

public class MonsterRoom extends Room {
    public MonsterRoom(int xPosition, int yPosition) {
        super(xPosition, yPosition);
    }

    private enum ActionResult {
        ACTION_SUCCESS, ACTION_CANCEL, NO_ACTION;
    }

    protected Enemy enemy = new Enemy();

    @Override
    public RoomState onRoomEnter() {
        if (roomState == RoomState.UNTOUCHED)
            Interface.printText("Um elemental de(a) %s corrompido apareceu", enemy.getElement().getName());
        return roomState;
    }

    @Override
    public RoomResult nextAction() {
        playerAction();
        printStatuses();
        if (isEnemyAlive()) {
            monsterAction();
            printStatuses();
        }
        return parseBattleResult();
    }

    private void printStatuses() {
        Interface.printText(">>>Vida do jogador: %s", Player.getInstance().getActualLife());
        Interface.printText(">>>Mana do jogador: %s", Player.getInstance().getActualMana());
        Interface.printText(">>>Vida do inimigo: %s", Math.max(enemy.getActualLife(), 0));
    }

    private boolean isEnemyAlive() {
        return enemy.getActualLife() > 0;
    }

    private RoomResult parseBattleResult() {
        if (Player.getInstance().getActualLife() <= 0) {
            return onLose();
        }
        if (!isEnemyAlive()) {
            return onWin();
        }
        return RoomResult.CONTINUE_ON_ROOM;
    }

    private void monsterAction() {
        if (enemy.getActualLife() <= 0) {
            Interface.printText("o inimogo está morto, n pode atacar");
            return;
        }
        try {
            attack(enemy, 0, 20, enemy.getElement(), Player.getInstance());
        } catch (NoManaException e) {

        }
    }

    private void playerAction() {

        ActionResult actionResult = ActionResult.NO_ACTION;
        do {
            Interface.printText("O que você deseja fezer?");
            Interface.printText("0 - Atacar \n1 - Usar um item");
            val selectedAction = Interface.readIntInput();
            if (selectedAction == 0) {
                actionResult = playerAttackAction();
            } else if (selectedAction == 1) {
                actionResult = playerItemAction();
            }
            Interface.printText("Por favor, escolha 0 ou 1");
        } while (actionResult != ActionResult.ACTION_SUCCESS);
    }

    private ActionResult playerItemAction() {
        return Player.getInstance().openInventory() ? ActionResult.ACTION_SUCCESS : ActionResult.ACTION_CANCEL;
    }

    private ActionResult playerAttackAction() {
        val player = Player.getInstance();
        Interface.printText("Que ataque deseja usar?");
        Interface.printText("0 - Soco espiritual (0MP, 10AP, Sem elemento)");
        Interface.printText("1 - Rajada de %s (10MP, 15AP)", player.getElement().getName());
        Interface.printText("2 - Flecha de %s (25MP, 30AP)", player.getElement().getName());
        Interface.printText("3 - Canhão de %s (45MP, 50AP)", player.getElement().getName());
        Interface.printText("4 - Voltar");
        do {
            try {
                val selectedAction = Interface.readIntInput();
                switch (selectedAction) {
                    case 0:
                        attack(player, 0, 10, null, enemy);
                        return ActionResult.ACTION_SUCCESS;
                    case 1:
                        attack(player, 10, 15, player.getElement(), enemy);
                        return ActionResult.ACTION_SUCCESS;
                    case 2:
                        attack(player, 25, 30, player.getElement(), enemy);
                        return ActionResult.ACTION_SUCCESS;
                    case 3:
                        attack(player, 45, 50, player.getElement(), enemy);
                        return ActionResult.ACTION_SUCCESS;
                    case 4:
                        return ActionResult.ACTION_CANCEL;
                }
                Interface.printText("Você deve escolher um numero entre 0 e 4");
            } catch (NoManaException e) {
                Interface.printText(e.getMessage());
            }
        } while (true);
    }

    private void attack(Targetable attacker, int mp, int ap, Element element, Targetable target) throws NoManaException {
        String attackerName = getAttackerName(attacker);
        val needed = Random.rollDice20();
        val diceResult = Random.rollDice20();
        Interface.printText("%s precisa tirar %s para atacar", attackerName, needed);
        Interface.printText("%s tirou %s", attackerName, diceResult);
        if (diceResult == 20) {
            attacker.wasteMana(mp);
            val damageDealt = target.takeDamage(ap * 1.5, element);
            Interface.printText("ATAQUE CRITICO, %s causou %s de dano", attackerName, damageDealt);
            return;
        }
        if (diceResult < needed) {
            Interface.printText("%s não conseguiu atacar", attackerName);
            return;
        }
        attacker.wasteMana(mp);
        val damageDealt = target.takeDamage(ap, element);
        Interface.printText("%s causou %s de dano", attackerName, damageDealt);
    }

    private String getAttackerName(Targetable attacker) {
        return attacker instanceof Player ? "Você" : "O Inimigo";
    }


    protected RoomResult onLose() {
        Interface.printText("###################################");
        Interface.printText("#############GAME OVER#############");
        Interface.printText("###################################");
        return RoomResult.GAME_OVER;
    }

    protected RoomResult onWin() {
        Item loot;
        boolean isWeak = Player.getInstance().getElement().hasWeaknessTo(enemy.getElement());
        boolean isStrong = Player.getInstance().getElement().isStrongAgainst(enemy.getElement());
        if (isStrong) {
            loot = Item.randomSmallItem();
        } else if (isWeak) {
            loot = Item.randomGreatItem();
        } else {
            loot = Item.randomMediumItem();
        }
        Interface.printText("Você derrotou o elemental de %s corrompido", enemy.getElement().getName());
        Interface.printText("Você encontrou uma %s e colocou no inventario", loot.getName());
        Player.getInstance().addItem(loot);
        roomState = RoomState.CLEAN;
        return RoomResult.ROOM_DONE;
    }
}
