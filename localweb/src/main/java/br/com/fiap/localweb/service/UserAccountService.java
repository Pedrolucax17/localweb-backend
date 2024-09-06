package br.com.fiap.localweb.service;

import br.com.fiap.localweb.model.UserAccount;
import br.com.fiap.localweb.repository.UserAccountRepository;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

public class UserAccountService {

    @Autowired
    private UserAccountRepository accountRepository;

    public UserAccount saveUserAccount(UserAccount userAccount){
        return accountRepository.save(userAccount);
    }

    public List<UserAccount> listAllUserAccount(){
        return accountRepository.findAll();
    }

    public UserAccount updateUserAccount(UserAccount userAccount){
        Optional<UserAccount> accountOptional = accountRepository.findById(userAccount.getId());
        if(accountOptional.isPresent()){
            return accountRepository.save(userAccount);
        }else{
            throw new RuntimeException("Contato não encontrado");
        }
    }

    public void deleteUserAccount(Long id){
        Optional<UserAccount> accountOptional = accountRepository.findById(id);
        if (accountOptional.isPresent()){
            accountRepository.deleteById(id);
        }else{
            throw new RuntimeException("Contato não encontrado!");
        }

    }

}
