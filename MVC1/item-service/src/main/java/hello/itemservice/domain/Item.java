package hello.itemservice.domain;

import lombok.Data;

@Data // 데이터는 위험함
public class Item {

    private Long id;
    private String itemName;
    private Integer price;
    private Integer quantity;

    public Item() {
    }

    public Item(String name, Integer price, Integer quantity) {
        this.itemName = name;
        this.price = price;
        this.quantity = quantity;
    }
}
