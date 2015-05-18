package cn.zxg.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import cn.zxg.dao.ZxgMapper;
import cn.zxg.pojo.Zxg;

@Service
public class Test {
	@Autowired
	private ZxgMapper zxgMapper;
	
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void do4(){
		Zxg a = new Zxg();
		a.setA("a");
		zxgMapper.insert(a);
		Zxg b = new Zxg();
		b.setA("a");
		zxgMapper.insert(b);
	}
	
}
