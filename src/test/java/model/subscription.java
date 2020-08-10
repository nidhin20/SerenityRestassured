package model;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class subscription {
	private int plan_Id;
	
	private String plan_Nm;
	
	private String card_Category;
	private boolean default_plan;
	
	private int sub_Period;
	
	private float discount_rate;
	
	public subscription(int planid, String planname, String cardcategory,boolean defaultplan,int subperiod,float discount) {
		this.plan_Id=planid;
		this.plan_Nm=planname;
		this.card_Category=cardcategory;
		this.default_plan=defaultplan;
		this.sub_Period=subperiod;
		this.discount_rate=discount;
	}
	public int getplan_Id() {
		return plan_Id;
	}
	public void setplan_Id(int plan_Id) {
		plan_Id = plan_Id;
	}
	public String getplan_Nm() {
		return plan_Nm;
	}
	public void setplan_Nm(String plan_Nm) {
		plan_Nm = plan_Nm;
	}
	public String getcard_Category() {
		return card_Category;
	}
	public void setcard_Category(String card_Category) {
	
		card_Category = card_Category;
	}
	public boolean isdefault_plan() {
		return default_plan;
	}
	public void setdefault_plan(boolean default_plan) {
		default_plan = default_plan;
	}
	public int getsub_Period() {
		return sub_Period;
	}
	public void setsub_Period(int sub_Period) {
		sub_Period = sub_Period;
	}
	public float getdiscount_rate() {
		return discount_rate;
	}
	public void setdiscount_rate(float discount_rate) {
		
		discount_rate = discount_rate;
	}

}
