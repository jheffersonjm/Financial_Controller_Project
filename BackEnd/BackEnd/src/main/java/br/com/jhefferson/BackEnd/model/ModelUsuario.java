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
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Column(name = "id_usuario")
private Long idUsuario;

@Column(name = "nome_usuario", nullable = false, length = 100)
private String nomeUsuario;

@Column(name = "email_usuario", nullable = false, length = 100, unique = true)
private String emailUsuario;

@Column(name = "senha_usuario", nullable = false, length = 255)
private String senhaUsuario;

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