package com.pabs.app.beans;

import java.util.StringJoiner;

public class SampleCICSDataHolder {

  private String storeNumber;
  private String transactionCode;


  public String getStoreNumber() {
    return storeNumber;
  }

  public void setStoreNumber(String storeNumber) {
    this.storeNumber = storeNumber;
  }

  public String getTransactionCode() {
    return transactionCode;
  }

  public void setTransactionCode(String transactionCode) {
    this.transactionCode = transactionCode;
  }


  @Override
  public String toString() {
    return new StringJoiner(", ", SampleCICSDataHolder.class.getSimpleName() + "[", "]")
        .add("storeNumber='" + storeNumber + "'")
        .add("transactionCode='" + transactionCode + "'")
        .toString();
  }
}
