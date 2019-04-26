import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;

public class GetDay {
	//This Day
	static public Calendar now_c = Calendar.getInstance();
	static public String now_year = "" + now_c.get(Calendar.YEAR);
	static public String now_month = "" + (now_c.get(Calendar.MONTH) + 1);
	
	//week
	static public String[] week = new String[] {"Sun", "Mon", "Tue", "Wed", "thu", "Fri", "Sat"};
	
	//maxDay; 	
	static public int maxDay = 28; 
	
	static public void setYearAndMonth() {
		for (int i = Integer.parseInt(now_year) - 100; i < Integer.parseInt(now_year) + 20; i++) {
			Window.years.addItem("" + i);
		}
		Window.years.setSelectedIndex(100);
		Window.top.add(Window.years);
		Window.top.add(Window.y_label);
		
		//add Date
		Window.Ok.addActionListener(new okListener());
		Window.Today.addActionListener(new todayListener());
		
		for (int i = 1; i <= 12; i++ ) {
			Window.months.addItem("" + i);
		}
		Window.months.setSelectedIndex(Integer.parseInt(now_month));
		Window.top.add(Window.months);
		Window.top.add(Window.m_label);
	}
	
	static public int getDay(String year, String month) {
		Calendar cal = Calendar.getInstance();
//	    cal.setFirstDayOfWeek(Calendar.MONDAY);
	    
//	    System.out.println("*" + year +  " " + month + "*");
	    
		cal.set(Calendar.YEAR, Integer.parseInt(year));
		cal.set(Calendar.MONTH, Integer.parseInt(month) - 1);
		cal.set(Calendar.DATE, 1);
		
		return cal.get(Calendar.DAY_OF_WEEK);
	}
	
	static public boolean isLeapYear(int y) {
		if (y % 400 == 0) return true;
		else if (y % 4 == 0 && y % 100 != 0) return true;
		else return false;
	}
	
	static void printDay(String monthYouWant, String yearYouWant, String dirstDayOfThatWeek) {
		int iMonthYouWant = Integer.parseInt(monthYouWant);
		if (iMonthYouWant == 1 || iMonthYouWant == 3 || iMonthYouWant == 5 || iMonthYouWant == 7 || iMonthYouWant == 8 || 
			iMonthYouWant == 10 || iMonthYouWant == 12) {
			maxDay = 31;
		} else if (iMonthYouWant == 2) {
			if (!isLeapYear(Integer.parseInt(yearYouWant))) maxDay = 28;
			else maxDay = 29;
		} else maxDay = 30;
		
		int cnt = 1;
		for (int i = 0; i < 42; i++) {
			if (i < Integer.parseInt(firstDayOfThatWeek) - 1) {
				Window.days[i].setText(" ");
			} else if (cnt > maxDay){
				Window.days[i].setText(" ");
			} else {
				Window.days[i].setText(" " + cnt);
				cnt++;
			}
		}
	}
	
	static public String yearYouWant;
	static public String monthYouWant;
	static public String firstDayOfThatWeek;
	static class okListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			yearYouWant = (String) Window.years.getSelectedItem();
			monthYouWant = (String) Window.months.getSelectedItem();
			
			firstDayOfThatWeek = "" + getDay(yearYouWant, monthYouWant);
//			System.out.println(yearYouWant +  " " + monthYouWant + " " + firstDayOfThatWeek);
			
			printDay(yearYouWant, monthYouWant, firstDayOfThatWeek);
		}
	}
	
	static class todayListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			Window.years.setSelectedItem(now_year);
			Window.months.setSelectedItem(now_month);
			
			firstDayOfThatWeek = "" + getDay(now_year, now_month);
			
			printDay(now_year, now_month, firstDayOfThatWeek);
		}
	}
}
