package com.myimooc.spring.aop.proxy.jdkimpl;

import java.lang.reflect.Proxy;

import com.myimooc.spring.aop.proxy.pattern.RealSubject;
import com.myimooc.spring.aop.proxy.pattern.Subject;

/**
 * @title 动态代理类
 * @describe JDK实现动态代理测试类
 * @author zc
 * @version 1.0 2017-09-13
 */
public class Client {
	
	public static void main(String[] args) {
		Subject subject = (Subject) Proxy.newProxyInstance(Client.class.getClassLoader(),
			new Class[]{Subject.class}, new JdkSubject(new RealSubject()));
		subject.request();
	}
	
}
