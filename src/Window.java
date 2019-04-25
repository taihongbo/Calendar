import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.*;

public class Window extends JFrame{
	//Year and month chooser
	static public JPanel top = new JPanel();
	static public JLabel y_label = new JLabel("年");
	static public JComboBox<String> years = new JComboBox<String>();
	static public JLabel m_label = new JLabel("月");
	static public JComboBox<String> months = new JComboBox<String>();
	
	//Button
	static public JButton Today = new JButton("今天");
	static public JButton Ok = new JButton("确定");
	
	//Body
	private JPanel body = new JPanel();
	
	//Days
	static public JButton[] days = new JButton[42];
		
	public Window() {
		super();
		
		this.setLayout(new BorderLayout(30, 5));
		this.setTitle("Calendar");
		this.setLocation(300, 100);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		this.setWindow();
		
		this.setVisible(true);
		this.setResizable(false);
		pack();
	}
	
	private void setWindow() {
		GetDay.setYearAndMonth();
		
		top.add(Ok);
		top.add(Today);
		
		this.add(top, BorderLayout.NORTH);
		
		body.setLayout(new GridLayout(7, 7, 3, 3));
		for (int i = 0; i < 7; i++) {
			body.add(new JButton(GetDay.week[i]));
		}

		for (int i = 0; i < 42; i++) {
			days[i] = new JButton(" ");
			body.add(days[i]);
		}
		this.add(body);
	}
}
