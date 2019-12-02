package view;

import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.ImageIcon;

public class PainelAjuda extends JPanel {

	/**
	 * Create the panel.
	 */
	public PainelAjuda() {
		
		JLabel lblAjuda = new JLabel("Ajuda");
		lblAjuda.setFont(new Font("Tahoma", Font.BOLD, 18));
		
		JLabel lblParaCadastrarUma = new JLabel("Para cadastrar uma pe\u00E7a ou um or\u00E7amento basta clicar no bot\u00E3o pe\u00E7a ou um or\u00E7amento dentro do espa\u00E7o de Cadastro, como mostra a figura a baixo.");
		
		JLabel lblParaConsultarUma = new JLabel("Para consultar uma pe\u00E7a ou or\u00E7ameto basta clicar no bot\u00E3o pe\u00E7a ou or\u00E7amento dentro do espa\u00E7o de Consulta.");
		
		JLabel lblParaAlterarUma = new JLabel("Para alterar uma pe\u00E7a ou or\u00E7ameto basta clicar no bot\u00E3o pe\u00E7a ou or\u00E7amento dentro do espa\u00E7o de Alterar.");
		
		JLabel lblParaConsultarUma_1 = new JLabel("Para Deletar uma pe\u00E7a ou or\u00E7ameto basta clicar no bot\u00E3o pe\u00E7a ou or\u00E7amento dentro do espa\u00E7o de Deletar.");
		
		JButton btnFechar = new JButton("Fechar");
		btnFechar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
			}
		});
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblParaCadastrarUma))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(291)
							.addComponent(lblAjuda))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(298)
							.addComponent(btnFechar))
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblParaConsultarUma))
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblParaAlterarUma))
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblParaConsultarUma_1)))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblAjuda)
					.addGap(34)
					.addComponent(lblParaCadastrarUma, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
					.addGap(32)
					.addComponent(lblParaConsultarUma)
					.addGap(52)
					.addComponent(lblParaAlterarUma)
					.addGap(51)
					.addComponent(lblParaConsultarUma_1)
					.addPreferredGap(ComponentPlacement.RELATED, 397, Short.MAX_VALUE)
					.addComponent(btnFechar)
					.addGap(71))
		);
		setLayout(groupLayout);

	}
}
