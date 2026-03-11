package br.com.jhefferson.BackEnd.model;

import java.sql.Time;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Version;

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

    @Version
    @Column(name = "version")
    private Long version;

    // O comando @Column e que ele pode ser usado para definir uma nova coluna dentro do Banco de dados. 
    // Para que ele possa efinir um nome da coluna temos que o comando name e dai ele vai receber uma String com o nome. 
    // para que ele não possa ser nulla temos que usar o comando nullable = false.
    // E para definir a quantidade de caracteres temos que uar o length = e depois temos que colocar o numero para o limite. 
    @Column(name = "valor_transacao", nullable = false, length = 255)
    private String descricaoTransacao;

    @Column(name = "data_transacao", nullable = false)
    private String dataTransacao;

     // O comando @Column e que ele pode ser usado para definir uma nova coluna dentro do Banco de dados.

    @Column(name = "tipo_transacao", nullable = false, length = 255)
    private String tipoTransacao;


////////////////////////////////////////////////////////////////Get e Set //////////////////////////////////////////////////////////////////////////////////
    public Long getIdTransacao() {
        return idTransacao;
    }

    public void setIdTransacao(Long idTransacao) {
        this.idTransacao = idTransacao;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    public String getDescricaoTransacao() {
        return descricaoTransacao;
    }

    public void setDescricaoTransacao(String descricaoTransacao) {
        this.descricaoTransacao = descricaoTransacao;
    }


    public String getTipoTransacao() {
        return tipoTransacao;
    }

    public void setTipoTransacao(String tipoTransacao) {
        this.tipoTransacao = tipoTransacao;
    }   

    public String getDataTransacao() {
        return dataTransacao != null ? dataTransacao : LocalDateTime.now().toString();
    }

    public void setDataTransacao(String dataTransacao) {
        this.dataTransacao = dataTransacao != null ? dataTransacao : LocalDateTime.now().toString();
    }

    
}