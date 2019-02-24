//package com.ranjit.aspects;
//
//import org.aspectj.lang.JoinPoint;
//import org.aspectj.lang.annotation.Aspect;
//import org.aspectj.lang.annotation.Before;
//import org.springframework.stereotype.Component;;
//
//import java.util.logging.Logger;
//
//@Aspect
//@Component
//public class LoggingAspect {
//    private Logger logger = Logger.getLogger(getClass().getName());
//
//    @Before("execution(void com.ranjit.model.*.set*(*))")
//    public void callSetters(JoinPoint joinPoint){
//        String methodName = joinPoint.getSignature().getName();
//        String args = joinPoint.getArgs()[0].toString();
//
//        logger.info("Setter called "+ methodName +"-"+args);
//    }
//
//
//}
