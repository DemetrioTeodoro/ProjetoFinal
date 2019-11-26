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
import javax.swing.DefaultComboBoxModel;

public class PainelComboBoxOpcaoDeletar extends JPanel {

	/**
	 * Create the panel.
	 */
	public PainelComboBoxOpcaoDeletar() {
		String[] opcoes = {TelaPrincipal2.OPCAO_SELECIONE,"    Orçamento","     Peça"};
		
		JLabel lblOpoParaExcluir = new JLabel("Op\u00E7\u00E3o para Excluir");
		
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
					.addGap(161)
					.addComponent(lblOpoParaExcluir)
					.addContainerGap(182, Short.MAX_VALUE))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(146)
					.addComponent(comboBox, 0, 131, Short.MAX_VALUE)
					.addGap(173))
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addGap(68)
					.addComponent(btnFechar)
					.addPreferredGap(ComponentPlacement.RELATED, 108, Short.MAX_VALUE)
					.addComponent(btnConfirmar)
					.addGap(88))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(24)
					.addComponent(lblOpoParaExcluir)
					.addGap(47)
					.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(70)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnConfirmar)
						.addComponent(btnFechar))
					.addContainerGap(96, Short.MAX_VALUE))
		);
		setLayout(groupLayout);

	}

}
