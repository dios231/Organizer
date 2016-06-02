package Model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import Service.Pool;

public class Note {

	protected int current_year;
	protected int current_month;
	protected int current_day;
	
	protected Connection conn = Pool.createDBConection();
	protected ArrayList<String> allTodayNotes = new ArrayList<String>();
		
	public static Note InitNewNote(){
		Note note = new Note();
		note.setYearMonthDate();
		return note;
	}
	
	public ArrayList<String> fetchTodayNotes(String Today){
		String dateForTheQuery = createDateForTheQuery(Today);
		fetchTodayNotesFromDB(dateForTheQuery);
		return allTodayNotes;
	}
	
	protected String createDateForTheQuery(String Today){
		return String.valueOf(current_year) + "-" + String.valueOf(current_month) + "-" + Today;
	}
	
	protected ArrayList<String> fetchTodayNotesFromDB(String dateForTheQuery){
		String sql = "SELECT NAME FROM NOTE WHERE DATE='" + dateForTheQuery + "'" ;
		System.out.println(sql);
		Statement stmt = null;
		try{
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
		    ResultSetMetaData rsmd = rs.getMetaData();
		    while (rs.next()) {
		        for (int i = 1; i <= rsmd.getColumnCount(); i++) {
		        	allTodayNotes.add(rs.getString(i));
		        }
		    }
			return allTodayNotes;
		}
		catch(SQLException se){
			se.printStackTrace();
		}
		catch(Exception e){
			 e.printStackTrace();
		}
		finally{
			//
		}
		return null;
	}
	
	protected void setYearMonthDate(){
		Lunar Calendar = Lunar.InitNewCalendar();	
		current_year = Calendar.getCurrentYear();
		current_month = Calendar.getCurrentMonth();
		current_day = Calendar.getCurrentDate();
	}
}
