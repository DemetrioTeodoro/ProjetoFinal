package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.naming.LimitExceededException;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.table.DefaultTableModel;

import controller.ControllerPeca;
import model.entity.Peca;
import java.awt.Font;

public class PainelDeletarPeca extends JPanel {
	private JTextField textNome;
	private JTextField textFabricante;
	private JTable tblPeca;
	private String[] colunasTabelaPecas = { "CODIGO"," NOME", "VALORVENDA", "VALORCOMPRA", "DATAENTRADA", "DATASAIDA", "QUANTIDADE" };
	private ArrayList<Peca> pecas;

	/**
	 * Create the panel.
	 */
	public PainelDeletarPeca() {
		
		JLabel lblDeletarPeca = new JLabel("Deletar Pe\u00E7a");
		lblDeletarPeca.setFont(new Font("Tahoma", Font.BOLD, 18));
		
		JLabel lblNome = new JLabel("Nome:");
		
		JLabel lblFabricante = new JLabel("Fabricante:");
		
		textNome = new JTextField();
		textNome.setColumns(10);
		
		textFabricante = new JTextField();
		textFabricante.setColumns(10);
		
		tblPeca = new JTable();
		limparTabela();
		
		JButton btnFechar = new JButton("Fechar");
		btnFechar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
			}
		});
		
		JButton btnConsultar = new JButton("Consultar");
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(314)
							.addComponent(btnFechar))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(54)
							.addComponent(tblPeca, GroupLayout.PREFERRED_SIZE, 642, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(163)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblFabricante)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(textFabricante, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblNome)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(textNome, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
							.addGap(99)
							.addComponent(btnConsultar))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(304)
							.addComponent(lblDeletarPeca)))
					.addContainerGap(101, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(33)
					.addComponent(lblDeletarPeca)
					.addGap(38)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNome)
								.addComponent(textNome, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblFabricante)
								.addComponent(textFabricante, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(16)
							.addComponent(btnConsultar)))
					.addGap(40)
					.addComponent(tblPeca, GroupLayout.PREFERRED_SIZE, 298, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(btnFechar)
					.addContainerGap(86, Short.MAX_VALUE))
		);
		setLayout(groupLayout);
	}
	
	protected void atualizarTabela() {
		ControllerPeca controllerPeca = new ControllerPeca();
		
		pecas = controllerPeca.listarPecas();
		
		
		
		DefaultTableModel model = new DefaultTableModel();
		
		for (Peca peca : pecas) {
			String[] novaLinha = new String[5];
			novaLinha[0] = peca.getCodigo();
			novaLinha[1] = peca.getNomePeca();
			novaLinha[2] = String.valueOf(peca.getValVenda());
			novaLinha[3] = String.valueOf(peca.getValCompra());
			novaLinha[4] = String.valueOf(peca.getDataEntrada());
			novaLinha[5] = String.valueOf(peca.getDataSaida());
			novaLinha[6] = String.valueOf(peca.getQuantidade());
			
			model.addRow(novaLinha);
		}
		
	}
		private void limparTabela() {
			
			tblPeca.setModel(new DefaultTableModel(new Object[][] { colunasTabelaPecas, }, colunasTabelaPecas));
		}
		
	

}
