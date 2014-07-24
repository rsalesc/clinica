package gerenciadorclinica;

import gerenciadorclinica.clinica.Consulta;
import gerenciadorclinica.clinica.Exame;
import gerenciadorclinica.clinica.Paciente;
import gerenciadorclinica.extras.Estado;
import gerenciadorclinica.extras.Genero;
import gerenciadorclinica.extras.Genero.GeneroEnum;
import gerenciadorclinica.gui.JanelaPrincipal;
import gerenciadorclinica.gui.LoginDialog;
import gerenciadorclinica.usuario.Usuario;

import java.awt.EventQueue;
import java.awt.Window;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;

public class App {

	
	public static final DB db = new DB("jdbc:sqlite:clinica.db");
	public static final DateFormat dataFormato = new SimpleDateFormat("dd/MM/yyyy");
	public static Usuario usuario = null;
	
	/**
	 * Executa a aplicação
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
					App.db.conecta();
					JanelaPrincipal frame = new JanelaPrincipal();
					frame.setVisible(true);
					LoginDialog.showDialog(frame);
					frame.atualizaUsuario();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public static void showMsgBox(Window owner, String msg){
		JOptionPane.showMessageDialog(owner, msg);
	}
	
	public static boolean showConfirm(Window owner){
		return (JOptionPane.showConfirmDialog(owner,  "Deseja confirmar a ação?", "Confirme a ação", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION);
	}
}
