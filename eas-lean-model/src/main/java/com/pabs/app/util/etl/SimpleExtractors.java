package com.pabs.app.util.etl;

import com.pabs.app.util.config.metadata.ServiceRequestMetaDataColumnsInfo;
import java.util.Map;
import java.util.function.BiFunction;

public class SimpleExtractors implements BiFunction<ServiceRequestMetaDataColumnsInfo,
    String,String> {

  /**
   * Applies this function to the given arguments.
   *
   * @param colInfo the first function argument
   * @param rawRequestData the second function argument
   * @return the function result
   */
  @Override
  public String apply(ServiceRequestMetaDataColumnsInfo colInfo, String rawRequestData) {
    String extractedData=rawRequestData.substring(colInfo.getColumnStart(), colInfo.getColumnEnd());
    String  columnName=colInfo.getCooksRequestMappingColumn ();

    return extractedData;
  }

}
