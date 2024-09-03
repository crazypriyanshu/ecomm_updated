package priyanshudev.demo.client.escuelajs.dtos;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Setter
@Getter
@ToString
public class ProxyProductDto {
    private Long id;
    private String title;
    private int price;
    private String description;
    private String[] images;
    private String creationAt;
    private String updatedAt;
    private ProxyCategoryDto category;

}
