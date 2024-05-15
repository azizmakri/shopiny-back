package tn.esprit.claimfacturesservice.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class Facture implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long idFacture;
    private String topicFacture;
    private boolean archive;
    private String reference;
    private float priceTotal;
    private Date datefacture ;
    //private String devise;
    @JsonIgnore
    @OneToOne
    private FactureAvoir factureAvoir;

    @JsonIgnore
    @OneToMany (mappedBy = "facture")
    private List<Claim> claims ;

    @JsonIgnore
    @ManyToOne
    private  User user;

    @JsonIgnore
    @OneToOne(mappedBy = "facture")
    private Delivery delivery;
}