package bean;

import java.util.Set;

public class UserEntity10 {
	private long uid;
	private String uname;
	private String upassword;
	private String sex;
	private Integer state;
	private String code;
	private String email;
	private Set<SaleVisitEntity10> saleVisitsByUid;

	public long getUid() {
		return uid;
	}

	public void setUid(long uid) {
		this.uid = uid;
	}

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public String getUpassword() {
		return upassword;
	}

	public void setUpassword(String upassword) {
		this.upassword = upassword;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		UserEntity10 that = (UserEntity10) o;

		if (uid != that.uid) return false;
		if (uname != null ? !uname.equals(that.uname) : that.uname != null) return false;
		if (upassword != null ? !upassword.equals(that.upassword) : that.upassword != null) return false;
		if (sex != null ? !sex.equals(that.sex) : that.sex != null) return false;
		if (state != null ? !state.equals(that.state) : that.state != null) return false;
		if (code != null ? !code.equals(that.code) : that.code != null) return false;
		return email != null ? email.equals(that.email) : that.email == null;
	}

	@Override
	public int hashCode() {
		int result = (int) (uid ^ (uid >>> 32));
		result = 31 * result + (uname != null ? uname.hashCode() : 0);
		result = 31 * result + (upassword != null ? upassword.hashCode() : 0);
		result = 31 * result + (sex != null ? sex.hashCode() : 0);
		result = 31 * result + (state != null ? state.hashCode() : 0);
		result = 31 * result + (code != null ? code.hashCode() : 0);
		result = 31 * result + (email != null ? email.hashCode() : 0);
		return result;
	}

	public Set<SaleVisitEntity10> getSaleVisitsByUid() {
		return saleVisitsByUid;
	}

	public void setSaleVisitsByUid(Set<SaleVisitEntity10> saleVisitsByUid) {
		this.saleVisitsByUid = saleVisitsByUid;
	}
}
