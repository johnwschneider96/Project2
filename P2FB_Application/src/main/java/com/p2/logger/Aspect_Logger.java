package com.p2.logger;

import org.apache.log4j.Logger;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

//@Component("aspect")
//@Aspect
public class Aspect_Logger {

	private final static Logger loggy = Logger.getLogger(Aspect_Logger.class);
	
	//@After("execution(public void draw*(*))")
	public void drawNature() {
		loggy.info("Insert Controller Called");
	}
}
