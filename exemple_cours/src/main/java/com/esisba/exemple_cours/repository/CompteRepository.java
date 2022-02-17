package com.esisba.exemple_cours.repository;

import com.esisba.exemple_cours.entities.Compte;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource

public interface CompteRepository extends JpaRepository<Compte,Long> {
}
