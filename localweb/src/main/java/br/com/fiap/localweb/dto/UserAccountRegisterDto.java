package br.com.fiap.localweb.dto;

public record UserAccountRegisterDto(
        Long id,
        String name,
        String email,
        String password
) {

}
