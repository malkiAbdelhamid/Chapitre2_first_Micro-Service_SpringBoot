package com.esisba.exemple_cours;

import com.esisba.exemple_cours.entities.Adresse;
import com.esisba.exemple_cours.entities.Civility;
import com.esisba.exemple_cours.entities.Client;
import com.esisba.exemple_cours.entities.ClientDetail;
import com.esisba.exemple_cours.repository.ClientDetailRepository;
import com.esisba.exemple_cours.repository.ClientRepository;
import com.esisba.exemple_cours.repository.CompteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.Date;

@SpringBootApplication
public class ExempleCoursApplication implements CommandLineRunner {

    @Autowired
    ClientRepository clientRepository;
    @Autowired
    CompteRepository compteRepository;
    @Autowired
    ClientDetailRepository clientDetailRepository;

    public static void main(String[] args) {
        SpringApplication.run(ExempleCoursApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        clientRepository.save(
                new Client(null, "malki", Civility.Homme,"a.malki@esi-sba.dz",30,
                        Date.valueOf("1989-04-20"),null,null,null,null));
        clientRepository.save(
                new Client(null, "Ali", Civility.Homme,"a.ali@esi-sba.dz",20,
                        Date.valueOf("1999-05-26"),null,null,null,null));

        Client c1= clientRepository.findById(1L).get();
        c1.setNom("Abdelhamid");
        c1.setAdresse(new Adresse("adda",52,"22000","sidi bel abbes"));
        clientRepository.save(c1);

        clientDetailRepository.save(new ClientDetail(null,"Software Developer",c1));


         clientRepository.findAll().forEach(System.out::println);
    }
}
