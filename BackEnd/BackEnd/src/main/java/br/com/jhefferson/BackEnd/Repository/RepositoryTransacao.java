package br.com.jhefferson.BackEnd.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import br.com.jhefferson.BackEnd.model.ModelTransacao;

public interface RepositoryTransacao extends JpaRepository<ModelTransacao, Long> {}