package br.com.fiap.localweb.controller;

import br.com.fiap.localweb.model.Email;
import br.com.fiap.localweb.model.UserAccount;
import br.com.fiap.localweb.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/email")
public class EmailController {

    @Autowired
    private EmailService emailService;

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public Email sendEmail(Email email, UserAccount userAccount){
        return emailService.sendEmail(email, userAccount);
    }

    @GetMapping("/id/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Email findEmail(Long id){
        return emailService.findEmail(id);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Email> listAllEmails(){
        return emailService.listAllEmails();
    }

    @DeleteMapping("id/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteEmail(Long id){
        emailService.deleteEmail(id);
    }

    @PutMapping("/id/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void markAsRead(Long id){
        emailService.markAsRead(id);
    }

    @GetMapping("/recipient/{recipient}")
    @ResponseStatus(HttpStatus.OK)
    public List<Email> listUnreadEmails(String recipient){
        return emailService.listUnreadEmails(recipient);
    }

    @GetMapping("/subject/{subject}")
    @ResponseStatus(HttpStatus.OK)
    public List<Email> searchEmailBySubject(String subject){
        return emailService.searchEmailBySubject(subject);
    }

    @GetMapping("/sender/{sender}")
    @ResponseStatus(HttpStatus.OK)
    public List<Email> listSentEmails(String sender){
        return emailService.listSentEmails(sender);
    }

    @GetMapping(value = "/date", params = {"initialDate", "finalDate"})
    @ResponseStatus(HttpStatus.OK)
    public List<Email> listEmailForPeriod(
            @RequestParam LocalDate initialDate,
            @RequestParam LocalDate finalDate){
        return emailService.listEmailForPeriod(initialDate, finalDate);
    }

}
