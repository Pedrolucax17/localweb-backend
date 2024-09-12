package br.com.fiap.localweb.service;

import br.com.fiap.localweb.dto.UserAccountExhibitDto;
import br.com.fiap.localweb.model.UserAccount;
import br.com.fiap.localweb.repository.UserAccountRepository;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserAccountService {

    @Autowired
    private UserAccountRepository accountRepository;

    public UserAccountExhibitDto saveUserAccount(UserAccount userAccount){
        return new UserAccountExhibitDto(accountRepository.save(userAccount));
    }

    public List<UserAccount> listAllUserAccount(){
        return accountRepository.findAll();
    }

    public UserAccountExhibitDto findUserAccountById(Long id){
        Optional<UserAccount> userAccountOptional = accountRepository.findById(id);
        if(userAccountOptional.isPresent()){
            return new UserAccountExhibitDto(userAccountOptional.get());
        }else{
            throw new RuntimeException("Usuário não encontrado");
        }
    }

    public UserAccountExhibitDto updateUserAccount(UserAccount userAccount){
        Optional<UserAccount> accountOptional = accountRepository.findById(userAccount.getId());
        if(accountOptional.isPresent()){
            return new UserAccountExhibitDto(accountRepository.save(userAccount));
        }else{
            throw new RuntimeException("Usuário não encontrado");
        }
    }

    public void deleteUserAccount(Long id){
        Optional<UserAccount> accountOptional = accountRepository.findById(id);
        if (accountOptional.isPresent()){
            accountRepository.deleteById(id);
        }else{
            throw new RuntimeException("Usuário não encontrado!");
        }

    }

}
