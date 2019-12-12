package com.myimooc.spring.tx.demo1;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * 账户服务测试
 *
 * @author zc
 * @version v1.0 2017-02-16
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext1.xml")
public class TransactionTest {

	@Resource(name="accountService")
	private AccountService accountService;
	
	@Test
	public void demo1(){
		accountService.transfer("aaa", "bbb", 200d);
	}
}
