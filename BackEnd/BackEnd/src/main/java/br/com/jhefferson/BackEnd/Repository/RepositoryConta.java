package br.com.jhefferson.BackEnd.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import br.com.jhefferson.BackEnd.model.ModelConta;

// Para ele se comunicar com o Banco de Dados com a tabela "Conta".
public interface RepositoryConta extends JpaRepository<ModelConta, Long> {}