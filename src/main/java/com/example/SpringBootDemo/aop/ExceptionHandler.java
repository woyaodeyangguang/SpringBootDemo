package com.example.SpringBootDemo.aop;

import com.example.SpringBootDemo.common.CustomException;
import com.example.SpringBootDemo.common.ExceptionEnum;
import com.example.SpringBootDemo.common.ResponseMessage;
import com.example.SpringBootDemo.common.ResponseUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 异常处理.
 */
@ControllerAdvice
public class ExceptionHandler {
  private Logger logger = LoggerFactory.getLogger(ExceptionHandler.class);


  @org.springframework.web.bind.annotation.ExceptionHandler(value = Exception.class)
  @ResponseBody
  public ResponseMessage exceptionGet(Exception e) {
    if(e instanceof CustomException) {
      CustomException customException = (CustomException) e;
      return ResponseUtils.buildErrorResponseMessage(customException.getCode(),
          customException.getMessage());
    }
    logger.error("System error : {}" , e);
    return ResponseUtils.buildErrorResponseMessage(ExceptionEnum.SERVER_INTERAL_ERROR);
  }
}
