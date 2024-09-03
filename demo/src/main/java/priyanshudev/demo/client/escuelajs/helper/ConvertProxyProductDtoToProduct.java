package priyanshudev.demo.client.escuelajs.helper;

import org.springframework.stereotype.Component;
import priyanshudev.demo.client.escuelajs.dtos.ProxyProductDto;
import priyanshudev.demo.exceptions.NotFoundException;
import priyanshudev.demo.models.Category;
import priyanshudev.demo.models.Product;

import java.util.Date;

@Component
public class ConvertProxyProductDtoToProduct  {
    ProxyProductDto productDto;

    public Product convertProxyProductToProduct(ProxyProductDto productDto) throws NotFoundException {
        if (productDto == null) {
            throw new NotFoundException(" No valid data to convert convertProxyProductToProduct ");
        }
        Product product = new Product();
        product.setId(product.getId());
        product.setTitle(productDto.getTitle());
        product.setDescription(productDto.getDescription());
        product.setPrice(product.getPrice());

        Category category = new Category();
        category.setId(productDto.getCategory().getId());
        category.setDescription(productDto.getCategory().getDescription());
        category.setName(productDto.getCategory().getName());

        product.setCategory(category);
        return product;
    }

}
