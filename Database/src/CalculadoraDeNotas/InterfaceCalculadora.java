package CalculadoraDeNotas;

import java.awt.EventQueue;
import java.util.Vector;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JCheckBox;
import javax.swing.border.TitledBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ListSelectionModel;
import javax.swing.JList;

public class InterfaceCalculadora {

	JFrame frame;
	private JTable table;
	private DefaultTableModel model;
	private JTable table_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InterfaceCalculadora window = new InterfaceCalculadora();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public InterfaceCalculadora() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		frame = new JFrame();
		frame.setBounds(100, 100, 900, 550);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnCalcularMedia = new JButton("Calcular Média");
		btnCalcularMedia.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnCalcularMedia.setBounds(439, 455, 200, 30);
		frame.getContentPane().add(btnCalcularMedia);
		
		JButton btnApagar = new JButton("Apagar notas");
		btnApagar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnApagar.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnApagar.setBounds(660, 455, 160, 30);
		frame.getContentPane().add(btnApagar);
		
		JPanel painelCadastro = new JPanel();
		painelCadastro.setBounds(10, 24, 864, 135);
		frame.getContentPane().add(painelCadastro);
		
		JLabel lblNota = new JLabel("Nota");
		lblNota.setFont(new Font("Tahoma", Font.PLAIN, 14));
        frame.getContentPane().add(lblNota);
        
		JFormattedTextField tfNota = new JFormattedTextField();
        frame.getContentPane().add(tfNota);
		
		JLabel lblPercentual = new JLabel("Percentual");
		lblPercentual.setFont(new Font("Tahoma", Font.PLAIN, 14));
        frame.getContentPane().add(lblPercentual);
        
		JFormattedTextField tfPercentual = new JFormattedTextField();
        frame.getContentPane().add(tfPercentual);



		
		JLabel lblMateria = new JLabel("Matéria");
		lblMateria.setFont(new Font("Tahoma", Font.PLAIN, 14));
        frame.getContentPane().add(lblMateria);

		JComboBox selMateria = new JComboBox();
		selMateria.setToolTipText("");
        frame.getContentPane().add(selMateria);

		
		JLabel lblTipo = new JLabel("Tipo");
		lblTipo.setFont(new Font("Tahoma", Font.PLAIN, 14));
        frame.getContentPane().add(lblTipo);

		
		JComboBox selTipo = new JComboBox();
		selTipo.setToolTipText("");
        frame.getContentPane().add(selTipo);

		
		
		JButton btnAdicionarNota = new JButton("Adicionar nota");
		btnAdicionarNota.setFont(new Font("Tahoma", Font.BOLD, 14));
		GroupLayout gl_painelCadastro = new GroupLayout(painelCadastro);
		gl_painelCadastro.setHorizontalGroup(
			gl_painelCadastro.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_painelCadastro.createSequentialGroup()
					.addGap(53)
					.addGroup(gl_painelCadastro.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_painelCadastro.createSequentialGroup()
							.addComponent(lblNota, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
							.addGap(13)
							.addComponent(tfNota, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
							.addGap(10)
							.addComponent(lblPercentual, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)
							.addGap(13)
							.addComponent(tfPercentual, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
							.addGap(10)
							.addComponent(lblMateria, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
							.addGap(13)
							.addComponent(selMateria, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
							.addGap(10)
							.addComponent(lblTipo, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
							.addGap(13)
							.addComponent(selTipo, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE))
						.addComponent(btnAdicionarNota, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(56, Short.MAX_VALUE))
		);
		gl_painelCadastro.setVerticalGroup(
			gl_painelCadastro.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_painelCadastro.createSequentialGroup()
					.addGap(33)
					.addGroup(gl_painelCadastro.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_painelCadastro.createSequentialGroup()
							.addGap(2)
							.addComponent(lblNota, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE))
						.addComponent(tfNota, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_painelCadastro.createSequentialGroup()
							.addGap(2)
							.addComponent(lblPercentual, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE))
						.addComponent(tfPercentual, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_painelCadastro.createSequentialGroup()
							.addGap(4)
							.addComponent(lblMateria, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE))
						.addComponent(selMateria, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_painelCadastro.createSequentialGroup()
							.addGap(4)
							.addComponent(lblTipo, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE))
						.addComponent(selTipo, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
					.addGap(34)
					.addComponent(btnAdicionarNota, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(55, Short.MAX_VALUE))
		);
		painelCadastro.setLayout(gl_painelCadastro);
		
        DefaultListModel<String> listModel = new DefaultListModel<>();
        listModel.addElement("Nota 1");
        listModel.addElement("Nota 2");
        listModel.addElement("Nota 3");
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(65, 187, 755, 262);
        frame.getContentPane().add(scrollPane);
        
        table_1 = new JTable();
        table_1.setModel(new DefaultTableModel(
        	new Object[][] {
        	},
        	new String[] {
        		"Selecionado", "Nota", "Percentual", "Matéria", "Tipo"
        	}
        ));
        scrollPane.setViewportView(table_1);

		

	}

	private void setTitle(String string) {
		// TODO Auto-generated method stub
		
	}
}
