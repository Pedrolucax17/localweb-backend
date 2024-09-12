package br.com.fiap.localweb.dto;

import br.com.fiap.localweb.model.UserPreferences;

public record UserAccountRegisterDto(
        Long id,
        String name,
        String email,
        String password,
        UserPreferences preferences
) {

}
