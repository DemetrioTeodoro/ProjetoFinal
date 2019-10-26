package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

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

public class PainelAlterarOrcamento extends JPanel {
	private JTextField textNome;
	private JTextField textTelefone;
//	private ControladoraUsuario controllerUsuario = new ControladoraUsuario();
	private String msg = "";
	private JFormattedTextField textCPF = new JFormattedTextField();
	private JTextField textServico;
	private JTextField textAutomovel;
	private JTextField textPlaca;
	private JTextField textDescricao;
	private JTextField textMecanico;
	private JTable table;
	private JTextField textDataEntrada;
	private JTextField textDataSaida;

	/**
	 * Create the panel.
	 */
	public PainelAlterarOrcamento() {
		
		JLabel lblAlterarOrcamento = new JLabel("Alterar Or\u00E7amento");
		
		JLabel lblNomeCliente = new JLabel("Nome do Cliente:");
		
		JLabel lblCPF = new JLabel("CPF:");
		
		JLabel lblTelefone = new JLabel("Telefone:");
		
		textNome = new JTextField();
		textNome.setColumns(10);
		
		textTelefone = new JTextField();
		textTelefone.setColumns(10);
		
		MaskFormatter formato;
		try {
			formato = new MaskFormatter("###.###.###-##");
			 textCPF = new JFormattedTextField(formato);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.getMessage();
		}
		
		JButton btnAlterar = new JButton("Alterar");
		btnAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String msg = "";
				String nome = textNome.getText();
				String cpf = textCPF.getText().replace(".", "").replace("-", "");
				String telefone = textTelefone.getText();
//				msg = controllerUsuario.cadastrarUsuarioController(nome, cpf, telefone, login, senha);
			}
		});
		
		textCPF.setText("   .   .   -   ");
		
		JLabel lblServico = new JLabel("Servi\u00E7o:");
		
		textServico = new JTextField();
		textServico.setColumns(10);
		
		JLabel lblAutomovel = new JLabel("Automovel:");
		
		textAutomovel = new JTextField();
		textAutomovel.setColumns(10);
		
		JLabel lblPlaca = new JLabel("Placa:");
		
		textPlaca = new JTextField();
		textPlaca.setColumns(10);
		
		JLabel lblDescricao = new JLabel("Descri\u00E7\u00E3o:");
		
		textDescricao = new JTextField();
		textDescricao.setColumns(10);
		
		JLabel lblMecanico = new JLabel("Mecanico:");
		
		textMecanico = new JTextField();
		textMecanico.setColumns(10);
		
		JLabel lblPeca = new JLabel("Pe\u00E7a:");
		
		JComboBox cbPeca = new JComboBox();
		
		table = new JTable();
		
		JButton btnAdd = new JButton("Add");
		
		JLabel lblDataEntrada = new JLabel("Data Entrada:");
		
		textDataEntrada = new JTextField();
		textDataEntrada.setColumns(10);
		
		JLabel lblDataSada = new JLabel("Data Sa\u00EDda:");
		
		textDataSaida = new JTextField();
		textDataSaida.setColumns(10);
		
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
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(89)
							.addComponent(lblNomeCliente)
							.addGap(7)
							.addComponent(textNome, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(31)
							.addComponent(lblCPF)
							.addGap(6)
							.addComponent(textCPF, GroupLayout.PREFERRED_SIZE, 94, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(119)
							.addComponent(lblServico)
							.addGap(6)
							.addComponent(textServico, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(38)
							.addComponent(lblTelefone)
							.addGap(5)
							.addComponent(textTelefone, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(101)
							.addComponent(lblAutomovel)
							.addGap(19)
							.addComponent(textAutomovel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(131)
							.addComponent(lblPlaca)
							.addGap(6)
							.addComponent(textPlaca, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(106)
							.addComponent(lblDescricao)
							.addGap(6)
							.addComponent(textDescricao, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(108)
							.addComponent(lblMecanico)
							.addGap(6)
							.addComponent(textMecanico, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(286)
							.addComponent(lblAlterarOrcamento))
						.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
							.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
								.addGap(150)
								.addComponent(btnFechar)
								.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(btnAlterar))
							.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
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
										.addComponent(textDataEntrada, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
									.addGroup(groupLayout.createSequentialGroup()
										.addGap(18)
										.addComponent(lblDataSada)
										.addGap(9)
										.addComponent(textDataSaida, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
									.addGroup(groupLayout.createSequentialGroup()
										.addGap(30)
										.addComponent(lblSituacao)
										.addGap(10)
										.addComponent(cbSituacao, GroupLayout.PREFERRED_SIZE, 118, GroupLayout.PREFERRED_SIZE)))
								.addGap(13)
								.addComponent(btnAdd)
								.addGap(39)
								.addComponent(table, GroupLayout.PREFERRED_SIZE, 107, GroupLayout.PREFERRED_SIZE))))
					.addContainerGap(233, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(74)
					.addComponent(lblAlterarOrcamento)
					.addGap(36)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(3)
							.addComponent(lblNomeCliente))
						.addComponent(textNome, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(3)
							.addComponent(lblCPF))
						.addComponent(textCPF, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(17)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblServico)
						.addComponent(textServico, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblTelefone)
						.addComponent(textTelefone, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(22)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblAutomovel)
						.addComponent(textAutomovel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(24)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(3)
							.addComponent(lblPlaca))
						.addComponent(textPlaca, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(29)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblDescricao)
						.addComponent(textDescricao, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(19)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblMecanico)
						.addComponent(textMecanico, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
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
								.addComponent(textDataEntrada, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(27)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(3)
									.addComponent(lblDataSada))
								.addComponent(textDataSaida, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
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
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnFechar)
						.addComponent(btnAlterar)))
		);
		setLayout(groupLayout);
	

	}
}
