package opgave.webshoprest.services;

import opgave.webshoprest.model.Product;
import opgave.webshoprest.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


public class ProductServices {

    ProductRepository productRepository;

    public ProductServices(ProductRepository pr){
        this.productRepository = pr;
    }

    public ProductRepository getProductRepository() {
        return productRepository;
    }
}
