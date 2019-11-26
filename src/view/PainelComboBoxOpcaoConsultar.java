package view;

import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PainelComboBoxOpcaoConsultar extends JPanel {

	/**
	 * Create the panel.
	 */
	public PainelComboBoxOpcaoConsultar() {
		String[] opcoes = {TelaPrincipal2.OPCAO_SELECIONE,"    Orçamento","     Peça"};
		
		JLabel lblOpcaoDeConsulta = new JLabel("Op\u00E7\u00E3o de Consulta");
		
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
							.addGap(162)
							.addComponent(lblOpcaoDeConsulta))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(152)
							.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, 117, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(181, Short.MAX_VALUE))
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addGap(62)
					.addComponent(btnFechar)
					.addPreferredGap(ComponentPlacement.RELATED, 102, Short.MAX_VALUE)
					.addComponent(btnConfirmar)
					.addGap(100))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(23)
					.addComponent(lblOpcaoDeConsulta)
					.addGap(43)
					.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(73)
							.addComponent(btnConfirmar))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(74)
							.addComponent(btnFechar)))
					.addContainerGap(97, Short.MAX_VALUE))
		);
		setLayout(groupLayout);

	}

}
