package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import model.entity.Peca;

import java.awt.Font;

public class PainelAlterarPeca extends JPanel {
	private JTextField textNomePeca;
	private JTextField textNomeFabricante;
	private JTextField textValor;
	private JTextField textQuantidade;
	Peca peca = new Peca();

	/**
	 * Create the panel.
	 */
	public PainelAlterarPeca() {
		
		JLabel lblAlterarPeca = new JLabel("Alterar Pe\u00E7a");
		lblAlterarPeca.setFont(new Font("Tahoma", Font.BOLD, 18));
		
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
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addContainerGap(79, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(5)
							.addComponent(lblNomeDaPeca)
							.addGap(6)
							.addComponent(textNomePeca, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(5)
							.addComponent(lblFabricante)
							.addGap(6)
							.addComponent(textNomeFabricante, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(5)
							.addComponent(lblValor)
							.addGap(6)
							.addComponent(textValor, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblQuantidade)
							.addGap(6)
							.addComponent(textQuantidade, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(17)
							.addComponent(btnFechar)
							.addGap(159)
							.addComponent(btnAlterar)))
					.addGap(53))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(166)
					.addComponent(lblAlterarPeca)
					.addContainerGap(214, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(26)
					.addComponent(lblAlterarPeca)
					.addGap(36)
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
						.addComponent(btnAlterar))
					.addContainerGap())
		);
		setLayout(groupLayout);
	}
}
