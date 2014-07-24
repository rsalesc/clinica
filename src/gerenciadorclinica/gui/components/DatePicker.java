package gerenciadorclinica.gui.components;

import java.util.Date;

import net.sourceforge.jdatepicker.impl.JDatePanelImpl;
import net.sourceforge.jdatepicker.impl.JDatePickerImpl;
import net.sourceforge.jdatepicker.impl.UtilDateModel;

@SuppressWarnings("serial")
public class DatePicker extends JDatePickerImpl {

	public DatePicker(){
		super(new JDatePanelImpl(new UtilDateModel()));
	}
	
	public DatePicker(Date date){
		super(new JDatePanelImpl(new UtilDateModel(date)));
	}
	
	public Date getSelectedDate(){
		return (Date)getModel().getValue();
	}
	
	public void setSelectedDate(Date date){
		((UtilDateModel)getModel()).setValue(date);
	}

}
