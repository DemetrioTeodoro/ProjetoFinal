package view;

import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.table.DefaultTableModel;

import controller.ControllerMecanico;
import controller.ControllerOrcamento;
import controller.ControllerSituacao;
import model.entity.Orcamento;
import model.entity.Peca;

import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.Font;
import java.util.ArrayList;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PainelConsultaOrcamento extends JPanel {
	private JTextField textNome;
	private JTextField textAutomovel;
	private JTable tblOrcamento;
	private String[] colunasTabelaOrc = { "#ID"," CLIENTE", "CARRO", "DATA ENTRADA", "VALOR TOTAL", "SITUAÇÃO" };
	private ArrayList<Orcamento>orcamentos;
	ControllerOrcamento controller = new ControllerOrcamento();
	ControllerMecanico controllerMecanico = new ControllerMecanico();
	
	
	ControllerSituacao controllerSituacao = new ControllerSituacao();
	ArrayList<String> situacoes; 
	private JTextField txtIdExcluir;
	JComboBox cbSituacao;
	Orcamento orcamento = new Orcamento();
	
	

	/**
	 * Create the panel.
	 */
	public PainelConsultaOrcamento() {
		
		JLabel lblConsultaDeOrcamento = new JLabel("Consulta de Or\u00E7amento");
		lblConsultaDeOrcamento.setFont(new Font("Tahoma", Font.BOLD, 18));
		
		JLabel lblNomeDoCliente = new JLabel("Nome do Cliente:");
		
		textNome = new JTextField();
		textNome.setColumns(10);
		
		JLabel lblAutomovel = new JLabel("Autom\u00F3vel:");
		
		textAutomovel = new JTextField();
		textAutomovel.setColumns(10);
		
		
		tblOrcamento = new JTable();
		limparTabela();
		
		JButton btnConsultar = new JButton("Consultar");
		btnConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				orcamento.setSituacao(cbSituacao.getSelectedIndex());
				atualizarTabelaOrc();
				txtIdExcluir.setText("");
				textAutomovel.setText("");
				textNome.setText("");
				
			}
		});
		
		JButton btnFechar = new JButton("Fechar");
		
		JLabel lblSituacao = new JLabel("Situa\u00E7\u00E3o:");
		
		situacoes = controllerSituacao.consultarSituacao();
		cbSituacao = new JComboBox(situacoes.toArray());
		cbSituacao.setSelectedIndex(-1);
		
		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limparTabela();
				txtIdExcluir.setText("");
				textAutomovel.setText("");
				textNome.setText("");
				cbSituacao.setSelectedIndex(-1);
			}
		});
		
		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int id = Integer.parseInt(txtIdExcluir.getText());
				controller.deletarOrcamento(id);			
				txtIdExcluir.setText("");
				textAutomovel.setText("");
				textNome.setText("");
				cbSituacao.setSelectedIndex(-1);
				limparTabela();
			}
		});
		
		JLabel lblDigiteId = new JLabel("Digite  Id:");
		
		txtIdExcluir = new JTextField();
		txtIdExcluir.setColumns(10);
	
		
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap(23, Short.MAX_VALUE)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(25)
									.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
										.addComponent(lblNomeDoCliente)
										.addComponent(lblAutomovel)
										.addComponent(lblSituacao))
									.addPreferredGap(ComponentPlacement.RELATED)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addGroup(groupLayout.createSequentialGroup()
											.addGap(266)
											.addComponent(lblConsultaDeOrcamento, GroupLayout.PREFERRED_SIZE, 222, GroupLayout.PREFERRED_SIZE))
										.addComponent(textNome, GroupLayout.PREFERRED_SIZE, 400, GroupLayout.PREFERRED_SIZE)
										.addComponent(textAutomovel, GroupLayout.PREFERRED_SIZE, 129, GroupLayout.PREFERRED_SIZE)
										.addComponent(cbSituacao, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(btnConsultar))
								.addGroup(groupLayout.createSequentialGroup()
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(tblOrcamento, GroupLayout.PREFERRED_SIZE, 747, GroupLayout.PREFERRED_SIZE))))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(32)
							.addComponent(lblDigiteId)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(txtIdExcluir, GroupLayout.PREFERRED_SIZE, 74, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnExcluir)
							.addPreferredGap(ComponentPlacement.RELATED, 350, Short.MAX_VALUE)
							.addComponent(btnLimpar)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnFechar)))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(34)
					.addComponent(lblConsultaDeOrcamento)
					.addPreferredGap(ComponentPlacement.RELATED, 60, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNomeDoCliente)
						.addComponent(textNome, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnConsultar))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblAutomovel)
						.addComponent(textAutomovel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(cbSituacao, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblSituacao))
					.addGap(34)
					.addComponent(tblOrcamento, GroupLayout.PREFERRED_SIZE, 323, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnFechar)
						.addComponent(btnLimpar)
						.addComponent(lblDigiteId)
						.addComponent(txtIdExcluir, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnExcluir))
					.addGap(21))
		);
		setLayout(groupLayout);

	}
	protected void atualizarTabelaOrc() {
		String filtroNome = textNome.getText();
		String filtroCarro = textAutomovel.getText();
		int filtroSituacao = orcamento.getSituacao();
		if (!filtroNome.equals("")) {
			orcamentos = controller.consultarOrcNome(filtroNome);
		}
		if (!filtroCarro.equals("")) {
			orcamentos = controller.consultarOrcCarro(filtroCarro);
			
		}
		if (filtroSituacao != -1) {
			orcamentos = controller.consultarOrcSituacao(filtroSituacao);
			
		}
		if (filtroNome.contentEquals("") && filtroCarro.equals("") && filtroSituacao == -1) {
			
			orcamentos = controller.listarOrcamentos();  
		}
			

		limparTabela();

		DefaultTableModel model = (DefaultTableModel) tblOrcamento.getModel();
		for (Orcamento orc : orcamentos) {
			String[] novaLinha = new String[6];
			novaLinha[0] = String.valueOf(orc.getIdOrcamento());
			novaLinha[1] = orc.getNmCliente();
			novaLinha[2] = orc.getModeloCarro();
			novaLinha[3] = String.valueOf(orc.getDataInicio());
			novaLinha[4] = String.valueOf(orc.getValorTotal());
			novaLinha[5] = orc.getDeSituacao();			
			
			model.addRow(novaLinha);
		}
	}
	
	private void limparTabela() {
		
		tblOrcamento.setModel(new DefaultTableModel(new Object[][] { colunasTabelaOrc, }, colunasTabelaOrc));
	}
}
