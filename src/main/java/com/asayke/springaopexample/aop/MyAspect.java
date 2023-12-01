package com.asayke.springaopexample.aop;

import com.asayke.springaopexample.dto.BookRequest;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

@Slf4j
@Aspect
@Component
public class MyAspect {
    @Around("Pointcuts.allAddMethods()")
    public Object aroundAddingAdvice(ProceedingJoinPoint joinPoint) {
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        BookRequest bookRequest = null;
        
        if (methodSignature.getName().equals("add")) {
            Object[] args = joinPoint.getArgs();
            for (Object arg : args) {
                if (arg instanceof BookRequest) {
                    bookRequest = (BookRequest) arg;
                    log.info("Trying to add book with title {}", bookRequest.getTitle());
                }
            }
        }

        log.info("Book with title {} added successfully", bookRequest.getTitle());

        Object result = null;

        try {
            result = joinPoint.proceed();
        } catch (Throwable e) {
            log.error("Could not add book with title {}", bookRequest.getTitle());
        }

        return result;
    }

    @Around("Pointcuts.allFindMethods()")
    public Object aroundGettingAdvice(ProceedingJoinPoint joinPoint) {
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        String title = null;

        if (methodSignature.getName().equals("findAll")) {
            log.info("Trying to find all books");
        } else if (methodSignature.getName().equals("findByTitle")) {
            Object[] arguments = joinPoint.getArgs();
            for (Object arg : arguments) {
                if (arg instanceof String) {
                    title = (String) arg;
                    log.info("Trying to add book with title {}", title);
                }
            }
        }

        Object result = null;

        try {
            result = joinPoint.proceed();
        } catch (Throwable e) {
            log.error(e.getMessage(), e);
        }

        if (methodSignature.getName().equals("findAll")) {
            log.info("All books found successfully");
        } else if (methodSignature.getName().equals("findByTitle")) {
            log.info("Book with title {} found successfully", title);
        }

        return result;
    }
}