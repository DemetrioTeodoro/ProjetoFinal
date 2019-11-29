package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;
import javax.swing.table.DefaultTableModel;

import controller.ControllerPeca;

import model.entity.Peca;
import java.awt.Font;
import javax.swing.ListSelectionModel;


public class PainelConsultarPeca extends JPanel {
	private JTextField textNome;
	private JTable tblPeca;
	private String[] colunasTabelaPecas = { "CODIGO"," NOME PEÇA", "VALOR DE VENDA", "VALOR DE COMPRA", "DATA DE ENTRADA", "DATA DE SAIDA", "QUANTIDADE" };
	private ArrayList<Peca>pecas;
	
	DateTimeFormatter formatador = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	
	/**
	 * Create the panel.
	 */
	public PainelConsultarPeca() {
		
		JLabel lblConsultarPeca = new JLabel("Consultar Pe\u00E7a");
		lblConsultarPeca.setFont(new Font("Tahoma", Font.BOLD, 18));
		
		JLabel lblNome = new JLabel("Nome Pe\u00E7a:");
		
		textNome = new JTextField();
		textNome.setColumns(10);
		
		tblPeca = new JTable();
		tblPeca.setSurrendersFocusOnKeystroke(true);
		tblPeca.setFillsViewportHeight(true);
		tblPeca.setCellSelectionEnabled(true);
		tblPeca.setColumnSelectionAllowed(true);
		tblPeca.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		tblPeca.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseClicked(MouseEvent e) {
				PainelAlterarPeca alterarPeca = new PainelAlterarPeca();
				alterarPeca.setVisible(true);
				
				
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
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
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(135)
					.addComponent(lblNome)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(textNome, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)
					.addGap(301)
					.addComponent(btnConsultar)
					.addGap(96))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(311)
					.addComponent(lblConsultarPeca)
					.addContainerGap(415, Short.MAX_VALUE))
				.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
					.addGap(86)
					.addComponent(btnFechar)
					.addPreferredGap(ComponentPlacement.RELATED, 559, Short.MAX_VALUE)
					.addComponent(btnGerarRelatorio)
					.addGap(58))
				.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(tblPeca, GroupLayout.PREFERRED_SIZE, 856, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(25, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap(98, Short.MAX_VALUE)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(btnConsultar)
								.addComponent(lblNome)
								.addComponent(textNome, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(34))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(22)
							.addComponent(lblConsultarPeca)))
					.addGap(18)
					.addComponent(tblPeca, GroupLayout.PREFERRED_SIZE, 298, GroupLayout.PREFERRED_SIZE)
					.addGap(27)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnFechar)
						.addComponent(btnGerarRelatorio))
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
			String[] novaLinha = new String[7];
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
