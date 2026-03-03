package br.com.jhefferson.BackEnd.Service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import br.com.jhefferson.BackEnd.Interface.InterfaceConta;
import br.com.jhefferson.BackEnd.Repository.RepositoryConta;
import br.com.jhefferson.BackEnd.model.ModelConta;

@Service
public class ServiceContas implements InterfaceConta {

    private final RepositoryConta repositoryConta;

    public ServiceContas(RepositoryConta repositoryConta) {
        this.repositoryConta = repositoryConta;
    }

    @Override
    public ModelConta criarConta(String nomeUsuario,
         String emailUsuario,
          String senhaUsuario) {
        try {
            ModelConta conta = new ModelConta();
            conta.setNomeConta(nomeUsuario);
            conta.setSaldoConta(0.0);
            return repositoryConta.save(conta);
        } catch (Exception e) {
            System.err.println("Erro ao criar conta: " + e.getMessage());
            return null;
        }
    }

    @Override
    public ModelConta atualizarConta(
        Long idConta,
         String nomeUsuario,
          String emailUsuario,
           String senhaUsuario) {
        try {
            Optional<ModelConta> optionalConta = repositoryConta.findById(idConta);
            if (optionalConta.isPresent()) {
                ModelConta contaExistente = optionalConta.get();
                contaExistente.setNomeConta(nomeUsuario);
                return repositoryConta.save(contaExistente);
            }
            System.err.println("Conta com ID " + idConta + " não encontrada.");
            return null;
        } catch (Exception e) {
            System.err.println("Erro ao atualizar conta: " + e.getMessage());
            return null;
        }
    }

    @Override
    public void deletarConta(Long idConta) {
        try {
            if (repositoryConta.existsById(idConta)) {
                repositoryConta.deleteById(idConta);
            } else {
                System.err.println("Conta com ID " + idConta + " não encontrada.");
            }
        } catch (Exception e) {
            System.err.println("Erro ao deletar conta: " + e.getMessage());
        }
    }

    @Override
    public ModelConta obterContaPorId(Long idConta) {
        try {
            return repositoryConta.findById(idConta).orElse(null);
        } catch (Exception e) {
            System.err.println("Erro ao obter conta: " + e.getMessage());
            return null;
        }
    }
}
