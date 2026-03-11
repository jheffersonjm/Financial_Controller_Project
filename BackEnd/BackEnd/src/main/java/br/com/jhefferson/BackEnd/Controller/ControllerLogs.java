package br.com.jhefferson.BackEnd.Controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.jhefferson.BackEnd.Service.ServiceLogs;
import br.com.jhefferson.BackEnd.model.ModelLogs;
import io.swagger.v3.oas.annotations.parameters.RequestBody;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping("/logs")
public class ControllerLogs {
    private ServiceLogs serviceLogs;

    public ControllerLogs(ServiceLogs serviceLogs) {
        this.serviceLogs = serviceLogs;
    }
   
    @GetMapping("/Pegar")
    public String getMethodName(@RequestParam String param) {
        return new String();
    }
    
    @GetMapping("/PegarLogs")
    public String pegarPorlogs(@RequestBody ModelLogs logs) {
        return serviceLogs.PegarLogs().toString();
    }

    @GetMapping("/PegarPorConta")
    public String pegarPorConta(@RequestParam int idConta, @RequestBody ModelLogs logs) {
        return serviceLogs.PegarLogsPorConta(idConta).toString();
    }
    
    
    
}
