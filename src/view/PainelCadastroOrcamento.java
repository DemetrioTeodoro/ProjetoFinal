package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

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

public class PainelCadastroOrcamento extends JPanel {
	private JTextField txtNome;
	private JTextField txtTelefone;
//	private ControladoraUsuario controllerUsuario = new ControladoraUsuario();
	private String msg = "";
	private JFormattedTextField textCPF = new JFormattedTextField();
	private JFormattedTextField txtCPF;
	private JTextField txtServico;
	private JTextField txtAutomovel;
	private JTextField txtPlaca;
	private JTextField txtDescricao;
	private JTextField txtMecanico;
	private JTable table;
	private JTextField txtDataEntrada;
	private JTextField txtDataSaida;

	/**
	 * Create the panel.
	 */
	public PainelCadastroOrcamento() {
		
		JLabel lblCadastroOrcamento = new JLabel("Cadastro Or\u00E7amento");
		
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
			}
		});
		
		txtCPF.setText("   .   .   -   ");
		
		JLabel lblServico = new JLabel("Servi\u00E7o:");
		
		txtServico = new JTextField();
		txtServico.setColumns(10);
		
		JLabel lblAutomovel = new JLabel("Automovel:");
		
		txtAutomovel = new JTextField();
		txtAutomovel.setColumns(10);
		
		JLabel lblPlaca = new JLabel("Placa:");
		
		txtPlaca = new JTextField();
		txtPlaca.setColumns(10);
		
		JLabel lblDescricao = new JLabel("Descri\u00E7\u00E3o:");
		
		txtDescricao = new JTextField();
		txtDescricao.setColumns(10);
		
		JLabel lblMecanico = new JLabel("Mecanico:");
		
		txtMecanico = new JTextField();
		txtMecanico.setColumns(10);
		
		JLabel lblPeca = new JLabel("Pe\u00E7a:");
		
		JComboBox cbPeca = new JComboBox();
		
		table = new JTable();
		
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
		
		JComboBox cbSituacao = new JComboBox();
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(251)
					.addComponent(lblCadastroOrcamento))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(89)
					.addComponent(lblNomeCliente)
					.addGap(7)
					.addComponent(txtNome, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(31)
					.addComponent(lblCpf)
					.addGap(6)
					.addComponent(txtCPF, GroupLayout.PREFERRED_SIZE, 94, GroupLayout.PREFERRED_SIZE))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(119)
					.addComponent(lblServico)
					.addGap(6)
					.addComponent(txtServico, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(38)
					.addComponent(lblTelefone)
					.addGap(5)
					.addComponent(txtTelefone, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(101)
					.addComponent(lblAutomovel)
					.addGap(19)
					.addComponent(txtAutomovel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(131)
					.addComponent(lblPlaca)
					.addGap(6)
					.addComponent(txtPlaca, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(106)
					.addComponent(lblDescricao)
					.addGap(6)
					.addComponent(txtDescricao, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(108)
					.addComponent(lblMecanico)
					.addGap(6)
					.addComponent(txtMecanico, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(101)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(33)
							.addComponent(lblPeca)
							.addGap(6)
							.addComponent(cbPeca, GroupLayout.PREFERRED_SIZE, 139, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblDataEntrada)
							.addGap(5)
							.addComponent(txtDataEntrada, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(18)
							.addComponent(lblDataSada)
							.addGap(9)
							.addComponent(txtDataSaida, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(30)
							.addComponent(lblSituacao)
							.addGap(10)
							.addComponent(cbSituacao, GroupLayout.PREFERRED_SIZE, 118, GroupLayout.PREFERRED_SIZE)))
					.addGap(13)
					.addComponent(btnAdd)
					.addGap(39)
					.addComponent(table, GroupLayout.PREFERRED_SIZE, 107, GroupLayout.PREFERRED_SIZE))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(150)
					.addComponent(btnFechar)
					.addGap(203)
					.addComponent(btnSalvar))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(74)
					.addComponent(lblCadastroOrcamento)
					.addGap(36)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(3)
							.addComponent(lblNomeCliente))
						.addComponent(txtNome, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(3)
							.addComponent(lblCpf))
						.addComponent(txtCPF, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(17)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblServico)
						.addComponent(txtServico, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblTelefone)
						.addComponent(txtTelefone, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(22)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblAutomovel)
						.addComponent(txtAutomovel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(24)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(3)
							.addComponent(lblPlaca))
						.addComponent(txtPlaca, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(29)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblDescricao)
						.addComponent(txtDescricao, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(19)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblMecanico)
						.addComponent(txtMecanico, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(19)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(1)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(3)
									.addComponent(lblPeca))
								.addComponent(cbPeca, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(3)
									.addComponent(lblDataEntrada))
								.addComponent(txtDataEntrada, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(27)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(3)
									.addComponent(lblDataSada))
								.addComponent(txtDataSaida, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(23)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(3)
									.addComponent(lblSituacao))
								.addComponent(cbSituacao, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
						.addComponent(btnAdd)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(5)
							.addComponent(table, GroupLayout.PREFERRED_SIZE, 167, GroupLayout.PREFERRED_SIZE)))
					.addGap(79)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(btnFechar)
						.addComponent(btnSalvar)))
		);
		setLayout(groupLayout);

	}
}
