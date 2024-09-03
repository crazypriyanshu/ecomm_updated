//package priyanshudev.demo;
//
//import jakarta.transaction.Transactional;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.annotation.Rollback;
//import priyanshudev.demo.models.Category;
//import priyanshudev.demo.models.Product;
//import priyanshudev.demo.repositories.CategoryRepository;
//import priyanshudev.demo.repositories.ProductRepository;
//
//import java.util.List;
//import java.util.Optional;
//
//@SpringBootTest
//public class ProductTest {
//    @Autowired
//    ProductRepository productRepository;
//    @Autowired
//    CategoryRepository categoryRepository;
//    @Test
//    @Transactional
//    @Rollback(value = false)
//    void testProduct() {
//        Category category = categoryRepository.findById(202L).get();
//        Product product = new Product();
//        product.setPrice(12.67);
//        product.setTitle("Chulha");
//        product.setDescription("This a type of Chulha");
//        product.setCategory(category);
//        Product product1 = new Product();
//        product.setPrice(14.47);
//        product.setTitle("Barahmuda");
//        product.setDescription("dfljlsdjf lkjhdflh");
//        product.setCategory(category);
//
//        Product saveProduct = productRepository.save(product);
//    }
//
//    @Test
//    @Transactional
//    void getProductForCategory() {
//        List<Category> categories = categoryRepository.findAllByIdIn(List.of(202L, 1L, 52L, 102L, 152L, 2L));
////        Category category = categoryRepository.findById(202L).get();
////        for (Product product: category.getProducts()){
////            System.out.println(product.getPrice());
////        }
//        for (Category category: categories){
//            for (Product product: category.getProducts()) {
//                System.out.println(product.getPrice());
//            }
//        }
//    }
//}
