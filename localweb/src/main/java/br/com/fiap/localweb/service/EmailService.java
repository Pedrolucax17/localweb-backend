package br.com.fiap.localweb.service;

import br.com.fiap.localweb.model.Email;
import br.com.fiap.localweb.model.UserAccount;
import br.com.fiap.localweb.repository.EmailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Optional;
import java.util.List;

@Service
public class EmailService {

    @Autowired
    private EmailRepository repository;


    //Fazer o DTO de Envio de Email
    //Retorno deve ser o ResponseEntity
    public Email sendEmail(Email email, UserAccount userAccount){
        String emailUser = userAccount.getEmail();

        email.setSender(emailUser);
        email.setDateTime(LocalDateTime.now());

        return repository.save(email);
    }

    //Fazer o DTO de Leitura de Email
    public Email findEmail(Long id){
        Optional<Email> emailOptional = repository.findById(id);
        if(emailOptional.isPresent()){
            return emailOptional.get();
        }else{
            //Modificar o tipo da exceção
            throw new RuntimeException("Email não encontrado");
        }
    }

    public List<Email> listAllEmails(){
        return repository.findAll();
    }

    public void deleteEmail(Long id){
        Optional<Email> emailOptional = repository.findById(id);
        if(emailOptional.isPresent()){
            Email email = emailOptional.get();
            repository.deleteById(email.getId());
        }else{
            throw new RuntimeException("Email não encontrado!");
        }

    }

    public void markAsRead(Long id){
        Optional<Email> emailOptional = repository.findById(id);
        if(emailOptional.isPresent()){
            Email email = emailOptional.get();
            email.setIsRead(true);
        }else{
            throw new RuntimeException("Email não encontrado!");
        }
    }

    public List<Email> listUnreadEmails(String recipient){
        return repository.listUnreadEmails(recipient);
    }

    public List<Email> searchEmailBySubject(String subject){
        return repository.searchEmailBySubject(subject);
    }

    public List<Email> listSentEmails(String sender){
        return repository.listSentEmails(sender);
    }

    //Fazer o dto de Exibição de Email
    public List<Email> listEmailForPeriod(LocalDate initialDate, LocalDate finalDate){
        return repository.listEmailForPeriod(initialDate, finalDate);
    }


    //Integrar com o calendário
    public void calendar(){}

}
