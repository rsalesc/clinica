package gerenciadorclinica.gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Window;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;

import gerenciadorclinica.gui.components.DatePicker;

import javax.swing.SwingConstants;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.Date;

import javax.swing.SpringLayout;
import gerenciadorclinica.gui.components.ScrollableTextArea;

@SuppressWarnings("serial")
public class AddConsultaDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField pacienteField;

	public static void showDialog(Window owner) {
		try {
			AddConsultaDialog dialog = new AddConsultaDialog(owner);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public AddConsultaDialog(Window owner) {
		super(owner);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setResizable(false);
		setModalityType(ModalityType.APPLICATION_MODAL);
		setTitle("Marcar Consulta");
		setBounds(100, 100, 341, 266);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblPaciente = new JLabel("Paciente:");
		lblPaciente.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPaciente.setBounds(10, 11, 45, 14);
		contentPanel.add(lblPaciente);
		
		pacienteField = new JTextField();
		pacienteField.setEditable(false);
		pacienteField.setBounds(66, 8, 255, 20);
		contentPanel.add(pacienteField);
		pacienteField.setColumns(10);
		
		DatePicker datePicker = new DatePicker(new Date());
		SpringLayout springLayout = (SpringLayout) datePicker.getLayout();
		springLayout.putConstraint(SpringLayout.SOUTH, datePicker.getJFormattedTextField(), 0, SpringLayout.SOUTH, datePicker);
		datePicker.setBounds(66, 36, 135, 23);
		contentPanel.add(datePicker);
		
		JLabel lblNewLabel = new JLabel("Data:");
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setBounds(10, 42, 45, 14);
		contentPanel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Obs:");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1.setBounds(9, 75, 46, 14);
		contentPanel.add(lblNewLabel_1);
		
		ScrollableTextArea scrollableTextArea = new ScrollableTextArea();
		scrollableTextArea.setBounds(66, 75, 255, 119);
		contentPanel.add(scrollableTextArea);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setAutoscrolls(true);
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Salvar");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						doMarcarConsulta();
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
		}
	}
	
	protected void doMarcarConsulta(){
		dispose();
	}
}
