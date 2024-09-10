package br.com.fiap.localweb.repository;

import br.com.fiap.localweb.model.Email;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmailRepository extends JpaRepository<Email, Long> {
}
