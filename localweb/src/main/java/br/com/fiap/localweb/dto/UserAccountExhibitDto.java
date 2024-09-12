package br.com.fiap.localweb.dto;

import br.com.fiap.localweb.model.UserAccount;

public record UserAccountExhibitDto(
        Long id,
        String name,
        String email
) {

    public UserAccountExhibitDto(UserAccount user){
        this(
                user.getId(),
                user.getName(),
                user.getEmail()
        );
    }

}
