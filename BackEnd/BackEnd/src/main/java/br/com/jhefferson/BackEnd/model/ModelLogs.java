package br.com.jhefferson.BackEnd.model;

import java.time.LocalTime;

import br.com.jhefferson.BackEnd.model.ModelUsuario;
import br.com.jhefferson.BackEnd.model.ModelConta;
import br.com.jhefferson.BackEnd.model.ModelTransacao;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name= "Logs")
public class ModelLogs {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idLog;

    @Column(name = "mensagem_log", nullable = false)
    private String mensagemLog;

    @Column(name = "data_log", nullable = false)
    private LocalTime dataLog = LocalTime.now();

    @Column(name= "URL", nullable = false)
    private String url;

    @ManyToOne
    @JoinColumn(name = "id_usuario", nullable = false)
    private ModelUsuario idUsuario;

    @ManyToOne
    @JoinColumn(name = "id_conta", nullable = false)
    private ModelConta idConta;

    @ManyToOne
    @JoinColumn(name = "id_transacao", nullable = false)
    private ModelTransacao idTransacao;

    @ManyToOne
    @JoinColumn(name = "HTTP_Status", nullable = false)
    private ModelHTTPS httpStatus;

    public Long getIdLog() {
        return idLog;
    }

    public void setIdLog(Long idLog) {
        this.idLog = idLog;
    }

    public String getMensagemLog() {
        return mensagemLog;
    }

    public void setMensagemLog(String mensagemLog) {
        this.mensagemLog = mensagemLog;
    }

    public LocalTime getDataLog() {
        return dataLog;
    }

    public void setDataLog(LocalTime dataLog) {
        this.dataLog = dataLog;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
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

    public ModelHTTPS getHttpStatus() {
        return httpStatus;
    }

    public void setHttpStatus(ModelHTTPS httpStatus) {
        this.httpStatus = httpStatus;
    }

    
}
