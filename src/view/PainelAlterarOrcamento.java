package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.ArrayList;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.text.MaskFormatter;

import controller.ControllerMecanico;
import controller.ControllerPeca;
import controller.ControllerServico;
import controller.ControllerSituacao;

import java.awt.Font;

public class PainelAlterarOrcamento extends JPanel {
	private JTextField txtNome;
	private JTextField txtTelefone;
//	private ControladoraUsuario controllerUsuario = new ControladoraUsuario();
	private String msg = "";
	private JFormattedTextField textCPF = new JFormattedTextField();
	private JFormattedTextField txtCPF;
	private JTextField txtPlaca;
	private JTable tblPeca;
	private JTextField txtDataEntrada;
	private JTextField txtDataSaida;
	private JTextField txtModelo;
	private JTextField txtCor;
	private JTextField txtMarca;
	private JTextField txtAno;
	private JTextField txtDescricao;

	/**
	 * Create the panel.
	 */
	public PainelAlterarOrcamento() {
		
		JLabel lblAlterarOrcamento = new JLabel("Alterar Or\u00E7amento");
		lblAlterarOrcamento.setFont(new Font("Tahoma", Font.BOLD, 18));
		
		JLabel lblNomeCliente = new JLabel("Nome do Cliente:");
		
		JLabel lblCPF = new JLabel("CPF:");
		
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
		
		JButton btnAlterar = new JButton("Alterar");
		btnAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String msg = "";
				String nome = txtNome.getText();
				String cpf = textCPF.getText().replace(".", "").replace("-", "");
				String telefone = txtTelefone.getText();
//				msg = controllerUsuario.cadastrarUsuarioController(nome, cpf, telefone, login, senha);
			}
		});
		
		txtCPF.setText("   .   .   -   ");
		
		JLabel lblServico = new JLabel("Servi\u00E7o:");
		
		JLabel lblPlaca = new JLabel("Placa:");
		
		txtPlaca = new JTextField();
		txtPlaca.setColumns(10);
		
		JLabel lblDescricao = new JLabel("Descri\u00E7\u00E3o:");
		
		JLabel lblMecanico = new JLabel("Mecanico:");
		
		JLabel lblPeca = new JLabel("Pe\u00E7a:");
		
		tblPeca = new JTable();
		
		JButton btnAdd = new JButton("Add");
		
		JLabel lblDataEntrada = new JLabel("Data Entrada:");
		
		txtDataEntrada = new JTextField();
		txtDataEntrada.setColumns(10);
		
		JLabel lblDataSada = new JLabel("Data Sa\u00EDda:");
		
		txtDataSaida = new JTextField();
		txtDataSaida.setColumns(10);
		
		JLabel lblSituacao = new JLabel("Situa\u00E7\u00E3o:");
		
		JButton btnFechar = new JButton("Fechar");
		btnFechar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
			}
		});
		
		ControllerSituacao controllerSituacao = new ControllerSituacao();
		ArrayList<String> situacoes = controllerSituacao.consultarSituacao();
		JComboBox cbSituacao = new JComboBox(situacoes.toArray());
		
		JLabel lblModelo = new JLabel("Modelo");
		
		txtModelo = new JTextField();
		txtModelo.setColumns(10);
		
		JLabel lblCor = new JLabel("Cor:");
		
		txtCor = new JTextField();
		txtCor.setColumns(10);
		
		JLabel lblMarca = new JLabel("Marca:");
		
		txtMarca = new JTextField();
		txtMarca.setColumns(10);
		
		JLabel lblAno = new JLabel("Ano:");
		
		txtAno = new JTextField();
		txtAno.setColumns(10);
		
		txtDescricao = new JTextField();
		txtDescricao.setColumns(10);
		
		ControllerServico controllerServico = new ControllerServico();
		ArrayList<String> servicos = controllerServico.consultarServico();
		JComboBox cbServico = new JComboBox(servicos.toArray());
		
		ControllerMecanico controllerMecanico = new ControllerMecanico();
		ArrayList<String> mecanicos = controllerMecanico.consultarMecanico();
		JComboBox cbMecanico = new JComboBox(mecanicos.toArray());
		
		JComboBox cbPeca = new JComboBox();
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addContainerGap(731, Short.MAX_VALUE)
					.addComponent(btnAlterar)
					.addContainerGap())
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(76)
					.addComponent(btnFechar)
					.addGap(667))
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addGap(76)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblPeca)
						.addComponent(lblServico)
						.addComponent(lblDescricao)
						.addComponent(lblMecanico)
						.addComponent(lblDataEntrada)
						.addComponent(lblSituacao)
						.addComponent(lblDataSada)
						.addComponent(lblNomeCliente)
						.addComponent(lblCPF)
						.addComponent(lblTelefone)
						.addComponent(lblModelo)
						.addComponent(lblPlaca)
						.addComponent(lblMarca)
						.addComponent(lblAno))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addComponent(cbServico, Alignment.LEADING, 0, 268, Short.MAX_VALUE)
								.addComponent(cbMecanico, Alignment.LEADING, 0, 268, Short.MAX_VALUE)
								.addComponent(cbPeca, 0, 268, Short.MAX_VALUE)
								.addComponent(txtDataEntrada, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(cbSituacao, Alignment.LEADING, 0, 268, Short.MAX_VALUE)
								.addComponent(txtDataSaida, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(23)
							.addComponent(btnAdd)
							.addGap(193))
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
							.addComponent(txtAno, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(txtMarca, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(txtPlaca, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGroup(groupLayout.createSequentialGroup()
								.addComponent(txtModelo, GroupLayout.PREFERRED_SIZE, 159, GroupLayout.PREFERRED_SIZE)
								.addGap(82)
								.addComponent(lblCor)
								.addGap(18)
								.addComponent(txtCor, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addComponent(txtNome, GroupLayout.PREFERRED_SIZE, 403, GroupLayout.PREFERRED_SIZE)
							.addComponent(txtCPF, GroupLayout.PREFERRED_SIZE, 177, GroupLayout.PREFERRED_SIZE)
							.addComponent(txtTelefone, GroupLayout.PREFERRED_SIZE, 167, GroupLayout.PREFERRED_SIZE)
							.addComponent(txtDescricao, GroupLayout.DEFAULT_SIZE, 539, Short.MAX_VALUE))
						.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
							.addComponent(tblPeca, GroupLayout.DEFAULT_SIZE, 526, Short.MAX_VALUE)
							.addGap(95)))
					.addContainerGap())
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(314)
					.addComponent(lblAlterarOrcamento)
					.addContainerGap(332, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(45)
					.addComponent(lblAlterarOrcamento)
					.addGap(57)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblDescricao)
							.addGap(84))
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(txtNome, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNomeCliente))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(txtCPF, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblCPF))
							.addGap(6)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(txtTelefone, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblTelefone))
							.addGap(9)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(txtModelo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblCor)
								.addComponent(txtCor, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblModelo))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(txtPlaca, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblPlaca))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(txtMarca, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblMarca))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(txtAno, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblAno))
							.addGap(18)
							.addComponent(txtDescricao, GroupLayout.PREFERRED_SIZE, 84, GroupLayout.PREFERRED_SIZE)
							.addGap(18)))
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblServico)
						.addComponent(cbServico, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblMecanico)
						.addComponent(cbMecanico, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblDataEntrada)
						.addComponent(txtDataEntrada, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblSituacao)
						.addComponent(cbSituacao, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblDataSada)
						.addComponent(txtDataSaida, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblPeca)
						.addComponent(btnAdd)
						.addComponent(cbPeca, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(tblPeca, GroupLayout.PREFERRED_SIZE, 78, GroupLayout.PREFERRED_SIZE)
					.addGap(28)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnAlterar)
						.addComponent(btnFechar))
					.addGap(38))
		);
		setLayout(groupLayout);
	

	}
}
