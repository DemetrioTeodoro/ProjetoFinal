package view;

import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PainelComboBoxOpcaoCadastro extends JPanel {

	private JComboBox comboBox;

	/**
	 * Create the panel.
	 */
	public PainelComboBoxOpcaoCadastro() {
		String[] opcoes = {TelaPrincipal2.OPCAO_SELECIONE,"    Orçamento","     Peça"};

		JLabel lblOpcaoDeCadastros = new JLabel("Op\u00E7\u00E3o de Cadastros");

		comboBox = new JComboBox(opcoes);

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
										.addGap(144)
										.addComponent(lblOpcaoDeCadastros))
								.addGroup(groupLayout.createSequentialGroup()
										.addGap(142)
										.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, 123, GroupLayout.PREFERRED_SIZE)))
						.addContainerGap(240, Short.MAX_VALUE))
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
						.addGap(70)
						.addComponent(btnFechar)
						.addPreferredGap(ComponentPlacement.RELATED, 103, Short.MAX_VALUE)
						.addComponent(btnConfirmar)
						.addGap(119))
				);
		groupLayout.setVerticalGroup(
				groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
						.addGap(17)
						.addComponent(lblOpcaoDeCadastros)
						.addGap(51)
						.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addGap(87)
						.addComponent(btnConfirmar)
						.addContainerGap(134, Short.MAX_VALUE))
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
						.addContainerGap(195, Short.MAX_VALUE)
						.addComponent(btnFechar)
						.addGap(134))
				);
		setLayout(groupLayout);

	}

	public void limparTela() {
		this.comboBox.setSelectedIndex(0);
	}
}
