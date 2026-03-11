package br.com.jhefferson.BackEnd.Interface;

import java.util.List;

import br.com.jhefferson.BackEnd.model.ModelLogs;

public interface InterfaceLogs {
List<ModelLogs> PegarLogs();
List<ModelLogs> PegarLogsPorConta(int idConta);
}
