package br.com.jhefferson.BackEnd.Interface;

import java.util.List;

import br.com.jhefferson.BackEnd.model.ModelConta;

public interface InterfaceConta {

    ModelConta criarConta(String nomeUsuario, String emailUsuario, String senhaUsuario);
    ModelConta atualizarConta(Long idConta, String nomeUsuario, String emailUsuario, String senhaUsuario);
    void deletarConta(Long idConta);
    ModelConta obterContaPorId(Long idConta);
    List<ModelConta> obterTodosRegistros();
    
}
