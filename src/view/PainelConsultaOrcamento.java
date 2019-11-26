package view;

import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.Font;

public class PainelConsultaOrcamento extends JPanel {
	private JTextField textNome;
	private JTextField textAutomovel;
	private JTable table;

	/**
	 * Create the panel.
	 */
	public PainelConsultaOrcamento() {
		
		JLabel lblConsultaDeOrcamento = new JLabel("Consulta de Or\u00E7amento");
		lblConsultaDeOrcamento.setFont(new Font("Tahoma", Font.BOLD, 18));
		
		JLabel lblNomeDoCliente = new JLabel("Nome do Cliente:");
		
		textNome = new JTextField();
		textNome.setColumns(10);
		
		JLabel lblAutomovel = new JLabel("Automovel:");
		
		textAutomovel = new JTextField();
		textAutomovel.setColumns(10);
		
		JLabel lblMecnico = new JLabel("Mec\u00E2nico:");
		
		JComboBox comboBox = new JComboBox();
		
		table = new JTable();
		
		JButton btnConsultar = new JButton("Consultar");
		
		JButton btnFechar = new JButton("Fechar");
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(345)
							.addComponent(btnFechar))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(59)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
									.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
										.addComponent(lblAutomovel)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(textAutomovel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(btnConsultar))
									.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
										.addComponent(lblNomeDoCliente)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(textNome, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addGap(65)
										.addComponent(lblMecnico)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, 160, GroupLayout.PREFERRED_SIZE)))
								.addComponent(table, GroupLayout.PREFERRED_SIZE, 644, GroupLayout.PREFERRED_SIZE)))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(235)
							.addComponent(lblConsultaDeOrcamento, GroupLayout.PREFERRED_SIZE, 222, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(96, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addGap(34)
					.addComponent(lblConsultaDeOrcamento)
					.addPreferredGap(ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNomeDoCliente)
						.addComponent(textNome, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblMecnico)
						.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(19)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblAutomovel)
								.addComponent(textAutomovel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(30))
						.addComponent(btnConsultar))
					.addGap(18)
					.addComponent(table, GroupLayout.PREFERRED_SIZE, 323, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(btnFechar)
					.addGap(22))
		);
		setLayout(groupLayout);

	}
}
