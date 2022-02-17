package com.esisba.exemple_cours.repository;

import com.esisba.exemple_cours.entities.ClientDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface ClientDetailRepository extends JpaRepository<ClientDetail,Long> {
}
