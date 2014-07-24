package gerenciadorclinica.gui.components;

import gerenciadorclinica.App;
import gerenciadorclinica.clinica.Consulta;
import gerenciadorclinica.clinica.Paciente;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

@SuppressWarnings("serial")
public class ConsultaTableModel extends AbstractTableModel {

	public static String[] columns = {"Paciente", "Data Marcada", "Observações"};
	private ArrayList<Consulta> rows;
	
	public ConsultaTableModel(){
		rows = new ArrayList<Consulta>();
	}
	
	public ConsultaTableModel(ArrayList<Consulta> consultas){
		rows = consultas;
	}
	
	@Override
	public int getColumnCount() {
		return columns.length;
	}

	@Override
	public int getRowCount() {
		return rows.size();
	}
	
	public Consulta getRow(int row){
		return rows.get(row);
	}
	
	@Override
	public Object getValueAt(int row, int column) {
		Consulta c = getRow(row);
		switch(column){
			case 0:
				return c.getPaciente().getNome();
			case 1:
				return App.dataFormato.format(c.getDataMarcada());
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
