package tn.esprit.claimfacturesservice.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User implements Serializable {
    @Id
   // @GeneratedValue(strategy= GenerationType.IDENTITY)
    private String idUser;

    private String firstName;

    private String lastName;

    private String username;

    private String email;

    private String password;

    private String phonenumber;

    private String country;

    private String gouvernment;

    private boolean etat;

    private Long phone;

    private boolean disponibilite;

    private int age;

    private  int nbrAvertissment ;

    private  boolean banned;




    @JsonIgnore
    @ManyToMany(cascade = CascadeType.ALL)
    /*@JoinTable(
            name = "FavorisProduct",
            joinColumns = @JoinColumn(name = "idUser"),
            inverseJoinColumns = @JoinColumn(name = "idFavori"))*/
    private List<FavoriProduct> favoris ;


    @OneToMany(mappedBy = "userclaim")
    private List<Claim> claimList;

    @OneToMany(mappedBy = "userRating")
    private List<RatingProduct> ratingProductList;


    @OneToMany(mappedBy = "userProduct")
    private List<Product> productListUser;

    @OneToMany(mappedBy = "usedBy")
    private List<Discount> discounts ;

    @OneToMany(mappedBy = "user")
    private List<Cart> carts ;

    @JsonIgnore
    @OneToMany(mappedBy = "user")
    private List<LikeComment> likeComments;

    @JsonIgnore
    @OneToMany(mappedBy = "user")
    private List<DislikeComment> dislikeComments;

    @OneToMany(mappedBy = "userPost")
    private List<Post>posts;

    @OneToMany(mappedBy = "userComment")
    List<CommentPost>commentList;

	 @OneToMany(mappedBy = "user")
    private List<Facture> factureList;


    @ManyToOne
    private DeliveryCompany deliveryCompany;



}
