package com.pabs.app.util.config.metadata;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.ResourceUtils;

public class MetaDataHarversterBean {

  private static Logger logger = LoggerFactory.getLogger(MetaDataHarversterBean.class);

  public static ServiceRequestMetaDataHeaderInfo getAssoDiscAuthMetaData(){
    try {

      ServiceRequestMetaDataHeaderInfo adRequestMetaData=null;

      File adRequestMetaDataFile = ResourceUtils.getFile("classpath:addata.json");
      if (adRequestMetaDataFile.exists()) {
        ObjectMapper mapper = new ObjectMapper();
        adRequestMetaData= mapper.readValue(adRequestMetaDataFile, ServiceRequestMetaDataHeaderInfo.class);
      }
      return adRequestMetaData;
    }catch (IOException io){
      System.out.println("Error ! "+io.getMessage());
      logger.error("IO Exception ß {}",io.getMessage());
    }
    catch (Exception io){
    System.out.println("Error ! "+io.getMessage());
    logger.error("Exception  {}",io.getMessage());
  }
    return null;
  }


  public static void main(String[] args) {
    getAssoDiscAuthMetaData();
  }


}
