package opgave.webshoprest.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table( name = "reviews")
public class Review {

    @Id
    @Column( nullable = false )
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private long id;

    @Column( length = 255)
    String description;

    @Column( nullable = false)
    int rating;

    int likes;

    @JsonIgnore
    @ManyToOne
    @JoinColumn( name = "product_id")
    Product product;

    public Review(){ }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
