package cn.zxg.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import cn.zxg.dao.ZxgMapper;
import cn.zxg.exception.MyException;
import cn.zxg.pojo.Zxg;
import cn.zxg.service.HelloService;

@Service
public class HelloServiceImpl implements HelloService {

	@Autowired
	private ZxgMapper zxgMapper;
	@Autowired
	private Test test;
	
	
	
//	@Transactional 注解可以被应用于接口定义和接口方法、类定义和类的 public 方法上 。
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void doSomething(String type) throws Exception {
		
		if("1".equals(type)){
			do1();
		}else if("2".equals(type)){
			do2();
		}else if("3".equals(type)){
			do3();
		}else if("4".equals(type)){
			test.do4();
		}else if("5".equals(type)){
			do5();
		}
	}
	
	private void do1(){
		Zxg a = new Zxg();
		a.setA("a");
		zxgMapper.insert(a);
		Zxg b = new Zxg();
		b.setA("b");
		zxgMapper.insert(b);
	}
	
	
	private void do2() throws Exception{
		Zxg a = new Zxg();
		a.setA("a");
		zxgMapper.insert(a);
		Zxg b = new Zxg();
		b.setA("b");
		zxgMapper.insert(b);
		throw new Exception("!!!!exception");
	}
	
	private void do3() throws MyException{
		Zxg a = new Zxg();
		a.setA("a");
		zxgMapper.insert(a);
		Zxg b = new Zxg();
		b.setA("b");
		zxgMapper.insert(b);
		throw new MyException("!!!!!!RuntimeException");
	}
	
	private void do5(){
		Zxg a = new Zxg();
		a.setA("a");
		zxgMapper.insert(a);
		Zxg b = new Zxg();
		b.setA("a");
//		try{
			zxgMapper.insert(b);
//		}catch(DuplicateKeyException e){
//			
//		}
		Zxg c = new Zxg();
		c.setA("c");
		zxgMapper.insert(c);
	}
}
