package com.pabs.app.util.etl;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@FunctionalInterface
public interface CICSDataLoaderInterface {
  /**
   * Applies this function to the given arguments.
   *
   * @param cicsRequestObject the first function argument
   * @param cicsDataInfo the second function argument
   *
   * @return populated cicsRequestObject as the function result
   */
  public Object apply(Object cicsRequestObject, Map<String,String> cicsDataInfo)
      throws IllegalAccessException, InvocationTargetException,Exception;

}
