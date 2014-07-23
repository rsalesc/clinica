package gerenciadorclinica;

import gerenciadorclinica.gui.JanelaPrincipal;
import gerenciadorclinica.gui.LoginDialog;

import java.awt.EventQueue;

import javax.swing.UIManager;

public class App {

	
	public static final DB db = new DB("jdbc:sqlite:clinica.db");
	
	/**
	 * Executa a aplicação
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
					JanelaPrincipal frame = new JanelaPrincipal();
					frame.setVisible(true);
					LoginDialog.showDialog(frame);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	
}
