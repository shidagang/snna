package cn.com.na.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.com.na.bean.FeedBack;
import cn.com.na.mapper.FeedBackMapper;
import cn.com.na.service.FeedBackService;

@Service("feedBackService")
public class FeedBackServiceImpl implements FeedBackService {


	@Autowired
	private FeedBackMapper feedBackMapper;
	@Override
	public void addFeedBack(FeedBack feedback) {
		feedBackMapper.addFeedBack(feedback);
	}

}
