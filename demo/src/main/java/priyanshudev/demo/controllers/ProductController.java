package priyanshudev.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import priyanshudev.demo.client.escuelajs.dtos.CreateProxyProductDto;
import priyanshudev.demo.client.escuelajs.dtos.ProxyProductDto;
import priyanshudev.demo.exceptions.NotFoundException;
import priyanshudev.demo.models.Product;
import priyanshudev.demo.service.ProductService;

import java.util.List;
import java.util.Optional;

@RestController
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping("/products/{id}")
    public ResponseEntity<Optional<Product>> getProductById(@PathVariable Long id) throws NotFoundException {
        MultiValueMap<String, String> headers = new LinkedMultiValueMap<>();
        headers.add("con", "priyanshu-proxy-server-application");
        Optional<Product> productOptional;
        try {
            productOptional = productService.getSingleProduct(id);
        }
        catch (Exception e) {
            throw e;
        }
        if (productOptional.isEmpty()) {
            throw new NotFoundException(" No product found with id: "+id);

        }
        ResponseEntity<Optional<Product>> responseEntity = new ResponseEntity(
                productService.getSingleProduct(id).get(),
                headers,
                HttpStatus.OK
        );
        return responseEntity;
    }

    @PostMapping("/product")
    public ResponseEntity<Product> addProduct(@RequestBody CreateProxyProductDto product) throws NotFoundException {
    Product newProduct = productService.addNewProduct(product);
    ResponseEntity<Product> response = new ResponseEntity(newProduct, HttpStatus.CREATED);
    return new ResponseEntity(newProduct, HttpStatus.CREATED);
    }

    @PutMapping("/product/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable Long id, @RequestBody ProxyProductDto productDto) throws NotFoundException {
        Product newProduct = productService.updateProduct(id,productDto);
        ResponseEntity<Product> response = new ResponseEntity(newProduct, HttpStatus.OK);
        return response;
    }

    @GetMapping("/products")
    public ResponseEntity<List<Product>> getAllProducts() throws NotFoundException {
        ResponseEntity<List<Product>> responseEntity = new ResponseEntity(productService.getAllProducts(), HttpStatus.OK);
        return responseEntity;
    }

    @DeleteMapping("/product/{id}")
    public boolean deleteProduct(@PathVariable Long id) {
        return productService.deleteProduct(id);
    }

//    @ExceptionHandler(NotFoundException.class)
//    public ResponseEntity<ErrorResponseDto> notFoundError(Exception ex) {
//        ErrorResponseDto errorResponseDto = new ErrorResponseDto();
//        errorResponseDto.setMessage(ex.getMessage());
//        return new ResponseEntity<>(errorResponseDto, HttpStatus.NOT_FOUND);
//
//    }
}
