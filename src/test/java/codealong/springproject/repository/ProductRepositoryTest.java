package codealong.springproject.repository;

import codealong.springproject.model.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ProductRepositoryTest {

    //ved autowired ved Spring at den skal bruge ProductRepository som en tjeneste (? - i tvivl)
    @Autowired
    ProductRepository productRepository;

    @Test
    void getProducts(){
        List<Product> products = new ArrayList<>();

        productRepository.findAll().forEach( product -> products.add(product));

        //Tilfælde hvor Double colon (::) kan anvendes nedenunder
        //
        //productRepository.findAll().forEach(products::add);

        assertEquals(2, products.size());

        products.forEach(System.out::println);

    }

}