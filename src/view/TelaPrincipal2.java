package view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SpringLayout;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaPrincipal2 extends JFrame {

	public static final String OPCAO_SELECIONE = "   --Selecione--";
	private JPanel contentPane;
	private JPanel painelDireito = new JPanel();
	private JPanel painelEsquerdo = new JPanel();
	
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
					TelaPrincipal2 frame = new TelaPrincipal2();
					frame.setExtendedState(MAXIMIZED_BOTH);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	/**
	 * Create the frame.
	 */
	public TelaPrincipal2() {
		setTitle("Gerencia de Pe\u00E7as e Servi\u00E7os");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 930, 800);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		SpringLayout sl_contentPane = new SpringLayout();
		contentPane.setLayout(sl_contentPane);
		
		painelEsquerdo = new JPanel();
		sl_contentPane.putConstraint(SpringLayout.WEST, painelEsquerdo, -5, SpringLayout.WEST, contentPane);
		painelEsquerdo.setBackground(Color.GRAY);
		sl_contentPane.putConstraint(SpringLayout.NORTH, painelEsquerdo, 5, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, painelEsquerdo, 55, SpringLayout.SOUTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, painelEsquerdo, 262, SpringLayout.WEST, contentPane);
		contentPane.add(painelEsquerdo);
		SpringLayout sl_painelEsquerdo = new SpringLayout();
		painelEsquerdo.setLayout(sl_painelEsquerdo);
		
		JLabel lblOficinaMecanicaAutobot = new JLabel("Oficina Mec\u00E2nica Autobot");
		sl_painelEsquerdo.putConstraint(SpringLayout.NORTH, lblOficinaMecanicaAutobot, 10, SpringLayout.NORTH, painelEsquerdo);
		sl_painelEsquerdo.putConstraint(SpringLayout.WEST, lblOficinaMecanicaAutobot, 10, SpringLayout.WEST, painelEsquerdo);
		lblOficinaMecanicaAutobot.setFont(new Font("Tahoma", Font.BOLD, 18));
		painelEsquerdo.add(lblOficinaMecanicaAutobot);
		
		JLabel lblCadastro = new JLabel("Cadastro");
		lblCadastro.setFont(new Font("Tahoma", Font.BOLD, 17));
		sl_painelEsquerdo.putConstraint(SpringLayout.NORTH, lblCadastro, 41, SpringLayout.SOUTH, lblOficinaMecanicaAutobot);
		sl_painelEsquerdo.putConstraint(SpringLayout.WEST, lblCadastro, 0, SpringLayout.WEST, lblOficinaMecanicaAutobot);
		painelEsquerdo.add(lblCadastro);
		
		JLabel label = new JLabel("______________________");
		sl_painelEsquerdo.putConstraint(SpringLayout.NORTH, label, 0, SpringLayout.NORTH, lblCadastro);
		sl_painelEsquerdo.putConstraint(SpringLayout.WEST, label, 6, SpringLayout.EAST, lblCadastro);
		painelEsquerdo.add(label);
		
		JLabel label_1 = new JLabel("_________________________________");
		sl_painelEsquerdo.putConstraint(SpringLayout.EAST, label_1, 0, SpringLayout.EAST, lblOficinaMecanicaAutobot);
		painelEsquerdo.add(label_1);
		
		painelDireito = new JPanel();
		sl_contentPane.putConstraint(SpringLayout.NORTH, painelDireito, 5, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, painelDireito, 263, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, painelDireito, -5, SpringLayout.SOUTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, painelDireito, -5, SpringLayout.EAST, contentPane);
		
		incluirPaineisEscondidos();
		
		JButton btnCadastroPeca = new JButton("Pe\u00E7a");
		btnCadastroPeca.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				mostrarPainel(painelCadastroPeca);
			}
		});
		sl_painelEsquerdo.putConstraint(SpringLayout.NORTH, label_1, 62, SpringLayout.SOUTH, btnCadastroPeca);
		sl_painelEsquerdo.putConstraint(SpringLayout.NORTH, btnCadastroPeca, 16, SpringLayout.SOUTH, lblCadastro);
		sl_painelEsquerdo.putConstraint(SpringLayout.WEST, btnCadastroPeca, 10, SpringLayout.WEST, painelEsquerdo);
		sl_painelEsquerdo.putConstraint(SpringLayout.SOUTH, btnCadastroPeca, 57, SpringLayout.SOUTH, lblCadastro);
		sl_painelEsquerdo.putConstraint(SpringLayout.EAST, btnCadastroPeca, -26, SpringLayout.EAST, lblOficinaMecanicaAutobot);
		btnCadastroPeca.setIcon(new ImageIcon(TelaPrincipal2.class.getResource("/icones/settings-icon.png")));
		painelEsquerdo.add(btnCadastroPeca);
		
		JButton btnCadastroOrcamento = new JButton("Or\u00E7amento");
		btnCadastroOrcamento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mostrarPainel(painelCadastroOrcamento);
			}
		});
		btnCadastroOrcamento.setIcon(new ImageIcon(TelaPrincipal2.class.getResource("/icones/Documents-icon.png")));
		sl_painelEsquerdo.putConstraint(SpringLayout.NORTH, btnCadastroOrcamento, -47, SpringLayout.NORTH, label_1);
		sl_painelEsquerdo.putConstraint(SpringLayout.WEST, btnCadastroOrcamento, 10, SpringLayout.WEST, painelEsquerdo);
		sl_painelEsquerdo.putConstraint(SpringLayout.SOUTH, btnCadastroOrcamento, -6, SpringLayout.NORTH, label_1);
		sl_painelEsquerdo.putConstraint(SpringLayout.EAST, btnCadastroOrcamento, 0, SpringLayout.EAST, btnCadastroPeca);
		painelEsquerdo.add(btnCadastroOrcamento);
		
		JLabel lblConsulta = new JLabel("Consulta");
		sl_painelEsquerdo.putConstraint(SpringLayout.NORTH, lblConsulta, 6, SpringLayout.SOUTH, label_1);
		sl_painelEsquerdo.putConstraint(SpringLayout.WEST, lblConsulta, 0, SpringLayout.WEST, lblOficinaMecanicaAutobot);
		lblConsulta.setFont(new Font("Tahoma", Font.BOLD, 17));
		painelEsquerdo.add(lblConsulta);
		
		JLabel label_2 = new JLabel("______________________");
		sl_painelEsquerdo.putConstraint(SpringLayout.NORTH, label_2, 6, SpringLayout.SOUTH, label_1);
		sl_painelEsquerdo.putConstraint(SpringLayout.EAST, label_2, 0, SpringLayout.EAST, lblOficinaMecanicaAutobot);
		painelEsquerdo.add(label_2);
		
		JButton btnConsultaPeca = new JButton("Pe\u00E7a");
		btnConsultaPeca.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mostrarPainel(painelConsultarPeca);
			}
		});
		btnConsultaPeca.setIcon(new ImageIcon(TelaPrincipal2.class.getResource("/icones/settings-icon.png")));
		sl_painelEsquerdo.putConstraint(SpringLayout.NORTH, btnConsultaPeca, 6, SpringLayout.SOUTH, lblConsulta);
		sl_painelEsquerdo.putConstraint(SpringLayout.WEST, btnConsultaPeca, 10, SpringLayout.WEST, painelEsquerdo);
		sl_painelEsquerdo.putConstraint(SpringLayout.SOUTH, btnConsultaPeca, 47, SpringLayout.SOUTH, lblConsulta);
		sl_painelEsquerdo.putConstraint(SpringLayout.EAST, btnConsultaPeca, 0, SpringLayout.EAST, btnCadastroPeca);
		painelEsquerdo.add(btnConsultaPeca);
		
		JButton btnConsultaOrcamento = new JButton("Or\u00E7amento");
		btnConsultaOrcamento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mostrarPainel(painelConsultaOrcamento);
			}
		});
		sl_painelEsquerdo.putConstraint(SpringLayout.NORTH, btnConsultaOrcamento, 13, SpringLayout.SOUTH, btnConsultaPeca);
		sl_painelEsquerdo.putConstraint(SpringLayout.WEST, btnConsultaOrcamento, 10, SpringLayout.WEST, painelEsquerdo);
		sl_painelEsquerdo.putConstraint(SpringLayout.SOUTH, btnConsultaOrcamento, 54, SpringLayout.SOUTH, btnConsultaPeca);
		sl_painelEsquerdo.putConstraint(SpringLayout.EAST, btnConsultaOrcamento, 0, SpringLayout.EAST, btnCadastroPeca);
		btnConsultaOrcamento.setIcon(new ImageIcon(TelaPrincipal2.class.getResource("/icones/Documents-icon.png")));
		painelEsquerdo.add(btnConsultaOrcamento);
		
		JLabel label_3 = new JLabel("_________________________________");
		sl_painelEsquerdo.putConstraint(SpringLayout.NORTH, label_3, 6, SpringLayout.SOUTH, btnConsultaOrcamento);
		sl_painelEsquerdo.putConstraint(SpringLayout.EAST, label_3, 0, SpringLayout.EAST, lblOficinaMecanicaAutobot);
		painelEsquerdo.add(label_3);
		
		JLabel lblAlterar = new JLabel("Alterar");
		sl_painelEsquerdo.putConstraint(SpringLayout.NORTH, lblAlterar, 6, SpringLayout.SOUTH, label_3);
		sl_painelEsquerdo.putConstraint(SpringLayout.WEST, lblAlterar, 0, SpringLayout.WEST, lblOficinaMecanicaAutobot);
		lblAlterar.setFont(new Font("Tahoma", Font.BOLD, 17));
		painelEsquerdo.add(lblAlterar);
		
		JLabel label_4 = new JLabel("______________________");
		sl_painelEsquerdo.putConstraint(SpringLayout.NORTH, label_4, 6, SpringLayout.SOUTH, label_3);
		sl_painelEsquerdo.putConstraint(SpringLayout.WEST, label_4, 6, SpringLayout.EAST, lblAlterar);
		painelEsquerdo.add(label_4);
		
		JButton btnAlteraPeca = new JButton("Pe\u00E7a");
		btnAlteraPeca.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mostrarPainel(painelAlterarPeca);
			}
		});
		btnAlteraPeca.setIcon(new ImageIcon(TelaPrincipal2.class.getResource("/icones/settings-icon.png")));
		sl_painelEsquerdo.putConstraint(SpringLayout.NORTH, btnAlteraPeca, 6, SpringLayout.SOUTH, lblAlterar);
		sl_painelEsquerdo.putConstraint(SpringLayout.WEST, btnAlteraPeca, 10, SpringLayout.WEST, painelEsquerdo);
		sl_painelEsquerdo.putConstraint(SpringLayout.SOUTH, btnAlteraPeca, 47, SpringLayout.SOUTH, lblAlterar);
		sl_painelEsquerdo.putConstraint(SpringLayout.EAST, btnAlteraPeca, 0, SpringLayout.EAST, btnCadastroPeca);
		painelEsquerdo.add(btnAlteraPeca);
		
		JButton btnAlterarOrcamento = new JButton("Or\u00E7amento");
		btnAlterarOrcamento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mostrarPainel(painelAlterarOrcamento);
			}
		});
		btnAlterarOrcamento.setIcon(new ImageIcon(TelaPrincipal2.class.getResource("/icones/Documents-icon.png")));
		sl_painelEsquerdo.putConstraint(SpringLayout.NORTH, btnAlterarOrcamento, 13, SpringLayout.SOUTH, btnAlteraPeca);
		sl_painelEsquerdo.putConstraint(SpringLayout.WEST, btnAlterarOrcamento, 0, SpringLayout.WEST, lblOficinaMecanicaAutobot);
		sl_painelEsquerdo.putConstraint(SpringLayout.SOUTH, btnAlterarOrcamento, 54, SpringLayout.SOUTH, btnAlteraPeca);
		sl_painelEsquerdo.putConstraint(SpringLayout.EAST, btnAlterarOrcamento, 0, SpringLayout.EAST, btnCadastroPeca);
		painelEsquerdo.add(btnAlterarOrcamento);
		
		JLabel label_5 = new JLabel("_________________________________");
		sl_painelEsquerdo.putConstraint(SpringLayout.NORTH, label_5, 6, SpringLayout.SOUTH, btnAlterarOrcamento);
		sl_painelEsquerdo.putConstraint(SpringLayout.WEST, label_5, 0, SpringLayout.WEST, lblOficinaMecanicaAutobot);
		painelEsquerdo.add(label_5);
		
		JLabel lblDeletar = new JLabel("Deletar");
		sl_painelEsquerdo.putConstraint(SpringLayout.NORTH, lblDeletar, 6, SpringLayout.SOUTH, label_5);
		sl_painelEsquerdo.putConstraint(SpringLayout.EAST, lblDeletar, 0, SpringLayout.EAST, lblAlterar);
		lblDeletar.setFont(new Font("Tahoma", Font.BOLD, 17));
		painelEsquerdo.add(lblDeletar);
		
		JLabel label_6 = new JLabel("______________________");
		sl_painelEsquerdo.putConstraint(SpringLayout.WEST, label_6, 0, SpringLayout.WEST, label_4);
		sl_painelEsquerdo.putConstraint(SpringLayout.SOUTH, label_6, 0, SpringLayout.SOUTH, lblDeletar);
		painelEsquerdo.add(label_6);
		
		JButton btnDeletarPeca = new JButton("Pe\u00E7a");
		btnDeletarPeca.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mostrarPainel(painelDeletarPeca);
			}
		});
		btnDeletarPeca.setIcon(new ImageIcon(TelaPrincipal2.class.getResource("/icones/settings-icon.png")));
		sl_painelEsquerdo.putConstraint(SpringLayout.NORTH, btnDeletarPeca, 7, SpringLayout.SOUTH, lblDeletar);
		sl_painelEsquerdo.putConstraint(SpringLayout.WEST, btnDeletarPeca, 0, SpringLayout.WEST, lblOficinaMecanicaAutobot);
		sl_painelEsquerdo.putConstraint(SpringLayout.SOUTH, btnDeletarPeca, 48, SpringLayout.SOUTH, lblDeletar);
		sl_painelEsquerdo.putConstraint(SpringLayout.EAST, btnDeletarPeca, 0, SpringLayout.EAST, btnCadastroPeca);
		painelEsquerdo.add(btnDeletarPeca);
		
		JButton btnDeletarOrcamento = new JButton("Or\u00E7amento");
		btnDeletarOrcamento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mostrarPainel(painelDeletarOrcamento);
			}
		});
		btnDeletarOrcamento.setIcon(new ImageIcon(TelaPrincipal2.class.getResource("/icones/Documents-icon.png")));
		sl_painelEsquerdo.putConstraint(SpringLayout.NORTH, btnDeletarOrcamento, 11, SpringLayout.SOUTH, btnDeletarPeca);
		sl_painelEsquerdo.putConstraint(SpringLayout.WEST, btnDeletarOrcamento, 0, SpringLayout.WEST, lblOficinaMecanicaAutobot);
		sl_painelEsquerdo.putConstraint(SpringLayout.SOUTH, btnDeletarOrcamento, 52, SpringLayout.SOUTH, btnDeletarPeca);
		sl_painelEsquerdo.putConstraint(SpringLayout.EAST, btnDeletarOrcamento, 0, SpringLayout.EAST, btnCadastroPeca);
		painelEsquerdo.add(btnDeletarOrcamento);
		
		JLabel label_7 = new JLabel("_________________________________");
		sl_painelEsquerdo.putConstraint(SpringLayout.NORTH, label_7, 6, SpringLayout.SOUTH, btnDeletarOrcamento);
		sl_painelEsquerdo.putConstraint(SpringLayout.EAST, label_7, 0, SpringLayout.EAST, lblOficinaMecanicaAutobot);
		painelEsquerdo.add(label_7);
		
		JButton btnSair = new JButton("Sair");
		sl_painelEsquerdo.putConstraint(SpringLayout.WEST, btnSair, 10, SpringLayout.WEST, painelEsquerdo);
		sl_painelEsquerdo.putConstraint(SpringLayout.EAST, btnSair, 0, SpringLayout.EAST, lblCadastro);
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		painelEsquerdo.add(btnSair);
		
		JButton button = new JButton("");
		sl_painelEsquerdo.putConstraint(SpringLayout.WEST, button, 97, SpringLayout.EAST, btnSair);
		sl_painelEsquerdo.putConstraint(SpringLayout.EAST, button, -26, SpringLayout.EAST, painelEsquerdo);
		sl_painelEsquerdo.putConstraint(SpringLayout.NORTH, btnSair, -41, SpringLayout.SOUTH, button);
		sl_painelEsquerdo.putConstraint(SpringLayout.SOUTH, btnSair, 0, SpringLayout.SOUTH, button);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mostrarPainel(painelAjuda);
			}
		});
		sl_painelEsquerdo.putConstraint(SpringLayout.NORTH, button, -103, SpringLayout.SOUTH, painelEsquerdo);
		sl_painelEsquerdo.putConstraint(SpringLayout.SOUTH, button, -56, SpringLayout.SOUTH, painelEsquerdo);
		button.setIcon(new ImageIcon(TelaPrincipal2.class.getResource("/icones/Help-icon.png")));
		painelEsquerdo.add(button);
		contentPane.add(painelDireito);
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
		validate();
	}
}
