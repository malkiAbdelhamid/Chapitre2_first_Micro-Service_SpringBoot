package com.esisba.exemple_cours.APIs;

import com.esisba.exemple_cours.entities.Client;
import com.esisba.exemple_cours.entities.Compte;
import com.esisba.exemple_cours.repository.ClientRepository;
import com.esisba.exemple_cours.repository.CompteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("client-api")
public class ClientAPIController {

    @Autowired
    ClientRepository clientRepository;

    @Autowired
    CompteRepository compteRepository;

    @GetMapping("/client/all") //GET http://localhost:8081/client-api/client/all
    public List<Client> getClients() {
        return clientRepository.findAll();
    }

    @GetMapping("/client/{id}") //GET http://localhost:8081/client-api/client/1
    public Client getClientById(@PathVariable("id") Long idclient) {
        return clientRepository.findById(idclient).get();
    }

    @GetMapping("/client")  //GET http://localhost:8081/client-api/client?id=1
    public Client getClientById2(@RequestParam("id") Long idclient) {
        return clientRepository.findById(idclient).get();
    }

    @PostMapping("/client")  //POST http://localhost:8081/client-api/client
    public Client createNewClient(@RequestBody Client client) {
        return clientRepository.save(client);
    }

    @PostMapping("/compte")  //POST  http://localhost:8081/client-api/compte
    public Compte createNewCopte(@RequestBody Map<String, Object> payload) {
        Compte e = new Compte();
        e.setLogin(payload.get("login").toString());
        e.setPassword(payload.get("password").toString());
        e.setDateCreation(new Date());

        Long idClient = Long.valueOf(payload.get("idClient").toString());
        e.setClient(clientRepository.findById(idClient).get());

        return compteRepository.save(e);
    }

    @PutMapping("/client/{id}")  //Put http://localhost:8081/client-api/client/1
    public Client updateClient(@PathVariable(value = "id") Long idClient,
                               @RequestBody Client client) {
        if (clientRepository.findById(idClient).isPresent()) {
            client.setIdClient(idClient);
            return clientRepository.save(client);
        }
        return null;
    }

    @DeleteMapping("/client/{id}")   //Delete http://localhost:8081/client-api/client/1

    public String DeleteClient(@PathVariable(value = "id") Long idClient){

    if (clientRepository.findById(idClient).isPresent()){
       clientRepository.deleteById(idClient);
       return "Correctly deleted";}
    return "the ID is not valid";
    }

}
