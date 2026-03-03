package br.com.jhefferson.BackEnd.Service;

import java.util.Optional;
import org.springframework.stereotype.Service;

import br.com.jhefferson.BackEnd.Interface.InterfaceUsuarios;
import br.com.jhefferson.BackEnd.Repository.RepositoryUsuario;
import br.com.jhefferson.BackEnd.model.ModelUsuario;

@Service
public class ServiceUsuarios implements InterfaceUsuarios{
   
    private final RepositoryUsuario repositoryUsuario;

    public ServiceUsuarios(RepositoryUsuario repositoryUsuario) {
        this.repositoryUsuario = repositoryUsuario;
    }

    @Override
    public ModelUsuario criarUsuario(String nomeUsuario, String emailUsuario, String senhaUsuario) {
        try {
           ModelUsuario usuario = new ModelUsuario();
        usuario.setNomeUsuario(nomeUsuario);
        usuario.setEmailUsuario(emailUsuario);
        usuario.setSenhaUsuario(senhaUsuario);
        
       return repositoryUsuario.save(usuario);
        } catch (Exception e) {
            System.err.println("Erro ao criar usuário: " + e.getMessage());
            return null;
        }
        
    }

    @Override
    public ModelUsuario atualizarUsuario(Long idUsuario, String nomeUsuario, String emailUsuario, String senhaUsuario) {
        try {
            Optional<ModelUsuario> optionalUsuario = repositoryUsuario.findById(idUsuario);
            if (optionalUsuario.isPresent()) {
                ModelUsuario usuarioExistente = optionalUsuario.get();
                usuarioExistente.setNomeUsuario(nomeUsuario);
                usuarioExistente.setEmailUsuario(emailUsuario);
                usuarioExistente.setSenhaUsuario(senhaUsuario);
                return repositoryUsuario.save(usuarioExistente);
            } else {
                System.err.println("Usuário com ID " + idUsuario + " não encontrado.");
                return null;
            }
        } catch (Exception e) {
            System.err.println("Erro ao atualizar usuário: " + e.getMessage());
            return null;
        }
    }

    @Override
    public void deletarUsuario(Long idUsuario) {
        try {
            Optional<ModelUsuario> optionalUsuario = repositoryUsuario.findById(idUsuario);
            if (optionalUsuario.isPresent()) {
                repositoryUsuario.deleteById(idUsuario);
            } else {
                System.err.println("Usuário com ID " + idUsuario + " não encontrado.");
            }
        } catch (Exception e) {
            System.err.println("Erro ao deletar usuário: " + e.getMessage());
        }
    }

    @Override
    public ModelUsuario obterUsuarioPorId(Long idUsuario) {
        try {
            Optional<ModelUsuario> optionalUsuario = repositoryUsuario.findById(idUsuario);
            if (optionalUsuario.isPresent()) {
                return optionalUsuario.get();
            } else {
                System.err.println("Usuário com ID " + idUsuario + " não encontrado.");
                return null;
            }
        } catch (Exception e) {
            System.err.println("Erro ao obter usuário: " + e.getMessage());
            return null;
        }
    }
    }


