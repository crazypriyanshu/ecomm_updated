package priyanshudev.demo.client.escuelajs.dtos;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class CreateProxyProductDto {
    private Long id;
    private String title;
    private int price;
    private String description;
    private int categoryId;
    private String[] images;
    private String categoryName;
}
