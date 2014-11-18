package factory;

import dao.*;

public class DAOFactory {
	public static ICompanyDAO getICompanyDAOInstance() {// get Dao instance
		return new ICompanyDAO();
	}
	public static IHoldDAO getIHoldDAOInstance() {// get Dao instance
		return new IHoldDAO();
	}
	public static IInvestorsDAO getIInvestorDAOInstance() {// get Dao instance
		return new IInvestorsDAO();
	}
	public static IStockDAO getIStockDAOInstance() {// get Dao instance
		return new IStockDAO();
	}
}
