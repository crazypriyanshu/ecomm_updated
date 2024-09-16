package priyanshudev.demo.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateProductDto {
    private String title;
    private String description;
    private double price;
    private Long categoryId;
    private String images;

    protected void CreateProductDto() {
        this.title = " ";
        this.description = " ";
        this.price = 0.00;
    }

    public void doSimpleThings() {
        System.out.println();

    }
}


