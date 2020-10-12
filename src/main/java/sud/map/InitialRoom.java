package sud.map;

import lombok.val;
import sud.models.Player;
import sud.models.elements.AirElement;
import sud.models.elements.FireElement;
import sud.models.elements.NatureElement;
import sud.models.elements.WaterElement;
import sud.screen.Interface;

import java.util.Arrays;

public class InitialRoom extends Room {
    public InitialRoom() {
        super(0, 0);
    }

    @Override
    public RoomState onRoomEnter() {
        return roomState;
    }

    @Override
    public RoomResult nextAction() {
        Interface.printTexts(new String[]{
                "*Você acorda, perdido, em um lugar estranho*",
                "*Você não sabe onde está, quem você é, o que você é*",
                "*Então você escuta uma vóz misteriosa*",
                "Voz misteriosa: Bom dia meu caro espirito.",
                "Voz misteriosa: Não fique assustado, você acabou de nascer",
                "Voz misteriosa: Nesse mundo, você não possui nenhum corpo fisico.",
                "Voz misteriosa: Você é apenas um ser de luz",
                "Voz misteriosa: Falando em luz, esse lugar aparenta estar meio sombrio, né?",
                "Voz misteriosa: E realmente está.",
                "Voz misteriosa: Mas nem sempre foi assim",
                "Voz misteriosa: Acontece que um ser, chamado corrumpidor, tomou conta desse lugar",
                "Voz misteriosa: Varios de seus irmãos ja foram corrompidos.",
                "Voz misteriosa: Quando você é corrompido, você se torna um ser das trevas.",
                "Voz misteriosa: Você é uma de nossas ultimas esperanças.",
                "Voz misteriosa: Lhe concederei a graça elemental.",
                "Voz misteriosa: Assim você poderá lutar contra esse ser maligno.",
        });

        val elementList = Arrays.asList(WaterElement.getInstance(), FireElement.getInstance(), NatureElement.getInstance(), AirElement.getInstance());
        Interface.printText("Escolha o seu elemento");
        for (int i = 0; i < elementList.size(); i++) {
            Interface.printText(i + " - " + elementList.get(i).getName());
        }
        do {
            val selectedElement = Interface.readIntInput();
            try {
                Player.getInstance().setElement(elementList.get(selectedElement));
            } catch (Exception e) {
                Interface.printText("Por favor, selecione um valor entre 0 e %s", (elementList.size() - 1));
            }
        } while (Player.getInstance().getElement() == null);
        Interface.printTexts(new String[]{
                "*Uma luz brilha, e então você se sente cheio de poder*",
                "Voz misteriosa: Agorá vá, meu ser de luz",
                "Voz misteriosa: Acabe com esse mal, e você poderá ir para o mundo exterior.",
                "Voz misteriosa: Lá a vida é bela, e quem sabe você pode conseguir um corpo.",
        });
        this.roomState=RoomState.CLEAN;
        return RoomResult.ROOM_DONE;
    }
}
