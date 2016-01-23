package freelance.poc.hibernate.ex1.entity;

import java.util.Date;

import javax.persistence.Embeddable;

@Embeddable
public class Job {
	

	private String organztion;
	private Date stDate;
	private Date endDate;
	private String expereinceSummary;
	
	public String getOrganztion() {
		return organztion;
	}
	public void setOrganztion(String organztion) {
		this.organztion = organztion;
	}
	public Date getStDate() {
		return stDate;
	}
	public void setStDate(Date stDate) {
		this.stDate = stDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public String getExpereinceSummary() {
		return expereinceSummary;
	}
	public void setExpereinceSummary(String expereinceSummary) {
		this.expereinceSummary = expereinceSummary;
	}
	
}
