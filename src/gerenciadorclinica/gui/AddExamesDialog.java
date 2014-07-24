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

import gerenciadorclinica.App;
import gerenciadorclinica.clinica.Consulta;
import gerenciadorclinica.clinica.Exame;
import gerenciadorclinica.clinica.Paciente;
import gerenciadorclinica.extras.exceptions.FormInvalidoException;
import gerenciadorclinica.gui.components.ScrollableTextArea;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.UIManager;

@SuppressWarnings("serial")
public class AddExamesDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private Paciente paciente;
	private ScrollableTextArea obsField;
	private JTextField pacienteField;
	private JTextField exameField;

	/**
	 * Launch the application.
	 */
	public static void showDialog(Window owner, Paciente p) {
		try {
			AddExamesDialog dialog = new AddExamesDialog(owner, p);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public AddExamesDialog(Window owner, Paciente p) {
		super(owner);
		this.paciente = p;
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setModalityType(ModalityType.APPLICATION_MODAL);
		setResizable(false);
		setTitle("Solicita\u00E7\u00E3o de Exame");
		setBounds(100, 100, 377, 289);
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
			lblObs.setBounds(10, 76, 55, 14);
			contentPanel.add(lblObs);
		}
		
		obsField = new ScrollableTextArea();
		obsField.setBorder(UIManager.getBorder("TextField.border"));
		obsField.setBounds(75, 70, 276, 138);
		contentPanel.add(obsField);
		
		Window self = this;
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Salvar");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						try {
							doSolicitarExame();
						} catch (Exception e1) {
							App.showMsgBox(self, e1.getMessage());
						}
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
		}
		
		pacienteField.setEditable(false);
		pacienteField.setText(p.getNome());
		
		exameField = new JTextField();
		exameField.setBounds(75, 39, 276, 20);
		contentPanel.add(exameField);
		exameField.setColumns(10);
		
		JLabel lblExame = new JLabel("Exame:");
		lblExame.setHorizontalAlignment(SwingConstants.RIGHT);
		lblExame.setBounds(19, 42, 46, 14);
		contentPanel.add(lblExame);
	}
	
	public void doSolicitarExame() throws Exception{
		if(exameField.getText().isEmpty())
			throw new FormInvalidoException("Campos obrigat�rios n�o foram preenchidos.");
		
		Exame e = new Exame(paciente, exameField.getText(), obsField.getText());
		
		e.salvar(App.db);
		
		dispose();
	}
}
