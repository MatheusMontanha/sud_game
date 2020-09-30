package sud.Models;

import lombok.Data;

import java.util.List;

@Data
public class Inventory {

    private int space;
    private int spaceAvaliable;
    private List<ItemInventary> items;

    public Inventory(int space, int spaceAvaliable, List<ItemInventary> items) {
        this.space = space;
        this.spaceAvaliable = spaceAvaliable;
        this.items = items;
    }

}
