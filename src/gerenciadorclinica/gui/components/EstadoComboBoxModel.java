package gerenciadorclinica.gui.components;

import gerenciadorclinica.extras.Estado;

import javax.swing.DefaultComboBoxModel;

@SuppressWarnings("serial")
public class EstadoComboBoxModel extends DefaultComboBoxModel<Estado> {

	Estado selected = null;
	
    @Override  
   public Estado getElementAt(int index) {    
      return new Estado((byte)index);
   }    
   
    @Override
   public int getIndexOf(Object obj){
	  return ((Estado)obj).getSelecionado();
   }
    
    @Override  
   public Object getSelectedItem() {    
      return selected;
   }    
   
   @Override
   public void setSelectedItem(Object estado){
	   if(((Estado)estado).getSelecionado() < getSize()){
		   this.selected = (Estado) estado;
		   int index = getIndexOf(selected);
		   fireContentsChanged(this, index, index);
	   }
   }
    
    @Override  
   public int getSize() {    
      return Estado.UFpossiveis.length;  
   }    
}
