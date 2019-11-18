package view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
import javax.swing.SwingConstants;

public class PainelTelaAcesso extends JPanel {
	private JTextField textUsuario;
	private JTextField textSenha;

	/**
	 * Create the panel.
	 */
	public PainelTelaAcesso() {
		setForeground(Color.BLACK);
		SpringLayout springLayout = new SpringLayout();
		setLayout(springLayout);

		JLabel lblUsuario = new JLabel("Usuario:");
		springLayout.putConstraint(SpringLayout.NORTH, lblUsuario, 111, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.WEST, lblUsuario, 118, SpringLayout.WEST, this);
		add(lblUsuario);

		JLabel lblSenha = new JLabel("Senha:");
		springLayout.putConstraint(SpringLayout.NORTH, lblSenha, 20, SpringLayout.SOUTH, lblUsuario);
		springLayout.putConstraint(SpringLayout.WEST, lblSenha, 0, SpringLayout.WEST, lblUsuario);
		add(lblSenha);

		JButton btnVoltar = new JButton("Voltar");
		springLayout.putConstraint(SpringLayout.WEST, btnVoltar, 66, SpringLayout.WEST, this);
		add(btnVoltar);

		JButton btnAcessar = new JButton("Acessar");
		springLayout.putConstraint(SpringLayout.SOUTH, btnAcessar, -61, SpringLayout.SOUTH, this);
		springLayout.putConstraint(SpringLayout.NORTH, btnVoltar, 0, SpringLayout.NORTH, btnAcessar);
		springLayout.putConstraint(SpringLayout.EAST, btnAcessar, -88, SpringLayout.EAST, this);
		add(btnAcessar);

		textUsuario = new JTextField();
		springLayout.putConstraint(SpringLayout.NORTH, textUsuario, -3, SpringLayout.NORTH, lblUsuario);
		springLayout.putConstraint(SpringLayout.WEST, textUsuario, 6, SpringLayout.EAST, lblUsuario);
		add(textUsuario);
		textUsuario.setColumns(10);

		textSenha = new JTextField();
		springLayout.putConstraint(SpringLayout.NORTH, textSenha, -3, SpringLayout.NORTH, lblSenha);
		springLayout.putConstraint(SpringLayout.WEST, textSenha, 6, SpringLayout.EAST, lblSenha);
		add(textSenha);
		textSenha.setColumns(10);

		JLabel lblTelaDeAcesso = new JLabel("Tela de Acesso");
		springLayout.putConstraint(SpringLayout.NORTH, lblTelaDeAcesso, 10, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.WEST, lblTelaDeAcesso, 10, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.SOUTH, lblTelaDeAcesso, 86, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.EAST, lblTelaDeAcesso, -10, SpringLayout.EAST, this);
		lblTelaDeAcesso.setOpaque(true);
		lblTelaDeAcesso.setHorizontalAlignment(SwingConstants.CENTER);
		lblTelaDeAcesso.setBackground(Color.DARK_GRAY);
		add(lblTelaDeAcesso);
		lblTelaDeAcesso.setFont(new Font("Tahoma", Font.BOLD, 17));

	}
}
