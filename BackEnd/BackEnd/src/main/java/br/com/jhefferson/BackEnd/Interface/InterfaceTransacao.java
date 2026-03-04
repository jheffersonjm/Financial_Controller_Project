package br.com.jhefferson.BackEnd.Interface;

import java.util.List;

import br.com.jhefferson.BackEnd.model.ModelTransacao;

public interface InterfaceTransacao {

    // Aqui e onde ele vai criar os metodos para a Transacao.
    // Para criar uma transacao, atualizar, deletar, obter por id e obter todos os registros.
    // E para ele criar uma nova transacao temso que passar o objeto ModelTransacao.
     ModelTransacao criarTransacao(ModelTransacao transacao);

     // Para atualizar uma transacao, temso que passar o objeto ModelTransacao.     
    ModelTransacao atualizarTransacao(ModelTransacao transacao);
    // Para deletar uma transacao, temso que passar o id da transacao.
    void deletarTransacao(Long idTransacao);
    // Para obter uma transacao por id, temso que passar o id da transacao.
    ModelTransacao obterTransacaoPorId(Long idTransacao);
    // Para obter todas as transacoes.
    List<ModelTransacao> obterTodasTransacoes(); 

}
