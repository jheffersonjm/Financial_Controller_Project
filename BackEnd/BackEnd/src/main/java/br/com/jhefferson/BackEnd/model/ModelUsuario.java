package br.com.jhefferson.BackEnd.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
 @Table(name= "Usuario")
public class ModelUsuario {
    // para ele indicar que essa varivel ele e um id.
@Id
// E que ele criar um valor automaticamente sem que o usuarios tenha que colocar.
@GeneratedValue(strategy = GenerationType.IDENTITY)
// E para definir o tipo de dado como Long temos que usar o comando Long e depois o nome da variavel.
@Column(name = "id_usuario")
private Long idUsuario;

// O comando @Column e que ele pode ser usado para definir uma nova coluna dentro do Banco de dados. 
    // Para que ele possa efinir um nome da coluna temos que o comando name e dai ele vai receber uma String com o nome. 
    // para que ele não possa ser nulla temos que usar o comando nullable = false.
    // E para definir a quantidade de caracteres temos que uar o length = e depois temos que colocar o numero para o limite.
@Column(name = "nome_usuario", nullable = false, length = 100)
private String nomeUsuario;

// O comando @Column e que ele pode ser usado para definir uma nova coluna dentro do Banco de dados. 
    // Para que ele possa efinir um nome da coluna temos que o comando name e dai ele vai receber uma String com o nome. 
    // para que ele não possa ser nulla temos que usar o comando nullable = false.
    // E para definir a quantidade de caracteres temos que uar o length = e depois temos que colocar o numero para o limite.
   // E que ele pode diser que ele e unico podemos usar o comando unique = true.
@Column(name = "email_usuario", nullable = false, length = 100, unique = true)
private String emailUsuario;

// O comando @Column e que ele pode ser usado para definir uma nova coluna dentro do Banco de dados. 
    // Para que ele possa efinir um nome da coluna temos que o comando name e dai ele vai receber uma String com o nome. 
    // para que ele não possa ser nulla temos que usar o comando nullable = false.
    // E para definir a quantidade de caracteres temos que uar o length = e depois temos que colocar o numero para o limite.
@Column(name = "senha_usuario", nullable = false, length = 255)
private String senhaUsuario;

////////////////////////////////////////////////////////////////Get e Set /////////////////////////////////////////////////////////////////////////////////
public Long getIdUsuario() {
    return idUsuario;
}

public void setIdUsuario(Long idUsuario) {
    this.idUsuario = idUsuario;
}

public String getNomeUsuario() {
    return nomeUsuario;
}

public void setNomeUsuario(String nomeUsuario) {
    this.nomeUsuario = nomeUsuario;
}

public String getEmailUsuario() {
    return emailUsuario;
}

public void setEmailUsuario(String emailUsuario) {
    this.emailUsuario = emailUsuario;
}

public String getSenhaUsuario() {
    return senhaUsuario;
}

public void setSenhaUsuario(String senhaUsuario) {
    this.senhaUsuario = senhaUsuario;
}


}