package br.com.jhefferson.BackEnd.Service;

import java.time.LocalTime;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

import br.com.jhefferson.BackEnd.Interface.InterfaceTransacao;
import br.com.jhefferson.BackEnd.Repository.RepositoryTransacao;
import br.com.jhefferson.BackEnd.model.ModelTransacao;

@Service
public class ServiceTransacao implements InterfaceTransacao {

    private final RepositoryTransacao repositoryTransacao;

    public ServiceTransacao(RepositoryTransacao repositoryTransacao) {
        this.repositoryTransacao = repositoryTransacao;
    }

    @Override
    public ModelTransacao criarTransacao(
        String nomeUsuario,
         String emailUsuario,
          String senhaUsuario
        ) {
        try {
            ModelTransacao transacao = new ModelTransacao();
            transacao.setDescricaoTransacao(nomeUsuario + " - " + emailUsuario + " - " + senhaUsuario);
            transacao.setDataTransacao(LocalTime.now());
            return repositoryTransacao.save(transacao);
        } catch (Exception e) {
            System.err.println("Erro ao criar transação: " + e.getMessage());
            return null;
        }
    }

    @Override
    public ModelTransacao atualizarTransacao(
        Long idTransacao,
         String nomeUsuario,
          String emailUsuario,
           String senhaUsuario
        ) {
        try {
            Optional<ModelTransacao> optionalTransacao = repositoryTransacao.findById(idTransacao);
            if (optionalTransacao.isPresent()) {
                ModelTransacao transacaoExistente = optionalTransacao.get();
                transacaoExistente.setDescricaoTransacao(nomeUsuario + " - " + emailUsuario + " - " + senhaUsuario);
                transacaoExistente.setDataTransacao(LocalTime.now());
                return repositoryTransacao.save(transacaoExistente);
            } else {
                System.err.println("Transação com ID " + idTransacao + " não encontrada.");
                return null;
            }
        } catch (Exception e) {
            System.err.println("Erro ao atualizar transação: " + e.getMessage());
            return null;
        }
    }

    @Override
    public void deletarTransacao(Long idTransacao) {
        try {
            Optional<ModelTransacao> optionalTransacao = repositoryTransacao.findById(idTransacao);
            if (optionalTransacao.isPresent()) {
                repositoryTransacao.deleteById(idTransacao);
            } else {
                System.err.println("Transação com ID " + idTransacao + " não encontrada.");
            }
        } catch (Exception e) {
            System.err.println("Erro ao deletar transação: " + e.getMessage());
        }
    }

    @Override
    public ModelTransacao obterTransacaoPorId(Long idTransacao) {
        try {
            Optional<ModelTransacao> optionalTransacao = repositoryTransacao.findById(idTransacao);
            if (optionalTransacao.isPresent()) {
                return optionalTransacao.get();
            }
            System.err.println("Transação com ID " + idTransacao + " não encontrada.");
            return null;
        } catch (Exception e) {
            System.err.println("Erro ao obter transação: " + e.getMessage());
            return null;
        }
    }

    @Override
    public List<ModelTransacao> obterTodasTransacoes() {
        try {
            return repositoryTransacao.findAll();
        } catch (Exception e) {
            System.err.println("Erro ao obter todas as transações: " + e.getMessage());
            return null;
        }
    }
}