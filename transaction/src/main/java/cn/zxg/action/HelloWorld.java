package cn.zxg.action;

import org.springframework.beans.factory.annotation.Autowired;

import cn.zxg.service.HelloService;

import com.opensymphony.xwork2.ActionSupport;

public class HelloWorld extends ActionSupport {
	
	@Autowired
	private HelloService helloService;
	
	private String type;
	
	public String execute() throws Exception {
		helloService.doSomething(type);
		return SUCCESS;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
}
