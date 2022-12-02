package com.myboard.aop;

import java.util.Arrays;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import lombok.extern.java.Log;

@Log
@Aspect // 이 어노테이션을 사용하기 위해 root-context.xml에 component-scan부분을 추가해줘야함.
@Component  // user가 객체를 생성할 때 사용
public class LogAdvice {
	@Before("execution(* com.myboard.model.BoardService*.*(..))")  
	public void logBefore() {
		log.info("================");
		System.out.println("logBefore");
	}
	
	@Around("execution(* com.myboard.model.BoardService*.*(..))") // 서비스가 동작되어지는 시점의 log를 찍기 위해 지정
	public Object logTime(ProceedingJoinPoint pjp) {
		long start = System.currentTimeMillis(); 
		log.info("Target : "+pjp.getTarget());
		log.info("Param : "+Arrays.toString(pjp.getArgs()));
		Object result = null;
		try {
			result = pjp.proceed();
		} catch (Throwable e) {
			e.printStackTrace();
		}
		long end = System.currentTimeMillis();
		log.info("start : "+start);
		log.info("end : "+end);
		log.info("TIME : "+(end-start));
		System.out.println("TIME : "+(end-start));
		return result;
	}

}
