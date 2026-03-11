package br.com.jhefferson.BackEnd.Service;

import java.util.Optional;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

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
    public ModelUsuario criarUsuario(ModelUsuario usuario) {
        String email = usuario.getEmailUsuario();
        if (email == null || email.isBlank()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "E-mail é obrigatório.");
        }

        Optional<ModelUsuario> usuarioExistente = repositoryUsuario.findByEmailUsuario(email);
        if (usuarioExistente.isPresent()) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "E-mail já cadastrado.");
        }

        try {
            usuario.setIdUsuario(null);
            usuario.setSenhaUsuario(PegarSenha(usuario.getSenhaUsuario()));
            return repositoryUsuario.save(usuario);
        } catch (DataIntegrityViolationException e) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "E-mail já cadastrado.");
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Erro ao criar usuário.");
        }
    }

    @Override
    public ModelUsuario atualizarUsuario(ModelUsuario usuario) {
        try {
            Optional<ModelUsuario> optionalUsuario = repositoryUsuario.findById(usuario.getIdUsuario());
            if (optionalUsuario.isPresent()) {
                ModelUsuario usuarioExistente = optionalUsuario.get();
                usuarioExistente.setNomeUsuario(usuario.getNomeUsuario());
                usuarioExistente.setEmailUsuario(usuario.getEmailUsuario());
                usuarioExistente.setSenhaUsuario(usuario.getSenhaUsuario());
                return repositoryUsuario.save(usuarioExistente);
            } else {
                System.err.println("Usuário com ID " + usuario.getIdUsuario() + " não encontrado.");
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

    public String PegarSenha(String senhaUsuario){ 

        return senhaUsuario;
    }

    public String PegarSenha(String nomeUsuario, String emailUsuario) {
        ModelUsuario usuario = obterUsuario(emailUsuario);
        if (usuario != null && usuario.getNomeUsuario() != null && usuario.getNomeUsuario().equals(nomeUsuario)) {
            return PegarSenha(usuario.getSenhaUsuario());
        }
        return null;
    }

    @Override
    public ModelUsuario obterUsuario(String emailUsuario) {
        try {
            Optional<ModelUsuario> usuario = repositoryUsuario.findByEmailUsuario(emailUsuario);
            if (usuario.isPresent()) {
                return usuario.get();
            } else {
                System.err.println("Usuário com email " + emailUsuario + " não encontrado.");
                return null;
            }
        } catch (Exception e) {
            System.err.println("Erro ao obter usuário: " + e.getMessage());
            return null;
        }
    }

   


    }