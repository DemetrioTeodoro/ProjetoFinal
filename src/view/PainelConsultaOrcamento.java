package view;

import javax.swing.JPanel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;

import controller.ControllerCarro;
import controller.ControllerCliente;
import controller.ControllerMecanico;
import controller.ControllerOrcamento;
import controller.ControllerPeca;
import controller.ControllerSituacao;
import model.entity.Carro;
import model.entity.Cliente;
import model.entity.Orcamento;
import model.entity.Peca;
import model.entity.Situacao;

import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFormattedTextField;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.Font;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.time.format.DateTimeFormatter;
import java.awt.event.ActionEvent;

public class PainelConsultaOrcamento extends JPanel {
	private JTextField textNome;
	private JTable tblOrcamento;
	private String[] colunasTabelaOrc = { "N."," CLIENTE", "CARRO", "PLACA", "DATA ENTRADA", "VALOR", "SITUAÇÃO" };
	private ArrayList<Orcamento>orcamentos;
	private ArrayList<Cliente>clientes;
	ControllerOrcamento controller = new ControllerOrcamento();
	ControllerMecanico controllerMecanico = new ControllerMecanico();
	ControllerCliente controllercliente = new ControllerCliente();
	ControllerSituacao controllerSituacao = new ControllerSituacao();
	ArrayList<String> situacoes; 
	private JTextField txtNumero;
	JComboBox cbSituacao;
	Orcamento orcamento = new Orcamento();
	private JComboBox cbMarca;
	private List<Carro>carros;
	ControllerCarro controllerCarro = new ControllerCarro();
	
	DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	

	/**
	 * Create the panel.
	 */
	public PainelConsultaOrcamento() {
		
		MaskFormatter formato;
		try {
			formato = new MaskFormatter("AAA-####");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.getMessage();
		}
		
		JLabel lblConsultaDeOrcamento = new JLabel("Consulta de Or\u00E7amento");
		lblConsultaDeOrcamento.setFont(new Font("Tahoma", Font.BOLD, 18));
		
		JLabel lblNomeDoCliente = new JLabel("Nome do Cliente:");
		
		textNome = new JTextField();
		textNome.setColumns(10);
		
		JLabel lblAutomovel = new JLabel("Marca:");
		
		
		tblOrcamento = new JTable();
		limparTabela();
		
		JButton btnConsultar = new JButton("Consultar");
		btnConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				atualizarTabelaOrc();
				txtNumero.setText("");
				cbMarca.setSelectedIndex(-1);
				textNome.setText("");
				cbSituacao.setSelectedIndex(-1);
				
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
				cbMarca.setSelectedIndex(-1);
				textNome.setText("");
				cbSituacao.setSelectedIndex(-1);
			}
		});
		
		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String Nuexclusao = txtNumero.getText();
				controller.deletarOrcamento(Nuexclusao);			
				txtNumero.setText("");
				cbMarca.setSelectedIndex(-1);
				textNome.setText("");
				cbSituacao.setSelectedIndex(-1);
				limparTabela();
			}
		});
		
		JLabel lblDigiteId = new JLabel("Digite  N\u00FAmero:");
		
		txtNumero = new JTextField();
		txtNumero.setColumns(10);
		
		JButton btnGerarRelatrio = new JButton("Gerar Relat\u00F3rio");
		btnGerarRelatrio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JFileChooser jcf = new JFileChooser();
				jcf.setDialogTitle("Salvar relatório como...");
				
				int resultado = jcf.showSaveDialog(null);
				if (resultado == JFileChooser.APPROVE_OPTION) {
					String caminhoEscolhido = jcf.getSelectedFile().getAbsolutePath();
					
					ControllerOrcamento controllerOrcamento = new ControllerOrcamento();
					controllerOrcamento.gerarRelatorio(orcamentos, caminhoEscolhido);
				}
			}
		});
		
		this.popularCbMarca();
		cbMarca = new JComboBox();
		cbMarca.setModel(new DefaultComboBoxModel(carros.toArray()));
		cbMarca.setSelectedIndex(-1);
	
		
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
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(textNome, GroupLayout.PREFERRED_SIZE, 456, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(btnConsultar))
								.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
									.addComponent(cbMarca, Alignment.LEADING, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(cbSituacao, Alignment.LEADING, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(32)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(tblOrcamento, GroupLayout.PREFERRED_SIZE, 826, GroupLayout.PREFERRED_SIZE)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblDigiteId)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(txtNumero, GroupLayout.PREFERRED_SIZE, 74, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(btnExcluir)
									.addPreferredGap(ComponentPlacement.RELATED, 289, Short.MAX_VALUE)
									.addComponent(btnGerarRelatrio)
									.addGap(18)
									.addComponent(btnLimpar)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(btnFechar)
									.addGap(22)))))
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
						.addComponent(cbMarca, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblSituacao)
						.addComponent(cbSituacao, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(27)
					.addComponent(tblOrcamento, GroupLayout.PREFERRED_SIZE, 444, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblDigiteId)
						.addComponent(txtNumero, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnExcluir)
						.addComponent(btnGerarRelatrio)
						.addComponent(btnLimpar)
						.addComponent(btnFechar))
					.addGap(21))
		);
		setLayout(groupLayout);

	}
	protected void atualizarTabelaOrc() {
		String filtroNome = textNome.getText();
		Carro filtroCarro = (Carro)cbMarca.getSelectedItem();
		int filtroSituacao = cbSituacao.getSelectedIndex();
	
			
		orcamentos = controller.listarOrcamentos(filtroNome, filtroCarro, filtroSituacao);  
		
			

		limparTabela();

		DefaultTableModel model = (DefaultTableModel) tblOrcamento.getModel();
		for (Orcamento orc : orcamentos) {
			String[] novaLinha = new String[7];
			novaLinha[0] = String.valueOf(orc.getNumeroOrcamento());
			
			Cliente c = new Cliente();
			c = controllercliente.consultarNome(orc.getCarro().getIdCliente());		
			orc.setCliente(c);
			novaLinha[1] = orc.getCliente().getNome();
			
			novaLinha[2] = String.valueOf(orc.getCarro().getModelo());
			novaLinha[3] = String.valueOf(orc.getCarro().getPlaca());
			novaLinha[4] = String.valueOf(orc.getDataInicio().format(format));
			
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
	
	private void popularCbMarca() {
		
		carros = controllerCarro.listarTodos();
	}
	
	
}
