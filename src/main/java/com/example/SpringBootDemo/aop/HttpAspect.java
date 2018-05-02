package com.example.SpringBootDemo.aop;

import com.example.SpringBootDemo.common.ResponseUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

import static com.example.SpringBootDemo.common.ExceptionEnum.MISS_TOKEN;
import static com.example.SpringBootDemo.constant.ConstantString.ATTR_TOKEN;


/**
 * Http切面.
 */
@Aspect
@Component
public class HttpAspect {
  private Logger logger = LoggerFactory.getLogger(HttpAspect.class);

  @Pointcut("execution(public * com.example.SpringBootDemo.controller.*.*(..))")
  public void log(){
  }

  @Before("log()")
  public void doBefore(JoinPoint joinPoint){
    ServletRequestAttributes attributes = (ServletRequestAttributes)
        RequestContextHolder.getRequestAttributes();
    HttpServletRequest request = attributes.getRequest();
    //url
    logger.info("url={}",request.getRequestURL());
    //method
    logger.info("method={}",request.getMethod());
    //ip
    logger.info("id={}",request.getRemoteAddr());
    //class_method
    logger.info("class_method={}",
        joinPoint.getSignature().getDeclaringTypeName() + "," + joinPoint.getSignature().getName());
    //args[]
    logger.info("args={}",joinPoint.getArgs());
  }

  @Around("log()")
  public Object doAround(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
    RequestAttributes ra = RequestContextHolder.getRequestAttributes();
    ServletRequestAttributes sra = (ServletRequestAttributes) ra;
    HttpServletRequest request = sra.getRequest();
    String token = request.getParameter(ATTR_TOKEN);
    // TODO 加入token验证
    if ("1234".equals(token)) {
      return ResponseUtils.buildErrorResponseMessage(MISS_TOKEN);
    }
    return proceedingJoinPoint.proceed();
  }

  @AfterReturning(pointcut = "log()",returning = "object")
  public void doAfterReturing(Object object){
    logger.info("response={}",object.toString());
  }

}
