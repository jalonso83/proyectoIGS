package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.border.TitledBorder;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

import com.sun.org.apache.bcel.internal.generic.ATHROW;

import logical.Federation;
import logical.SportMan;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.Font;
import java.awt.Color;

public class RegisterSportMan extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtName;
	private Federation fed;
	private JSpinner spnAge;
	private JComboBox cbxSport;

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the dialog.
	 */
	public RegisterSportMan(final Federation fed) {
		this.fed = fed;
		setTitle("Registro de Atletas");
		setLocationRelativeTo(null);
		setBounds(100, 100, 425, 235);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Informaci\u00F3n de Atleta:", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(10, 29, 387, 124);
		contentPanel.add(panel);
		panel.setLayout(null);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(22, 22, 128, 14);
		panel.add(lblNombre);
		
		JLabel lblEdad = new JLabel("Edad:");
		lblEdad.setBounds(270, 22, 46, 14);
		panel.add(lblEdad);
		
		JLabel lblDeporte = new JLabel("Deporte:");
		lblDeporte.setBounds(22, 72, 128, 14);
		panel.add(lblDeporte);
		
		txtName = new JTextField();
		txtName.setBounds(22, 41, 224, 21);
		panel.add(txtName);
		txtName.setColumns(10);
		
		spnAge = new JSpinner();
		spnAge.setModel(new SpinnerNumberModel(18, 18, 35, 1));
		spnAge.setBounds(270, 41, 96, 21);
		panel.add(spnAge);
		
		cbxSport = new JComboBox();
		cbxSport.setModel(new DefaultComboBoxModel(new String[] {"<Seleccione>", "BaseBall", "FutBall", "Nataci\u00F3n", "Boxeo", "Karate", "Judo"}));
		cbxSport.setBounds(22, 93, 224, 21);
		panel.add(cbxSport);
		
		JLabel label_1 = new JLabel("*");
		label_1.setForeground(Color.RED);
		label_1.setBounds(10, 41, 6, 14);
		panel.add(label_1);
		
		JLabel label_2 = new JLabel("*");
		label_2.setForeground(Color.RED);
		label_2.setBounds(10, 96, 6, 14);
		panel.add(label_2);
		
		JLabel label = new JLabel("*");
		label.setForeground(Color.RED);
		label.setFont(new Font("Tahoma", Font.BOLD, 11));
		label.setBounds(287, 11, 13, 14);
		contentPanel.add(label);
		
		JLabel lblCamposObligatorios = new JLabel("Campos obligatorios");
		lblCamposObligatorios.setFont(new Font("Tahoma", Font.ITALIC, 10));
		lblCamposObligatorios.setBounds(297, 11, 100, 14);
		contentPanel.add(lblCamposObligatorios);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Registrar");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if(!txtName.getText().equalsIgnoreCase("") && cbxSport.getSelectedIndex()!=0){
						SportMan a = new SportMan(txtName.getText(),Integer.parseInt(spnAge.getValue().toString()),cbxSport.getSelectedItem().toString());
						fed.insertSpotMan(a);
						JOptionPane.showMessageDialog(null, "Deportista registrado satisfectoriamente", null, JOptionPane.INFORMATION_MESSAGE, null);
						clear();
						}else{
							JOptionPane.showMessageDialog(null, "Verifique que todos los campos esten llenos", null, JOptionPane.ERROR_MESSAGE, null);
						}
						
					}

					
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancelar");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
	
	private void clear() {
		txtName.setText("");
		cbxSport.setSelectedIndex(0);
		spnAge.setValue(new Integer(18));
		
	}
}
