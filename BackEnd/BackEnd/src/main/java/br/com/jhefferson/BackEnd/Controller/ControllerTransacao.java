package br.com.jhefferson.BackEnd.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.jhefferson.BackEnd.Service.ServiceTransacao;
import br.com.jhefferson.BackEnd.model.ModelTransacao;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;




@RestController
@RequestMapping("/transacoes")
public class ControllerTransacao {

    private final ServiceTransacao serviceTransacao;

    public ControllerTransacao(ServiceTransacao serviceTransacao) {
        this.serviceTransacao = serviceTransacao;
    }
    
    @GetMapping("/Pegar")
    public List<ModelTransacao> PegarDados(
        @RequestParam int id,
         @RequestParam String param
        ) {
        return serviceTransacao.obterTodasTransacoes();
    }
    
    @GetMapping("/PegarTodas/{id}")
    public List<ModelTransacao> PegarTodasTransacoes(@PathVariable int id) {
        return serviceTransacao.obterTodasTransacoes();
    }

    @DeleteMapping("/Deletar/{id}")
    public void deletarTransacao(@PathVariable Long id) {
        serviceTransacao.deletarTransacao(id);
    }
}
