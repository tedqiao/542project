package ui;

import java.util.ArrayList;

import vo.Stock;
import factory.DAOFactory;

public class controller {
	private static UserInformation ui;

	public static UserInformation getUi() {
		return ui;
	}

	public static  void setUi(UserInformation ui) {
		controller.ui = ui;
	}
	
	
}
