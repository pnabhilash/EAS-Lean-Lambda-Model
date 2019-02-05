package com.pabs.app.util.config.metadata;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class ServiceRequestMetaDataColumnsInfo {

  @SerializedName("columnName")
  @Expose
  private String columnName;
  @SerializedName("columnStart")
  @Expose
  private Integer columnStart;
  @SerializedName("columnEnd")
  @Expose
  private Integer columnEnd;
  @SerializedName("columnHex2Ascii")
  @Expose
  private Boolean columnHex2Ascii;
  @SerializedName("cooksRequestMappingColumn")
  @Expose
  private String cooksRequestMappingColumn;

  /**
   * No args constructor for use in serialization
   *
   */
  public ServiceRequestMetaDataColumnsInfo() {
  }

  /**
   *
   * @param cooksRequestMappingColumn
   * @param columnEnd
   * @param columnHex2Ascii
   * @param columnName
   * @param columnStart
   */
  public ServiceRequestMetaDataColumnsInfo(String columnName, Integer columnStart, Integer columnEnd, Boolean columnHex2Ascii, String cooksRequestMappingColumn) {
    super();
    this.columnName = columnName;
    this.columnStart = columnStart;
    this.columnEnd = columnEnd;
    this.columnHex2Ascii = columnHex2Ascii;
    this.cooksRequestMappingColumn = cooksRequestMappingColumn;
  }

  public String getColumnName() {
    return columnName;
  }

  public void setColumnName(String columnName) {
    this.columnName = columnName;
  }

  public Integer getColumnStart() {
    return columnStart;
  }

  public void setColumnStart(Integer columnStart) {
    this.columnStart = columnStart;
  }

  public Integer getColumnEnd() {
    return columnEnd;
  }

  public void setColumnEnd(Integer columnEnd) {
    this.columnEnd = columnEnd;
  }

  public Boolean getColumnHex2Ascii() {
    return columnHex2Ascii;
  }

  public void setColumnHex2Ascii(Boolean columnHex2Ascii) {
    this.columnHex2Ascii = columnHex2Ascii;
  }

  public String getCooksRequestMappingColumn() {
    return cooksRequestMappingColumn;
  }

  public void setCooksRequestMappingColumn(String cooksRequestMappingColumn) {
    this.cooksRequestMappingColumn = cooksRequestMappingColumn;
  }

  @Override
  public String toString() {
    return new ToStringBuilder(this).append("columnName", columnName).append("columnStart", columnStart).append("columnEnd", columnEnd).append("columnHex2Ascii", columnHex2Ascii).append("cooksRequestMappingColumn", cooksRequestMappingColumn).toString();
  }

}