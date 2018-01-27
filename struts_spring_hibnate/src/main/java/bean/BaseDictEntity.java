package bean;

public class BaseDictEntity {
	private String dictId;
	private String dictTypeCode;
	private String dictTypeName;
	private String dictItemName;
	private String dictItemCode;
	private Integer dictSort;
	private String dictEnable;
	private String dictMemo;

	public String getDictId() {
		return dictId;
	}

	public void setDictId(String dictId) {
		this.dictId = dictId;
	}

	public String getDictTypeCode() {
		return dictTypeCode;
	}

	public void setDictTypeCode(String dictTypeCode) {
		this.dictTypeCode = dictTypeCode;
	}

	public String getDictTypeName() {
		return dictTypeName;
	}

	public void setDictTypeName(String dictTypeName) {
		this.dictTypeName = dictTypeName;
	}

	public String getDictItemName() {
		return dictItemName;
	}

	public void setDictItemName(String dictItemName) {
		this.dictItemName = dictItemName;
	}

	public String getDictItemCode() {
		return dictItemCode;
	}

	public void setDictItemCode(String dictItemCode) {
		this.dictItemCode = dictItemCode;
	}

	public Integer getDictSort() {
		return dictSort;
	}

	public void setDictSort(Integer dictSort) {
		this.dictSort = dictSort;
	}

	public String getDictEnable() {
		return dictEnable;
	}

	public void setDictEnable(String dictEnable) {
		this.dictEnable = dictEnable;
	}

	public String getDictMemo() {
		return dictMemo;
	}

	public void setDictMemo(String dictMemo) {
		this.dictMemo = dictMemo;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		BaseDictEntity that = (BaseDictEntity) o;

		if (dictId != null ? !dictId.equals(that.dictId) : that.dictId != null) return false;
		if (dictTypeCode != null ? !dictTypeCode.equals(that.dictTypeCode) : that.dictTypeCode != null) return false;
		if (dictTypeName != null ? !dictTypeName.equals(that.dictTypeName) : that.dictTypeName != null) return false;
		if (dictItemName != null ? !dictItemName.equals(that.dictItemName) : that.dictItemName != null) return false;
		if (dictItemCode != null ? !dictItemCode.equals(that.dictItemCode) : that.dictItemCode != null) return false;
		if (dictSort != null ? !dictSort.equals(that.dictSort) : that.dictSort != null) return false;
		if (dictEnable != null ? !dictEnable.equals(that.dictEnable) : that.dictEnable != null) return false;
		return dictMemo != null ? dictMemo.equals(that.dictMemo) : that.dictMemo == null;
	}

	@Override
	public int hashCode() {
		int result = dictId != null ? dictId.hashCode() : 0;
		result = 31 * result + (dictTypeCode != null ? dictTypeCode.hashCode() : 0);
		result = 31 * result + (dictTypeName != null ? dictTypeName.hashCode() : 0);
		result = 31 * result + (dictItemName != null ? dictItemName.hashCode() : 0);
		result = 31 * result + (dictItemCode != null ? dictItemCode.hashCode() : 0);
		result = 31 * result + (dictSort != null ? dictSort.hashCode() : 0);
		result = 31 * result + (dictEnable != null ? dictEnable.hashCode() : 0);
		result = 31 * result + (dictMemo != null ? dictMemo.hashCode() : 0);
		return result;
	}
}
