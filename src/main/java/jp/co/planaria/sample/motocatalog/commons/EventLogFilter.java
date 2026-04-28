package jp.co.planaria.sample.motocatalog.commons;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;


@Component
@Aspect
@Slf4j
public class EventLogFilter {
    
    
    @Before("execution* jp.co.planaria.sample.motocatalog..*Controller.*(..))") 
    public void beforelog(JoinPoint joinpoint) {
        log.info(String.format("%s START", joinpoint.toShortString()));
    }

    @After("execution* jp.co.planaria.sample.motocatalog..*Controller.*(..))") 
    public void afterlog(JoinPoint joinpoint) {
        log.info(String.format("%s END", joinpoint.toShortString()));
    }
}
