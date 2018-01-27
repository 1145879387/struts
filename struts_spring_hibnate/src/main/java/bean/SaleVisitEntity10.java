package bean;

import java.sql.Date;

public class SaleVisitEntity10 {
	private String visitId;
	private Date visitTime;
	private String visitInterviewee;
	private String visitAddr;
	private String visitDetail;
	private Date visitNexttime;
	private CstCustomerEntity10 cstCustomerByVisitCustId;
	private UserEntity10 userByVisitUserId;

	public String getVisitId() {
		return visitId;
	}

	public void setVisitId(String visitId) {
		this.visitId = visitId;
	}

	public Date getVisitTime() {
		return visitTime;
	}

	public void setVisitTime(Date visitTime) {
		this.visitTime = visitTime;
	}

	public String getVisitInterviewee() {
		return visitInterviewee;
	}

	public void setVisitInterviewee(String visitInterviewee) {
		this.visitInterviewee = visitInterviewee;
	}

	public String getVisitAddr() {
		return visitAddr;
	}

	public void setVisitAddr(String visitAddr) {
		this.visitAddr = visitAddr;
	}

	public String getVisitDetail() {
		return visitDetail;
	}

	public void setVisitDetail(String visitDetail) {
		this.visitDetail = visitDetail;
	}

	public Date getVisitNexttime() {
		return visitNexttime;
	}

	public void setVisitNexttime(Date visitNexttime) {
		this.visitNexttime = visitNexttime;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		SaleVisitEntity10 that = (SaleVisitEntity10) o;

		if (visitId != null ? !visitId.equals(that.visitId) : that.visitId != null) return false;
		if (visitTime != null ? !visitTime.equals(that.visitTime) : that.visitTime != null) return false;
		if (visitInterviewee != null ? !visitInterviewee.equals(that.visitInterviewee) : that.visitInterviewee != null)
			return false;
		if (visitAddr != null ? !visitAddr.equals(that.visitAddr) : that.visitAddr != null) return false;
		if (visitDetail != null ? !visitDetail.equals(that.visitDetail) : that.visitDetail != null) return false;
		return visitNexttime != null ? visitNexttime.equals(that.visitNexttime) : that.visitNexttime == null;
	}

	@Override
	public int hashCode() {
		int result = visitId != null ? visitId.hashCode() : 0;
		result = 31 * result + (visitTime != null ? visitTime.hashCode() : 0);
		result = 31 * result + (visitInterviewee != null ? visitInterviewee.hashCode() : 0);
		result = 31 * result + (visitAddr != null ? visitAddr.hashCode() : 0);
		result = 31 * result + (visitDetail != null ? visitDetail.hashCode() : 0);
		result = 31 * result + (visitNexttime != null ? visitNexttime.hashCode() : 0);
		return result;
	}

	public CstCustomerEntity10 getCstCustomerByVisitCustId() {
		return cstCustomerByVisitCustId;
	}

	public void setCstCustomerByVisitCustId(CstCustomerEntity10 cstCustomerByVisitCustId) {
		this.cstCustomerByVisitCustId = cstCustomerByVisitCustId;
	}

	public UserEntity10 getUserByVisitUserId() {
		return userByVisitUserId;
	}

	public void setUserByVisitUserId(UserEntity10 userByVisitUserId) {
		this.userByVisitUserId = userByVisitUserId;
	}
}
