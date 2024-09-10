package br.com.fiap.localweb.controller;

import br.com.fiap.localweb.model.UserAccount;
import br.com.fiap.localweb.repository.UserAccountRepository;
import br.com.fiap.localweb.service.UserAccountService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/account")
public class UserAccountController {

    @Autowired
    private UserAccountService userAccountService;

    @PostMapping
    public UserAccount saveUserAccount(UserAccount userAccount){
        return userAccountService.saveUserAccount(userAccount);
    }

    @GetMapping
    public List<UserAccount> listAllUserAccount(){
        return userAccountService.listAllUserAccount();
    }

    @DeleteMapping
    public void deleteUserAccount(Long id){
        userAccountService.deleteUserAccount(id);
    }

}
