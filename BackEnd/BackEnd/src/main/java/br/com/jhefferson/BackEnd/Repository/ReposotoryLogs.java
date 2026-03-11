package br.com.jhefferson.BackEnd.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.jhefferson.BackEnd.model.ModelLogs;

public interface ReposotoryLogs extends JpaRepository<ModelLogs, Integer> {
}
