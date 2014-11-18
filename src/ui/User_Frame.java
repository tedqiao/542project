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
import vo.Investors;

import java.awt.Color;
import java.util.List;


public class User_Frame extends JFrame {

	private JPanel contentPane;
	private String[] a;
	
	public User_Frame() throws Exception {
		Investors invest = new Investors();
		invest.setuserID("zhang san");
		invest = DAOFactory.getIInvestorDAOInstance().getInvestorById(invest);
		Hold hold = new Hold();
		hold.setuserID(invest.getuserID());
		List<Hold> l = DAOFactory.getIHoldDAOInstance().getAllHoldById(hold);
		for(Hold hd:l){
			System.out.println(hd.getSid());
			System.out.println(hd.getshares());
		}
		//System.out.println(invest.getsex());
		//System.out.println(invest.getAssets());
		String sid[] = new String[l.size()];
		for(int i=0;i<l.size();i++){
			sid[i] = l.get(i).getSid();
		}
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 592, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		UserInformation user = new UserInformation(invest.getuserName(),invest.getsex(),invest.getuserID(),invest.getAssets(),sid);
		user.setBorder(new LineBorder(Color.YELLOW, 1, true));
		user.setBounds(0, 0, 193, 278);
		getContentPane().add(user);
		stockPanel st = new stockPanel();
		st.setBounds(192, 105, 400, 173);
		JScrollPane scroll = new JScrollPane(st);
		scroll.setBounds(192, 105, 400, 173);
		getContentPane().add(scroll);
		TotalInfo t = new TotalInfo();
		t.setSize(400, 105);
		t.setLocation(192, 0);
		getContentPane().add(t);
	}

}