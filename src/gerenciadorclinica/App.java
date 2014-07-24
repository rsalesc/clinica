package gerenciadorclinica;

import gerenciadorclinica.clinica.Consulta;
import gerenciadorclinica.clinica.Exame;
import gerenciadorclinica.clinica.Paciente;
import gerenciadorclinica.extras.Estado;
import gerenciadorclinica.extras.Genero;
import gerenciadorclinica.extras.Genero.GeneroEnum;
import gerenciadorclinica.gui.JanelaPrincipal;
import gerenciadorclinica.gui.LoginDialog;

import java.awt.EventQueue;
import java.awt.Window;
import java.sql.SQLException;
import java.util.Date;

import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;

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
					// DB TESTE
					/*
					{
						DB data = db.clone();
						Consulta c = new Consulta(1);
						try{
							data.conecta();
							c.carregar(data);
							Paciente p = c.getPaciente();
							System.out.println(c.getObservacao());
							System.out.println(p.getNome());
						}catch(SQLException e){
							System.out.println(e.getMessage());
						} finally{
							data.desconecta();
						}
					}*/
					App.db.conecta();
					JanelaPrincipal frame = new JanelaPrincipal();
					frame.setVisible(true);
					LoginDialog.showDialog(frame);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public static void showMsgBox(Window owner, String msg){
		JOptionPane.showMessageDialog(owner, msg);
	}
}
