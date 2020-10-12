package sud.map;

import lombok.val;
import sud.models.enemies.Boss;
import sud.screen.Interface;

public class BossRoom extends MonsterRoom {
    public BossRoom(int xPosition, int yPosition) {
        super(xPosition, yPosition);
        this.enemy = new Boss();

    }

    @Override
    public RoomState onRoomEnter() {
        Interface.printTexts(new String[]{
                "*Você entra em uma sala escura, e sente uma presença maligna*",
                "*Você estaria tremendo de medo, se tivesse um corpo*",
                "*Sua alma apenas grita \"MORTE\", seu unico instinto é tentar fugir*",
                "*Então, você escuta uma vóz, uma vóz muito sombria*",
                "Corrumpidor: Parece que você conseguiu me encontrar, criança",
                "Corrumpidor: Aposto que você deve ter encontrado algum de seus irmãos pelo caminho.",
                "Corrumpidor: Corcorda comigo que eles ficaram muito mais magnificos estando corrompidos?",
                "Corrumpidor: Todos tentaram me derrotar para livrar os demais, mas falharam miseravelmente.",
                "Corrumpidor: Você vai tentar também, estou certo?",
                "Corrumpidor: Sinto lhe informar, mas você também fracassará, e irá se tornar um com eles.",
                "Corrumpidor: Meros espiritos como vocês não podem me fazer um unico arranhão.",
                "Corrumpidor: Agora venha, criança! Tente seu melhor, que lhe prometo uma demorada e dolorosa morte",
        });
        return RoomState.UNTOUCHED;
    }

    @Override
    protected RoomResult onLose() {
        Interface.printTexts(new String[]{
                "Corrumpidor: Hahahaha, exatamente como eu pensei.",
                "Corrumpidor: Ninguém é pareo para mim!",
                "Corrumpidor: Porém, gostei de nossa batalha. Não lhe matarei",
                "Corrumpidor: Irei fazer um coisa muito melhor",
                "Corrumpidor: Lhe emprestarei meu poder. Você se tornará um de nós",
                "Corrumpidor: Um corrompido!",
                "*Sua mente começa a esvainir, uma raiva incontrolavel começa a tomar conta de você*",
                "Corrumpidor: Se você ver um de seus irmãos, não tenha medo de ataca-los",
                "Corrumpidor: Eles não terão outra alternativa a não ser atacar você também",
                "Corrumpidor: Agora vá, meu corrompido, vague por essas terras pela eternidade.",
        });
        return super.onLose();
    }

    @Override
    protected RoomResult onWin() {
        Interface.printTexts(new String[]{
                "*A criatura que estava em sua frente, começa a lentamente desaparecer*",
                "Corrumpidor: *ofegante* É...",
                "Corrumpidor: *ofegante* Parece que... no fim... fui derrotado!",
                "Corrumpidor: *ofegante* Um dia... outros como eu irão aparecer",
                "Corrumpidor: *ofegante* Lembre-se... sempre onda há luz, há escuridão",
                "Corrumpidor: *ofegante* É apenas uma questão de tempo...",
                "*A criatura some, a presença maligna não existe mais*",
                "*O ambiente começa a ficar mais claro, uma luz distante surge*",
                "*Outros, puros, como você começam a aparecer, aparentemente confusos*",
                "*Você nota que eles eram seres que haviam sido corrompidos, mas agora estão libertos*",
                "*Então você segue em direção há luz, e entra nela*",
                "*Agora você vê arvores, um belo ceu azul*",
                "*Tudo que você quer agora é correr, aproveitar esse lindo lugar*",
                "*Então aproveite, você venceu a escuridão, a vida é só uma*",
                "*Saia da frente desse computador e vá aproveitar enquanto ainda pode*",
                "*Nunca se sabe quando a escuridão retornará*",
        });
        return RoomResult.GAME_SUCCESS;
    }
}
