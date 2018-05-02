package com.example.SpringBootDemo.common;

/**
 * 错误类型.
 */
public enum ExceptionEnum {
  SERVER_INTERAL_ERROR(500, "Server Internal Error"),
  MISS_TOKEN(408, "Missing Token, Please apply token.");

  private int code;
  private String message;

  public int getCode() {
    return code;
  }

  public void setCode(int code) {
    this.code = code;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  ExceptionEnum(int code, String message) {
    this.code = code;
    this.message = message;
  }
}
