package gerenciadorclinica.gui.components;

import gerenciadorclinica.extras.Estado;
import gerenciadorclinica.extras.Genero;

import javax.swing.DefaultComboBoxModel;

@SuppressWarnings("serial")
public class GeneroComboBoxModel extends DefaultComboBoxModel<Genero> {
	   
		Genero selected = null;
	
	    @Override  
	   public Genero getElementAt(int index) {    
	      return new Genero((byte) index); 
	   }
	    
	   @Override
	   public int getIndexOf(Object obj){
		   Genero g = (Genero) obj;
		   if(g.getValue() >= getSize())
			   return -1;
		   return g.getValue();
	   }
	    
	    @Override  
	   public Object getSelectedItem() {    
	      return selected;
	   }    
	   
	   @Override
	   public void setSelectedItem(Object obj){
		   if(((Genero)obj).getValue() < getSize()){
			   this.selected = (Genero) obj;
			   int index = getIndexOf(selected);
			   fireContentsChanged(this, index, index);
		   }
	   }
	    
	    @Override  
	   public int getSize() {    
	      return 2;  
	   }    
}
