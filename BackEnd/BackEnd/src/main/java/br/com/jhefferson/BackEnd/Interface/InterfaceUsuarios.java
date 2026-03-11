package br.com.jhefferson.BackEnd.Interface;



import br.com.jhefferson.BackEnd.model.ModelUsuario;

public interface InterfaceUsuarios {

    ModelUsuario criarUsuario(ModelUsuario usuario);
    ModelUsuario atualizarUsuario(ModelUsuario usuario);
    void deletarUsuario(Long idUsuario);
    ModelUsuario obterUsuarioPorId(Long idUsuario); 
    ModelUsuario obterUsuario(String emailUsuario);
}
