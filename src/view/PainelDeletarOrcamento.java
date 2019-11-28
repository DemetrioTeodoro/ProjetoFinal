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
import java.awt.Font;

public class PainelDeletarOrcamento extends JPanel {
	private JTextField textNomeCliente;
	private JTextField textAutomovel;
	private JTextField textMecanico;
	private JTable table;

	/**
	 * Create the panel.
	 */
	public PainelDeletarOrcamento() {
		
		JLabel lblConsultaOrcamento = new JLabel("Consulta Or\u00E7amento");
		lblConsultaOrcamento.setFont(new Font("Tahoma", Font.BOLD, 18));
		
		JLabel lblNomeDoCliente = new JLabel("Nome do Cliente:");
		
		textNomeCliente = new JTextField();
		textNomeCliente.setColumns(10);
		
		JLabel lblAutomovel = new JLabel("Autom\u00F3vel:");
		
		textAutomovel = new JTextField();
		textAutomovel.setColumns(10);
		
		JLabel lblMecanico = new JLabel("Mec\u00E2nico:");
		
		textMecanico = new JTextField();
		textMecanico.setColumns(10);
		
		table = new JTable();
		
		JButton btnFechar = new JButton("Fechar");
		btnFechar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		
		JButton btnConsultar = new JButton("Consultar");
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(265)
							.addComponent(btnFechar))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(84)
							.addComponent(table, GroupLayout.PREFERRED_SIZE, 539, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(145)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblAutomovel)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(textAutomovel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addGap(109)
									.addComponent(btnConsultar))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblNomeDoCliente)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(textNomeCliente, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblMecanico)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(textMecanico, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(281)
							.addComponent(lblConsultaOrcamento)))
					.addContainerGap(141, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(29)
					.addComponent(lblConsultaOrcamento)
					.addGap(26)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNomeDoCliente)
						.addComponent(textNomeCliente, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblAutomovel)
						.addComponent(textAutomovel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnConsultar))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblMecanico)
						.addComponent(textMecanico, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(28)
					.addComponent(table, GroupLayout.PREFERRED_SIZE, 273, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 66, Short.MAX_VALUE)
					.addComponent(btnFechar)
					.addContainerGap())
		);
		setLayout(groupLayout);
	}

}
