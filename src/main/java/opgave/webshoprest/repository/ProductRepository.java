package opgave.webshoprest.repository;

import opgave.webshoprest.model.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, Long>{

    Iterable<Product> findProductByName(String name);

}
