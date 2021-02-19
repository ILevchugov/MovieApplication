package ru.levchugov.movieapp.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Slf4j
@Aspect
@Component
public class LoggingAspect {

    @Pointcut("execution(public * ru.levchugov.movieapp.service.impl.*.*(..))")
    private void serviceMethod() {}

    @Around("serviceMethod()")
    public Object invoke(ProceedingJoinPoint jp) throws Throwable {
        String serviceName = jp.getTarget().getClass().getSimpleName();
        String methodName = jp.getSignature().getName();

        log.info("start execution service {}, method {}", serviceName, methodName);
        long start = System.nanoTime();
        try {
            Object result =  jp.proceed();
            long finish = System.nanoTime();
            log.info("finish execution execution service {}, method {}. Time = {} ns", serviceName, methodName, finish - start);
            return result;
        } catch (Throwable e) {
            log.error("failed execution service {}, method {}", serviceName, methodName, e);
            throw e;
        }
    }

}
