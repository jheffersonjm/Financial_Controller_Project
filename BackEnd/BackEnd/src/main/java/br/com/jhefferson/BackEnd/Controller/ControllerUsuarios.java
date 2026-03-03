package br.com.jhefferson.BackEnd.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import br.com.jhefferson.BackEnd.Service.ServiceUsuarios;
import br.com.jhefferson.BackEnd.model.ModelUsuario;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


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

    @PostMapping("/salvarUsuario")
    public ModelUsuario salvarUsuario(@RequestBody ModelUsuario usuario) {
        return serviceUsuarios.criarUsuario(
            usuario.getNomeUsuario(),
            usuario.getEmailUsuario(),
            usuario.getSenhaUsuario()
        );
    }
    
}
