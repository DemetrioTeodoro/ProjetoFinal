package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JComboBox;
//import controller.ControladoraUsuario;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;

import controller.ControllerMecanico;
import controller.ControllerOrcamento;
import controller.ControllerServico;
import controller.ControllerSituacao;
import model.entity.Carro;
import model.entity.Cliente;
import model.entity.Orcamento;

import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextArea;
import java.awt.Font;

public class PainelCadastroOrcamento extends JPanel {
	private JTextField txtNome;
	private JTextField txtTelefone;
//	private ControladoraUsuario controllerUsuario = new ControladoraUsuario();
	private String msg = "";
	private JFormattedTextField textCPF = new JFormattedTextField();
	private JFormattedTextField txtCPF;
	private JTextField txtModelo;
	private JTextField txtPlaca;
	private JTextField txtDataSaida;
	private JTextField txtDtEntrada;
	private JTextField txtMarca;
	private JTextField txtAno;
	private JTextField txtCor;
	private JTextField txtDescricao;
	
	ArrayList<String> situacoes; 
	JComboBox cbSituacao; 

	
	DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	
	ControllerOrcamento controller = new ControllerOrcamento();
	private JTable table;
	/**
	 * Create the panel.
	 */
	public PainelCadastroOrcamento() {
		
		
		
		JLabel lblCadastroOrcamento = new JLabel("Cadastro de Or\u00E7amento");
		lblCadastroOrcamento.setFont(new Font("Tahoma", Font.BOLD, 18));
		
		JLabel lblNomeCliente = new JLabel("Nome do Cliente:");
		
		JLabel lblCpf = new JLabel("CPF:");
		
		JLabel lblTelefone = new JLabel("Telefone:");
		
		txtNome = new JTextField();
		txtNome.setColumns(10);
		
		txtTelefone = new JTextField();
		txtTelefone.setColumns(10);
		
		MaskFormatter formato;
		try {
			formato = new MaskFormatter("###.###.###-##");
			 txtCPF = new JFormattedTextField(formato);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.getMessage();
		}
		
		JButton btnSalvar = new JButton("Cadastrar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String msg = "";
				String nome = txtNome.getText();
				String cpf = textCPF.getText().replace(".", "").replace("-", "");
				String telefone = txtTelefone.getText();
//				msg = controllerUsuario.cadastrarUsuarioController(nome, cpf, telefone, login, senha);
				
				Carro carro = new Carro();
				carro.setMarca(txtMarca.getText());
				carro.setAno(txtAno.getText());
				carro.setCor(txtCor.getText());
				carro.setModelo(txtModelo.getText());
				carro.setPlaca(txtPlaca.getText());
				
				Cliente cliente = new Cliente();
				cliente.setNome(nome);
				cliente.setCpf(cpf);
				cliente.setTelefone(telefone);
				cliente.setCarro(carro);
				
				Orcamento orcamento = new Orcamento();
				orcamento.setCliente(cliente);
				orcamento.setDescricao(txtDescricao.getText());
				orcamento.setDataInicio(LocalDate.parse((txtDtEntrada.getText()), format));
				orcamento.setSituacao(cbSituacao.getSelectedIndex());
				
				controller.cadastrarOrcamento(orcamento);
			
				
			}
		});
		
		txtCPF.setText("   .   .   -   ");
		
		JLabel lblServico = new JLabel("Servi\u00E7o:");
		
		JLabel lblModelo = new JLabel("Modelo:");
		
		txtModelo = new JTextField();
		txtModelo.setColumns(10);
		
		JLabel lblPlaca = new JLabel("Placa:");
		
		txtPlaca = new JTextField();
		txtPlaca.setColumns(10);
		
		JLabel lblDescricao = new JLabel("Descri\u00E7\u00E3o:");
		
		JLabel lblMecanico = new JLabel("Mecanico:");
		
		JLabel lblPeca = new JLabel("Pe\u00E7a:");
		
		JComboBox cbPeca = new JComboBox();
		
		JButton btnAdd = new JButton("Add");
		
		JLabel lblDataEntrada = new JLabel("Data de Entrada:");
		
		JLabel lblDataSada = new JLabel("Data de Sa\u00EDda:");
		
		txtDataSaida = new JTextField();
		txtDataSaida.setColumns(10);
		
		JLabel lblSituacao = new JLabel("Situa\u00E7\u00E3o:");
		
		JButton btnFechar = new JButton("Fechar");
		btnFechar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
			}
		});
		
		abaMecanico();
		
		
		ControllerSituacao controllerSituacao = new ControllerSituacao();
		situacoes = controllerSituacao.consultarSituacao();	
		cbSituacao = new JComboBox(situacoes.toArray());
		cbSituacao.setSelectedIndex(-1);
		
		txtDtEntrada = new JTextField();
		txtDtEntrada.setColumns(10);
		
		JLabel lblMarca = new JLabel("Marca:");
		
		txtMarca = new JTextField();
		txtMarca.setColumns(10);
		
		JLabel lblAno = new JLabel("Ano:");
		
		txtAno = new JTextField();
		txtAno.setColumns(10);
		
		JLabel lblCor = new JLabel("Cor:");
		
		txtCor = new JTextField();
		txtCor.setColumns(10);
		
		txtDescricao = new JTextField();
		txtDescricao.setColumns(10);
		
		ControllerServico controllerServico = new ControllerServico();
		ArrayList<String> servicos = controllerServico.consultarServico();
		JComboBox cbServico = new JComboBox(servicos.toArray());
		cbServico.setSelectedIndex(-1);
		cbServico.setEnabled(false);
		
		table = new JTable();
		
		ControllerMecanico controllerMecanico = new ControllerMecanico();
		ArrayList<String> mecanicos = controllerMecanico.consultarMecanico();
		JComboBox cbMecanico = new JComboBox(mecanicos.toArray());
		cbMecanico.setSelectedIndex(-1);
		cbMecanico.setEnabled(false);
		cbPeca.setEnabled(false);
		
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(149)
							.addComponent(btnFechar)
							.addGap(427)
							.addComponent(btnSalvar))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(88)
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addComponent(lblPlaca)
								.addComponent(lblModelo)
								.addComponent(lblDataSada)
								.addComponent(lblDataEntrada)
								.addComponent(lblServico)
								.addComponent(lblDescricao)
								.addComponent(lblMarca)
								.addComponent(lblAno)
								.addComponent(lblSituacao)
								.addComponent(lblPeca)
								.addComponent(lblMecanico))
							.addGap(18)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(txtDataSaida, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(txtPlaca, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
											.addComponent(txtAno, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
											.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
												.addComponent(txtMarca, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
												.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
													.addGroup(groupLayout.createSequentialGroup()
														.addComponent(txtModelo, 147, 147, 147)
														.addPreferredGap(ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
														.addComponent(lblCor)
														.addPreferredGap(ComponentPlacement.RELATED)
														.addComponent(txtCor, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
														.addGap(208))
													.addComponent(txtDescricao, GroupLayout.DEFAULT_SIZE, 551, Short.MAX_VALUE)
													.addComponent(table, GroupLayout.DEFAULT_SIZE, 551, Short.MAX_VALUE)
													.addGroup(groupLayout.createSequentialGroup()
														.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
															.addComponent(cbPeca, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
															.addComponent(cbSituacao, 0, 278, Short.MAX_VALUE))
														.addGap(18)
														.addComponent(btnAdd))
													.addComponent(txtDtEntrada, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))))
									.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
										.addComponent(cbMecanico, Alignment.LEADING, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(cbServico, Alignment.LEADING, 0, 274, Short.MAX_VALUE)))))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(67)
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addComponent(lblCpf)
								.addComponent(lblNomeCliente)
								.addComponent(lblTelefone))
							.addGap(18)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
									.addComponent(txtTelefone, Alignment.LEADING)
									.addComponent(txtCPF, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 190, Short.MAX_VALUE))
								.addComponent(txtNome, GroupLayout.PREFERRED_SIZE, 474, GroupLayout.PREFERRED_SIZE))
							.addGap(78)))
					.addGap(170))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(311)
					.addComponent(lblCadastroOrcamento, GroupLayout.PREFERRED_SIZE, 234, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(257, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(39)
					.addComponent(lblCadastroOrcamento)
					.addGap(36)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNomeCliente)
						.addComponent(txtNome, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblCpf)
						.addComponent(txtCPF, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtTelefone, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblTelefone))
					.addGap(7)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblModelo)
						.addComponent(lblCor)
						.addComponent(txtCor, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtModelo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblPlaca)
						.addComponent(txtPlaca, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblMarca)
						.addComponent(txtMarca, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblAno)
						.addComponent(txtAno, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(13)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblDescricao)
						.addComponent(txtDescricao, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblServico)
						.addComponent(cbServico, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblMecanico)
						.addComponent(cbMecanico, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblDataEntrada)
						.addComponent(txtDtEntrada, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(10)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(cbSituacao, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblSituacao))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblDataSada)
						.addComponent(txtDataSaida, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(cbPeca, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblPeca)
						.addComponent(btnAdd))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(table, GroupLayout.PREFERRED_SIZE, 84, GroupLayout.PREFERRED_SIZE)
					.addGap(34)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnSalvar)
						.addComponent(btnFechar))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		setLayout(groupLayout);
		
		abaMecanico();
		
	}
	
	public void abaMecanico() {
		txtDataSaida.setEnabled(false);
		
	}
	
	
}
