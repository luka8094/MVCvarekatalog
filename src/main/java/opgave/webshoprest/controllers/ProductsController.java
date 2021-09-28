package opgave.webshoprest.controllers;


import opgave.webshoprest.model.Product;
import opgave.webshoprest.services.ProductServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RequestMapping("/products")
@RestController
public class ProductsController {

    @Autowired
    private ProductServices productServices;

    /*public ProductsController(ProductServices productServices){
        this.productServices = productServices;
    }*/

    ProductsController(){ }

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

    @CrossOrigin( origins = "*", exposedHeaders = "Location")
    @PostMapping
    public ResponseEntity<Product> create(@RequestBody Product product){

        Long checkProductId = (Long)product.getId();

        if(checkProductId!=null) return ResponseEntity.status(400).build();

        Product createProduct = productServices.getProductRepository().save(product);

        String location = "/student/" + createProduct.getId();

        return ResponseEntity.status(201).header("Location", location).body(product);

    }

    @PutMapping("/{id}")
    public ResponseEntity<String> update(@PathVariable Long id, @RequestBody Product product){

        Optional<Product> checkIfProduct = productServices.getProductRepository().findById(id);

        if(checkIfProduct.isPresent()){
            if(id.equals(product.getId())){
                productServices.getProductRepository().save(product);
                return ResponseEntity.status(204).build();
            }
            }else
            {
                return ResponseEntity.status(400).build();
            }

        return ResponseEntity.status(404).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id){
        Optional<Product> checkIfProduct = productServices.getProductRepository().findById(id);

        if(checkIfProduct.isPresent()){
            productServices.getProductRepository().deleteById(id);
            return ResponseEntity.status(200).build();
        }

        return ResponseEntity.status(404).build();
    }


}
