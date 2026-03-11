package br.com.jhefferson.BackEnd.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.jhefferson.BackEnd.Service.ServiceTransacao;
import br.com.jhefferson.BackEnd.model.ModelTransacao;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;

/*
Para ele definir que essa classe ele e um controller para que os 
furmework Spring Boot ele possa reconhecer essa classe como um 
controller e para isso que ele tem a anotação @RestController.
*/
@RestController
/*
 Para ele possa criar um caminho e que ele possa criar um caminho 
para ele achar para deletar os dados.
*/ 
@RequestMapping("/transacoes")
public class ControllerTransacao {

    /*
    Para ele pegar os dados e dentro dos metodos para que ele possa usar dentro de codigo como o service ele vai ter que seguir a interfase e que vai ter 
    todas as função para uma organisação e que cado tenha que adicionar algo. 
    */
    private final ServiceTransacao serviceTransacao;


    public ControllerTransacao(ServiceTransacao serviceTransacao) {
        this.serviceTransacao = serviceTransacao;
    }
    
    // Para ele pegar os caminhor para ele pegar os dados. 
    @GetMapping("/Pegar")
    // Ele criar uma lista com o modelo usando a classe ModelTransação. 
    public List<ModelTransacao> PegarDados(
        
        //O corpo que ele vai retorna e que para isso usamo os comando @RequestBody e que vai retorna os ModelTransação. 
        
        ) {
        return serviceTransacao.obterTodasTransacoes();
    }
    
    @GetMapping("/PegarTodas/{id}")
    // Ele vai criar uma lista com o modelo usando a classe ModelTransação.
    public List<ModelTransacao> PegarTodasTransacoes(
        /* Ele vai pegar o ID dentro da URL usando o comando @PathVariable e que ele vai pegar o ID para depois ele passar para o serviceTransacao.obterTodasTransacoes()
         para que ele possa pegar os dados do banco de dados e mostrar para o usuario, e para isso que ele tem o serviceTransacao.obterTodasTransacoes()
        */
       @PathVariable int id 
       /*
       Ele vai retorna o corpo da Requisição e que para isso para ele seguir o modelo podemos usar o comando @RequestBody. 
       */
        
    ) {
        return serviceTransacao.obterTodasTransacoes();
    }

    @DeleteMapping("/Deletar/{id}")
    public void deletarTransacao(@PathVariable Long id) {
        serviceTransacao.deletarTransacao(id);
    }
    
    @PostMapping("/Criar")
    public ModelTransacao criarTransacao(@RequestBody ModelTransacao transacao) {
         try {
            return serviceTransacao.criarTransacao(transacao);
        } catch (Exception e) {
            // Uma mensagem de erro para que dentro do console. 
            System.err.println("Erro ao criar transação: " + e.getMessage());
            return null;
        }
    }

    @PutMapping("/Atualizar/{id}")
    public ModelTransacao atualizar(@PathVariable Long id, @RequestBody ModelTransacao entity) {
       try {
          entity.setIdTransacao(id);
             return serviceTransacao.atualizarTransacao(id, entity);
       } catch (Exception e) {
        System.err.println("Erro ao atualizar transação: " + e.getMessage());
        return null;
       }
    }
    
    
}
