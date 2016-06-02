package Model;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JTextArea;

public class CustomActionListener implements ActionListener {
	JTextArea TextArea;

	public void actionPerformed(ActionEvent e) {
		JButton button = (JButton) e.getSource();
        String day = button.getText();
    	
        Note note = Note.InitNewNote();
		ArrayList<String> notes = note.fetchTodayNotes(day);
		
		TextArea.setText(null);
		String note_text = "";
		for(String new_note : notes){
			note_text = note_text.concat(new_note + "\n");
		}
		TextArea.setText(note_text);
    }
	
	public void setTextArea(JTextArea TextArea){
		this.TextArea = TextArea;
	}
}
