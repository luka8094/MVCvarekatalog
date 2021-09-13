package codealong.springproject.repository;


import codealong.springproject.model.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

//<det først i <..., ...> fortæller hvilken entity vi arbejder med, det andet
//fortæller hvad dens 'id' er
//OBS! Id må ikke være en Long
@Repository
public interface ProductRepository extends CrudRepository<Product, Integer> {



}
