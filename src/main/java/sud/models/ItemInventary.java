package sud.models;

import lombok.Data;

@Data
public class ItemInventary {
    private String name;
    private int size;
    private ItemType type;

    public ItemInventary(String name, int size, ItemType type) {
        this.name = name;
        this.size = size;
        this.type = type;
    }
}
