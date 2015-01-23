package com.zhukm.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zhukm.dao.TopicMapper;
import com.zhukm.model.Page;
import com.zhukm.model.PageResult;
import com.zhukm.model.Topic;

@Controller
public class TopicController {
	@Autowired
	private TopicMapper mapper;
	@RequestMapping(value="/capture",method=RequestMethod.POST)
	public @ResponseBody Map<String,String> capture(){
		Map<String,String> result = new HashMap<String,String>();
		try {
			List<Topic> topicList = new ArrayList<Topic>();
			for(int n = 1; n < 10; n++){
				Document doc = Jsoup.connect("https://cnodejs.org/?page="
						+n).get();
				if(doc != null){
					Elements media = doc.getElementsByClass("cell");
					for(Element m : media){
						Topic topic = new Topic();
						topic.setAuthor(m.select(".user_avatar img")
								.get(0).attr("title"));
						topic.setTitle(m.select(".topic_title").get(0).text());
						topic.setUrl(m.select("a[class=topic_title]").get(0).attr("href"));
						topic.setVisitCount(Integer
								.parseInt(m.getElementsByClass("count_of_visits").text()));
						topic.setReplyCount(Integer.parseInt(m.getElementsByClass("count_of_replies").text()));
						topicList.add(topic);
					}
				}
			}
			System.out.println(topicList.size());
			mapper.saveTopic(topicList);
			
			result.put("flag", "1");
			
			return result;
		} catch (IOException e) {
			result.put("flag", "0");
			System.out.println(e.getMessage());
			return result;
		}
	}
	
	@RequestMapping("/list/{pageNow}")
	public String getList(@PathVariable(value="pageNow") int pageNow,@RequestParam(value="param",required=false)String param,ModelMap model){
		 
		Page page =new Page(mapper,param);
		page.setPageNow(pageNow);
		List<Topic> topicList = mapper.searchTopic(page);
		PageResult result = new PageResult();
		result.setPage(page);
		result.setTopicList(topicList);
		model.addAttribute("pageResult", result);
		return "list";
		
	}
}
