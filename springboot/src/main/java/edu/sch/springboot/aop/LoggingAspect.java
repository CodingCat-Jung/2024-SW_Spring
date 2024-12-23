package edu.sch.springboot.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    @Around("execution(* edu.sch.springboot.service.MemberService.*(..))")
    public Object execute(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("--->> Before proceeding getMember");
        Object result = joinPoint.proceed();  // 실제 메서드 실행
        System.out.println("--->> After proceeding getMember");
        return result;
    }
}
