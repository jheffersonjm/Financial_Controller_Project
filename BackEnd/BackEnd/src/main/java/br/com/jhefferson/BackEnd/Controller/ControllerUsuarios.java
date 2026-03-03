package br.com.jhefferson.BackEnd.Controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import br.com.jhefferson.BackEnd.Service.ServiceUsuarios;
import br.com.jhefferson.BackEnd.model.ModelUsuario;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;



@RestController
@RequestMapping("/usuarios")
public class ControllerUsuarios {

    private final ServiceUsuarios serviceUsuarios;

    public ControllerUsuarios(ServiceUsuarios serviceUsuarios) {
        this.serviceUsuarios = serviceUsuarios;
    }

    @GetMapping("/BuscarUsuarios")
    public String BuscarUsuarios(
        @RequestParam String nomeUsuario,
        @RequestParam String emailUsuario
    ) {

        return serviceUsuarios.PegarSenha(nomeUsuario, emailUsuario);
    }

    @GetMapping("/BuscarUsuarioPorId/{id}")
    public ModelUsuario BuscarUsuarioPorId(@PathVariable Long id) {
        return serviceUsuarios.obterUsuarioPorId(id);
    }

    @PostMapping("/salvarUsuario")
    public ModelUsuario salvarUsuario(@RequestBody ModelUsuario usuario) {
        return serviceUsuarios.criarUsuario(
            usuario.getNomeUsuario(),
            usuario.getEmailUsuario(),
            usuario.getSenhaUsuario()
        );
    }

    @PutMapping("/atualizarUsuario/{id}")
    public ModelUsuario atualizarUsuario(@PathVariable Long id, @RequestBody ModelUsuario usuario) {
        return serviceUsuarios.atualizarUsuario(
            id,
            usuario.getNomeUsuario(),
            usuario.getEmailUsuario(),
            usuario.getSenhaUsuario()
        );
    }
    
    @DeleteMapping("/deletarUsuario/{id}")
    public void deletarUsuario(@PathVariable Long id) {
        serviceUsuarios.deletarUsuario(id);
    }
    
}
