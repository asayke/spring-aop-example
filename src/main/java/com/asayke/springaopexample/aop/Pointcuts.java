package com.asayke.springaopexample.aop;

import org.aspectj.lang.annotation.Pointcut;

public class Pointcuts {
    @Pointcut("execution(* com.asayke.springaopexample.service.implementation.BookServiceImpl.find*(..))")
    public void allFindMethods() {}

    @Pointcut("execution(* com.asayke.springaopexample.service.implementation.BookServiceImpl.add*(..))")
    public void allAddMethods() {}
}