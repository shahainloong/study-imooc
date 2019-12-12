package com.myimooc.guice.demo.useguice.helloworlddemo;

import java.io.PrintStream;

import com.google.inject.AbstractModule;
import com.myimooc.guice.demo.useguice.MyApplet;

/**
 * @title HelloWorldModule类
 * @describe HelloWorld模块的依赖配置
 * @author zc
 * @version 1.0 2017-10-15
 */
public class HelloWorldModule extends AbstractModule{
	
	@Override
	protected void configure() {
		bind(MyApplet.class).to(StringWritingApplet.class);
		bind(MyDestination.class).to(PrintStreamWriter.class);
		bind(PrintStream.class).toInstance(System.out);
		bind(String.class).annotatedWith(Output.class).toInstance("Hello World");
	}
}
