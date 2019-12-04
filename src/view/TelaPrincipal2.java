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
	private JButton btnAlteraPeca;
	private JButton btnCadastroPeca;
	private JButton btnCadastroOrcamento;
	private JButton btnConsultaPeca;
	private JButton btnConsultaOrcamento;
	private JButton btnAlterarOrcamento;
	private JLabel lblLinha2;
	private JLabel lblConsulta;
	private JLabel lblLinha3;
	private JLabel lblLinha4;
	private JLabel lblAlterar;
	private JLabel lblLinha5;
	private JLabel lblLinha6;
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
	
	public JLabel getLblLinha2() {
		return lblLinha2;
	}
	public void setLblLinha2(JLabel lblLinha2) {
		this.lblLinha2 = lblLinha2;
	}
	public JLabel getLblConsulta() {
		return lblConsulta;
	}
	public void setLblConsulta(JLabel lblConsulta) {
		this.lblConsulta = lblConsulta;
	}
	public JLabel getLblLinha3() {
		return lblLinha3;
	}
	public void setLblLinha3(JLabel lblLinha3) {
		this.lblLinha3 = lblLinha3;
	}
	public JLabel getLblLinha4() {
		return lblLinha4;
	}
	public void setLblLinha4(JLabel lblLinha4) {
		this.lblLinha4 = lblLinha4;
	}
	public JLabel getLblAlterar() {
		return lblAlterar;
	}
	public void setLblAlterar(JLabel lblAlterar) {
		this.lblAlterar = lblAlterar;
	}
	public JLabel getLblLinha5() {
		return lblLinha5;
	}
	public void setLblLinha5(JLabel lblLinha5) {
		this.lblLinha5 = lblLinha5;
	}
	public JLabel getLblLinha6() {
		return lblLinha6;
	}
	public void setLblLinha6(JLabel lblLinha6) {
		this.lblLinha6 = lblLinha6;
	}
	public JButton getBtnAlteraPeca() {
		return btnAlteraPeca;
	}
	public void setBtnAlteraPeca(JButton btnAlteraPeca) {
		this.btnAlteraPeca = btnAlteraPeca;
	}
	public JButton getBtnCadastroPeca() {
		return btnCadastroPeca;
	}
	public void setBtnCadastroPeca(JButton btnCadastroPeca) {
		this.btnCadastroPeca = btnCadastroPeca;
	}
	public JButton getBtnCadastroOrcamento() {
		return btnCadastroOrcamento;
	}
	public void setBtnCadastroOrcamento(JButton btnCadastroOrcamento) {
		this.btnCadastroOrcamento = btnCadastroOrcamento;
	}
	public JButton getBtnConsultaPeca() {
		return btnConsultaPeca;
	}
	public void setBtnConsultaPeca(JButton btnConsultaPeca) {
		this.btnConsultaPeca = btnConsultaPeca;
	}
	public JButton getBtnConsultaOrcamento() {
		return btnConsultaOrcamento;
	}
	public void setBtnConsultaOrcamento(JButton btnConsultaOrcamento) {
		this.btnConsultaOrcamento = btnConsultaOrcamento;
	}
	public JButton getBtnAlterarOrcamento() {
		return btnAlterarOrcamento;
	}
	public void setBtnAlterarOrcamento(JButton btnAlterarOrcamento) {
		this.btnAlterarOrcamento = btnAlterarOrcamento;
	}
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
		setTitle("Ger\u00EAncia de Pe\u00E7as e Servi\u00E7os");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 930, 800);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		SpringLayout sl_contentPane = new SpringLayout();
		contentPane.setLayout(sl_contentPane);
		
		painelEsquerdo = new JPanel();
		sl_contentPane.putConstraint(SpringLayout.WEST, painelEsquerdo, -5, SpringLayout.WEST, contentPane);
		painelEsquerdo.setBackground(Color.LIGHT_GRAY);
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
		
		JLabel lblLinha1 = new JLabel("______________________");
		sl_painelEsquerdo.putConstraint(SpringLayout.NORTH, lblLinha1, 0, SpringLayout.NORTH, lblCadastro);
		sl_painelEsquerdo.putConstraint(SpringLayout.WEST, lblLinha1, 6, SpringLayout.EAST, lblCadastro);
		painelEsquerdo.add(lblLinha1);
		
		lblLinha2 = new JLabel("_________________________________");
		sl_painelEsquerdo.putConstraint(SpringLayout.NORTH, lblLinha2, 213, SpringLayout.NORTH, painelEsquerdo);
		sl_painelEsquerdo.putConstraint(SpringLayout.EAST, lblLinha2, 0, SpringLayout.EAST, lblOficinaMecanicaAutobot);
		painelEsquerdo.add(lblLinha2);
		
		painelDireito = new JPanel();
		sl_contentPane.putConstraint(SpringLayout.NORTH, painelDireito, 5, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, painelDireito, 263, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, painelDireito, -5, SpringLayout.SOUTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, painelDireito, -5, SpringLayout.EAST, contentPane);
		
		incluirPaineisEscondidos();
		
		btnCadastroPeca = new JButton("Pe\u00E7a");
		sl_painelEsquerdo.putConstraint(SpringLayout.WEST, btnCadastroPeca, 0, SpringLayout.WEST, lblOficinaMecanicaAutobot);
		sl_painelEsquerdo.putConstraint(SpringLayout.SOUTH, btnCadastroPeca, -4, SpringLayout.NORTH, lblLinha2);
		sl_painelEsquerdo.putConstraint(SpringLayout.EAST, btnCadastroPeca, -26, SpringLayout.EAST, lblOficinaMecanicaAutobot);
		btnCadastroPeca.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				mostrarPainel(painelCadastroPeca);
			}
		});
		btnCadastroPeca.setIcon(new ImageIcon(TelaPrincipal2.class.getResource("/icones/settings-icon.png")));
		painelEsquerdo.add(btnCadastroPeca);
		
		btnCadastroOrcamento = new JButton("Or\u00E7amento");
		sl_painelEsquerdo.putConstraint(SpringLayout.NORTH, btnCadastroOrcamento, 16, SpringLayout.SOUTH, lblCadastro);
		sl_painelEsquerdo.putConstraint(SpringLayout.WEST, btnCadastroOrcamento, 0, SpringLayout.WEST, lblOficinaMecanicaAutobot);
		sl_painelEsquerdo.putConstraint(SpringLayout.SOUTH, btnCadastroOrcamento, -62, SpringLayout.NORTH, lblLinha2);
		sl_painelEsquerdo.putConstraint(SpringLayout.EAST, btnCadastroOrcamento, -52, SpringLayout.EAST, painelEsquerdo);
		btnCadastroOrcamento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mostrarPainel(painelCadastroOrcamento);
			}
		});
		btnCadastroOrcamento.setIcon(new ImageIcon(TelaPrincipal2.class.getResource("/icones/Documents-icon.png")));
		painelEsquerdo.add(btnCadastroOrcamento);
		
		lblConsulta = new JLabel("Consulta");
		sl_painelEsquerdo.putConstraint(SpringLayout.NORTH, lblConsulta, 6, SpringLayout.SOUTH, lblLinha2);
		sl_painelEsquerdo.putConstraint(SpringLayout.WEST, lblConsulta, 0, SpringLayout.WEST, lblOficinaMecanicaAutobot);
		lblConsulta.setFont(new Font("Tahoma", Font.BOLD, 17));
		painelEsquerdo.add(lblConsulta);
		
		lblLinha3 = new JLabel("______________________");
		sl_painelEsquerdo.putConstraint(SpringLayout.NORTH, lblLinha3, 6, SpringLayout.SOUTH, lblLinha2);
		sl_painelEsquerdo.putConstraint(SpringLayout.EAST, lblLinha3, 0, SpringLayout.EAST, lblOficinaMecanicaAutobot);
		painelEsquerdo.add(lblLinha3);
		
		btnConsultaPeca = new JButton("Pe\u00E7a");
		sl_painelEsquerdo.putConstraint(SpringLayout.WEST, btnConsultaPeca, 0, SpringLayout.WEST, lblOficinaMecanicaAutobot);
		sl_painelEsquerdo.putConstraint(SpringLayout.EAST, btnConsultaPeca, -52, SpringLayout.EAST, painelEsquerdo);
		btnConsultaPeca.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mostrarPainel(painelConsultarPeca);
			}
		});
		btnConsultaPeca.setIcon(new ImageIcon(TelaPrincipal2.class.getResource("/icones/settings-icon.png")));
		painelEsquerdo.add(btnConsultaPeca);
		
		btnConsultaOrcamento = new JButton("Or\u00E7amento");
		sl_painelEsquerdo.putConstraint(SpringLayout.NORTH, btnConsultaOrcamento, 6, SpringLayout.SOUTH, lblConsulta);
		sl_painelEsquerdo.putConstraint(SpringLayout.WEST, btnConsultaOrcamento, 0, SpringLayout.WEST, lblOficinaMecanicaAutobot);
		sl_painelEsquerdo.putConstraint(SpringLayout.SOUTH, btnConsultaOrcamento, -13, SpringLayout.NORTH, btnConsultaPeca);
		sl_painelEsquerdo.putConstraint(SpringLayout.EAST, btnConsultaOrcamento, 0, SpringLayout.EAST, btnCadastroPeca);
		btnConsultaOrcamento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mostrarPainel(painelConsultaOrcamento);
			}
		});
		btnConsultaOrcamento.setIcon(new ImageIcon(TelaPrincipal2.class.getResource("/icones/Documents-icon.png")));
		painelEsquerdo.add(btnConsultaOrcamento);
		
		lblLinha4 = new JLabel("_________________________________");
		sl_painelEsquerdo.putConstraint(SpringLayout.SOUTH, btnConsultaPeca, -6, SpringLayout.NORTH, lblLinha4);
		sl_painelEsquerdo.putConstraint(SpringLayout.NORTH, lblLinha4, 363, SpringLayout.NORTH, painelEsquerdo);
		sl_painelEsquerdo.putConstraint(SpringLayout.EAST, lblLinha4, 0, SpringLayout.EAST, lblOficinaMecanicaAutobot);
		painelEsquerdo.add(lblLinha4);
		
		lblAlterar = new JLabel("Alterar");
		sl_painelEsquerdo.putConstraint(SpringLayout.NORTH, lblAlterar, 6, SpringLayout.SOUTH, lblLinha4);
		sl_painelEsquerdo.putConstraint(SpringLayout.WEST, lblAlterar, 0, SpringLayout.WEST, lblOficinaMecanicaAutobot);
		lblAlterar.setFont(new Font("Tahoma", Font.BOLD, 17));
		painelEsquerdo.add(lblAlterar);
		
		lblLinha5 = new JLabel("______________________");
		sl_painelEsquerdo.putConstraint(SpringLayout.NORTH, lblLinha5, 6, SpringLayout.SOUTH, lblLinha4);
		sl_painelEsquerdo.putConstraint(SpringLayout.WEST, lblLinha5, 6, SpringLayout.EAST, lblAlterar);
		painelEsquerdo.add(lblLinha5);
		
		btnAlteraPeca = new JButton("Pe\u00E7a");
		sl_painelEsquerdo.putConstraint(SpringLayout.WEST, btnAlteraPeca, 0, SpringLayout.WEST, lblOficinaMecanicaAutobot);
		sl_painelEsquerdo.putConstraint(SpringLayout.EAST, btnAlteraPeca, 0, SpringLayout.EAST, btnCadastroPeca);
		btnAlteraPeca.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mostrarPainel(painelAlterarPeca);
			}
		});
		btnAlteraPeca.setIcon(new ImageIcon(TelaPrincipal2.class.getResource("/icones/settings-icon.png")));
		painelEsquerdo.add(btnAlteraPeca);
		
		btnAlterarOrcamento = new JButton("Or\u00E7amento");
		sl_painelEsquerdo.putConstraint(SpringLayout.NORTH, btnAlterarOrcamento, 11, SpringLayout.SOUTH, lblAlterar);
		sl_painelEsquerdo.putConstraint(SpringLayout.WEST, btnAlterarOrcamento, 0, SpringLayout.WEST, lblOficinaMecanicaAutobot);
		sl_painelEsquerdo.putConstraint(SpringLayout.EAST, btnAlterarOrcamento, -52, SpringLayout.EAST, painelEsquerdo);
		btnAlterarOrcamento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mostrarPainel(painelAlterarOrcamento);
			}
		});
		btnAlterarOrcamento.setIcon(new ImageIcon(TelaPrincipal2.class.getResource("/icones/Documents-icon.png")));
		painelEsquerdo.add(btnAlterarOrcamento);
		
		lblLinha6 = new JLabel("_________________________________");
		sl_painelEsquerdo.putConstraint(SpringLayout.NORTH, btnAlteraPeca, -63, SpringLayout.SOUTH, lblLinha6);
		sl_painelEsquerdo.putConstraint(SpringLayout.SOUTH, btnAlteraPeca, -6, SpringLayout.NORTH, lblLinha6);
		sl_painelEsquerdo.putConstraint(SpringLayout.SOUTH, btnAlterarOrcamento, -55, SpringLayout.NORTH, lblLinha6);
		sl_painelEsquerdo.putConstraint(SpringLayout.NORTH, lblLinha6, 513, SpringLayout.NORTH, painelEsquerdo);
		sl_painelEsquerdo.putConstraint(SpringLayout.NORTH, btnConsultaPeca, -213, SpringLayout.SOUTH, lblLinha6);
		sl_painelEsquerdo.putConstraint(SpringLayout.NORTH, btnCadastroPeca, -361, SpringLayout.SOUTH, lblLinha6);
		sl_painelEsquerdo.putConstraint(SpringLayout.WEST, lblLinha6, 0, SpringLayout.WEST, lblOficinaMecanicaAutobot);
		painelEsquerdo.add(lblLinha6);
		
		JButton btnSair = new JButton("Sair");
		sl_painelEsquerdo.putConstraint(SpringLayout.WEST, btnSair, 10, SpringLayout.WEST, painelEsquerdo);
		sl_painelEsquerdo.putConstraint(SpringLayout.EAST, btnSair, 0, SpringLayout.EAST, lblCadastro);
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		painelEsquerdo.add(btnSair);
		
		JButton btnAjuda = new JButton("");
		sl_painelEsquerdo.putConstraint(SpringLayout.WEST, btnAjuda, 97, SpringLayout.EAST, btnSair);
		sl_painelEsquerdo.putConstraint(SpringLayout.EAST, btnAjuda, -26, SpringLayout.EAST, painelEsquerdo);
		sl_painelEsquerdo.putConstraint(SpringLayout.NORTH, btnSair, -41, SpringLayout.SOUTH, btnAjuda);
		sl_painelEsquerdo.putConstraint(SpringLayout.SOUTH, btnSair, 0, SpringLayout.SOUTH, btnAjuda);
		btnAjuda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mostrarPainel(painelAjuda);
			}
		});
		sl_painelEsquerdo.putConstraint(SpringLayout.NORTH, btnAjuda, -103, SpringLayout.SOUTH, painelEsquerdo);
		sl_painelEsquerdo.putConstraint(SpringLayout.SOUTH, btnAjuda, -56, SpringLayout.SOUTH, painelEsquerdo);
		btnAjuda.setIcon(new ImageIcon(TelaPrincipal2.class.getResource("/icones/Help-icon.png")));
		painelEsquerdo.add(btnAjuda);
		contentPane.add(painelDireito);
	}
	
	private void incluirPaineisEscondidos() {
		painelDireito.add(painelCadastroOrcamento);
		painelDireito.add(painelCadastroPeca);
		painelDireito.add(painelConsultaOrcamento);
		painelDireito.add(painelConsultarPeca);
		painelDireito.add(painelAlterarOrcamento);
		painelDireito.add(painelAlterarPeca);
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
		painelAjuda.setVisible(false);
	}

	protected void mostrarPainel(JPanel painelSelecionado) {
		esconderTodosPaineis();
		painelSelecionado.setVisible(true);
		validate();
	}
}
