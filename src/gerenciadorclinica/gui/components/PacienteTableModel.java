package gerenciadorclinica.gui.components;

import gerenciadorclinica.clinica.Paciente;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;

@SuppressWarnings("serial")
public class PacienteTableModel extends AbstractTableModel implements TableModel {

	
	public static String[] columns = {"Nome", "Idade", "Gênero", "Telefone"};
	private ArrayList<Paciente> rows;
	
	public PacienteTableModel(){
		rows = new ArrayList<Paciente>();
	}
	
	public PacienteTableModel(ArrayList<Paciente> pacientes){
		rows = pacientes;
	}
	
	@Override
	public int getColumnCount() {
		return columns.length;
	}

	@Override
	public int getRowCount() {
		return rows.size();
	}
	
	public Paciente getRow(int row){
		return rows.get(row);
	}
	
	@Override
	public Object getValueAt(int row, int column) {
		Paciente p = getRow(row);
		switch(column){
			case 0:
				return p.getNome();
			case 1:
				return new Integer(p.getIdade());
			case 2:
				return p.getGenero();
			case 3:
				return p.getTelefone();
		}
		return null;
	}

	@Override
	public String getColumnName(int column) {
		// TODO Auto-generated method stub
		return columns[column];
	}
}
