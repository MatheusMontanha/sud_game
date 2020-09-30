package sud.Models;

import java.util.List;

public class Inventory {

    private int space;
    private int spaceAvaliable;
    private List<ItemInventary> items;

    public Inventory(int space, int spaceAvaliable, List<ItemInventary> items) {
        this.space = space;
        this.spaceAvaliable = spaceAvaliable;
        this.items = items;
    }

    public int getSpace() {
        return space;
    }

    public void setSpace(int space) {
        this.space = space;
    }

    public int getSpaceAvaliable() {
        return spaceAvaliable;
    }

    public void setSpaceAvaliable(int spaceAvaliable) {
        this.spaceAvaliable = spaceAvaliable;
    }

    public List<ItemInventary> getItems() {
        return items;
    }

    public void setItems(List<ItemInventary> items) {
        this.items = items;
    }
}
