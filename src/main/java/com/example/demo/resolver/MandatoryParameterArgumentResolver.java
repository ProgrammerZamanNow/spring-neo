package com.example.demo.resolver;

import com.example.demo.model.MandatoryParameter;
import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

public class MandatoryParameterArgumentResolver implements HandlerMethodArgumentResolver {

  @Override
  public boolean supportsParameter(MethodParameter parameter) {
    return parameter.getParameterType().equals(MandatoryParameter.class);
  }

  @Override
  public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer, NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
    MandatoryParameter mandatoryParameter = new MandatoryParameter();
    mandatoryParameter.setRequestId(webRequest.getHeader("X-Request-Id"));
    mandatoryParameter.setUsername(webRequest.getHeader("X-Username"));
    mandatoryParameter.setSessionId(webRequest.getHeader("X-Session-Id"));
    return mandatoryParameter;
  }
}
