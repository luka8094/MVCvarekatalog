package opgave.webshoprest.controllers;

import opgave.webshoprest.services.ReviewServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/reviews")
@RestController
public class ReviewsController {

    @Autowired
    ReviewServices reviewServices;

    ReviewsController(){ }


}
