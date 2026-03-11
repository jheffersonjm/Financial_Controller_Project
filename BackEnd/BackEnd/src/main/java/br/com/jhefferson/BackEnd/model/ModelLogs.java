package br.com.jhefferson.BackEnd.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "logs")
public class ModelLogs {

@Column(name = "id ", nullable = false, unique = true)
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
int id; 

@Column(name = "Mensagem", nullable = false, length = 255)
String mensagem;

@Column(name = "Data", nullable = false)
String data= LocalDateTime.now().toString();

@ManyToOne
@JoinColumn (name = "id_usuario", nullable = false)
ModelUsuario idUsuario;

@ManyToOne
@JoinColumn (name = "id_conta", nullable = false)
ModelConta idConta;

@ManyToOne
@JoinColumn(name = "id_transacao", nullable = false)
ModelTransacao idTransacao;

@Column(name = "Level", nullable = false, length = 50)
String level;

@Column(name = "Ação", nullable = false, length = 50)
String acao;

public int getId() {
    return id;
}

public void setId(int id) {
    this.id = id;
}

public String getMensagem() {
    return mensagem;
}

public void setMensagem(String mensagem) {
    this.mensagem = mensagem;
}

public String getData() {
    return data;
}

public void setData(String data) {
    this.data = data;
}

public ModelUsuario getIdUsuario() {
    return idUsuario;
}

public void setIdUsuario(ModelUsuario idUsuario) {
    this.idUsuario = idUsuario;
}

public ModelConta getIdConta() {
    return idConta;
}

public void setIdConta(ModelConta idConta) {
    this.idConta = idConta;
}

public ModelTransacao getIdTransacao() {
    return idTransacao;
}

public void setIdTransacao(ModelTransacao idTransacao) {
    this.idTransacao = idTransacao;
}

public String getLevel() {
    return level;
}

public void setLevel(String level) {
    this.level = level;
}

public String getAcao() {
    return acao;
}

public void setAcao(String acao) {
    this.acao = acao;
}

}
