package gerenciadorclinica.gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Window;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;

import gerenciadorclinica.gui.components.ScrollableTextArea;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class AddExamesDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField pacienteField;

	/**
	 * Launch the application.
	 */
	public static void showDialog(Window owner) {
		try {
			AddExamesDialog dialog = new AddExamesDialog(owner);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public AddExamesDialog(Window owner) {
		super(owner);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setModalityType(ModalityType.APPLICATION_MODAL);
		setResizable(false);
		setTitle("Solicita\u00E7\u00E3o de Exame");
		setBounds(100, 100, 377, 259);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblPaciente = new JLabel("Paciente:");
			lblPaciente.setHorizontalAlignment(SwingConstants.RIGHT);
			lblPaciente.setBounds(10, 11, 55, 14);
			contentPanel.add(lblPaciente);
		}
		{
			pacienteField = new JTextField();
			pacienteField.setEditable(false);
			pacienteField.setBounds(75, 8, 276, 20);
			contentPanel.add(pacienteField);
			pacienteField.setColumns(10);
		}
		{
			JLabel lblObs = new JLabel("Obs:");
			lblObs.setHorizontalAlignment(SwingConstants.RIGHT);
			lblObs.setBounds(10, 45, 55, 14);
			contentPanel.add(lblObs);
		}
		
		ScrollableTextArea scrollableTextArea = new ScrollableTextArea();
		scrollableTextArea.setBounds(75, 39, 276, 138);
		contentPanel.add(scrollableTextArea);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						doSolicitarExame();
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
		}
	}
	
	public void doSolicitarExame(){
		dispose();
	}
}
