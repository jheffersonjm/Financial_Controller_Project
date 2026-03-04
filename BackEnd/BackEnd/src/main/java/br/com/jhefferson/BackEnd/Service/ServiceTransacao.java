package br.com.jhefferson.BackEnd.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.http.ResponseEntity;

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
    public void deletarTransacao(Long idTransacao) {
        try {
            // Ele vai criar um objeto do tipo Optional para verificar se a transação existe dentro do banco de dados,
            //  caso ela exista ele vai deletar os dados, caso ela não exista ele vai mostrar uma mensagem de erro.
            Optional<ModelTransacao> optionalTransacao = repositoryTransacao.findById(idTransacao);
            if (optionalTransacao.isPresent()) { // E que ele vai verificar se a transação existe dentro do banco de dados.
                repositoryTransacao.deleteById(idTransacao); // Ele vai para ele deletar os dados dentro do banco de dados. 
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
            // Ele vai criar um objeto do tipo Optional para verificar se a transação existe dentro do banco de dados,
            //  caso ela exista ele vai retornar os dados, caso ela não exista ele vai mostrar uma mensagem de erro.
            Optional<ModelTransacao> optionalTransacao = repositoryTransacao.findById(idTransacao);
            if (optionalTransacao.isPresent()) { // Ele vai ver se esse dados ele var se esses dados existe. 
                return optionalTransacao.get(); // Ele vai pegar os dados dentro do banco de dados e que ele vai retorna para o usuario.
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
            // Ele vai criar uma lista com o modelo usando a classe ModelTransacao.
            // Ele vai Pegar os dados dentro do banco de dados usando o comando .findAll() e que ele vai retorna uma lista com os dados.
            return repositoryTransacao.findAll();
        } catch (Exception e) {
            System.err.println("Erro ao obter todas as transações: " + e.getMessage());
            return null;
        }
    }

    public ResponseEntity<ModelTransacao> salvarTransacao(ModelTransacao transacao) {
        try {
            ModelTransacao savedTransacao = repositoryTransacao.save(transacao);
            return ResponseEntity.ok(savedTransacao);
        } catch (Exception e) {
            System.err.println("Erro ao salvar transação: " + e.getMessage());
            // Caso ocorra um erro, retorna uma resposta de erro com status 500 (Internal Server Error).
            return ResponseEntity.status(500).build();
        }
    }

    @Override
    public ModelTransacao atualizarTransacao(ModelTransacao transacao) {
        try {
            // Ele vai criar um objeto do tipo Optional para verificar se a transação existe dentro do banco de dados,
            //  caso ela exista ele vai atualizar os dados, caso ela não exista ele vai mostrar uma mensagem de erro.

            Optional<ModelTransacao> optionalTransacao = repositoryTransacao.findById(transacao.getIdTransacao());
            if (optionalTransacao.isPresent()) { // para ele verificar se a transação existe dentro do banco de dados.
                ModelTransacao existingTransacao = optionalTransacao.get(); // para ele pegar os dados usando o GET. 
                return repositoryTransacao.save(existingTransacao); // Para ele sauvar os dados dentro do banco de dados.
            }
            return null;
        } catch (Exception e) {
            System.err.println("Erro ao atualizar transação: " + e.getMessage());
            return null;

        } 
}



    @Override
    public ModelTransacao criarTransacao(ModelTransacao transacao) {
        try {
            return repositoryTransacao.save(transacao);
        } catch (Exception e) {
            System.err.println("Erro ao criar transação: " + e.getMessage());
            return null;
        }
    }
} 