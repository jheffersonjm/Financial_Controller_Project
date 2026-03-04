package br.com.jhefferson.BackEnd.model;

import java.time.LocalTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

// Para que ele possa cria um nova entidade dentro do banco de dados e para isso que ele tem a anotação @Entity.
@Entity
// Para que ele possa mudar o nome dentro do Banco de Dados. 
@Table(name= "Transacao")
public class ModelTransacao {

    // para ele indicar que essa varivel ele e um id. 
    @Id
    // E que ele criar um valor automaticamente sem que o usuarios tenha que colocar. 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idTransacao;

    // O comando @Column e que ele pode ser usado para definir uma nova coluna dentro do Banco de dados. 
    // Para que ele possa efinir um nome da coluna temos que o comando name e dai ele vai receber uma String com o nome. 
    // para que ele não possa ser nulla temos que usar o comando nullable = false.
    // E para definir a quantidade de caracteres temos que uar o length = e depois temos que colocar o numero para o limite. 
    @Column(name = "valor_transacao", nullable = false, length = 255)
    private String descricaoTransacao;

    @Column(name = "data_transacao", nullable = false)
    private LocalTime dataTransacao = LocalTime.now();

    
    // Para que ele possa criar uma relação entre duas tabelas temos que usar o comando @ManyToOne. 
    /* 
    O comando @JoinColumn é usado para indicar qual variável vai armazenar a (FK) chave estrangeira, usamos a tag name para indicar o nome da coluna e 
    nullable para indicar se ela pode ser nula ou não.
    */
    @ManyToOne
    @JoinColumn(name = "id_conta", nullable = false)
    private ModelConta idConta;

    @Column(name = "tipo_transacao", nullable = false, length = 255)
    private String tipoTransacao;


////////////////////////////////////////////////////////////////Get e Set //////////////////////////////////////////////////////////////////////////////////
    public Long getIdTransacao() {
        return idTransacao;
    }

    public void setIdTransacao(Long idTransacao) {
        this.idTransacao = idTransacao;
    }

    public String getDescricaoTransacao() {
        return descricaoTransacao;
    }

    public void setDescricaoTransacao(String descricaoTransacao) {
        this.descricaoTransacao = descricaoTransacao;
    }

    public LocalTime getDataTransacao() {
        return dataTransacao;
    }

    public void setDataTransacao(LocalTime dataTransacao) {
        this.dataTransacao = dataTransacao;
    }

    public ModelConta getIdConta() {
        return idConta;
    }

    public void setIdConta(ModelConta idConta) {
        this.idConta = idConta;
    }

    public String getTipoTransacao() {
        return tipoTransacao;
    }

    public void setTipoTransacao(String tipoTransacao) {
        this.tipoTransacao = tipoTransacao;
    }   
}