package util;

import java.util.List;

public class PageBean {
	//	当前页数
	public Integer currentpage;
	//	总记录数量
	public Integer totalcount;
	//	每页显示条数
	public Integer pagesize;
	//	总页数
	public Integer totalpage;
	//	分页列表数据
	public List list;

	public PageBean(Integer currentpage, Integer totalcount, Integer pagesize) {
//		目的是处理好pagebean,使里面的所有属性都有固定的值，不过分页列表数据需要自己封装
		this.currentpage = currentpage;
		if (this.currentpage == null) {
			this.currentpage = 1;
		}
//		第二个参数是从数据库查的，一定有值，其他的参数如果没有值则需要初始化
		this.totalcount = totalcount;
		this.pagesize = pagesize;
//		注意，需要先赋值才可以查，编辑器这里做了优化
		if (this.pagesize == null) {
			this.pagesize = 3;
		}
//		我需要计算总页数,不过java默认是向下取整数，所以我来个写新的
//		this.totalpage = this.totalcount / this.pagesize;
		this.totalpage = (this.totalcount + this.pagesize - 1) / this.pagesize;
//		判断当前页数是否超出范围
		if (this.currentpage < 1) {
			this.currentpage = 1;
		}
		if (this.currentpage > this.totalpage) {
			this.currentpage = this.totalpage;
		}
	}

	//	计算起始索引
	public int getstart() {
		return (this.currentpage - 1) * this.pagesize;
	}

	public Integer getCurrentpage() {
		return currentpage;
	}

	public void setCurrentpage(Integer currentpage) {
		this.currentpage = currentpage;
	}

	public Integer getTotalcount() {
		return totalcount;
	}

	public void setTotalcount(Integer totalcount) {
		this.totalcount = totalcount;
	}

	public Integer getPagesize() {
		return pagesize;
	}

	public void setPagesize(Integer pagesize) {
		this.pagesize = pagesize;
	}

	public Integer getTotalpage() {
		return totalpage;
	}

	public void setTotalpage(Integer totalpage) {
		this.totalpage = totalpage;
	}

	public List getList() {
		return list;
	}

	public void setList(List list) {
		this.list = list;
	}
}
