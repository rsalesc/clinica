package gerenciadorclinica;

import gerenciadorclinica.clinica.Paciente;
import gerenciadorclinica.extras.Estado;
import gerenciadorclinica.extras.Genero;
import gerenciadorclinica.extras.Genero.GeneroEnum;
import gerenciadorclinica.gui.JanelaPrincipal;
import gerenciadorclinica.gui.LoginDialog;

import java.awt.EventQueue;
import java.sql.SQLException;
import java.util.Date;

import javax.swing.JOptionPane;
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
					// DB TESTE
					{
						DB data = db.clone();
						Paciente p = new Paciente(7, "Xerequinho", new Genero(GeneroEnum.FEMININO), new Date(), "", "123456789", "Minha casa", "Salvador", new Estado((byte) 2), "", "", "", "Costa Pica");
						try{
							data.conecta();
							p.salvar(data);
						}catch(SQLException e){
							System.out.println(e.getMessage());
						} finally{
							System.out.println(p.getID());
							data.desconecta();
						}
					}
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
