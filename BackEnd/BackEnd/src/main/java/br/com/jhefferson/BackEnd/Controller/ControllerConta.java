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
    // Para ele pegar os dados dentro do services 
    private final ServiceContas serviceConta; 
    // Criar o controtor para que ele possa injetar os 
    // dados dentro desse sistema. 
    public ControllerConta(ServiceContas serviceConta) {
        this.serviceConta = serviceConta;
    }
    /* 
    Ele e uma função que vai pegar os dados do banco de dados e mostrar para o usuario,
    e para isso que ele tem o serviceConta.obterTodosRegistros() que e a
    */
    @GetMapping("/buscarTodos")
    /*
    Ele vai criar uma lista de dados e que ele vai seguir os 
    modelos do ModelConta e depois ele vai pegar os dados do banco de dados e mostrar para o usuario, e para isso que ele tem o serviceConta.obterTodosRegistros() que e a
    */
    public List<ModelConta> BuscarContas() {
        /*
        Ele vai Chamar o metodo obterTodosRegistros e que esta dentro do service.
        */
        return serviceConta.obterTodosRegistros();
    }


    /*
    Ele e uma função que vai pegar os dados do banco de dados e mostrar para o usuario,
    e para isso que ele tem o serviceConta.obterContaPorId(id) que e a
    */
    @GetMapping("/buscar/{id}")
    public ModelConta getContaPorId(
        @PathVariable Long id // Ele vai Pegar os id dos usuarios e depois ele vai passar para o serviceConta.obterContaPorId(id) para que ele possa pegar os dados do banco de dados e mostrar para o usuario.
    ) {
        /*
        para ele pegar os dados dentro do service para ele vaser a operação
        e com isso ele vai pegar os dados do banco de dados e mostrar para o usuario, e para isso que ele tem o serviceConta.obterContaPorId(id) que e a
        */
        return serviceConta.obterContaPorId(id);
    }
    
    // Ele vai criar um caminho para que ele posa chamar para outro sistema.
    @PostMapping("/salvar")
    
    //Um metodo e que ele vai retorna um Objetos do tipo ModeloConta e que ele vai retorna os dados.
    
    public ModelConta salvarConta(
        /*
        Ele via pegar os dados e que vai usar o modelo do ModelConta para pegar os dados e depois ele vai passar para o serviceConta.criarConta(novaConta) para que ele possa criar uma nova conta no banco de dados e mostrar para o usuario, e para isso que ele tem o serviceConta.criarConta(novaConta) que ele
        vai retorna um corpo para a requisição seguinco o modelo da Classe ModelConta. 
        */
        @RequestBody ModelConta novaConta
    ) {
        return serviceConta.criarConta(novaConta);
    }
    
    // Ele vai atualisar os dados e que vai seguir o modelo ModeloConta

    @PutMapping("/atualizar/{id}")
    public ModelConta atualizarConta(
        /*
        E para que ele possa pegar os dadso dentro da URL usamos o comando 
        PathVariable e que ele vai esta com o tipo Longs.
        */
        @PathVariable ("id") Long idLong,
            /*
            E que ele vai retorna um corpo com o modelo usando uma classe ModelConta e que vai esta armagenado dentro da variavel. 
            */
         @RequestBody ModelConta dadosAtualizados
        ) {
     
        return serviceConta.atualizarConta(idLong, dadosAtualizados);
    }

    // Ele criar uma caminho para que ele possa deltar os dadados dentro do Banco de Dados.
    @DeleteMapping("/deletar/{id}")
    public void deletarConta(@PathVariable Long id) {
        serviceConta.deletarConta(id);
    }
   
}
