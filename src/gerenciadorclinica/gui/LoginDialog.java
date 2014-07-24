package gerenciadorclinica.gui;

import gerenciadorclinica.App;
import gerenciadorclinica.extras.exceptions.FormInvalidoException;
import gerenciadorclinica.usuario.Usuario;

import java.awt.Window;

import javax.swing.JDialog;

import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.factories.FormFactory;

import javax.swing.JLabel;

import java.awt.Component;

import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JPasswordField;
import javax.swing.JButton;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.SQLException;

@SuppressWarnings("serial")
public class LoginDialog extends JDialog {
	private JTextField loginField;
	private JPasswordField passwordField;
	private boolean wasLoginHit;

	/**
	 * Mostra o dialog.
	 */
	public static void showDialog(Window owner) {
		try {
			LoginDialog dialog = new LoginDialog(owner);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public LoginDialog(Window owner) {
		super(owner);
		wasLoginHit = false;
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosed(WindowEvent arg0) {
				if(!wasLoginHit) owner.dispose();
			}
		});
		setTitle("Autentica\u00E7\u00E3o");
		setModalityType(ModalityType.APPLICATION_MODAL);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 207, 150);
		setResizable(false);
		getContentPane().setLayout(new FormLayout(new ColumnSpec[] {
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),},
			new RowSpec[] {
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,}));
		
		JLabel lblUsurio = new JLabel("Usu\u00E1rio:");
		lblUsurio.setHorizontalAlignment(SwingConstants.RIGHT);
		lblUsurio.setAlignmentX(Component.CENTER_ALIGNMENT);
		getContentPane().add(lblUsurio, "4, 4, right, default");
		
		loginField = new JTextField();
		loginField.setHorizontalAlignment(SwingConstants.CENTER);
		loginField.setAlignmentX(0.0f);
		getContentPane().add(loginField, "6, 4");
		loginField.setColumns(10);
		
		JLabel lblSenha = new JLabel("Senha:");
		lblSenha.setHorizontalAlignment(SwingConstants.RIGHT);
		getContentPane().add(lblSenha, "4, 6, right, default");
		
		passwordField = new JPasswordField();
		passwordField.setHorizontalAlignment(SwingConstants.CENTER);
		getContentPane().add(passwordField, "6, 6, fill, default");
		
		JButton btnEntrar = new JButton("Entrar");
		
		Window self = this;
		
		btnEntrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					doLogin();
				} catch (Exception e) {
					App.showMsgBox(self, e.getMessage());
				}
			}
		});
		getContentPane().add(btnEntrar, "6, 8");
	}

	public void doLogin() throws Exception{
		String password = new String(passwordField.getPassword());
		if(loginField.getText().isEmpty() || password.isEmpty())
			throw new FormInvalidoException("Os campos obrigatórios não foram preenchidos.");
		App.usuario = Usuario.getUsuarioAutenticado(App.db, loginField.getText(), password);
		wasLoginHit = true;
		dispose();
	}
}
