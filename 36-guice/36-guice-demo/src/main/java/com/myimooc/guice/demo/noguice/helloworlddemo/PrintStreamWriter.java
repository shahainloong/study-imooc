package com.myimooc.guice.demo.noguice.helloworlddemo;

import java.io.PrintStream;

/**
 * 实现write()方法
 *
 * @author zc  2017-10-15
 */
public class PrintStreamWriter implements MyDestination {

    private PrintStream destination;

    public PrintStreamWriter(PrintStream destination) {
        super();
        this.destination = destination;
    }

    @Override
    public void write(String string) {
        destination = System.out;
        destination.println(string);
    }
}
