package com.zhukm.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.zhukm.model.Page;
import com.zhukm.model.Topic;

public interface TopicMapper {
	public void saveTopic(List<Topic> topics);
	public List<Topic> getAllTopic();
	public List<Topic> getPageResult(Page page);
	public int getRecordCount(@Param(value="param")String param);
	public List<Topic> searchTopic(Page page);
}
