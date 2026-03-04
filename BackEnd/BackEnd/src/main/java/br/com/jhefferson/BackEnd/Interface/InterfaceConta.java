package br.com.jhefferson.BackEnd.Interface;

import java.util.List;

import br.com.jhefferson.BackEnd.model.ModelConta;

public interface InterfaceConta {

    // Para criar uma conta, atualizar, deletar, obter por id e obter todos os registros.
    // E para ele criar um nova Conta temso que passar um objeto do tipo ModelConta.
    ModelConta criarConta(ModelConta novaConta);

    // Para atualizar uma conta, temso que passar o id da conta e um objeto do tipo ModelConta com os dados atualizados.
    ModelConta atualizarConta(Long idConta, ModelConta dadosAtualizados);

    // Para deletar uma conta, temso que colocar o id da conta.
    void deletarConta(Long idConta);

    // Para obter uma conta por id, temso que colocar o id da conta.
    ModelConta obterContaPorId(Long idConta);
    // Para obter todos os registros de contas.
    List<ModelConta> obterTodosRegistros();
    
}
