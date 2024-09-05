package priyanshudev.demo.utils;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;
import priyanshudev.demo.dtos.CreateProductDto;
import priyanshudev.demo.models.Product;

@Getter
@Setter
@Component
public class CreateProductDtoToProductConverter {
    public Product convertToProduct(CreateProductDto productDto) {
        Product product = new Product();
        product.setTitle(productDto.getTitle());
        product.setPrice(productDto.getPrice());
        product.setDescription(productDto.getDescription());
        product.setImageUrl(productDto.getImages());
        return product;
    }
}
