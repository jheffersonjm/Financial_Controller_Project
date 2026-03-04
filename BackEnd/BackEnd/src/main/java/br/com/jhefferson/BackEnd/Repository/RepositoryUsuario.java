package br.com.jhefferson.BackEnd.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import br.com.jhefferson.BackEnd.model.ModelUsuario;

public interface RepositoryUsuario extends JpaRepository<ModelUsuario, Long> {

    Optional<ModelUsuario> findByEmailUsuario(String emailUsuario);
	
}