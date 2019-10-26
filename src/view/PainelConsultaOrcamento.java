package view;

import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JComboBox;

public class PainelConsultaOrcamento extends JPanel {
	private JTextField textNome;
	private JTextField textAutomovel;

	/**
	 * Create the panel.
	 */
	public PainelConsultaOrcamento() {
		
		JLabel lblConsultaDeOrcamento = new JLabel("Consulta de Or\u00E7amento");
		
		JLabel lblNomeDoCliente = new JLabel("Nome do Cliente:");
		
		textNome = new JTextField();
		textNome.setColumns(10);
		
		JLabel lblAutomovel = new JLabel("Automovel:");
		
		textAutomovel = new JTextField();
		textAutomovel.setColumns(10);
		
		JLabel lblMecnico = new JLabel("Mec\u00E2nico:");
		
		JComboBox comboBox = new JComboBox();
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addContainerGap(169, Short.MAX_VALUE)
					.addComponent(lblConsultaDeOrcamento)
					.addGap(147))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(59)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblNomeDoCliente)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(textNome, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
							.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
								.addComponent(lblMecnico)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(comboBox, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
							.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
								.addComponent(lblAutomovel)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(textAutomovel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
					.addContainerGap(171, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblConsultaDeOrcamento)
					.addGap(26)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNomeDoCliente)
						.addComponent(textNome, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblAutomovel)
						.addComponent(textAutomovel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblMecnico)
						.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(149, Short.MAX_VALUE))
		);
		setLayout(groupLayout);

	}

}
