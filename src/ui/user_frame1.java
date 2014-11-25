package ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import factory.DAOFactory;
import vo.Hold;
import vo.HoldCompany;
import vo.Investors;

import java.awt.Color;
import java.util.List;
import java.awt.FlowLayout;

import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.factories.FormFactory;

import javax.swing.JLabel;



public class user_frame1 extends JFrame {

	private JPanel contentPane;
	private String[] a;
	private TotalInfo t;
	private stockPanel st;
	
	public user_frame1(String userID) throws Exception {
		Investors invest = new Investors();
		invest.setuserID(userID);
		invest = DAOFactory.getIInvestorDAOInstance().getInvestorById(invest);
		
		HoldCompany hold = new HoldCompany();
		hold.setuserID(invest.getuserID());
		List<HoldCompany> l = DAOFactory.getIHoldDAOInstance().getAllHoldById(hold);
		for(HoldCompany hd:l){
				System.out.println(hd.getSid());
				System.out.println(hd.getshares());
			}
		System.out.println("---------------------------------");
		//System.out.println(invest.getAssets());
		String sid[] = new String[l.size()];
		for(int i=0;i<l.size();i++){
			sid[i] = l.get(i).getSid()+"   "+l.get(i).getName();
		}
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		UserInformation user = new UserInformation(invest.getuserName(),invest.getsex(),invest.getuserID(),invest.getAssets(),sid);
		user.setBorder(new LineBorder(Color.YELLOW, 1, true));
		user.setBounds(0, 0, 193, 598);
		getContentPane().add(user);
		st = new stockPanel();
		st.setBounds(196, 155, 800-200, 600-180);
		JScrollPane scroll = new JScrollPane(st);
		scroll.setBounds(196, 155, 800-200, 600-180);
		getContentPane().add(scroll);
		t = new TotalInfo();
		t.setSize(600, 120);
		t.setLocation(196, 0);
		getContentPane().add(t);
	
	}
	
	TotalInfo getTotals(){
		return t;
	}
	
	stockPanel getstockpanel(){
		return st;
	}
	
	
	
		

}