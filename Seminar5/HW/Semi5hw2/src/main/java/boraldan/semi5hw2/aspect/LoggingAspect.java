package boraldan.semi5hw2.aspect;

import lombok.extern.log4j.Log4j2;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.util.Arrays;

//https://docs.spring.io/spring-framework/reference/core/aop/ataspectj.html

@Aspect
@Log4j2
@Component
public class LoggingAspect {
    /**
     * Логируем сигнарутуру аннотируемого метода
     * @param jp
     */
    @Before("@annotation(boraldan.semi5hw2.aspect.TrackUserAction)")
    public void beforeCallAtMethod2(JoinPoint jp)  {
        String methodName = jp.getSignature().getName();
        Object[] arguments = jp.getArgs();
        log.info("Method " + methodName + " with parameters " + Arrays.asList(arguments) + " will execute");
    }

}
