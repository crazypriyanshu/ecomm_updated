package priyanshudev.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import priyanshudev.demo.client.escuelajs.dtos.CreateProxyProductDto;
import priyanshudev.demo.client.escuelajs.dtos.ProxyProductDto;
import priyanshudev.demo.client.escuelajs.helper.ConvertProxyProductDtoToProduct;
import priyanshudev.demo.client.escuelajs.service.Client;
import priyanshudev.demo.exceptions.NotFoundException;
import priyanshudev.demo.models.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Service
public class CategoryServiceEscuelajsClientImplementation implements CategoryService {

    @Override
    public String getAllCategories() {
        return "getting all categories";
    }

    @Override
    public String getCategoryById() {
        return "getting category by id";
    }
}
