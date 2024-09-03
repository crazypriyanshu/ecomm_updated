package priyanshudev.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import priyanshudev.demo.models.Product;
import priyanshudev.demo.repositories.ProductRepository;

@SpringBootTest
class ProductCatalogApplicationTests {
	@Autowired
	ProductRepository productRepository;

	@Test
	void contextLoads() {
	}

	@Test
	void testAddingProduct() {
		Product product = new Product();
		product.setTitle("Computer");
		product.setDescription("Desktop");
		product.setPrice(11.0);
		productRepository.save(product);
	}

}
