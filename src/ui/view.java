package ui;
import java.util.*;

import javax.swing.JFrame;
public class view{

    public static void main(String[] args) throws Exception {
    	
    	Login_frame lo = new Login_frame();
    	lo.setVisible(true);
    	
    }
   
} 

class newThread implements Runnable{
	 public int i=0;
	 //view v = new view();
	 User_Frame my;
	@Override
	public void run() {
		try {
			my=new User_Frame("1");
			my.setVisible(true);
	    	my.setResizable(false);
	        my.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		while(i!=100){
			try {
				Thread.sleep(10000);
				my.getTotals().updata();
				my.getTotals().updateUI();
				my.getstockpanel().updata();
				my.getstockpanel().updateUI();
			} catch (InterruptedException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
		
		}
		
	}	
}
