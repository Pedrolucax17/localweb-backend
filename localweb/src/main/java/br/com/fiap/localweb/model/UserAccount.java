package br.com.fiap.localweb.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "tbl_user_account")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class UserAccount {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(unique = true)
    private String email;

    private String password;

    //@OneToOne(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//    @Transient
//    private UserPreferences preferences;

}
