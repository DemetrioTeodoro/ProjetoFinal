package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PainelAlterarPeca extends JPanel {
	private JTextField textNomePeca;
	private JTextField textNomeFabricante;
	private JTextField textValor;
	private JTextField textQuantidade;

	/**
	 * Create the panel.
	 */
	public PainelAlterarPeca() {
		
		JLabel lblAlterarPeca = new JLabel("Alterar Pe\u00E7a");
		
		JLabel lblNomeDaPeca = new JLabel("Nome da Peca:");
		
		JLabel lblFabricante = new JLabel("Fabricante:");
		
		JLabel lblValor = new JLabel("Valor:");
		
		JLabel lblQuantidade = new JLabel("Quantidade:");
		
		textNomePeca = new JTextField();
		textNomePeca.setColumns(10);
		
		textNomeFabricante = new JTextField();
		textNomeFabricante.setColumns(10);
		
		textValor = new JTextField();
		textValor.setColumns(10);
		
		textQuantidade = new JTextField();
		textQuantidade.setColumns(10);
		
		JButton btnAlterar = new JButton("Alterar");
		
		JButton btnFechar = new JButton("Fechar");
		btnFechar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(160)
					.addComponent(lblAlterarPeca))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(54)
					.addComponent(lblNomeDaPeca)
					.addGap(6)
					.addComponent(textNomePeca, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(54)
					.addComponent(lblFabricante)
					.addGap(6)
					.addComponent(textNomeFabricante, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(54)
					.addComponent(lblValor)
					.addGap(6)
					.addComponent(textValor, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(49)
					.addComponent(lblQuantidade)
					.addGap(6)
					.addComponent(textQuantidade, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(66)
					.addComponent(btnFechar)
					.addGap(159)
					.addComponent(btnAlterar))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(10)
					.addComponent(lblAlterarPeca)
					.addGap(24)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNomeDaPeca)
						.addComponent(textNomePeca, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(12)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(3)
							.addComponent(lblFabricante))
						.addComponent(textNomeFabricante, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(3)
							.addComponent(lblValor))
						.addComponent(textValor, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(15)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(3)
							.addComponent(lblQuantidade))
						.addComponent(textQuantidade, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(51)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(btnFechar)
						.addComponent(btnAlterar)))
		);
		setLayout(groupLayout);
	}
}
