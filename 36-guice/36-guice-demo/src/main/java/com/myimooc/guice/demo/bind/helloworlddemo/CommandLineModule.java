package com.myimooc.guice.demo.bind.helloworlddemo;

import java.util.Arrays;
import java.util.List;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;

/**
 * @title CommandLineModule类
 * @describe 封装从命令行传入的参数
 * @author zc
 * @version 1.0 2017-10-15
 */
public class CommandLineModule extends AbstractModule {
	
	private final String[] args;
	
	public CommandLineModule(String[] args) {
		super();
		this.args = args;
	}

	@Override
	protected void configure() {
		
	}
	
	@Provides
	@Args
	List<String> getCommandLineArgs(){
		return Arrays.asList(args).subList(1, args.length);
	}

}
