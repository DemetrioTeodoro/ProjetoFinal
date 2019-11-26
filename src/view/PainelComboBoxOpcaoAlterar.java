package view;

import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class PainelComboBoxOpcaoAlterar extends JPanel {

	/**
	 * Create the panel.
	 */
	public PainelComboBoxOpcaoAlterar() {
		String[] opcoes = {TelaPrincipal2.OPCAO_SELECIONE,"    Orçamento","     Peça"};
		
		JLabel lblOpcaoDeAlteracao = new JLabel("Op\u00E7\u00E3o de Altera\u00E7\u00E3o");
		
		JComboBox comboBox = new JComboBox(opcoes);
		
		JButton btnConfirmar = new JButton("Confirmar");
		
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
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(149)
							.addComponent(lblOpcaoDeAlteracao))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(139)
							.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(189, Short.MAX_VALUE))
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addGap(54)
					.addComponent(btnFechar)
					.addPreferredGap(ComponentPlacement.RELATED, 102, Short.MAX_VALUE)
					.addComponent(btnConfirmar)
					.addGap(108))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(22)
					.addComponent(lblOpcaoDeAlteracao)
					.addGap(49)
					.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(60)
							.addComponent(btnConfirmar))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(62)
							.addComponent(btnFechar)))
					.addContainerGap(104, Short.MAX_VALUE))
		);
		setLayout(groupLayout);

	}

}
