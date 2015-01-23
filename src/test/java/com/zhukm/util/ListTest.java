package com.zhukm.util;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.zhukm.model.Topic;

public class ListTest {
	@Test
	public void testList(){
		List<Topic> topics = new ArrayList<Topic>();
		
		for(int i = 0; i < 3; i++){
			Topic topic = new Topic();
			topic.setTitle("dssssd" + i);
			topics.add(topic);
		}
		for(Topic t : topics){
			System.out.println(t.getTitle());
		}
	}
	@Test
	public void testEncoder(){
		
	}
}
