package br.com.jhefferson.BackEnd.Interface;



import br.com.jhefferson.BackEnd.model.ModelUsuario;

public interface InterfaceUsuarios {

    ModelUsuario criarUsuario(String nomeUsuario, String emailUsuario, String senhaUsuario);
    ModelUsuario atualizarUsuario(Long idUsuario, String nomeUsuario, String emailUsuario, String senhaUsuario);
    void deletarUsuario(Long idUsuario);
    ModelUsuario obterUsuarioPorId(Long idUsuario); 
}
