package opgave.webshoprest.controllers;


import opgave.webshoprest.model.Product;
import opgave.webshoprest.services.ProductServices;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RequestMapping("/products")
@RestController
public class ProductsController {

    private ProductServices productServices;

    public ProductsController(ProductServices productServices){
        this.productServices = productServices;
    }

    @GetMapping
    public ResponseEntity<List<Product>> getAllProducts(){
        ArrayList<Product> products = new ArrayList<>();
        productServices.getProductRepository().findAll().forEach(products::add);
        return ResponseEntity.status(200).body(products);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Product>> findByid(@PathVariable("id") Long id){
        Optional<Product> lookupProduct = productServices.getProductRepository().findById(id);
        if(lookupProduct.isPresent()) return ResponseEntity.status(200).body(lookupProduct);
        return ResponseEntity.status(204).body(lookupProduct);
    }




}
