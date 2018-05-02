package com.example.SpringBootDemo.common;

/**
 * 已知的Exception.
 */
public class CustomException extends RuntimeException{

  public int getCode() {
    return code;
  }

  public void setCode(int code) {
    this.code = code;
  }

  private int code;

  public CustomException(ExceptionEnum exceptionEnum) {
    super(exceptionEnum.getMessage());
    this.code = exceptionEnum.getCode();
  }

  public CustomException(int code, String message) {
    super(message);
    this.code = code;
  }



}
