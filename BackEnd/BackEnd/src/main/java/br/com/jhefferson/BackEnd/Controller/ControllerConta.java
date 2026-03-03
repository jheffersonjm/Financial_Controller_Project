package br.com.jhefferson.BackEnd.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.jhefferson.BackEnd.Service.ServiceContas;
import br.com.jhefferson.BackEnd.model.ModelConta;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;




@RequestMapping("/contas")
@RestController
public class ControllerConta {

    private final ServiceContas serviceConta;

    public ControllerConta(ServiceContas serviceConta) {
        this.serviceConta = serviceConta;
    }

    @GetMapping("/buscarTodos")
    public List<ModelConta> BuscarContas() {
        return serviceConta.obterTodosRegistros();
    }
    
    @GetMapping("/buscar/{id}")
    public ModelConta getContaPorId(@PathVariable Long id) {
        return serviceConta.obterContaPorId(id);
    }
    
    @PostMapping("/salvar")
    public ModelConta salvarConta(@RequestBody ModelConta novaConta) {
        return serviceConta.criarConta(novaConta);
    }
    
    @PutMapping("/atualizar/{id}")
    public ModelConta atualizarConta(@PathVariable ("id") Long idLong, @RequestBody ModelConta dadosAtualizados) {
     
        return serviceConta.atualizarConta(idLong, dadosAtualizados);
    }
    @DeleteMapping("/deletar/{id}")
    public void deletarConta(@PathVariable Long id) {
        serviceConta.deletarConta(id);
    }
   
}
