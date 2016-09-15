package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import logical.Federation;
import logical.SportMan;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class SportManList extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTable table;
	private Object[] fila;
	private DefaultTableModel tableModel;
	private JButton btnEliminar;
	private JButton btnModificar;
	private Federation fed;
	private int code;



	/**
	 * Create the dialog.
	 * @param fed 
	 */
	public SportManList(final Federation fed) {
		setTitle("Listado");
		this.fed = fed;
		setBounds(100, 100, 567, 376);
		setResizable(false);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Listado de Deportistas:", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(10, 37, 531, 257);
		contentPanel.add(panel);
		panel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 26, 511, 220);
		panel.add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
			/*String country;
				int delivery;*/
				if(table.getSelectedRow()>=0){
					btnEliminar.setEnabled(true);
					btnModificar.setEnabled(true);
					int index = table.getSelectedRow();
					code = (int)table.getModel().getValueAt(index, 0);
					/*country = (String)tableSupply.getModel().getValueAt(index, 1);
					delivery = (Integer)tableSupply.getModel().getValueAt(index, 2);
					textFldSupplyName.setText(name);
					spnDelivery.getModel().setValue(Integer.valueOf(delivery));
					cbCountry.getModel().setSelectedItem(new String(country));*/
				}
			}
		});
		tableModel = new DefaultTableModel();
		String[] columnNames = {"Código","Nombre", "Edad", "Deporte"};
		tableModel.setColumnIdentifiers(columnNames);
		loadSportMans();
		scrollPane.setViewportView(table);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			
			btnModificar = new JButton("Modificar");
			btnModificar.setEnabled(false);
			buttonPane.add(btnModificar);
			{
				btnEliminar = new JButton("Eliminar");
				btnEliminar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						fed.deleteSportMan(code);
						loadSportMans();
					}
				});
				btnEliminar.setEnabled(false);
				btnEliminar.setActionCommand("OK");
				buttonPane.add(btnEliminar);
				getRootPane().setDefaultButton(btnEliminar);
			}
			{
				JButton cancelButton = new JButton("Cancel");
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



	private void loadSportMans() {
		tableModel.setRowCount(0);
		fila = new Object[tableModel.getColumnCount()];
		for (int i = 0; i < fed.cantAthletes; i++) {

			fila[0] = fed.getAthletes()[i].getCode();
			fila[1] = fed.getAthletes()[i].getName();
			fila[2] = fed.getAthletes()[i].getAge();
			fila[3] = fed.getAthletes()[i].getSport();
			
			tableModel.addRow(fila);
		}

		table.setModel(tableModel);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		table.getTableHeader().setReorderingAllowed(false);
		TableColumnModel columnModel = table.getColumnModel();
		columnModel.getColumn(0).setPreferredWidth(40);
		columnModel.getColumn(1).setPreferredWidth(200);
		columnModel.getColumn(2).setPreferredWidth(100);
		columnModel.getColumn(3).setPreferredWidth(167);
		
		
	}
}
