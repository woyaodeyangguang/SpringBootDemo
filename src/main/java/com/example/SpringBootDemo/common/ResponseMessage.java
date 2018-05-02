package com.example.SpringBootDemo.common;


import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * Http response message.
 */
public class ResponseMessage<T> {
  // 状态码
  private int status;
  // 消息
  private String message;
  // 数据
  private T responseData;

  public int getStatus() {
    return status;
  }

  public void setStatus(int status) {
    this.status = status;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public T getResponseData() {
    return responseData;
  }

  public void setResponseData(T responseData) {
    this.responseData = responseData;
  }

  public Map<String, ?> asMap() {
    Map<String, Object> map = new HashMap<>();
    try {
      BeanInfo beanInfo = Introspector.getBeanInfo(this.getClass());
      PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
      for (PropertyDescriptor property : propertyDescriptors) {
        String key = property.getName();
        // 过滤class属性
        if (!key.equals("class")) {
          // 得到property对应的getter方法
          Method getter = property.getReadMethod();
          Object value = getter.invoke(this);
          map.put(key, value);
        }
      }
    } catch (Exception e) {
    }
    return map;
  }
}
