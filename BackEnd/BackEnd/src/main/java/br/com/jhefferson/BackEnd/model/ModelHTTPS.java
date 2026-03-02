package br.com.jhefferson.BackEnd.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name= "HTTP_Status")
public class ModelHTTPS {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idHTTPStatus;

        @Column(name = "codigo_status", nullable = false, length = 3)
    private Integer codigoStatus;

    @Column(name = "descricao_status", nullable = false, length = 255)
    private String descricaoStatus;

    public Long getIdHTTPStatus() {
        return idHTTPStatus;
    }

    public void setIdHTTPStatus(Long idHTTPStatus) {
        this.idHTTPStatus = idHTTPStatus;
    }

    public Integer getCodigoStatus() {
        return codigoStatus;
    }

    public void setCodigoStatus(Integer codigoStatus) {
        this.codigoStatus = codigoStatus;
    }

    public String getDescricaoStatus() {
        return descricaoStatus;
    }

    public void setDescricaoStatus(String descricaoStatus) {
        this.descricaoStatus = descricaoStatus;
    }

    
}
