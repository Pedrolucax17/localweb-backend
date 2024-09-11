package br.com.fiap.localweb.model;

import jakarta.persistence.*;

@Entity
@Table(name = "tbl_user_preferences")
public class UserPreferences {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @OneToOne
    @JoinColumn(name = "user_account_id", referencedColumnName = "id")
    private UserAccount user;

    @Enumerated(EnumType.STRING)
    private Theme theme;
    private String color;
    @Enumerated(EnumType.STRING)
    private Category category;

}
