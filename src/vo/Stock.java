package vo;

public class Stock {
	private Double Price_share; //��Ʊ����
	private int OverallShares;  //�ܹ���
	private Double Variation_Range; //������
	private String Cid; //��˾����

	public Double getPrice_share() {
		return Price_share;
	}

	public void setPrice_share(Double Price_share) {
		this.Price_share = Price_share;
	}

	public int getOverallCapital() {
		return OverallShares;
	}

	public void setOverallCapital(int OverallShares) {
		this.OverallShares = OverallShares;
	}

	public Double getVariation_Range() {
		return Variation_Range;
	}

	public void setVariation_Range(Double Variation_Range) {
		this.Variation_Range = Variation_Range;
	}
	
	public String getCid() {
		return Cid;
	}

	public void setCid(String Cid) {
		this.Cid = Cid;
	}
}