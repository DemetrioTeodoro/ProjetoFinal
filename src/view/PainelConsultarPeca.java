package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

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


public class PainelConsultarPeca extends JPanel {
	private JTextField textNome;
	private JTextField textFabricante;
	private JTable tblPeca;
	private String[] colunasTabelaPecas = { "CODIGO"," NOME", "VALORVENDA", "VALORCOMPRA", "DATAENTRADA", "I.DATASAIDA", "QUANTIDADE" };
	private ArrayList<Peca>pecas;
	
	/**
	 * Create the panel.
	 */
	public PainelConsultarPeca() {
		
		JLabel lblConsultarPeca = new JLabel("Consultar Pe\u00E7a");
		
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
		btnConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				atualizarTabelaPecas();
			}
		});
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(67)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblFabricante, Alignment.TRAILING)
						.addComponent(lblNome, Alignment.TRAILING))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(textFabricante, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 285, Short.MAX_VALUE)
							.addComponent(btnConsultar)
							.addGap(61))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(textNome, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addContainerGap(433, Short.MAX_VALUE))))
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(559, Short.MAX_VALUE)
					.addComponent(btnFechar)
					.addGap(56))
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addContainerGap(25, Short.MAX_VALUE)
					.addComponent(tblPeca, GroupLayout.PREFERRED_SIZE, 685, GroupLayout.PREFERRED_SIZE)
					.addGap(28))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(307)
					.addComponent(lblConsultarPeca)
					.addContainerGap(346, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblConsultarPeca)
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNome)
						.addComponent(textNome, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblFabricante)
						.addComponent(textFabricante, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnConsultar))
					.addGap(42)
					.addComponent(tblPeca, GroupLayout.PREFERRED_SIZE, 298, GroupLayout.PREFERRED_SIZE)
					.addGap(33)
					.addComponent(btnFechar)
					.addContainerGap(66, Short.MAX_VALUE))
		);
		setLayout(groupLayout);
		
	
	}
	
	protected void atualizarTabelaPecas() {
		ControllerPeca controller = new ControllerPeca();

			pecas = controller.listarPecas();
		

		limparTabela();

		DefaultTableModel model = (DefaultTableModel) tblPeca.getModel();
		for (Peca peca : pecas) {
			String[] novaLinha = new String[5];
			novaLinha[0] = peca.getCodigo();
			novaLinha[1] = peca.getNomePeca();
			novaLinha[2] = String.valueOf(peca.getValVenda());
			novaLinha[3] = String.valueOf(peca.getValCompra());
			novaLinha[4] = String.valueOf(peca.getDataEntrada());
			novaLinha[5] = String.valueOf(peca.getDataSaida());
			novaLinha[6] = String.valueOf(peca.getQuantida());
			
			model.addRow(novaLinha);
		}
	}
	
	private void limparTabela() {
		
		tblPeca.setModel(new DefaultTableModel(new Object[][] { colunasTabelaPecas, }, colunasTabelaPecas));
	}

}
