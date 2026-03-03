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

@Entity 
@Table(name= "Conta")
public class ModelConta {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long idConta;

@Column(name = "nome_conta", nullable = false, length = 100)
private String nomeConta;

@ManyToOne
@JoinColumn(name = "id_usuario", nullable = false)
private ModelUsuario idUsuarios;

@Column(name = "saldo_conta", nullable = false, precision = 10, scale = 2)
private BigDecimal saldoConta;

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
