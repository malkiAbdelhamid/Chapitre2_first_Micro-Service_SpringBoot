package com.esisba.exemple_cours.repository;

import com.esisba.exemple_cours.entities.Civility;
import com.esisba.exemple_cours.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.Date;
import java.util.List;

@RepositoryRestResource
public interface ClientRepository extends JpaRepository<Client,Long> {

    List<Client> findClientsByNom(String nom);
    List<Client> findClientsByNomAndSexe(String n, Civility s);
    List<Client> findClientsByNomIsLike(String n);
    List<Client> findClientsByDateNaissanceAfter(Date d) ;
    boolean existsByEmailContaining(String e);

    @Query("SELECT e.nom FROM Client e where e.idClient = :id")
    String findNameById(@Param("id") Long id);

    @Query("SELECT e FROM Client e where e.nom like %:keyword%")
    List<Client> findEmployeByKeywordInName(@Param("keyword") String keyword);

    @Query(value = "Select e.* from client_table e  join compte c " +
                    "on e.id_client=c.idclient " +
                    "where c.login=:login", nativeQuery = true)
    List<Client> ClientByLogin(@Param("login") String login);

}
