package br.com.jhefferson.BackEnd.Interface;

import java.util.List;

import br.com.jhefferson.BackEnd.model.ModelTransacao;

public interface InterfaceTransacao {

     ModelTransacao criarTransacao(String nomeUsuario, String emailUsuario, String senhaUsuario);
    ModelTransacao atualizarTransacao(Long idTransacao, String nomeUsuario, String emailUsuario, String senhaUsuario);
    void deletarTransacao(Long idTransacao);
    ModelTransacao obterTransacaoPorId(Long idTransacao);
    List<ModelTransacao> obterTodasTransacoes(); 

}
