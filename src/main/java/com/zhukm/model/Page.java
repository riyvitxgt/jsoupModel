package com.zhukm.model;

import org.apache.ibatis.annotations.Param;

import com.zhukm.dao.TopicMapper;

public class Page {
	private int total = 0;
	private int pageNow = 1;
	private int pageCount;
	private int pageSize = 20;
	private String param;
	public Page(){}
	
	public Page(TopicMapper topicMapper,String param){
		this.total = topicMapper.getRecordCount(param);
		if(total % pageSize == 0){
			this.pageCount = total / pageSize;
		}else{
			this.pageCount = total / pageSize + 1;
		}
		this.param = param;
	}
	public int getPageNow() {
		return pageNow;
	}
	public void setPageNow(int pageNow) {
		if(pageNow > pageCount){
			this.pageNow = pageCount;
		}else if(pageNow < 0){
			this.pageNow = 1;
		}else{
			this.pageNow = pageNow;
		}
		
	}
	public int getPageCount() {
		return pageCount;
	}
	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public String getParam() {
		return param;
	}

	public void setParam(String param) {
		this.param = param;
	}
	
	
}
