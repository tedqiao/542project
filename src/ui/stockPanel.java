package ui;
import javax.swing.JPanel;

import vo.*;
import factory.*;

import java.awt.Color;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;


public class stockPanel extends JPanel {
	boolean isblack = true;
	/**
	 * Create the panel.
	 */
	controller con= new controller();
	public stockPanel() throws Exception {
		setForeground(Color.YELLOW); 
		setBackground(Color.BLACK);
		setSize(700, 700);
		setLayout(new GridLayout(0, 1, 0, 0));
		this.setBounds(500, 500, 500, 500);;
		List<StockCompany> list =  DAOFactory.getIStockDAOInstance().getAllStocks();
		
		for(StockCompany sc:list){
			//System.out.println(sc.getName());
			//System.out.println(sc.getPrice_share());
			//System.out.println(sc.getVariation_Range());
			if(!isblack){
			stockInfo s1 = new stockInfo(sc.getSid(),sc.getName(),sc.getPrice_share(),sc.getVariation_Range());
			s1.setBackground(Color.gray);
			add(s1);
			isblack=true;
			}else{
				stockInfo s1 = new stockInfo(sc.getSid(),sc.getName(),sc.getPrice_share(),sc.getVariation_Range());
				s1.setBackground(Color.black);
				isblack=false;
				add(s1);
			}
			
			
		}
		/*stockInfo s1 = new stockInfo("3123123","shenzhenkeji",1231,-10.0);
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
		add(new stockInfo("3123123","shenzhenkeji",1231,-10.0));*/
	}
}
