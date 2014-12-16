package ui;
import java.util.*;

import javax.swing.JFrame;

import vo.Events;
import vo.GlobalVo;
import vo.Market;
import vo.StockCompany;
import factory.DAOFactory;
public class view{

    public static void main(String[] args) {
    	
    	Login_frame lo = new Login_frame();
    	lo.setVisible(true);
    	
    }
   
} 

class newThread implements Runnable{
	 public int i=0;
	 private String UserID;
	 User_Frame my;
	
	@Override
	public void run() {
		try {
			Events event = DAOFactory.getIEventsInstance().getRandomEvent();
			
			
			GlobalVo globalvo = new GlobalVo();
			Market market = DAOFactory.getIMarketDAOInstance().getMarketAfterEvent(event);
			List<StockCompany> stocks = DAOFactory.getIStockDAOInstance().getAllStocksAfterEvent(event);
			globalvo.event = event;
			globalvo.market = market;
			globalvo.stocks = stocks;
			my=new User_Frame(UserID);
			my.setVisible(true);
	    	my.setResizable(false);
	        my.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		controller.setUi(my.getUserInof());
		while(true){
			try {
				Thread.sleep(10000);
				Events event = DAOFactory.getIEventsInstance().getRandomEvent();
				
				
				GlobalVo globalvo = new GlobalVo();
				Market market = DAOFactory.getIMarketDAOInstance().getMarketAfterEvent(event);
				List<StockCompany> stocks = DAOFactory.getIStockDAOInstance().getAllStocksAfterEvent(event);
				globalvo.event = event;
				globalvo.market = market;
				globalvo.stocks = stocks;
				
				
				controller.setEvent(event);
				my.getTotals().updata();
				my.getTotals().updateUI();
				my.getstockpanel().updata();
				my.getstockpanel().updateUI();
				//my.getUserInof().update();
			} catch (InterruptedException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
		
		}
		
	}	
	
	void setUserID(String UserID){
		this.UserID = UserID;
	}
}
