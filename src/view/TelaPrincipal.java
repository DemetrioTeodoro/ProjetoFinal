package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SpringLayout;

public class TelaPrincipal{

	
	public static final String OPCAO_SELECIONE = "    --Selecione--";
	public JFrame frame;
	private JPanel painelEsquerdo;
	private JPanel painelDireito;
	
	/**
	 * Paineis solicitados
	 */
	private PainelCadastroOrcamento painelCadastroOrcamento = new PainelCadastroOrcamento();
	private PainelCadastroPeca painelCadastroPeca = new PainelCadastroPeca();
	private PainelConsultaOrcamento painelConsultaOrcamento = new PainelConsultaOrcamento();
	private PainelConsultarPeca painelConsultarPeca = new PainelConsultarPeca();
	private PainelAlterarOrcamento painelAlterarOrcamento = new PainelAlterarOrcamento();
	private PainelAlterarPeca painelAlterarPeca = new PainelAlterarPeca();
	private PainelDeletarOrcamento painelDeletarOrcamento = new PainelDeletarOrcamento();
	private PainelDeletarPeca painelDeletarPeca = new PainelDeletarPeca();
	private PainelAjuda painelAjuda = new PainelAjuda();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaPrincipal window = new TelaPrincipal();
					window.frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TelaPrincipal() {
		
		frame = new JFrame();
		frame.setTitle("Gerencia de Pe\u00E7as e Servi\u00E7os");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(100, 100, 1117, 1219);

		Dimension dimensoesTela = Toolkit.getDefaultToolkit().getScreenSize();
		int larguraDaTela = (int) dimensoesTela.getWidth();
		int alturaDaTela = (int) dimensoesTela.getHeight();

		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);

		JMenu mnSobre = new JMenu("Sobre");
		menuBar.add(mnSobre);

