package com.zhukm.dao;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.zhukm.model.Page;
import com.zhukm.model.Topic;

public class MapperTest {

	@Test
	public void testMapper(){
		ApplicationContext context =
				new ClassPathXmlApplicationContext("applicationContext.xml");
		TopicMapper mapper = (TopicMapper) context.getBean("topicMapper");
		//System.out.println(mapper);
		List<Topic> topics = new ArrayList<Topic>();
		for(int i = 0; i < 5; i++){
			Topic topic = new Topic();
			topic.setAuthor("author" + i);
			topic.setTitle("title" + i);
			topic.setUrl("url" + i);
			topic.setReplyCount(1);
			topic.setVisitCount(i);
			topics.add(topic);
		}
		System.out.println(topics.size());	
		
		mapper.saveTopic(topics);
	}
	
	/**����mapper��getAllTopic����*/
	@Test
	public void testGetAllTopic(){
		ApplicationContext context =
				new ClassPathXmlApplicationContext("applicationContext.xml");
		TopicMapper mapper = (TopicMapper) context.getBean("topicMapper");
		List<Topic> topics = mapper.getAllTopic();
		System.out.println(topics.size());
	}

	/**��ȡ�ܼ�¼��*/
	@Test
	public void testGetTotal(){
		ApplicationContext context =
				new ClassPathXmlApplicationContext("applicationContext.xml");
		TopicMapper mapper = (TopicMapper) context.getBean("topicMapper");
		int sun = mapper.getRecordCount("���");
		System.out.println(sun + " " + sun%6 + "  " + sun%7);
	}
	
	/**���Ի�ȡĳ��ҳ������*/
	@Test
	public void testGetPageResult(){
		ApplicationContext context =
				new ClassPathXmlApplicationContext("applicationContext.xml");
		TopicMapper mapper = (TopicMapper) context.getBean("topicMapper");
		Page page = new Page(mapper,"���");
		
		System.out.println(page.getPageCount());
		List<Topic> topics = mapper.getPageResult(page);
		System.out.println(topics.size());
	}
	
	/**���Բ��ҹ���*/
	@Test
	public void testSearchTopic(){
		ApplicationContext context =
				new ClassPathXmlApplicationContext("applicationContext.xml");
		TopicMapper mapper = (TopicMapper) context.getBean("topicMapper");
		/*int total = mapper.getRecordCount("���");
		Page page = new Page();
		page.setPageNow(1);
		page.setPageCount(total);*/
		Page page = new Page(mapper,"如何");
		List<Topic> topics = mapper.searchTopic(page);
		System.out.println(topics.size());
	}
}
