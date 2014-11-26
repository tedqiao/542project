package ui;

import java.util.ArrayList;

import vo.Stock;
import factory.DAOFactory;

public class controller {
	private static UserInformation ui;
	private static boolean transactionresult;

	public static boolean gettransactionresult() {
		return transactionresult;
	}

	public static void settransactionresult(boolean transactionresult) {
		controller.transactionresult = transactionresult;
	}

	public static UserInformation getUi() {
		return ui;
	}

	public static  void setUi(UserInformation ui) {
		controller.ui = ui;
	}
	
	
}
