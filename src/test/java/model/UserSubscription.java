package model;

public class UserSubscription {
	private int planid;
	private String cardnumber;
	private String refno;

	public UserSubscription(int planid, String cardno, String refnumber) {
		this.planid=planid;
		this.cardnumber=cardno;
		this.refno=refnumber;
	}
	public int getPlanid() {
		return planid;
	}

	public void setPlanid(int planid) {
		this.planid = planid;
	}

	public String getRefno() {
		return refno;
	}

	public void setRefno(String refno) {
		this.refno = refno;
	}

	public String getCardnumber() {
		return cardnumber;
	}

	public void setCardnumber(String cardnumber) {
		this.cardnumber = cardnumber;
	}
}
