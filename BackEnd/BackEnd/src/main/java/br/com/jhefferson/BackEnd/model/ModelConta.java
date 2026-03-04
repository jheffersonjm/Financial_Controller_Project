package br.com.jhefferson.BackEnd.model;

import java.math.BigDecimal;

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
@Table(name= "Conta")
public class ModelConta {
 // para ele indicar que essa varivel ele e um id.
@Id
// E que ele criar um valor automaticamente sem que o usuarios tenha que colocar.
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long idConta;

// O comando @Column e que ele pode ser usado para definir uma nova coluna dentro do Banco de dados. 
    // Para que ele possa efinir um nome da coluna temos que o comando name e dai ele vai receber uma String com o nome. 
    // para que ele não possa ser nulla temos que usar o comando nullable = false.
    // E para definir a quantidade de caracteres temos que uar o length = e depois temos que colocar o numero para o limite.
@Column(name = "nome_conta", nullable = false, length = 100)
private String nomeConta;

// Para que ele possa criar uma relação entre duas tabelas temos que usar o comando @ManyToOne. 
    /* 
    O comando @JoinColumn é usado para indicar qual variável vai armazenar a (FK) chave estrangeira, usamos a tag name para indicar o nome da coluna e 
    nullable para indicar se ela pode ser nula ou não.
    */
@ManyToOne
@JoinColumn(name = "id_usuario", nullable = false)
private ModelUsuario idUsuarios;

// O comando @Column e que ele pode ser usado para definir uma nova coluna dentro do Banco de dados. 
    // Para que ele possa efinir um nome da coluna temos que o comando name e dai ele vai receber uma String com o nome. 
    // para que ele não possa ser nulla temos que usar o comando nullable = false.
    // E para definir a quantidade de caracteres temos que uar o length = e depois temos que colocar o numero para o limite.
    // E que possa ser usado para definir o tipo de dado e para isso que ele tem o precision = 10.
    //  scale = 2 que e para definir o tipo de dado como decimal com 10 digitos no total e 2 digitos depois da virgula.
@Column(name = "saldo_conta", nullable = false, precision = 10, scale = 2)
private BigDecimal saldoConta;

////////////////////////////////////////////////////////////////Get e Set ////////////////////////////////////////////////////////////////////////////////
public Long getIdConta() {
    return idConta;
}

public void setIdConta(Long idConta) {
    this.idConta = idConta;
}

public String getNomeConta() {
    return nomeConta;
}

public void setNomeConta(String nomeConta) {
    this.nomeConta = nomeConta;
}

public ModelUsuario getIdUsuarios() {
    return idUsuarios;
}

public void setIdUsuarios(ModelUsuario idUsuarios) {
    this.idUsuarios = idUsuarios;
}

public BigDecimal getSaldoConta() {
    return saldoConta;
}

public void setSaldoConta(BigDecimal saldoConta) {
    this.saldoConta = saldoConta;
}


}
