package br.com.fiap.localweb.service;

import br.com.fiap.localweb.dto.EmailExhibitDto;
import br.com.fiap.localweb.dto.EmailRegisterDto;
import br.com.fiap.localweb.model.Email;
import br.com.fiap.localweb.model.UserAccount;
import br.com.fiap.localweb.repository.EmailRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Optional;
import java.util.List;

@Service
public class EmailService {

    @Autowired
    private EmailRepository repository;


    public EmailExhibitDto sendEmail(EmailRegisterDto emailRegiterDto){
        Email email = new Email();
        email.setDateTime(LocalDateTime.now());
        BeanUtils.copyProperties(emailRegiterDto, email);

        return new EmailExhibitDto(repository.save(email));
    }

    public EmailExhibitDto findEmail(Long id){
        Optional<Email> emailOptional = repository.findById(id);
        if(emailOptional.isPresent()){
            return new EmailExhibitDto(emailOptional.get());
        }else{
            //Modificar o tipo da exceção
            throw new RuntimeException("Email não encontrado");
        }
    }

    public List<EmailExhibitDto> listAllEmails(){
        return repository.findAll().stream().map(EmailExhibitDto::new).toList();
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
            repository.save(email);
        }else{
            throw new RuntimeException("Email não encontrado!");
        }
    }

    public List<EmailExhibitDto> listUnreadEmails(String recipient){
        return repository.listUnreadEmails(recipient);
    }

    public List<EmailExhibitDto> searchEmailBySubject(String subject){
        return repository.searchEmailBySubject(subject);
    }

    public List<EmailExhibitDto> listSentEmails(String sender){
        return repository.listSentEmails(sender);
    }


    public List<EmailExhibitDto> listEmailForPeriod(LocalDate initialDate, LocalDate finalDate){
        return repository.listEmailForPeriod(initialDate, finalDate);
    }


    //Integrar com o calendário
    public void calendar(){}

}
