package br.com.jhefferson.BackEnd.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "logs")
public class ModelLogs {

@Column(name = "id ", nullable = false, unique = true)
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
int id; 

@Column(name = "mensagem", nullable = false)
String version;


}