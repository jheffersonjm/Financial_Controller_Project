package br.com.jhefferson.BackEnd.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import br.com.jhefferson.BackEnd.Interface.InterfaceConta;
import br.com.jhefferson.BackEnd.Repository.RepositoryConta;
import br.com.jhefferson.BackEnd.model.ModelConta;

//quando usamos o @Service ele indica que essa classe e um serviço, ou seja, ela vai conter a lógica de negócio da aplicação.
@Service
public class ServiceContas implements InterfaceConta {

    /* Para ele se comunicar com o Banco de Dados com a tabela "Conta" e para ele poder usar os métodos do RepositoryConta temos que criar uma variável
      do tipo RepositoryConta e depois criar um construtor para ela. 
      */
    private final RepositoryConta repositoryConta;

    public ServiceContas(RepositoryConta repositoryConta) {
        this.repositoryConta = repositoryConta;
    }

    // Para que ele possa sobreescrever os metodos da interfase. 
  
    // Para ele e um metodo para ele criar um novo usuarios e que ele possa faser a ação temso que passa os dados como um objetos do tipo ModelConta e 
    // depois ele vai pegar os dados desse objeto e salvar no banco de dados.
    public ModelConta criarConta(ModelConta novaConta) {
        try {
            if (novaConta.getSaldoConta() == null) { // Ele vai verificar se esse saldo ele e igual a null. 
                novaConta.setSaldoConta(BigDecimal.ZERO); // Caso ele seja null ele vai setar o valor do saldo como zero.
            }
            return repositoryConta.save(novaConta); // Ele vai salvar tudo dentro do Banco de dados.
        } catch (Exception e) {
            System.err.println("Erro ao criar conta: " + e.getMessage());
            return null;
        }
    }

   

    public ModelConta atualizarConta(Long idConta, ModelConta dadosAtualizados) {
        try {
            // Ele vai pegar os dados do banco de dados e verificar se essa conta ele vai esta presente dentro do banco de dados, caso ele esteja presente 
            // ele vai pegar os dados dessa conta
            Optional<ModelConta> optionalConta = repositoryConta.findById(idConta);
            // Ele vai verificar se essa conta ele vai esta presente dentro do banco de dados, caso ele esteja presente ele vai pegar os dados dessa conta
            //  e atualizar com os dados que o usuario passou, e depois ele vai salvar as alterações dentro do banco de dados.
            if (optionalConta.isPresent()) {
                ModelConta contaExistente = optionalConta.get(); // Ele vai pegar os dados dentro do Banco de Dados. 
                contaExistente.setNomeConta(dadosAtualizados.getNomeConta()); // caso ele não estaja lá ele vai mandar para o banco de dados
                if (dadosAtualizados.getSaldoConta() != null) { // Ele vai vericar se esse dados são nullos ou não. 
                    contaExistente.setSaldoConta(dadosAtualizados.getSaldoConta()); // Ele vai atualizar o saldo da conta com os dados que o usuario passou,
                    //  caso ele não seja null ele vai atualizar o saldo da conta.
                }
                if (dadosAtualizados.getIdUsuarios() != null) { // Ele vai verificar se esse dados são nullos ou não.
                    contaExistente.setIdUsuarios(dadosAtualizados.getIdUsuarios()); // Ele vai atualizar o id do usuario da conta com os dados que o usuario
                    //  passou, caso ele não seja null ele vai atualizar o id do usuario da conta.
                }
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
            if (repositoryConta.existsById(idConta)) { // ele vai esta registrado dentro dos Bando de dados. 
                repositoryConta.deleteById(idConta); // Se sim ele vai deletar os dados. 
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
            // Ele vai pegar os dados dentro do banco de dados. 
            /* usando o comando .orElse(null) ele vai verificar se essa conta ele esta presente dentro do banco de dados, caso ele esteja presente ele vai 
             pegar os dados dessa conta, caso ele não esteja presente ele vai retorna null. */
            return repositoryConta.findById(idConta).orElse(null); 
        } catch (Exception e) {
            System.err.println("Erro ao obter conta: " + e.getMessage());
            return null;
        }
    }

    @Override
    // Ele vai criar uma lista com o modelo usando a classe ModelConta.
    public List<ModelConta> obterTodosRegistros() {
    try {
        // Ele vai Pegar os dados dentro do banco de dados usando o comando .findAll() e que ele vai retorna uma lista com os dados.
        return repositoryConta.findAll(PageRequest.of(0, 10)).getContent(); // Ele vai pegar os dados dentro do banco de dados usando o comando .findAll() e que ele vai retorna uma lista com os dados.
   } catch (Exception e) {
        System.err.println("Erro ao obter todos os registros: " + e.getMessage());
        return null;
    }
}
    }
