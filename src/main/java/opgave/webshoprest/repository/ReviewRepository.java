package opgave.webshoprest.repository;

import opgave.webshoprest.model.Review;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReviewRepository extends CrudRepository<Review, Long> {

    public Iterable<Review> findReviewByRating(int rating);
}
