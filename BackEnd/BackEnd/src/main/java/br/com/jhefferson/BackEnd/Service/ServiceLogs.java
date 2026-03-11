package br.com.jhefferson.BackEnd.Service;

import java.util.List;

import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import br.com.jhefferson.BackEnd.Interface.InterfaceLogs;
import br.com.jhefferson.BackEnd.Repository.ReposotoryLogs;
import br.com.jhefferson.BackEnd.model.ModelLogs;

@Service
public class ServiceLogs implements InterfaceLogs{
    private final ReposotoryLogs repositoryLogs;

    public ServiceLogs(ReposotoryLogs repositoryLogs) {
        this.repositoryLogs = repositoryLogs;
    }

    @Override
    public List<ModelLogs> PegarLogs() {
        try {
            return repositoryLogs.findAll(PageRequest.of(0, 10)).getContent(); // Ele vai pegar os dados dentro do banco de dados usando o comando .findAll() e que ele vai retorna uma lista com os dados.
        } catch (Exception e) {
            return null;
        } 

    }
   
}