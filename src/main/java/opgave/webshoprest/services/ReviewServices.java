package opgave.webshoprest.services;

import opgave.webshoprest.repository.ReviewRepository;
import org.springframework.stereotype.Service;

@Service
public class ReviewServices {

    ReviewRepository reviewRepository;

    public ReviewServices(ReviewRepository rr){
        this.reviewRepository = rr;
    }

    public ReviewRepository getReviewRepository() {
        return reviewRepository;
    }
}
