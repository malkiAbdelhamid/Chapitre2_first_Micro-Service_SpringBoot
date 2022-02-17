package com.esisba.exemple_cours.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@Data @AllArgsConstructor  @NoArgsConstructor
public class Adresse implements Serializable {
    private String rue;
    private Integer numero;
    private String codePostal;
    private String  ville;

}
