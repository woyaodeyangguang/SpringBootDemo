package com.example.SpringBootDemo.common;


import static com.example.SpringBootDemo.constant.ConstantString.CODE_SUCCESS;
import static com.example.SpringBootDemo.constant.ConstantString.SUCCESS;

/**
 * 工具类,构建ResponseMessage.
 */
public class ResponseUtils {

  /**
   * 构建成功时response message.
   * @param data The response data.
   * @return
   */
  public static <T> ResponseMessage<T>  buildSuccessReponseMessage(T data) {
    ResponseMessage responseMessage = new ResponseMessage();
    responseMessage.setStatus(CODE_SUCCESS);
    responseMessage.setMessage(SUCCESS);
    responseMessage.setResponseData(data);
    return responseMessage;
  }

  /**
   * 构建成功时Response message.
   * @return
   */
  public static ResponseMessage buildSuccessReponseMessage() {
    return buildSuccessReponseMessage("");
  }

  /**
   * 构建失败时Response message.
   * @param code Error Http Status Code.
   * @param message Error Message.
   * @return
   */
  public static ResponseMessage buildErrorResponseMessage(int code, String message) {
    ResponseMessage responseMessage = new ResponseMessage();
    responseMessage.setStatus(code);
    responseMessage.setMessage(message);
    responseMessage.setMessage("");
    return responseMessage;
  }

  /**
   * 返回异常信息,已知的范围内
   * @param exceptionEnum The known exception type.
   * @return
   */
  public static ResponseMessage buildErrorResponseMessage(ExceptionEnum exceptionEnum) {
    ResponseMessage responseMessage = new ResponseMessage();
    responseMessage.setStatus(exceptionEnum.getCode());
    responseMessage.setMessage(exceptionEnum.getMessage());
    responseMessage.setResponseData("");
    return responseMessage;
  }


}
