package gerenciadorclinica.gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Window;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Dialog.ModalityType;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import gerenciadorclinica.gui.components.DatePicker;
import java.awt.Dimension;
import gerenciadorclinica.gui.components.ScrollableTextArea;
import javax.swing.UIManager;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class AddPacienteDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField pacienteField;
	private JTextField rgField;
	private JTextField cpfField;
	private JTextField enderecoField;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	
	public static void showDialog(Window owner){
		try {
			AddPacienteDialog dialog = new AddPacienteDialog(owner);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public AddPacienteDialog(Window owner) {
		super(owner);
		setTitle("Cadastrar Paciente");
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setResizable(false);
		setModalityType(ModalityType.APPLICATION_MODAL);
		setBounds(100, 100, 375, 345);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblPaciente = new JLabel("Nome:");
		lblPaciente.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPaciente.setBounds(10, 11, 61, 14);
		contentPanel.add(lblPaciente);
		
		pacienteField = new JTextField();
		pacienteField.setBounds(81, 8, 274, 20);
		contentPanel.add(pacienteField);
		pacienteField.setColumns(10);
		
		JLabel lblGnero = new JLabel("G\u00EAnero:");
		lblGnero.setHorizontalAlignment(SwingConstants.RIGHT);
		lblGnero.setBounds(25, 42, 46, 14);
		contentPanel.add(lblGnero);
		
		JComboBox generoSelect = new JComboBox();
		generoSelect.setBounds(81, 39, 92, 20);
		contentPanel.add(generoSelect);
		
		JLabel lblRg = new JLabel("RG:");
		lblRg.setBounds(178, 42, 18, 14);
		contentPanel.add(lblRg);
		
		rgField = new JTextField();
		rgField.setBounds(206, 39, 149, 20);
		contentPanel.add(rgField);
		rgField.setColumns(10);
		
		JLabel lblDataNasc = new JLabel("Data Nasc.:");
		lblDataNasc.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDataNasc.setBounds(10, 72, 61, 14);
		contentPanel.add(lblDataNasc);
		
		DatePicker datePicker = new DatePicker();
		datePicker.setMaximumSize(new Dimension(32813, 20));
		datePicker.getJFormattedTextField().setPreferredSize(new Dimension(178, 20));
		datePicker.setMinimumSize(new Dimension(52, 20));
		datePicker.setPreferredSize(new Dimension(202, 20));
		datePicker.setBounds(81, 68, 115, 20);
		contentPanel.add(datePicker);
		
		JLabel lblCpf = new JLabel("CPF:");
		lblCpf.setBounds(206, 72, 23, 14);
		contentPanel.add(lblCpf);
		
		cpfField = new JTextField();
		cpfField.setBounds(239, 68, 116, 20);
		contentPanel.add(cpfField);
		cpfField.setColumns(10);
		
		enderecoField = new JTextField();
		enderecoField.setBounds(81, 99, 188, 20);
		contentPanel.add(enderecoField);
		enderecoField.setColumns(10);
		
		textField = new JTextField();
		textField.setBounds(81, 130, 99, 20);
		contentPanel.add(textField);
		textField.setColumns(10);
		
		JLabel lblUf = new JLabel("UF:");
		lblUf.setBounds(279, 102, 23, 14);
		contentPanel.add(lblUf);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(301, 99, 54, 20);
		contentPanel.add(comboBox);
		
		JLabel lblEndereco = new JLabel("Endere\u00E7o:");
		lblEndereco.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEndereco.setBounds(10, 102, 61, 14);
		contentPanel.add(lblEndereco);
		
		JLabel lblCidade = new JLabel("Cidade:");
		lblCidade.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCidade.setBounds(25, 133, 46, 14);
		contentPanel.add(lblCidade);
		
		JLabel lblBairro = new JLabel("Bairro:");
		lblBairro.setHorizontalAlignment(SwingConstants.RIGHT);
		lblBairro.setBounds(190, 133, 32, 14);
		contentPanel.add(lblBairro);
		
		textField_1 = new JTextField();
		textField_1.setBounds(232, 130, 123, 20);
		contentPanel.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblEmail = new JLabel("E-mail:");
		lblEmail.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEmail.setBounds(25, 164, 46, 14);
		contentPanel.add(lblEmail);
		
		textField_2 = new JTextField();
		textField_2.setBounds(81, 161, 123, 20);
		contentPanel.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblTel = new JLabel("Tel.:");
		lblTel.setHorizontalAlignment(SwingConstants.CENTER);
		lblTel.setBounds(206, 164, 32, 14);
		contentPanel.add(lblTel);
		
		textField_3 = new JTextField();
		textField_3.setBounds(239, 161, 116, 20);
		contentPanel.add(textField_3);
		textField_3.setColumns(10);
		
		ScrollableTextArea scrollableTextArea = new ScrollableTextArea();
		scrollableTextArea.setBorder(UIManager.getBorder("TextField.border"));
		scrollableTextArea.setBounds(81, 192, 274, 81);
		contentPanel.add(scrollableTextArea);
		
		JLabel lblObs = new JLabel("Obs:");
		lblObs.setHorizontalAlignment(SwingConstants.RIGHT);
		lblObs.setBounds(25, 198, 46, 14);
		contentPanel.add(lblObs);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Salvar");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						doCadastrarPaciente();
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
		}
	}
	
	public void doCadastrarPaciente(){
		dispose();
	}
}
