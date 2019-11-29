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
import java.awt.event.MouseAdapter;


public class PainelConsultarPeca extends JPanel {
	private JTextField textNome;
	private JTable tblPeca;
	private String[] colunasTabelaPecas = { "CODIGO"," NOME PEÇA", "VALOR DE VENDA", "VALOR DE COMPRA", "DATA DE ENTRADA", "DATA DE SAIDA", "QUANTIDADE" };
	private ArrayList<Peca>pecas;
	ControllerPeca controller = new ControllerPeca();
	
	DateTimeFormatter formatador = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	private PainelAlterarPeca painelAlterarPeca = new PainelAlterarPeca();
	private JTextField txtCodigoExclusao;
	
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
		tblPeca.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				PainelAlterarPeca painelAlterarPeca = new PainelAlterarPeca();
				painelAlterarPeca.setVisible(true);
			}
		});
		tblPeca.setSurrendersFocusOnKeystroke(true);
		tblPeca.setFillsViewportHeight(true);
		tblPeca.setCellSelectionEnabled(true);
		tblPeca.setColumnSelectionAllowed(true);
		
		
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
		
		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				limparTabela();
			}
		});
		
		JLabel lblDigiteCdigo = new JLabel("Digite C\u00F3digo:");
		
		txtCodigoExclusao = new JTextField();
		txtCodigoExclusao.setColumns(10);
		
		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Peca peca = new Peca();
				String codigo = txtCodigoExclusao.getText();
				peca = controller.consultarPecaCodigo(codigo);
				controller.excluirPeca(peca.getIdPeca());
						
			}
		});
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(135)
							.addComponent(lblNome)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(textNome, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)
							.addGap(301)
							.addComponent(btnConsultar))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(311)
							.addComponent(lblConsultarPeca))
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblDigiteCdigo)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(txtCodigoExclusao, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(btnExcluir)
									.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(btnGerarRelatorio)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(btnLimpar)
									.addGap(18)
									.addComponent(btnFechar))
								.addComponent(tblPeca, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 856, GroupLayout.PREFERRED_SIZE))))
					.addContainerGap(25, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap(130, Short.MAX_VALUE)
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
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(20)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(btnFechar)
								.addComponent(btnLimpar)
								.addComponent(btnGerarRelatorio)))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(18)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblDigiteCdigo)
								.addComponent(txtCodigoExclusao, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnExcluir))))
					.addGap(79))
		);
		setLayout(groupLayout);
		
	
	}
	
	protected void atualizarTabelaPecas() {
		String objFiltro = textNome.getText();
		if (!objFiltro.equals("")) {
			pecas = controller.consultarPecaNome(objFiltro);
		}
		else { 
			pecas = controller.listarPecas();
		}
			

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
