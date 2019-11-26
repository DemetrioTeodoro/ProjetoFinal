package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
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
import java.awt.Font;

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
		lblCadastroDePeca.setFont(new Font("Tahoma", Font.BOLD, 18));
		
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
				peca.setDataEntrada(LocalDate.parse((txtDtEntrada.getText()), format));
				peca.setDataSaida(LocalDate.parse((txtDtSaida.getText()),format));
				
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
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
					.addGap(37)
					.addComponent(btnFechar)
					.addPreferredGap(ComponentPlacement.RELATED, 285, Short.MAX_VALUE)
					.addComponent(btnCadastrar)
					.addGap(176))
				.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
					.addGap(115)
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
								.addComponent(lblQuantidade)
								.addComponent(lblDtSaida))
							.addPreferredGap(ComponentPlacement.UNRELATED))
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addComponent(lblValorVenda, GroupLayout.PREFERRED_SIZE, 99, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblDtEntrada, GroupLayout.PREFERRED_SIZE, 105, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)))
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addComponent(txtNmPeca, GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE)
						.addComponent(txtCdPeca)
						.addComponent(txtValorCompra)
						.addComponent(txtValorVenda)
						.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
							.addComponent(txtQuantidade, Alignment.LEADING, 0, 0, Short.MAX_VALUE)
							.addComponent(txtDtEntrada, Alignment.LEADING, 0, 0, Short.MAX_VALUE)
							.addComponent(txtDtSaida, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 98, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(259, Short.MAX_VALUE))
				.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
					.addGap(212)
					.addComponent(lblCadastroDePeca)
					.addContainerGap(290, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(40)
					.addComponent(lblCadastroDePeca)
					.addGap(103)
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
					.addGap(68)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnFechar)
						.addComponent(btnCadastrar))
					.addGap(133))
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


