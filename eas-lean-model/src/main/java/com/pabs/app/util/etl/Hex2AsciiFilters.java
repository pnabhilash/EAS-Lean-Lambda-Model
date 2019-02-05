package com.pabs.app.util.etl;

import com.pabs.app.util.config.metadata.ServiceRequestMetaDataColumnsInfo;
import java.util.function.Predicate;

public class Hex2AsciiFilters implements
    Predicate<ServiceRequestMetaDataColumnsInfo> {


  /**
   * Evaluates this predicate on the given argument.
   *
   * @param serviceRequestMetaDataColumnsInfo the input argument
   * @return {@code true} if the input argument matches the predicate, otherwise {@code false}
   */
  @Override
  public boolean test(ServiceRequestMetaDataColumnsInfo serviceRequestMetaDataColumnsInfo) {
    return (serviceRequestMetaDataColumnsInfo.getColumnHex2Ascii());
  }
}
