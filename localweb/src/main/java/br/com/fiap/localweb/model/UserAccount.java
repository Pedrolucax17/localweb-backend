package br.com.fiap.localweb.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
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

    @NotNull(message = "O nome é obrigatório")
    private String name;

    @Column(unique = true)
    @NotNull(message = "O email é obrigatório")
    @Email(message = "O formato do email está inválido")
    private String email;

    @NotNull(message = "A senha é obrigatória")
    private String password;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonManagedReference
    private UserPreferences preferences;

    public void setPreferences(UserPreferences preferences) {
        this.preferences = preferences;
        if (preferences != null) {
            preferences.setUser(this);
        }
    }

}