		JMenuItem mntmVersao = new JMenuItem("Vers\u00E3o");
		mntmVersao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Versão do Crud 1.00. \n Programa desenvolvido por Demetrio e Gabriel. ");
			}
		});
		mnSobre.add(mntmVersao);
		
		frame.getContentPane().setBackground(Color.WHITE);
		frame.getContentPane().setForeground(Color.BLACK);
		frame.getContentPane().setLayout(null);

		painelDireito = new JPanel();
		painelDireito.setBackground(Color.WHITE);
		painelDireito.setBounds(300, 0, larguraDaTela - 300, alturaDaTela - 20);
		//TODO descomentar as linhas comentadas para que a tela apareça no preview do modo Design do WindowBuilder
		//painelDireito.setBounds(300, 10, 300,600);
		frame.getContentPane().add(painelDireito);
		SpringLayout sl_painelDireito = new SpringLayout();
		sl_painelDireito.putConstraint(SpringLayout.NORTH, painelCadastroOrcamento, 0, SpringLayout.NORTH, painelDireito);
		sl_painelDireito.putConstraint(SpringLayout.WEST, painelCadastroOrcamento, 0, SpringLayout.WEST, painelDireito);
		sl_painelDireito.putConstraint(SpringLayout.SOUTH, painelCadastroOrcamento, -396, SpringLayout.SOUTH, painelDireito);
		sl_painelDireito.putConstraint(SpringLayout.EAST, painelCadastroOrcamento, -1093, SpringLayout.EAST, painelDireito);
		painelDireito.setLayout(sl_painelDireito);
		
		incluirPaineisEscondidos();

		JButton btnMostrarMenuLateral = new JButton(">>");
		sl_painelDireito.putConstraint(SpringLayout.WEST, btnMostrarMenuLateral, 10, SpringLayout.WEST, painelDireito);
		sl_painelDireito.putConstraint(SpringLayout.SOUTH, btnMostrarMenuLateral, -514, SpringLayout.SOUTH, painelDireito);
		sl_painelDireito.putConstraint(SpringLayout.EAST, btnMostrarMenuLateral, 69, SpringLayout.WEST, painelDireito);
		painelDireito.add(btnMostrarMenuLateral);
		btnMostrarMenuLateral.setVisible(false);

		btnMostrarMenuLateral.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				painelEsquerdo.setVisible(true);
				btnMostrarMenuLateral.setVisible(false);
				painelDireito.setBounds(300, 0, larguraDaTela - 300, alturaDaTela - 20);
				//painelDireito.setBounds(0, 0, 800,600);
			}
		});
		
		painelEsquerdo = new JPanel();
		painelEsquerdo.setBackground(Color.GRAY);
		painelEsquerdo.setBounds(0, 0, 300, alturaDaTela - 20);
		//painelEsquerdo.setBounds(10, 10, 300, 600);
		frame.getContentPane().add(painelEsquerdo);
		SpringLayout sl_painelEsquerdo = new SpringLayout();
		painelEsquerdo.setLayout(sl_painelEsquerdo);

		JLabel lblOficinaMecanicaAutobot = new JLabel("Oficina Mec\u00E2nica Autobot");
		sl_painelEsquerdo.putConstraint(SpringLayout.NORTH, lblOficinaMecanicaAutobot, 10, SpringLayout.NORTH, painelEsquerdo);
		sl_painelEsquerdo.putConstraint(SpringLayout.WEST, lblOficinaMecanicaAutobot, 38, SpringLayout.WEST, painelEsquerdo);
		sl_painelEsquerdo.putConstraint(SpringLayout.SOUTH, lblOficinaMecanicaAutobot, -1028, SpringLayout.SOUTH, painelEsquerdo);
		sl_painelEsquerdo.putConstraint(SpringLayout.EAST, lblOficinaMecanicaAutobot, -22, SpringLayout.EAST, painelEsquerdo);
		painelEsquerdo.add(lblOficinaMecanicaAutobot);
		lblOficinaMecanicaAutobot.setForeground(Color.BLACK);
		lblOficinaMecanicaAutobot.setBackground(Color.LIGHT_GRAY);
		lblOficinaMecanicaAutobot.setFont(new Font("Tahoma", Font.BOLD, 18));

		JButton btnEsconderMenuLateral = new JButton("<<");
		sl_painelEsquerdo.putConstraint(SpringLayout.WEST, btnEsconderMenuLateral, 239, SpringLayout.WEST, painelEsquerdo);
		sl_painelEsquerdo.putConstraint(SpringLayout.EAST, btnEsconderMenuLateral, -10, SpringLayout.EAST, painelEsquerdo);
		btnEsconderMenuLateral.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				painelEsquerdo.setVisible(false);
				btnMostrarMenuLateral.setVisible(true);
				painelDireito.setBounds(0, 0, larguraDaTela, alturaDaTela - 20);
				//painelDireito.setBounds(0, 0, 800,600);
			}
		});
		painelEsquerdo.add(btnEsconderMenuLateral);

		JButton btnSair = new JButton("Sair");
		sl_painelEsquerdo.putConstraint(SpringLayout.NORTH, btnSair, 877, SpringLayout.NORTH, painelEsquerdo);
		sl_painelEsquerdo.putConstraint(SpringLayout.WEST, btnSair, 10, SpringLayout.WEST, painelEsquerdo);
		sl_painelEsquerdo.putConstraint(SpringLayout.SOUTH, btnSair, -133, SpringLayout.SOUTH, painelEsquerdo);
		painelEsquerdo.add(btnSair);
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});

		JButton btnAjuda = new JButton("");
		btnAjuda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mostrarPainel(painelAjuda);
			}
		});
		sl_painelEsquerdo.putConstraint(SpringLayout.EAST, btnSair, -96, SpringLayout.WEST, btnAjuda);
		sl_painelEsquerdo.putConstraint(SpringLayout.SOUTH, btnEsconderMenuLateral, -489, SpringLayout.NORTH, btnAjuda);
		sl_painelEsquerdo.putConstraint(SpringLayout.NORTH, btnAjuda, 870, SpringLayout.NORTH, painelEsquerdo);
		sl_painelEsquerdo.putConstraint(SpringLayout.WEST, btnAjuda, 197, SpringLayout.WEST, painelEsquerdo);
		sl_painelEsquerdo.putConstraint(SpringLayout.SOUTH, btnAjuda, 0, SpringLayout.SOUTH, btnSair);
		sl_painelEsquerdo.putConstraint(SpringLayout.EAST, btnAjuda, 0, SpringLayout.EAST, lblOficinaMecanicaAutobot);
		painelEsquerdo.add(btnAjuda);
		btnAjuda.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/icones/Help-icon.png")));
		
		JButton btnCadastroDePeca = new JButton("Pe\u00E7a");
		sl_painelEsquerdo.putConstraint(SpringLayout.WEST, btnCadastroDePeca, 21, SpringLayout.WEST, painelEsquerdo);
		sl_painelEsquerdo.putConstraint(SpringLayout.EAST, btnCadastroDePeca, -74, SpringLayout.EAST, painelEsquerdo);
		btnCadastroDePeca.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				mostrarPainel(painelCadastroPeca);
			}
		});
		btnCadastroDePeca.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/icones/settings-icon.png")));
		painelEsquerdo.add(btnCadastroDePeca);
		
		JButton btnCadastroDeOrcamento = new JButton("Or\u00E7amento");
		sl_painelEsquerdo.putConstraint(SpringLayout.SOUTH, btnCadastroDePeca, -8, SpringLayout.NORTH, btnCadastroDeOrcamento);
		sl_painelEsquerdo.putConstraint(SpringLayout.WEST, btnCadastroDeOrcamento, 0, SpringLayout.WEST, btnCadastroDePeca);
		sl_painelEsquerdo.putConstraint(SpringLayout.EAST, btnCadastroDeOrcamento, 0, SpringLayout.EAST, btnCadastroDePeca);
		btnCadastroDeOrcamento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mostrarPainel(painelCadastroOrcamento);
			}
		});
		btnCadastroDeOrcamento.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/icones/Documents-icon.png")));
		painelEsquerdo.add(btnCadastroDeOrcamento);
		
		JLabel label = new JLabel("_____________________________");
		sl_painelEsquerdo.putConstraint(SpringLayout.NORTH, label, 75, SpringLayout.SOUTH, lblOficinaMecanicaAutobot);
		sl_painelEsquerdo.putConstraint(SpringLayout.EAST, label, -10, SpringLayout.EAST, painelEsquerdo);
		painelEsquerdo.add(label);
		
		JLabel label_1 = new JLabel("_______________________________________");
		sl_painelEsquerdo.putConstraint(SpringLayout.SOUTH, btnCadastroDeOrcamento, -6, SpringLayout.NORTH, label_1);
		sl_painelEsquerdo.putConstraint(SpringLayout.NORTH, label_1, 236, SpringLayout.NORTH, painelEsquerdo);
		sl_painelEsquerdo.putConstraint(SpringLayout.EAST, label_1, -10, SpringLayout.EAST, painelEsquerdo);
		painelEsquerdo.add(label_1);
		
		JLabel lblCadastro = new JLabel("Cadastro");
		lblCadastro.setFont(new Font("Tahoma", Font.BOLD, 17));
		sl_painelEsquerdo.putConstraint(SpringLayout.WEST, lblCadastro, 10, SpringLayout.WEST, painelEsquerdo);
		sl_painelEsquerdo.putConstraint(SpringLayout.SOUTH, lblCadastro, 0, SpringLayout.SOUTH, label);
		painelEsquerdo.add(lblCadastro);
		
		JLabel label_2 = new JLabel("_____________________________");
		sl_painelEsquerdo.putConstraint(SpringLayout.SOUTH, label_2, -765, SpringLayout.SOUTH, painelEsquerdo);
		sl_painelEsquerdo.putConstraint(SpringLayout.EAST, label_2, -10, SpringLayout.EAST, painelEsquerdo);
		painelEsquerdo.add(label_2);
		
		JLabel lblConsulta = new JLabel("Consulta");
		sl_painelEsquerdo.putConstraint(SpringLayout.NORTH, lblConsulta, -4, SpringLayout.NORTH, label_2);
		sl_painelEsquerdo.putConstraint(SpringLayout.WEST, lblConsulta, 0, SpringLayout.WEST, btnSair);
		lblConsulta.setFont(new Font("Tahoma", Font.BOLD, 17));
		painelEsquerdo.add(lblConsulta);
		
		JButton btnConsultarPeca = new JButton("Pe\u00E7a");
		btnConsultarPeca.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mostrarPainel(painelConsultarPeca);
			}
		});
		btnConsultarPeca.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/icones/settings-icon.png")));
		sl_painelEsquerdo.putConstraint(SpringLayout.NORTH, btnConsultarPeca, 6, SpringLayout.SOUTH, label_2);
		sl_painelEsquerdo.putConstraint(SpringLayout.WEST, btnConsultarPeca, 21, SpringLayout.WEST, painelEsquerdo);
		sl_painelEsquerdo.putConstraint(SpringLayout.SOUTH, btnConsultarPeca, -718, SpringLayout.SOUTH, painelEsquerdo);
		sl_painelEsquerdo.putConstraint(SpringLayout.EAST, btnConsultarPeca, 0, SpringLayout.EAST, btnCadastroDePeca);
		painelEsquerdo.add(btnConsultarPeca);
		
		JButton btnConsultarOrcamento = new JButton("Or\u00E7amento");
		btnConsultarOrcamento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				mostrarPainel(painelConsultaOrcamento);
			}
		});
		btnConsultarOrcamento.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/icones/Documents-icon.png")));
		sl_painelEsquerdo.putConstraint(SpringLayout.NORTH, btnConsultarOrcamento, -8, SpringLayout.NORTH, btnEsconderMenuLateral);
		sl_painelEsquerdo.putConstraint(SpringLayout.WEST, btnConsultarOrcamento, 0, SpringLayout.WEST, btnCadastroDePeca);
		sl_painelEsquerdo.putConstraint(SpringLayout.SOUTH, btnConsultarOrcamento, 389, SpringLayout.NORTH, painelEsquerdo);
		sl_painelEsquerdo.putConstraint(SpringLayout.EAST, btnConsultarOrcamento, -13, SpringLayout.WEST, btnEsconderMenuLateral);
		painelEsquerdo.add(btnConsultarOrcamento);
		
		JLabel label_3 = new JLabel("_______________________________________");
		sl_painelEsquerdo.putConstraint(SpringLayout.NORTH, label_3, 6, SpringLayout.SOUTH, btnConsultarOrcamento);
		sl_painelEsquerdo.putConstraint(SpringLayout.EAST, label_3, 0, SpringLayout.EAST, btnEsconderMenuLateral);
		painelEsquerdo.add(label_3);
		
		JLabel lblAlterar = new JLabel("Alterar");
		sl_painelEsquerdo.putConstraint(SpringLayout.WEST, lblAlterar, 0, SpringLayout.WEST, btnCadastroDePeca);
		lblAlterar.setFont(new Font("Tahoma", Font.BOLD, 17));
		painelEsquerdo.add(lblAlterar);
		
		JLabel label_4 = new JLabel("_____________________________");
		sl_painelEsquerdo.putConstraint(SpringLayout.NORTH, label_4, 11, SpringLayout.SOUTH, label_3);
		sl_painelEsquerdo.putConstraint(SpringLayout.NORTH, lblAlterar, -4, SpringLayout.NORTH, label_4);
		sl_painelEsquerdo.putConstraint(SpringLayout.EAST, label_4, 0, SpringLayout.EAST, btnEsconderMenuLateral);
		painelEsquerdo.add(label_4);
		
		JButton btnAlterarPeca = new JButton("Peca");
		btnAlterarPeca.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mostrarPainel(painelAlterarPeca);
			}
		});
		btnAlterarPeca.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/icones/settings-icon.png")));
		sl_painelEsquerdo.putConstraint(SpringLayout.NORTH, btnAlterarPeca, 6, SpringLayout.SOUTH, lblAlterar);
		sl_painelEsquerdo.putConstraint(SpringLayout.WEST, btnAlterarPeca, 21, SpringLayout.WEST, painelEsquerdo);
		sl_painelEsquerdo.putConstraint(SpringLayout.SOUTH, btnAlterarPeca, 47, SpringLayout.SOUTH, lblAlterar);
		sl_painelEsquerdo.putConstraint(SpringLayout.EAST, btnAlterarPeca, 0, SpringLayout.EAST, btnCadastroDePeca);
		painelEsquerdo.add(btnAlterarPeca);
		
		JButton btnAlterarOrcamento = new JButton("Or\u00E7amento");
		btnAlterarOrcamento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mostrarPainel(painelAlterarOrcamento);
			}
		});
		btnAlterarOrcamento.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/icones/Documents-icon.png")));
		sl_painelEsquerdo.putConstraint(SpringLayout.NORTH, btnAlterarOrcamento, 8, SpringLayout.SOUTH, btnAlterarPeca);
		sl_painelEsquerdo.putConstraint(SpringLayout.WEST, btnAlterarOrcamento, 0, SpringLayout.WEST, btnCadastroDePeca);
		sl_painelEsquerdo.putConstraint(SpringLayout.SOUTH, btnAlterarOrcamento, 49, SpringLayout.SOUTH, btnAlterarPeca);
		sl_painelEsquerdo.putConstraint(SpringLayout.EAST, btnAlterarOrcamento, 0, SpringLayout.EAST, btnCadastroDePeca);
		painelEsquerdo.add(btnAlterarOrcamento);
		
		JLabel lblDeletar = new JLabel("Deletar");
		sl_painelEsquerdo.putConstraint(SpringLayout.NORTH, lblDeletar, 20, SpringLayout.SOUTH, btnAlterarOrcamento);
		sl_painelEsquerdo.putConstraint(SpringLayout.WEST, lblDeletar, 0, SpringLayout.WEST, btnCadastroDePeca);
		lblDeletar.setFont(new Font("Tahoma", Font.BOLD, 17));
		painelEsquerdo.add(lblDeletar);
		
		JLabel label_5 = new JLabel("_____________________________");
		sl_painelEsquerdo.putConstraint(SpringLayout.WEST, label_5, 0, SpringLayout.WEST, label);
		sl_painelEsquerdo.putConstraint(SpringLayout.SOUTH, label_5, 0, SpringLayout.SOUTH, lblDeletar);
		painelEsquerdo.add(label_5);
		
		JButton btnDeletarPeca = new JButton("Peca");
		btnDeletarPeca.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mostrarPainel(painelDeletarPeca);
			}
		});
		btnDeletarPeca.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/icones/settings-icon.png")));
		sl_painelEsquerdo.putConstraint(SpringLayout.NORTH, btnDeletarPeca, 14, SpringLayout.SOUTH, lblDeletar);
		sl_painelEsquerdo.putConstraint(SpringLayout.WEST, btnDeletarPeca, 0, SpringLayout.WEST, btnCadastroDePeca);
		sl_painelEsquerdo.putConstraint(SpringLayout.SOUTH, btnDeletarPeca, 55, SpringLayout.SOUTH, lblDeletar);
		sl_painelEsquerdo.putConstraint(SpringLayout.EAST, btnDeletarPeca, 0, SpringLayout.EAST, btnCadastroDePeca);
		painelEsquerdo.add(btnDeletarPeca);
		
		JButton btnDeletarOrcamento = new JButton("Orcamento");
		btnDeletarOrcamento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mostrarPainel(painelDeletarOrcamento);
			}
		});
		btnDeletarOrcamento.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/icones/Documents-icon.png")));
		sl_painelEsquerdo.putConstraint(SpringLayout.NORTH, btnDeletarOrcamento, 9, SpringLayout.SOUTH, btnDeletarPeca);
		sl_painelEsquerdo.putConstraint(SpringLayout.WEST, btnDeletarOrcamento, 0, SpringLayout.WEST, btnCadastroDePeca);
		sl_painelEsquerdo.putConstraint(SpringLayout.SOUTH, btnDeletarOrcamento, 50, SpringLayout.SOUTH, btnDeletarPeca);
		sl_painelEsquerdo.putConstraint(SpringLayout.EAST, btnDeletarOrcamento, 0, SpringLayout.EAST, btnCadastroDePeca);
		painelEsquerdo.add(btnDeletarOrcamento);
	}

	private void incluirPaineisEscondidos() {
		painelDireito.add(painelCadastroOrcamento);
		painelDireito.add(painelCadastroPeca);
		painelDireito.add(painelConsultaOrcamento);
		painelDireito.add(painelConsultarPeca);
		painelDireito.add(painelAlterarOrcamento);
		painelDireito.add(painelAlterarPeca);
		painelDireito.add(painelDeletarOrcamento);
		painelDireito.add(painelDeletarPeca);
		painelDireito.add(painelAjuda);
		esconderTodosPaineis();
	}

	private void esconderTodosPaineis() {
		painelCadastroOrcamento.setVisible(false);
		painelCadastroPeca.setVisible(false);
		painelConsultaOrcamento.setVisible(false);
		painelConsultarPeca.setVisible(false);
		painelAlterarOrcamento.setVisible(false);
		painelAlterarPeca.setVisible(false);
		painelDeletarOrcamento.setVisible(false);
		painelDeletarPeca.setVisible(false);
		painelAjuda.setVisible(false);
	}

	protected void mostrarPainel(JPanel painelSelecionado) {
		esconderTodosPaineis();
		painelSelecionado.setVisible(true);
		frame.validate();
	}
}
