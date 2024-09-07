package priyanshudev.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import priyanshudev.demo.repositories.CategoryRepository;
import priyanshudev.demo.repositories.ProductRepository;

@SpringBootApplication
public class ProductCatalogApplication implements CommandLineRunner {
	private final ProductRepository productRepository;
	private final CategoryRepository categoryRepository;

    public ProductCatalogApplication(ProductRepository productRepository, CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
		this.categoryRepository = categoryRepository;
    }

    public static void main(String[] args) {
		SpringApplication.run(ProductCatalogApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		productRepository.findAll().forEach(product -> {
			System.out.println(product.toString());
		});
	}
}
