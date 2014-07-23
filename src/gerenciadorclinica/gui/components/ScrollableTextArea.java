package gerenciadorclinica.gui.components;

import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;

@SuppressWarnings("serial")
public class ScrollableTextArea extends JScrollPane {
	private JTextArea textArea;
	
	public ScrollableTextArea(){
		super();
		textArea = new JTextArea();
		textArea.setLineWrap(true);
		setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		setViewportView(textArea);
	}

	public JTextArea getTextArea(){
		return textArea;
	}
	
	public String getText(){
		return textArea.getText();
	}
	
	public void setText(String t){
		textArea.setText(t);
	}
	
	public void append(String t){
		textArea.append(t);
	}
}
