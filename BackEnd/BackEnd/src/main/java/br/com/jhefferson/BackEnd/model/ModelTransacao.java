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

@Entity
@Table(name= "Transacao")
public class ModelTransacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idTransacao;

    @Column(name = "valor_transacao", nullable = false, precision = 10, scale = 2)
    private String descricaoTransacao;

    @Column(name = "data_transacao", nullable = false)
    private LocalTime dataTransacao = LocalTime.now();

    @ManyToOne
    @JoinColumn(name = "id_conta", nullable = false)
    private ModelConta idConta;
}
