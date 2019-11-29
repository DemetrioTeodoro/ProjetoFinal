package model.utils;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

import model.entity.Orcamento;
import model.entity.Peca;

public class GeradorPlanilhas {
	
	public void gerarPlanilhasPeca(List<Peca> pecas, String caminhoEscolhido) {
		String[] colunasTabelaPecas = { "CODIGO"," NOME", "VALOR DE VENDA", "VALOR DE COMPRA", "DATA DE ENTRADA", "DATA DE SAIDA", "QUANTIDADE" };
		
		HSSFWorkbook planilha = new HSSFWorkbook();
		
		HSSFSheet abaPlanilha = planilha.createSheet("Pecas");
		
		Row headerRow = abaPlanilha.createRow(0);
		
		for (int i = 0; i < colunasTabelaPecas.length; i++) {
			Cell cell = headerRow.createCell(i);
			cell.setCellValue(colunasTabelaPecas[i]);
		}
		
		DateTimeFormatter formatadorDeData = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		
		int rowNum = 1;
		for (Peca peca : pecas) {
			Row novaLinha = abaPlanilha.createRow(rowNum++);
			
			novaLinha.createCell(0).setCellValue(peca.getCodigo());
			novaLinha.createCell(1).setCellValue(peca.getNomePeca());
			novaLinha.createCell(2).setCellValue(peca.getValVenda());
			novaLinha.createCell(3).setCellValue(peca.getValCompra());
			novaLinha.createCell(4).setCellValue(peca.getDataEntrada().format(formatadorDeData));
			novaLinha.createCell(5).setCellValue(peca.getDataSaida().format(formatadorDeData));
			novaLinha.createCell(6).setCellValue(peca.getQuantidade());
		}
		
		for (int i = 0; i < colunasTabelaPecas.length; i++) {
			abaPlanilha.autoSizeColumn(i);
		}
		
		FileOutputStream fileOut = null;
		
		try {
			fileOut = new FileOutputStream(caminhoEscolhido + ".xls");
			planilha.write(fileOut);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				fileOut.close();
				planilha.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		
	}
	
	public void gerarPlanilhasOrcamento(List<Orcamento> orcamentos, String caminhoEscolhido) {
		String[] colunasTabelaPecas = {  };
		
		HSSFWorkbook planilha = new HSSFWorkbook();
		
		HSSFSheet abaPlanilha = planilha.createSheet("Pecas");
		
		Row headerRow = abaPlanilha.createRow(0);
		
		for (int i = 0; i < colunasTabelaPecas.length; i++) {
			Cell cell = headerRow.createCell(i);
			cell.setCellValue(colunasTabelaPecas[i]);
		}
		
		DateTimeFormatter formatadorDeData = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		
		int rowNum = 1;
		for (Orcamento orcamento : orcamentos) {
			Row novaLinha = abaPlanilha.createRow(rowNum++);
			
			/*novaLinha.createCell(0).setCellValue(orcamento.
			novaLinha.createCell(1).setCellValue(orcamento.
			novaLinha.createCell(2).setCellValue(orcamento.
			novaLinha.createCell(3).setCellValue(orcamento.
			novaLinha.createCell(4).setCellValue(orcamento.
			novaLinha.createCell(5).setCellValue(orcamento.
			novaLinha.createCell(6).setCellValue(orcamento.getQuantidade());*/
		}
		
		for (int i = 0; i < colunasTabelaPecas.length; i++) {
			abaPlanilha.autoSizeColumn(i);
		}
		
		FileOutputStream fileOut = null;
		
		try {
			fileOut = new FileOutputStream(caminhoEscolhido + ".xls");
			planilha.write(fileOut);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				fileOut.close();
				planilha.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		
	}

}