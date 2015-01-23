package com.zhukm.model;

import java.util.ArrayList;
import java.util.List;

public class PageResult {
	private List<Topic> topicList = new ArrayList<Topic>();
	private Page page;
	
	public List<Topic> getTopicList() {
		return topicList;
	}
	public void setTopicList(List<Topic> topicList) {
		this.topicList = topicList;
	}
	public Page getPage() {
		return page;
	}
	public void setPage(Page page) {
		this.page = page;
	}
}
