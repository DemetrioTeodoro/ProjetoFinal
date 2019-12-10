package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.text.MaskFormatter;

import controller.ControllerPeca;
import model.entity.Peca;
import java.awt.Font;

public class PainelCadastroPeca extends JPanel {
	private JTextField txtNomePeca;
	private JFormattedTextField txtCodigoPeca;
	private JTextField txtValorCompra;
	private JTextField txtValorVenda;
	private JTextField txtQuantidade;
	private JTextField txtDtEntrada;
	private Peca peca = new Peca();
	private ControllerPeca controllerPeca = new ControllerPeca();
	
	DecimalFormat decimalFormata = new DecimalFormat("0.00");
	DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	

	/**
	 * Create the panel.
	 */
	public PainelCadastroPeca() {
		
		MaskFormatter formato;
		try {
			formato = new MaskFormatter("###");
			 txtCodigoPeca = new JFormattedTextField(formato);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.getMessage();
		}
		
		JLabel lblCadastroDePeca = new JLabel("Cadastro de Pe\u00E7a");
		lblCadastroDePeca.setFont(new Font("Tahoma", Font.BOLD, 18));
		
		JLabel lblNomeDaPeca = new JLabel("Nome da Peca:");
		
		JLabel lblCodigo = new JLabel("C\u00F3digo:");
		
		JLabel lblValorCompra = new JLabel("Valor de Compra:");
		
		JLabel lblQuantidade = new JLabel("Quantidade:");
		
		txtNomePeca = new JTextField();
		txtNomePeca.setColumns(10);
		
		
		txtCodigoPeca.setColumns(10);
		
		txtValorCompra = new JTextField();
		txtValorCompra.setColumns(10);
		try {
			formato = new MaskFormatter("####,##");
			 txtValorCompra = new JFormattedTextField(formato);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.getMessage();
		}
		
		txtQuantidade = new JTextField();
		txtQuantidade.setColumns(10);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String msg = "";
				String nomePeca = txtNomePeca.getText();
				String codigoPeca = txtCodigoPeca.getText();
				double valorCompra = Double.parseDouble(txtValorCompra.getText().replace(",", "."));
				double valorVenda = Double.parseDouble(txtValorVenda.getText().replace(",", "."));
				int quantidade = Integer.parseInt(txtQuantidade.getText());
				LocalDate dataEntrada = LocalDate.parse(txtDtEntrada.getText(), format);
				msg = controllerPeca.validarCamposPeca(nomePeca, codigoPeca, valorCompra, valorVenda, quantidade, dataEntrada);
				
				if (msg.isEmpty()) {
				peca.setNomePeca(txtNomePeca.getText());
				peca.setCodigo(txtCodigoPeca.getText());
				peca.setValCompra(Double.parseDouble(txtValorCompra.getText().replace(",", ".")));
				peca.setValVenda(Double.parseDouble(txtValorVenda.getText().replace(",", ".")));
				peca.setQuantidade(Integer.parseInt(txtQuantidade.getText()));
				peca.setDataEntrada(LocalDate.parse((txtDtEntrada.getText()), format));
				controllerPeca.cadastrarPeca(peca);
				limparCampos();
				
				JOptionPane.showMessageDialog(null, " Peça cadastrada com sucesso! ");
				
				}else {
					JOptionPane.showMessageDialog(null, msg, " Atenção! ", JOptionPane.WARNING_MESSAGE);
				}
				
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
		try {
			formato = new MaskFormatter("####,##");
			 txtValorVenda = new JFormattedTextField(formato);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.getMessage();
		}
		
		JLabel lblValorVenda = new JLabel("Valor de Venda:");
		
		JLabel lblDtEntrada = new JLabel("Data de Entrada:");
		
		txtDtEntrada = new JTextField();
		txtDtEntrada.setColumns(10);
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(37)
					.addComponent(btnFechar)
					.addPreferredGap(ComponentPlacement.RELATED, 162, Short.MAX_VALUE)
					.addComponent(btnCadastrar)
					.addGap(176))
				.addGroup(groupLayout.createSequentialGroup()
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
							.addComponent(lblQuantidade)
							.addPreferredGap(ComponentPlacement.UNRELATED))
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addComponent(lblValorVenda, GroupLayout.PREFERRED_SIZE, 99, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblDtEntrada, GroupLayout.PREFERRED_SIZE, 105, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)))
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(txtNomePeca, GroupLayout.PREFERRED_SIZE, 294, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
							.addComponent(txtDtEntrada, Alignment.LEADING)
							.addComponent(txtQuantidade, Alignment.LEADING)
							.addComponent(txtValorVenda, Alignment.LEADING)
							.addComponent(txtValorCompra, Alignment.LEADING)
							.addComponent(txtCodigoPeca, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 176, Short.MAX_VALUE)))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(212)
					.addComponent(lblCadastroDePeca)
					.addContainerGap(167, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(40)
					.addComponent(lblCadastroDePeca)
					.addGap(103)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNomeDaPeca)
						.addComponent(txtNomePeca, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblCodigo)
						.addComponent(txtCodigoPeca, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
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
					.addGap(91)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnFechar)
						.addComponent(btnCadastrar))
					.addGap(133))
		);
		setLayout(groupLayout);
		
	}

	private void limparCampos() {
		txtNomePeca.setText("");
		txtCodigoPeca.setText("");
		txtValorCompra.setText("");
		txtValorVenda.setText("");
		txtQuantidade.setText("");
		txtDtEntrada.setText("");
		
		
	}
		
	
}


