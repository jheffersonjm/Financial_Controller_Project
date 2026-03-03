package br.com.jhefferson.BackEnd.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import br.com.jhefferson.BackEnd.model.ModelConta;

public interface RepositoryConta extends JpaRepository<ModelConta, Long> {}