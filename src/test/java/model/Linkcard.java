package model;

public class Linkcard {
	private int User_Id;
	private String Card_Num;
	public int getUser_Id() {
		return User_Id;
	}
	public void setUser_Id(int user_Id) {
		User_Id = user_Id;
	}
	public String getCard_Num() {
		return Card_Num;
	}
	public void setCard_Num(String card_Num) {
		Card_Num = card_Num;
	}
	public Linkcard(int userid,String cardnum){
		this.User_Id=userid;
		this.Card_Num= cardnum;
	}
}
