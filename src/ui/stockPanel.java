package ui;
import javax.swing.JPanel;

import vo.Stock;

import java.awt.Color;
import java.awt.GridLayout;
import java.util.ArrayList;


public class stockPanel extends JPanel {
	
	/**
	 * Create the panel.
	 */
	controller con= new controller();
	public stockPanel() {
		setForeground(Color.YELLOW); 
		setBackground(Color.BLACK);
		setSize(700, 700);
		setLayout(new GridLayout(0, 1, 0, 0));
		this.setBounds(500, 500, 500, 500);;
		ArrayList<Stock> stocks=con.getstocks();
		for(Stock s:stocks){
			//stockInfo si = new stockInfo(s.getCid(),s.g)
		}
		
		stockInfo s1 = new stockInfo("3123123","shenzhenkeji",1231,-10.0);
		 // stockInfo s1 = new stockInfo("3123123","shenzhenkeji",1231,-10.0); 
	        stockInfo s2 = new stockInfo("3123123","shenzhenkeji",1231,-10.0);
	        stockInfo s3 = new stockInfo("3123123","shenzhenkeji",1231,-10.0);
	        stockInfo s4 = new stockInfo("3123123","shenzhenkeji",1231,-10.0);
		
		add(new stockInfo("3123123","shenzhenkeji",1231,-10.0));
		add(new stockInfo("3123123","shenzhenkeji",1231,-10.0));
		add(new stockInfo("3123123","shenzhenkeji",1231,-10.0));
		add(new stockInfo("3123123","shenzhenkeji",1231,-10.0));
		add(new stockInfo("3123123","shenzhenkeji",1231,-10.0));
		add(new stockInfo("3123123","shenzhenkeji",1231,-10.0));
		add(new stockInfo("3123123","shenzhenkeji",1231,-10.0));
		add(new stockInfo("3123123","shenzhenkeji",1231,-10.0));
		add(new stockInfo("3123123","shenzhenkeji",1231,-10.0));
		add(new stockInfo("3123123","shenzhenkeji",1231,-10.0));
		
	
	}
}
