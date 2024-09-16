package priyanshudev.demo.controllers;

import jakarta.annotation.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import priyanshudev.demo.client.authenticationClients.AuthenticationClient;
import priyanshudev.demo.client.authenticationClients.dto.InvalidTokenDto;
import priyanshudev.demo.client.authenticationClients.dto.Role;
import priyanshudev.demo.client.authenticationClients.dto.SessionStatus;
import priyanshudev.demo.client.authenticationClients.dto.ValidateTokenResponseDto;
import priyanshudev.demo.dtos.CreateProductDto;
import priyanshudev.demo.exceptions.NotFoundException;
import priyanshudev.demo.models.Product;
import priyanshudev.demo.service.ProductService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private ProductService productService;
    @Autowired
    private AuthenticationClient authenticationClient;

    @GetMapping("withCategory")
    public ResponseEntity<List<Product>> productWithId() {

        List<Product> product = productService.productWithCategory();
        ResponseEntity<List<Product>> response = new ResponseEntity<>(product, HttpStatus.OK);
        return response;
    }
    @GetMapping("/{id}")
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

    @PostMapping("")
    public ResponseEntity<Product> addProduct(@RequestBody CreateProductDto product) throws NotFoundException {
    Product newProduct = productService.addNewProduct(product);
    ResponseEntity<Product> response = new ResponseEntity(newProduct, HttpStatus.CREATED);
    return new ResponseEntity(newProduct, HttpStatus.CREATED);
    }

//    @PutMapping("/product/{id}")
//    public ResponseEntity<Product> updateProduct(@PathVariable Long id, @RequestBody ProxyProductDto productDto) throws NotFoundException {
//        Product newProduct = productService.updateProduct(id,productDto);
//        ResponseEntity<Product> response = new ResponseEntity(newProduct, HttpStatus.OK);
//        return response;
//    }


    // Only admins can see all products
    @GetMapping("")
    public ResponseEntity<List<Product>> getAllProducts(@Nullable @RequestHeader("AUTH_TOKEN") String token,
                                                        @Nullable @RequestHeader("USER_ID") Long userId ) throws NotFoundException {
        // if token exists
        if (token == null) {
            throw new RuntimeException("Token is null or invalid");
        }
        if (token.isEmpty() || token == null || userId == null) {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
        //validate token
        ValidateTokenResponseDto response = authenticationClient.validate(token, userId);

        if(response.getSessionStatus().equals(SessionStatus.INVALID) || response.getSessionStatus().equals(SessionStatus.EXPIRED)){
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
        boolean isUserAdmin = false;
        for (Role role: response.getUserDto().getRoles())
        {
            if (role.getName().equals("ADMIN")) {
                isUserAdmin = true;
                break;
            }
        }
        if(!isUserAdmin) {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }

        // Rest template
        RestTemplate rt = new RestTemplate();
        ResponseEntity<List<Product>> responseEntity = new ResponseEntity(productService.getAllProducts(), HttpStatus.OK);
        return responseEntity;
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable Long id) throws NotFoundException {
        productService.deleteById(id);
    }

//    @ExceptionHandler(NotFoundException.class)
//    public ResponseEntity<ErrorResponseDto> notFoundError(Exception ex) {
//        ErrorResponseDto errorResponseDto = new ErrorResponseDto();
//        errorResponseDto.setMessage(ex.getMessage());
//        return new ResponseEntity<>(errorResponseDto, HttpStatus.NOT_FOUND);
//
//    }
}
