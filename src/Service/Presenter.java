package Service;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Presenter {
	public JFrame newFrame(String Title){
		return new JFrame(Title);
	}
	
	public JPanel newPanel(){
		return new JPanel(new BorderLayout());
	}
	
	public JPanel newPanel(Integer row, Integer collumns, Integer padding){
		return new JPanel(new GridLayout(row, collumns, padding, padding));
	}
	
	public void setDCO(JFrame Frame){
		Frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void setBorder(JPanel Panel){
		Panel.setBorder(BorderFactory.createEmptyBorder(50, 50, 50, 50));
	}
}
