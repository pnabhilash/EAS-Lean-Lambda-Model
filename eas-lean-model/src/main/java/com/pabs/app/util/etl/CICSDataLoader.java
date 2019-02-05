package com.pabs.app.util.etl;


import java.lang.reflect.InvocationTargetException;
import java.util.Map;
import java.util.function.BiFunction;
import org.apache.commons.beanutils.BeanUtils;


public class CICSDataLoader implements CICSDataLoaderInterface{


  /**
   * Applies this function to the given arguments.
   *
   * @param cicsRequestObject the first function argument
   * @param cicsDataInfo the second function argument
   * @return populated cicsRequestObject as the function result
   */
  @Override
  public Object apply(Object cicsRequestObject , Map<String, String> cicsDataInfo)
      throws IllegalAccessException, InvocationTargetException, Exception {
    cicsDataInfo.
        entrySet ().
        stream ().
        forEach (e -> {
          try {
             BeanUtils.setProperty (cicsRequestObject , e.getKey () , e.getValue ());
          } catch (Exception eX) {
            System.out.println (eX.getMessage ());
          }
        });
    return cicsRequestObject;
}}
