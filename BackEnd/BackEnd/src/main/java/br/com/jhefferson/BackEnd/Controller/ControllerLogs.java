package br.com.jhefferson.BackEnd.Controller;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;

import br.com.jhefferson.BackEnd.Service.ServiceLogs;
import br.com.jhefferson.BackEnd.model.ModelLogs;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/logs")
public class ControllerLogs {
    private ServiceLogs serviceLogs;

    public ControllerLogs(ServiceLogs serviceLogs ) {
        this.serviceLogs = serviceLogs;
    }
   
    @GetMapping("/PegarLogs")
    public String pegarPorlogs() {
        List<ModelLogs> logs = serviceLogs.PegarLogs();
        return logs != null ? logs.toString() : "[]";
    }

  
    
}
