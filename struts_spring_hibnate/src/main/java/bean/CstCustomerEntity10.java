package bean;

import java.util.Set;

public class CstCustomerEntity10 {
	private long custId;
	private String custName;
	private Long custUserId;
	private Long custCreateId;
	private String custLinkman;
	private String custPhone;
	private String custMobile;
	private Set<SaleVisitEntity10> saleVisitsByCustId;

	public long getCustId() {
		return custId;
	}

	public void setCustId(long custId) {
		this.custId = custId;
	}

	public String getCustName() {
		return custName;
	}

	public void setCustName(String custName) {
		this.custName = custName;
	}

	public Long getCustUserId() {
		return custUserId;
	}

	public void setCustUserId(Long custUserId) {
		this.custUserId = custUserId;
	}

	public Long getCustCreateId() {
		return custCreateId;
	}

	public void setCustCreateId(Long custCreateId) {
		this.custCreateId = custCreateId;
	}

	public String getCustLinkman() {
		return custLinkman;
	}

	public void setCustLinkman(String custLinkman) {
		this.custLinkman = custLinkman;
	}

	public String getCustPhone() {
		return custPhone;
	}

	public void setCustPhone(String custPhone) {
		this.custPhone = custPhone;
	}

	public String getCustMobile() {
		return custMobile;
	}

	public void setCustMobile(String custMobile) {
		this.custMobile = custMobile;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		CstCustomerEntity10 that = (CstCustomerEntity10) o;

		if (custId != that.custId) return false;
		if (custName != null ? !custName.equals(that.custName) : that.custName != null) return false;
		if (custUserId != null ? !custUserId.equals(that.custUserId) : that.custUserId != null) return false;
		if (custCreateId != null ? !custCreateId.equals(that.custCreateId) : that.custCreateId != null) return false;
		if (custLinkman != null ? !custLinkman.equals(that.custLinkman) : that.custLinkman != null) return false;
		if (custPhone != null ? !custPhone.equals(that.custPhone) : that.custPhone != null) return false;
		return custMobile != null ? custMobile.equals(that.custMobile) : that.custMobile == null;
	}

	@Override
	public int hashCode() {
		int result = (int) (custId ^ (custId >>> 32));
		result = 31 * result + (custName != null ? custName.hashCode() : 0);
		result = 31 * result + (custUserId != null ? custUserId.hashCode() : 0);
		result = 31 * result + (custCreateId != null ? custCreateId.hashCode() : 0);
		result = 31 * result + (custLinkman != null ? custLinkman.hashCode() : 0);
		result = 31 * result + (custPhone != null ? custPhone.hashCode() : 0);
		result = 31 * result + (custMobile != null ? custMobile.hashCode() : 0);
		return result;
	}

	public Set<SaleVisitEntity10> getSaleVisitsByCustId() {
		return saleVisitsByCustId;
	}

	public void setSaleVisitsByCustId(Set<SaleVisitEntity10> saleVisitsByCustId) {
		this.saleVisitsByCustId = saleVisitsByCustId;
	}
}
