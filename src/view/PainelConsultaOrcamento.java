package view;

import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;

import controller.ControllerCliente;
import controller.ControllerMecanico;
import controller.ControllerOrcamento;
import controller.ControllerSituacao;
import model.entity.Carro;
import model.entity.Cliente;
import model.entity.Orcamento;
import model.entity.Peca;
import model.entity.Situacao;

import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.Font;
import java.util.ArrayList;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.awt.event.ActionEvent;

public class PainelConsultaOrcamento extends JPanel {
	private JTextField textNome;
	private JTextField textAutomovel;
	private JTable tblOrcamento;
	private String[] colunasTabelaOrc = { "N."," CLIENTE", "CARRO", "PLACA", "DATA ENTRADA", "VALOR", "SITUAÇÃO" };
	private ArrayList<Orcamento>orcamentos;
	private ArrayList<Cliente>clientes;
	private ArrayList<Carro>carros;
	ControllerOrcamento controller = new ControllerOrcamento();
	ControllerMecanico controllerMecanico = new ControllerMecanico();
	ControllerCliente controllercliente = new ControllerCliente();
	
	
	ControllerSituacao controllerSituacao = new ControllerSituacao();
	ArrayList<String> situacoes; 
	private JTextField txtNumero;
	JComboBox cbSituacao;
	Orcamento orcamento = new Orcamento();
	private JFormattedTextField txtPlaca;
	
	
	

	/**
	 * Create the panel.
	 */
	public PainelConsultaOrcamento() {
		
		MaskFormatter formato;
		try {
			formato = new MaskFormatter("AAA-####");
			 txtPlaca = new JFormattedTextField(formato);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.getMessage();
		}
		
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
				
				atualizarTabelaOrc();
				txtNumero.setText("");
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
				txtNumero.setText("");
				textAutomovel.setText("");
				textNome.setText("");
				cbSituacao.setSelectedIndex(-1);
			}
		});
		
		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int id = Integer.parseInt(txtNumero.getText());
				controller.deletarOrcamento(id);			
				txtNumero.setText("");
				textAutomovel.setText("");
				textNome.setText("");
				cbSituacao.setSelectedIndex(-1);
				limparTabela();
			}
		});
		
		JLabel lblDigiteId = new JLabel("Digite  N\u00FAmero:");
		
		txtNumero = new JTextField();
		txtNumero.setColumns(10);
		
		JLabel lblDigiteAPlaca = new JLabel("Digite a Placa:");
		
		
		txtPlaca.setText("   -    ");
		txtPlaca.setColumns(10);
	
		
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(296)
							.addComponent(lblConsultaDeOrcamento, GroupLayout.PREFERRED_SIZE, 222, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(82)
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addComponent(lblAutomovel)
								.addComponent(lblNomeDoCliente)
								.addComponent(lblSituacao))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(textAutomovel, GroupLayout.PREFERRED_SIZE, 129, GroupLayout.PREFERRED_SIZE)
								.addComponent(cbSituacao, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(textNome, GroupLayout.PREFERRED_SIZE, 456, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(btnConsultar))))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(32)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(tblOrcamento, GroupLayout.PREFERRED_SIZE, 826, GroupLayout.PREFERRED_SIZE)
								.addGroup(groupLayout.createSequentialGroup()
									.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
										.addComponent(lblDigiteAPlaca)
										.addComponent(lblDigiteId))
									.addPreferredGap(ComponentPlacement.RELATED)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addGroup(groupLayout.createSequentialGroup()
											.addComponent(txtNumero, GroupLayout.PREFERRED_SIZE, 74, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(btnExcluir)
											.addPreferredGap(ComponentPlacement.RELATED, 475, Short.MAX_VALUE)
											.addComponent(btnLimpar)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(btnFechar))
										.addComponent(txtPlaca, GroupLayout.PREFERRED_SIZE, 74, GroupLayout.PREFERRED_SIZE))))))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(29)
					.addComponent(lblConsultaDeOrcamento)
					.addGap(26)
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
						.addComponent(lblSituacao)
						.addComponent(cbSituacao, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(27)
					.addComponent(tblOrcamento, GroupLayout.PREFERRED_SIZE, 444, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblDigiteAPlaca)
						.addComponent(txtPlaca, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnFechar)
						.addComponent(btnLimpar)
						.addComponent(lblDigiteId)
						.addComponent(txtNumero, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnExcluir))
					.addGap(21))
		);
		setLayout(groupLayout);

	}
	protected void atualizarTabelaOrc() {
		String filtroNome = textNome.getText();
		String filtroCarro = textAutomovel.getText();
		int filtroSituacao = cbSituacao.getSelectedIndex();
		if (!filtroNome.equals("")) {
			orcamentos = controller.consultarOrcNome(filtroNome);
		}
		if (!filtroCarro.equals("")) {
			orcamentos = controller.consultarOrcCarro(filtroCarro);
			
		}
		if (filtroSituacao != -1) {
			orcamentos = controller.consultarOrcSituacao(filtroSituacao);
			
		}
		if (filtroNome.equals("") && filtroCarro.equals("") && filtroSituacao == -1) {
			
			orcamentos = controller.listarOrcamentos();  
		}
			

		limparTabela();

		DefaultTableModel model = (DefaultTableModel) tblOrcamento.getModel();
		for (Orcamento orc : orcamentos) {
			String[] novaLinha = new String[7];
			novaLinha[0] = String.valueOf(orc.getNumeroOrcamento());
			
			Cliente c = new Cliente();
			c = controllercliente.consultarNome(orc.getCarro().getIdCliente());					
			novaLinha[1] = c.getNome();
			
			novaLinha[2] = String.valueOf(orc.getCarro().getModelo());
			novaLinha[3] = String.valueOf(orc.getCarro().getPlaca());
			novaLinha[4] = String.valueOf(orc.getDataInicio());
			
			double valTotal = (orc.getValorPeca() + orc.getValorMaoObra());
			String valor = "R$" + String.valueOf(valTotal);
			novaLinha[5] = valor;
			
			novaLinha[6] = String.valueOf(orc.getSituacao().getDeSituacao());			
			
			model.addRow(novaLinha);
		}
	}
	
	private void limparTabela() {
		
		tblOrcamento.setModel(new DefaultTableModel(new Object[][] { colunasTabelaOrc, }, colunasTabelaOrc));
	}
}
