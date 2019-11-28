package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.table.DefaultTableModel;

import controller.ControllerPeca;

import model.entity.Peca;
import java.awt.Font;


public class PainelConsultarPeca extends JPanel {
	private JTextField textNome;
	private JTextField textFabricante;
	private JTable tblPeca;
	private String[] colunasTabelaPecas = { "CODIGO"," NOME", "VALOR DE VENDA", "VALOR DE COMPRA", "DATA DE ENTRADA", "DATA DE SAIDA", "QUANTIDADE" };
	private ArrayList<Peca>pecas;
	
	/**
	 * Create the panel.
	 */
	public PainelConsultarPeca() {
		
		JLabel lblConsultarPeca = new JLabel("Consultar Pe\u00E7a");
		lblConsultarPeca.setFont(new Font("Tahoma", Font.BOLD, 18));
		
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
		
		JButton btnGerarRelatorio = new JButton("Gerar Relat\u00F3rio");
		btnGerarRelatorio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JFileChooser jcf = new JFileChooser();
				jcf.setDialogTitle("Salvar relatório como...");
				
				int resultado = jcf.showSaveDialog(null);
				if (resultado == JFileChooser.APPROVE_OPTION) {
					String caminhoEscolhido = jcf.getSelectedFile().getAbsolutePath();
					
					ControllerPeca controllerPeca = new ControllerPeca();
					controllerPeca.gerarRelatorio(pecas, caminhoEscolhido);
				}
			}
		});
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(150)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblFabricante, Alignment.TRAILING)
						.addComponent(lblNome, Alignment.TRAILING))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(textFabricante, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(textNome, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(229)
							.addComponent(btnConsultar)))
					.addGap(210))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(311)
					.addComponent(lblConsultarPeca)
					.addContainerGap(415, Short.MAX_VALUE))
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addGap(86)
					.addComponent(btnFechar)
					.addPreferredGap(ComponentPlacement.RELATED, 481, Short.MAX_VALUE)
					.addComponent(btnGerarRelatorio)
					.addGap(105))
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(tblPeca, GroupLayout.PREFERRED_SIZE, 774, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(76, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap(71, Short.MAX_VALUE)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNome)
								.addComponent(textNome, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblFabricante)
								.addComponent(textFabricante, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(0))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(22)
							.addComponent(lblConsultarPeca)
							.addGap(30)
							.addComponent(btnConsultar)))
					.addGap(18)
					.addComponent(tblPeca, GroupLayout.PREFERRED_SIZE, 298, GroupLayout.PREFERRED_SIZE)
					.addGap(27)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnGerarRelatorio)
						.addComponent(btnFechar))
					.addGap(72))
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
			novaLinha[6] = String.valueOf(peca.getQuantidade());
			
			model.addRow(novaLinha);
		}
	}
	
	private void limparTabela() {
		
		tblPeca.setModel(new DefaultTableModel(new Object[][] { colunasTabelaPecas, }, colunasTabelaPecas));
	}
}
