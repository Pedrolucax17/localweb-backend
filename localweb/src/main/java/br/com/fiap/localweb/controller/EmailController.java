package br.com.fiap.localweb.controller;

import br.com.fiap.localweb.dto.EmailExhibitDto;
import br.com.fiap.localweb.dto.EmailRegisterDto;
import br.com.fiap.localweb.model.Email;
import br.com.fiap.localweb.model.UserAccount;
import br.com.fiap.localweb.service.EmailService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/email")
public class EmailController {

    @Autowired
    private EmailService emailService;

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public EmailExhibitDto sendEmail(@RequestBody @Valid EmailRegisterDto email){
        return emailService.sendEmail(email);
    }

    @GetMapping("/id/{id}")
    @ResponseStatus(HttpStatus.OK)
    public EmailExhibitDto findEmail(@PathVariable Long id){
        return emailService.findEmail(id);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<EmailExhibitDto> listAllEmails(){
        return emailService.listAllEmails();
    }

    @DeleteMapping("id/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteEmail(@PathVariable Long id){
        emailService.deleteEmail(id);
    }

    @PutMapping("/id/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void markAsRead(@PathVariable Long id){
        emailService.markAsRead(id);
    }

    @GetMapping("/recipient/{recipient}")
    @ResponseStatus(HttpStatus.OK)
    public List<EmailExhibitDto> listUnreadEmails(@PathVariable String recipient){
        return emailService.listUnreadEmails(recipient);
    }

    @GetMapping("/subject/{subject}")
    @ResponseStatus(HttpStatus.OK)
    public List<EmailExhibitDto> searchEmailBySubject(@PathVariable String subject){
        return emailService.searchEmailBySubject(subject);
    }

    @GetMapping("/sender/{sender}")
    @ResponseStatus(HttpStatus.OK)
    public List<EmailExhibitDto> listSentEmails(@PathVariable String sender){
        return emailService.listSentEmails(sender);
    }

    @GetMapping(value = "/date", params = {"initialDate", "finalDate"})
    @ResponseStatus(HttpStatus.OK)
    public List<EmailExhibitDto> listEmailForPeriod(
            @RequestParam LocalDateTime initialDate,
            @RequestParam LocalDateTime finalDate){
        return emailService.listEmailForPeriod(initialDate, finalDate);
    }

}
