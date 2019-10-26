package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;

public class PainelConsultarPeca extends JPanel {
	private JTextField textNome;
	private JTextField textFabricante;
	private JTable table;

	/**
	 * Create the panel.
	 */
	public PainelConsultarPeca() {
		
		JLabel lblConsultarPeca = new JLabel("Consultar Pe\u00E7a");
		
		JLabel lblNome = new JLabel("Nome:");
		
		JLabel lblFabricante = new JLabel("Fabricante:");
		
		textNome = new JTextField();
		textNome.setColumns(10);
		
		textFabricante = new JTextField();
		textFabricante.setColumns(10);
		
		table = new JTable();
		
		JButton btnFechar = new JButton("Fechar");
		btnFechar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
			}
		});
		
		JButton btnConsultar = new JButton("Consultar");
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(94)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblFabricante)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(textFabricante, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblNome)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(textNome, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addGap(99)
					.addComponent(btnConsultar)
					.addContainerGap(164, Short.MAX_VALUE))
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addContainerGap(47, Short.MAX_VALUE)
					.addComponent(table, GroupLayout.PREFERRED_SIZE, 543, GroupLayout.PREFERRED_SIZE)
					.addGap(40))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(262)
					.addComponent(btnFechar)
					.addContainerGap(297, Short.MAX_VALUE))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(252)
					.addComponent(lblConsultarPeca)
					.addContainerGap(293, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblConsultarPeca)
							.addGap(18)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNome)
								.addComponent(textNome, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblFabricante)
								.addComponent(textFabricante, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(63)
							.addComponent(btnConsultar)))
					.addGap(42)
					.addComponent(table, GroupLayout.PREFERRED_SIZE, 298, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnFechar)
					.addContainerGap(14, Short.MAX_VALUE))
		);
		setLayout(groupLayout);

	}

}
