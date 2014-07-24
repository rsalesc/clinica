package gerenciadorclinica.gui.components;

import gerenciadorclinica.App;
import gerenciadorclinica.clinica.Exame;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

@SuppressWarnings("serial")
public class ExameTableModel extends AbstractTableModel {

	public static String[] columns = {"Paciente", "Exame", "Observações"};
	private ArrayList<Exame> rows;
	
	public ExameTableModel(){
		rows = new ArrayList<Exame>();
	}
	
	public ExameTableModel(ArrayList<Exame> exames){
		rows = exames;
	}
	
	@Override
	public int getColumnCount() {
		return columns.length;
	}

	@Override
	public int getRowCount() {
		return rows.size();
	}
	
	public Exame getRow(int row){
		return rows.get(row);
	}
	
	@Override
	public Object getValueAt(int row, int column) {
		Exame c = getRow(row);
		switch(column){
			case 0:
				return c.getPaciente().getNome();
			case 1:
				return c.getExame();
			case 2:
				return c.getObservacao();
		}
		return null;
	}

	@Override
	public String getColumnName(int column) {
		// TODO Auto-generated method stub
		return columns[column];
	}

}
