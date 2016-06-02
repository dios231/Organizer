package Service;

import java.awt.Color;
import java.time.LocalDate;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JTextArea;

import Model.CustomActionListener;
import Model.Lunar;


public class Buttons {
	protected ArrayList<JButton> Buttons = new ArrayList<JButton>();
	CustomActionListener listener = new CustomActionListener();
	protected JTextArea TextArea;
	
	//It must called first than the "neTextArea" method.
	public ArrayList<JButton> fetchButtonsList(){
		Lunar calendar = Lunar.InitNewCalendar();
		
		ArrayList<LocalDate> Dayes = calendar.getAllDaysOfTheCurrentMonth();
		for (LocalDate Day : Dayes){
			JButton Button = new JButton(String.valueOf(Day.getDayOfMonth()));
			if (Day.getDayOfMonth() == calendar.getCurrentDate() )
				Button.setBackground(Color.RED);
			Button.addActionListener(listener);
			Buttons.add(Button);
		}
		return Buttons;
	}
	
	 public JTextArea newTextArea(Integer width, Integer height){ 
		 TextArea = new JTextArea(width, height);
		 listener.setTextArea(TextArea);
		 return TextArea; 
	 }
}
