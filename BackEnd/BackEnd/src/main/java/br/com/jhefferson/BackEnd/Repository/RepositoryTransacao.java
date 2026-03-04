package br.com.jhefferson.BackEnd.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import br.com.jhefferson.BackEnd.model.ModelTransacao;

// Para ele se comunicar com o Banco de Dados com a tabela "Transacao".
public interface RepositoryTransacao extends JpaRepository<ModelTransacao, Long> {}