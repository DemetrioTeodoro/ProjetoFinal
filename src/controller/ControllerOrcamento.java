package controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import model.bo.CarroBO;
import model.bo.ClienteBO;
import model.bo.OrcamentoBO;
import model.entity.Carro;
import model.entity.Orcamento;
import model.utils.GeradorPlanilhas;

public class ControllerOrcamento {
	
	DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	ArrayList<Orcamento> orcamentos;
	ControllerCliente controllerCliente = new ControllerCliente();
	
	
	public String cadastrarOrcamento(Orcamento orcamento) {
		String msg = null;
		
		OrcamentoBO orcamentoBO = new OrcamentoBO();
		orcamentoBO.cadastrarOrcamentoBO(orcamento);
		return msg;
	}
	
	public String consultarOrcamento(Orcamento orcamento) {
		String msg = null;
		OrcamentoBO orcamentoBO = new OrcamentoBO();
		orcamentoBO.consultarOrcamentoBO(orcamento);
		return msg;
	}
	
	public String alterarOrcamento(Orcamento orcamento) {
		String msg = null;
		OrcamentoBO orcamentoBO = new OrcamentoBO();
		orcamentoBO.alterarOrcamentoBO(orcamento);
		return msg; 
	}
	
	public String deletarOrcamento(String nuExclusao) {
		String msg = null;
		OrcamentoBO orcamentoBO = new OrcamentoBO();  
		orcamentoBO.deletarOrcamentoBO(nuExclusao);
		return msg;
	}

	public ArrayList<Orcamento> listarOrcamentos(String filtroNome, Carro filtroCarro, int filtroSituacao) {
		OrcamentoBO orcamentoBO = new OrcamentoBO();
		return orcamentoBO.listarOrcamentos(filtroNome, filtroCarro, filtroSituacao);
		
	}

	public ArrayList<Orcamento> consultarOrcNome(String filtroNome) {
		OrcamentoBO orcamentoBO = new OrcamentoBO();
		orcamentos = orcamentoBO.consultarOrcNome(filtroNome);
		return orcamentos;
	}

	public ArrayList<Orcamento> consultarOrcCarro(String filtroCarro) {
		OrcamentoBO orcamentoBO = new OrcamentoBO();
		orcamentos = orcamentoBO.consultarOrcCarro(filtroCarro);
		return orcamentos;
	}

	public ArrayList<Orcamento> consultarOrcSituacao(int filtroSituacao) {
		OrcamentoBO orcamentoBO = new OrcamentoBO();
		orcamentos = orcamentoBO.consultarOrcSituacao(filtroSituacao);
		return orcamentos;
	}

	public void gerarRelatorio(ArrayList<Orcamento> orcamentosRelatorio, String caminhoEscolhido) {
		GeradorPlanilhas gerador = new GeradorPlanilhas();
		gerador.gerarPlanilhasOrcamento(orcamentosRelatorio, caminhoEscolhido);
	}

	public String validarDataEntrada(String dataEntrada) {
		String mensagem = "";
		//LocalDate dataEntrada = LocalDate.parse((txtDataEntrada.getText()), format);
		if (dataEntrada.isEmpty()) {
			mensagem += " A data deve estar preenchida! \n";
		}

		return mensagem;
	}

	


}
