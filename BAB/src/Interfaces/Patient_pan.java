package Interfaces;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.JTextField;

import DataBase.Helper;
import actors.Patient;

import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.SQLException;

public class Patient_pan extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static JTable table;
	private JTextField textField;
	private JComboBox<String> comboBox ;

	/**
	 * Create the panel.
	 */
	public Patient_pan() {
		setLayout(null);
		
		JLabel lblEntrez = new JLabel("");
		lblEntrez.setFont(new Font("Yu Gothic UI Semilight", Font.BOLD, 14));
		lblEntrez.setBounds(275, 21, 282, 16);
		add(lblEntrez);
		
		textField = new JTextField();
		textField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				if(comboBox.getSelectedItem().equals("Nom")) {
					try {
						table.setModel(Helper.buildTableModel(Patient.filtrernom(textField.getText())));
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
				}else if(comboBox.getSelectedItem().equals("Pr?nom")){ {try {
					table.setModel(Helper.buildTableModel(Patient.filtrerprenom(textField.getText())));
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
					
				}
			}}
		});
		textField.setFont(new Font("Yu Gothic UI Semilight", Font.BOLD, 15));
		textField.setBackground(new Color(175, 238, 238));
		textField.setBounds(581, 12, 174, 33);
		add(textField);
		textField.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 59, 840, 392);
		add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		comboBox = new JComboBox<String>();
		comboBox.setFont(new Font("Yu Gothic UI Semilight", Font.BOLD, 14));
		comboBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				switch (comboBox.getSelectedIndex()) {
				case 1 : {
					lblEntrez.setText("Entrez le nom du patient");
					lblEntrez.setVisible(true);
					textField.setVisible(true);
					break;
					
				}
				case 2 :{
					lblEntrez.setText("Entrez le pr?nom du patient");
					lblEntrez.setVisible(true);
					textField.setVisible(true);
					break;
					
				}
				}
			}
		});
		comboBox.setEditable(true);
		comboBox.setBackground(new Color(175, 238, 238));
		comboBox.setBounds(26, 13, 234, 33);
		comboBox.addItem("Filter par");
		comboBox.addItem("Nom");
		comboBox.addItem("Pr?nom");
		
		add(comboBox);
		


		JLabel lblNewLabel = new JLabel("");
		
		lblNewLabel.setIcon(new ImageIcon("ressources\\backgroud ki ma tle3.png"));
		lblNewLabel.setBounds(0, 0, 864, 462);
		add(lblNewLabel);

	}
}
