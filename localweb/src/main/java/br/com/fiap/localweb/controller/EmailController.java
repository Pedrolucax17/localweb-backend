package br.com.fiap.localweb.controller;

import br.com.fiap.localweb.model.Email;
import br.com.fiap.localweb.model.UserAccount;
import br.com.fiap.localweb.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;

public class EmailController {

    @Autowired
    private EmailService emailService;

    public Email sendEmail(Email email, UserAccount userAccount){
        return emailService.sendEmail(email, userAccount);
    }
}
