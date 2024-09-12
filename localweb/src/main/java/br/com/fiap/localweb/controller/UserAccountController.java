package br.com.fiap.localweb.controller;

import br.com.fiap.localweb.model.UserAccount;
import br.com.fiap.localweb.repository.UserAccountRepository;
import br.com.fiap.localweb.service.UserAccountService;
import java.util.List;

import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/account")
public class UserAccountController {

    @Autowired
    private UserAccountService userAccountService;

    @PostMapping
    public UserAccount saveUserAccount(@RequestBody UserAccount userAccount){
        return userAccountService.saveUserAccount(userAccount);
    }

    @GetMapping("/id/{id}")
    public UserAccount findUserAccountById(@PathVariable Long id){
        return userAccountService.findUserAccountById(id);
    }

    @GetMapping
    public List<UserAccount> listAllUserAccount(){
        return userAccountService.listAllUserAccount();
    }

    @DeleteMapping("/id/{id}")
    public void deleteUserAccount(@PathVariable Long id){
        userAccountService.deleteUserAccount(id);
    }

}
