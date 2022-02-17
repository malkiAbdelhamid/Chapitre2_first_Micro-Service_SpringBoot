package com.esisba.exemple_cours.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor
public class Compte {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCompte;

    private String login;
    private String password;
    private Date dateCreation;

    @ManyToOne
    @JoinColumn(name="idclient")
    private Client client;
}
