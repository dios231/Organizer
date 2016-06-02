import java.awt.BorderLayout;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import Service.Pool;
import Service.Buttons;
import Service.Presenter;


public class Renderer {
	public static void main(String[] args) {
		Presenter Presenter = new Presenter();
		
		JFrame Frame = Presenter.newFrame("Oganizer");
		JPanel MasterPanel = Presenter.newPanel();
		
		Presenter.setDCO(Frame);
		
		JPanel NotePanel = Presenter.newPanel(7, 5, 25);
		Presenter.setBorder(NotePanel);
		
		Buttons Buttons = new Buttons();
		ArrayList<JButton> buttons = Buttons.fetchButtonsList();
		
		for (JButton button: buttons){
			NotePanel.add(button);
		}
		
		MasterPanel.add(NotePanel, BorderLayout.CENTER);
		
		JTextArea TextArea = Buttons.newTextArea(15, 20);//FAIL AUTO - PREPEI NA TO FIXARW!!!
		MasterPanel.add(TextArea, BorderLayout.PAGE_END);
		
		Frame.add(MasterPanel,  BorderLayout.CENTER);
		Frame.pack();
        Frame.setLocationRelativeTo(null);
        Frame.setVisible(true);
		
	}
}
