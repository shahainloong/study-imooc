package com.myimooc.guice.demo.bind.helloworlddemo;

import java.io.PrintStream;
import java.util.List;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.myimooc.guice.demo.bind.Applets;

/**
 * @title HelloWorldModule类
 * @describe HelloWorld模块的依赖配置
 * @author zc
 * @version 1.0 2017-10-15
 */
public class HelloWorldModule extends AbstractModule{
	
	@Override
	protected void configure() {
		Applets.register(binder()).named("hello").to(StringWritingApplet.class);
		bind(MyDestination.class).to(PrintStreamWriter.class);
		bind(PrintStream.class).toInstance(System.out);
	}
	
	@Provides
	@Output
	String getOutputString(@Args List<String> args){
		return args.get(0);
	}
}
