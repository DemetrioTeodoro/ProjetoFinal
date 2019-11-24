package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;

import controller.ControllerPeca;
import model.entity.Peca;

public class PainelCadastroPeca extends JPanel {
	private JTextField txtNmPeca;
	private JTextField txtCdPeca;
	private JTextField txtValorCompra;
	private JTextField txtValorVenda;
	private JTextField txtQuantidade;
	private JTextField txtDtEntrada;
	private JTextField txtDtSaida;

	DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	
	ControllerPeca controller = new ControllerPeca();

	/**
	 * Create the panel.
	 */
	public PainelCadastroPeca() {
		
		JLabel lblCadastroDePeca = new JLabel("Cadastro de Peca");
		
		JLabel lblNomeDaPeca = new JLabel("Nome da Peca:");
		
		JLabel lblCodigo = new JLabel("C\u00F3digo:");
		
		JLabel lblValorCompra = new JLabel("Valor de Compra:");
		
		JLabel lblQuantidade = new JLabel("Quantidade:");
		
		txtNmPeca = new JTextField();
		txtNmPeca.setColumns(10);
		
		txtCdPeca = new JTextField();
		txtCdPeca.setColumns(10);
		
		txtValorCompra = new JTextField();
		txtValorCompra.setColumns(10);
		
		txtQuantidade = new JTextField();
		txtQuantidade.setColumns(10);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
	
				Peca peca = new Peca();
				peca.setNomePeca(txtNmPeca.getText());
				peca.setCodigo(txtCdPeca.getText());
				peca.setValCompra(Double.parseDouble(txtValorCompra.getText()));
				peca.setValVenda(Double.parseDouble(txtValorVenda.getText()));
				peca.setQuantida(Integer.parseInt(txtQuantidade.getText()));
				peca.setDataEntrada((Date) format.parse(txtDtEntrada.getText()));
				peca.setDataSaida((Date) format.parse(txtDtSaida.getText()));
				
				controller.cadastrarPeca(peca);
				limparCampos();
			}
		});
		
		JButton btnFechar = new JButton("Fechar");
		btnFechar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
			
		
		txtValorVenda = new JTextField();
		txtValorVenda.setColumns(10);
		
		JLabel lblValorVenda = new JLabel("Valor de Venda:");
		
		JLabel lblDtEntrada = new JLabel("Data de Entrada:");
		
		txtDtEntrada = new JTextField();
		txtDtEntrada.setColumns(10);
		
		JLabel lblDtSaida = new JLabel("Data de Sa\u00EDda:");
		
		txtDtSaida = new JTextField();
		txtDtSaida.setColumns(10);
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(160)
							.addComponent(lblCadastroDePeca))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(49)
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblNomeDaPeca)
									.addGap(6))
								.addGroup(groupLayout.createSequentialGroup()
									.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
										.addComponent(lblCodigo)
										.addComponent(lblValorCompra))
									.addPreferredGap(ComponentPlacement.UNRELATED))
								.addGroup(groupLayout.createSequentialGroup()
									.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
										.addComponent(btnFechar)
										.addComponent(lblQuantidade)
										.addComponent(lblDtSaida))
									.addPreferredGap(ComponentPlacement.UNRELATED))
								.addGroup(groupLayout.createSequentialGroup()
									.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
										.addComponent(lblValorVenda, GroupLayout.PREFERRED_SIZE, 99, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblDtEntrada, GroupLayout.PREFERRED_SIZE, 105, GroupLayout.PREFERRED_SIZE))
									.addPreferredGap(ComponentPlacement.RELATED)))
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
									.addComponent(txtNmPeca, GroupLayout.PREFERRED_SIZE, 170, GroupLayout.PREFERRED_SIZE)
									.addGroup(groupLayout.createSequentialGroup()
										.addComponent(btnCadastrar)
										.addPreferredGap(ComponentPlacement.RELATED)))
								.addComponent(txtCdPeca, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtValorCompra, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtValorVenda, GroupLayout.PREFERRED_SIZE, 116, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtQuantidade, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtDtEntrada, GroupLayout.PREFERRED_SIZE, 116, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtDtSaida, GroupLayout.PREFERRED_SIZE, 116, GroupLayout.PREFERRED_SIZE))))
					.addContainerGap(71, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(10)
					.addComponent(lblCadastroDePeca)
					.addGap(24)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNomeDaPeca)
						.addComponent(txtNmPeca, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblCodigo)
						.addComponent(txtCdPeca, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblValorCompra)
						.addComponent(txtValorCompra, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtValorVenda, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblValorVenda))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblQuantidade)
						.addComponent(txtQuantidade, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblDtEntrada)
						.addComponent(txtDtEntrada, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblDtSaida)
						.addComponent(txtDtSaida, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(20)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnFechar)
						.addComponent(btnCadastrar))
					.addGap(280))
		);
		setLayout(groupLayout);
		
	}

	private void limparCampos() {
		txtNmPeca.setText("");
		txtCdPeca.setText("");
		txtValorCompra.setText("");
		txtValorVenda.setText("");
		txtQuantidade.setText("");
		txtDtEntrada.setText("");
		txtDtSaida.setText("");
		
	}
		
	
}


