package bean;

import javax.persistence.*;

@Entity
@Table(name = "category", schema = "cao")
public class CategoryEntity {
	private long cid;
	private String cname;

	@Id
	@Column(name = "cid")
	public long getCid() {
		return cid;
	}

	public void setCid(long cid) {
		this.cid = cid;
	}

	@Basic
	@Column(name = "cname")
	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		CategoryEntity that = (CategoryEntity) o;

		if (cid != that.cid) return false;
		return cname != null ? cname.equals(that.cname) : that.cname == null;
	}

	@Override
	public int hashCode() {
		int result = (int) (cid ^ (cid >>> 32));
		result = 31 * result + (cname != null ? cname.hashCode() : 0);
		return result;
	}

	@Override
	public String toString() {
		return "CategoryEntity{" +
				"cid=" + cid +
				", cname='" + cname + '\'' +
				'}';
	}
}
