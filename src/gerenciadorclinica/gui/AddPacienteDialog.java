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

import gerenciadorclinica.App;
import gerenciadorclinica.DB;
import gerenciadorclinica.clinica.Paciente;
import gerenciadorclinica.extras.Estado;
import gerenciadorclinica.extras.Genero;
import gerenciadorclinica.extras.Validacao;
import gerenciadorclinica.extras.exceptions.FormInvalidoException;
import gerenciadorclinica.gui.components.DatePicker;
import gerenciadorclinica.gui.components.EstadoComboBoxModel;
import gerenciadorclinica.gui.components.GeneroComboBoxModel;

import java.awt.Dimension;

import gerenciadorclinica.gui.components.ScrollableTextArea;

import javax.swing.UIManager;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.SQLException;
import java.util.Date;
import java.awt.Font;
import java.awt.Color;

@SuppressWarnings("serial")
public class AddPacienteDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField pacienteField;
	private JTextField rgField;
	private JTextField cpfField;
	private JTextField enderecoField;
	private JTextField cidadeField;
	private JTextField bairroField;
	private JTextField emailField;
	private JTextField telefoneField;
	private JComboBox<Estado> estadoSelect;
	private JComboBox<Genero> generoSelect;
	private DatePicker datePicker;
	private ScrollableTextArea obsField;
	private Paciente paciente;

	
	public static void showDialog(Window owner, Paciente paciente){
		try {
			AddPacienteDialog dialog = (paciente == null) ? new AddPacienteDialog(owner) : new AddPacienteDialog(owner, paciente);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 * @wbp.parser.constructor
	 */
	public AddPacienteDialog(Window owner) {
		super(owner);
		paciente = null;
		setTitle("Cadastrar Paciente");
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setResizable(false);
		setModalityType(ModalityType.APPLICATION_MODAL);
		setBounds(100, 100, 375, 383);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblPaciente = new JLabel("Nome:");
		lblPaciente.setForeground(new Color(165, 42, 42));
		lblPaciente.setFont(new Font("Tahoma", Font.PLAIN, 11));
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
		
		generoSelect = new JComboBox<Genero>();
		generoSelect.setModel(new GeneroComboBoxModel());
		generoSelect.setBounds(81, 39, 92, 20);
		generoSelect.setSelectedIndex(0);
		contentPanel.add(generoSelect);
		
		JLabel lblRg = new JLabel("RG:");
		lblRg.setForeground(new Color(165, 42, 42));
		lblRg.setFont(new Font("Tahoma", Font.PLAIN, 11));
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
		
		datePicker = new DatePicker(new Date());
		datePicker.setMinimumSize(new Dimension(52, 20));
		datePicker.setBounds(81, 68, 115, 23);
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
		
		cidadeField = new JTextField();
		cidadeField.setBounds(81, 130, 99, 20);
		contentPanel.add(cidadeField);
		cidadeField.setColumns(10);
		
		JLabel lblUf = new JLabel("UF:");
		lblUf.setBounds(279, 102, 23, 14);
		contentPanel.add(lblUf);
		
		estadoSelect = new JComboBox<Estado>();
		estadoSelect.setModel(new EstadoComboBoxModel());
		estadoSelect.setBounds(301, 99, 54, 20);
		estadoSelect.setSelectedIndex(0);
		contentPanel.add(estadoSelect);
		
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
		
		bairroField = new JTextField();
		bairroField.setBounds(232, 130, 123, 20);
		contentPanel.add(bairroField);
		bairroField.setColumns(10);
		
		JLabel lblEmail = new JLabel("E-mail:");
		lblEmail.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEmail.setBounds(25, 164, 46, 14);
		contentPanel.add(lblEmail);
		
		emailField = new JTextField();
		emailField.setBounds(81, 161, 123, 20);
		contentPanel.add(emailField);
		emailField.setColumns(10);
		
		JLabel lblTel = new JLabel("Tel.:");
		lblTel.setHorizontalAlignment(SwingConstants.CENTER);
		lblTel.setBounds(206, 164, 32, 14);
		contentPanel.add(lblTel);
		
		telefoneField = new JTextField();
		telefoneField.setBounds(239, 161, 116, 20);
		contentPanel.add(telefoneField);
		telefoneField.setColumns(10);
		
		obsField = new ScrollableTextArea();
		obsField.setBorder(UIManager.getBorder("TextField.border"));
		obsField.setBounds(81, 210, 274, 81);
		contentPanel.add(obsField);
		
		JLabel lblObs = new JLabel("Obs:");
		lblObs.setHorizontalAlignment(SwingConstants.RIGHT);
		lblObs.setBounds(25, 216, 46, 14);
		contentPanel.add(lblObs);
		
		Window self = this;
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					doCadastrarPaciente();
				} catch (Exception e1) {
					App.showMsgBox(self, e1.getMessage());
				}
			}
		});
		btnSalvar.setBounds(274, 302, 81, 23);
		contentPanel.add(btnSalvar);
		
		JLabel lblDdXxxxxxxx = new JLabel("Formato: DD XXXXXXXX");
		lblDdXxxxxxxx.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDdXxxxxxxx.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblDdXxxxxxxx.setBounds(239, 185, 116, 14);
		contentPanel.add(lblDdXxxxxxxx);
	}
	
	public AddPacienteDialog(Window owner, Paciente paciente) {
		this(owner);
		this.paciente = paciente;
		setTitle("Editar Paciente");
		pacienteField.setText(paciente.getNome());
		generoSelect.setSelectedItem(paciente.getGenero());
		datePicker.setSelectedDate(paciente.getDataNascimento());
		cpfField.setText(paciente.getCpf());
		rgField.setText(paciente.getRg());
		enderecoField.setText(paciente.getEndereco());
		cidadeField.setText(paciente.getCidade());
		estadoSelect.setSelectedItem(paciente.getEstado());
		telefoneField.setText(paciente.getTelefone());
		emailField.setText(paciente.getEmail());
		obsField.setText(paciente.getObservacao());
		bairroField.setText(paciente.getBairro());
	}
	
	public void doCadastrarPaciente() throws Exception{
		if(pacienteField.getText().isEmpty() || rgField.getText().isEmpty())
			throw new FormInvalidoException("Os campos obrigatórios não foram preenchidos.");
		
		if(!telefoneField.getText().isEmpty())
			Validacao.validaTelefone(telefoneField.getText());
		if(!emailField.getText().isEmpty())
			Validacao.validaEmail(emailField.getText());
		if(!cpfField.getText().isEmpty())
			Validacao.validaCpf(cpfField.getText());
		Validacao.validaRg(rgField.getText());
	
		
		Paciente p = new Paciente(pacienteField.getText(), (Genero)generoSelect.getSelectedItem(), datePicker.getSelectedDate(), cpfField.getText(), rgField.getText(), enderecoField.getText(), 
				cidadeField.getText(), (Estado)estadoSelect.getSelectedItem(), telefoneField.getText(), emailField.getText(), obsField.getText(), bairroField.getText());
		if(this.paciente != null){
			p.setID(this.paciente.getID());	
		}
		
		
		p.salvar(App.db);
	
		dispose();
	}
}
