package priyanshudev.demo.client.escuelajs.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import priyanshudev.demo.client.escuelajs.dtos.CreateProxyProductDto;
import priyanshudev.demo.client.escuelajs.dtos.ProxyProductDto;
import priyanshudev.demo.client.escuelajs.helper.Helper;
import priyanshudev.demo.exceptions.NotFoundException;

import java.util.Arrays;
import java.util.List;


public class Client {
    @Autowired
    private Helper helper;
    @Autowired
    private RestTemplateBuilder restTemplateBuilder;

    public Client(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplateBuilder = restTemplateBuilder;
    }

    public List<ProxyProductDto> getAllProducts() throws NotFoundException {
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<ProxyProductDto[]> response = restTemplate.getForEntity(
                "https://api.escuelajs.co/api/v1/products",
                ProxyProductDto[].class
        );
        return Arrays.asList(response.getBody());
    }

    public ProxyProductDto getSingLeProduct(Long id) throws NotFoundException{
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<ProxyProductDto> response = null;
        try {
            response = restTemplate.getForEntity(
                    "https://api.escuelajs.co/api/v1/products/{id}",
                    ProxyProductDto.class,
                    id
                    );
        } catch (Exception e) {
            e.printStackTrace();
            throw new NotFoundException("Something is wrong while fetching "+ id+ " prodcut id" );
        }
        return response.getBody();
    }

    public ProxyProductDto addNewProduct(CreateProxyProductDto productDto) {
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<ProxyProductDto> response = restTemplate.postForEntity(
                "https://api.escuelajs.co/api/v1/products",
                productDto,
                ProxyProductDto.class
        );

        ProxyProductDto proxyProductDto = response.getBody();
        return proxyProductDto;
    }

    public ProxyProductDto updateProduct(Long id, ProxyProductDto proxyProductDto) throws NotFoundException {
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<ProxyProductDto> response;
        try {
            response = helper.requestForEntity(
                    "https://api.escuelajs.co/api/v1/products/{id}",
                    HttpMethod.PUT,
                    proxyProductDto,
                    ProxyProductDto.class,
                    id
            );
        } catch (Exception e) {
            e.printStackTrace();
            throw new NotFoundException("Something is wrong while updating product: "+ id+ " prodcut id" );

        }
        return response.getBody();
    }

    public boolean deleteProduct(Long id) throws NotFoundException {
        RestTemplate restTemplate = restTemplateBuilder.build();
        try {
            restTemplate.delete("http://api.escuelajs.co/api/v1/products/{id}", id);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            throw new NotFoundException("Something is wrong while deleting product: "+ id+ " prodcut id" );
        }
    }

}
