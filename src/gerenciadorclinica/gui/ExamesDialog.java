package gerenciadorclinica.gui;

import java.awt.Window;

import javax.swing.JDialog;
import javax.swing.JButton;
import javax.swing.JTable;

@SuppressWarnings("serial")
public class ExamesDialog extends JDialog {
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void showDialog(Window owner) {
		try {
			ExamesDialog dialog = new ExamesDialog(owner);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ExamesDialog(Window owner) {
		super(owner);
		setTitle("Gerenciamento de Exames");
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setModalityType(ModalityType.APPLICATION_MODAL);
		setResizable(false);
		setBounds(100, 100, 511, 346);
		getContentPane().setLayout(null);
		
		JButton btnVincularArquivo = new JButton("Vincular Arquivo");
		btnVincularArquivo.setBounds(386, 11, 109, 23);
		getContentPane().add(btnVincularArquivo);
		
		table = new JTable();
		table.setBounds(10, 45, 485, 262);
		getContentPane().add(table);
	}
}
