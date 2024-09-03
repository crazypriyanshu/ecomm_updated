package priyanshudev.demo.client.escuelajs.dtos;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class ProxyCategoryDto {
    private Long id;
    private String name;
    private String description;
    private String image;
    private String creationAt;
    private String updatedAt;

}
