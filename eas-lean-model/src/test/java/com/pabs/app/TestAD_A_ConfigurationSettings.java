package com.pabs.app;

import com.pabs.app.beans.SampleCICSDataHolder;
import com.pabs.app.util.config.metadata.ServiceRequestMetaDataColumnsInfo;
import com.pabs.app.util.config.metadata.ServiceRequestMetaDataHeaderInfo;
import com.pabs.app.util.config.metadata.MetaDataHarversterBean;
import com.pabs.app.util.etl.CICSDataLoader;
import com.pabs.app.util.etl.Hex2AsciiFilters;
import com.pabs.app.util.etl.SimpleExtractors;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.apache.commons.beanutils.BeanUtils;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = EasLeanModelApplication.class)
public class TestAD_A_ConfigurationSettings {

  private ServiceRequestMetaDataHeaderInfo serviceRequestMetaDataHeaderInfo=null;


  @Before
  public void init()
  {
    serviceRequestMetaDataHeaderInfo = MetaDataHarversterBean.getAssoDiscAuthMetaData();
  }


  @Test
  public void testAssoDiscAuthJSONMetaDataCollections(){

    ServiceRequestMetaDataHeaderInfo serviceRequestMetaDataHeaderInfo= MetaDataHarversterBean.getAssoDiscAuthMetaData();
    assert(!serviceRequestMetaDataHeaderInfo.getReqColumns().isEmpty());
    serviceRequestMetaDataHeaderInfo.getReqColumns().forEach(System.out::println);

  }

  @Test
  public void testHex2AsciiConversionRequiredColumns(){
        serviceRequestMetaDataHeaderInfo
        .getReqColumns().stream()
        .filter(new Hex2AsciiFilters())
            .forEach(System.out::println);


  }


  @Test
  public void testSimpleExtractProcess(){

    String rawRequestData="DR935510abcdefghijklmnop";
        serviceRequestMetaDataHeaderInfo
        .getReqColumns()
            .stream()
            .map(e->new SimpleExtractors().apply(e, rawRequestData))
            .forEach(System.out::println);

  }

  @Test
  public void testLoadCICSServiceObject(){

    SampleCICSDataHolder sampleCICSDataHolder = new SampleCICSDataHolder();

    String rawRequestData="DR935510abcdefghijklmnop";
    List<ServiceRequestMetaDataColumnsInfo> reqColumns = serviceRequestMetaDataHeaderInfo
        .getReqColumns();
    Map<String, String> collect2 =reqColumns
        .stream ()
        .collect (Collectors.toMap (
            ServiceRequestMetaDataColumnsInfo::getCooksRequestMappingColumn,
            (e -> new SimpleExtractors ().apply (e , rawRequestData)))) ;//value

    System.out.println (collect2);

  }

  @Test
  public void testPopulateCICSServiceObject() throws Exception{

    SampleCICSDataHolder sampleCICSDataHolder = new SampleCICSDataHolder();

    String rawRequestData="DR935510abcdefghijklmnop";
    List<ServiceRequestMetaDataColumnsInfo> reqColumns = serviceRequestMetaDataHeaderInfo
        .getReqColumns();
    Map<String, String> collect2 =reqColumns
        .stream ()
        .collect (Collectors.toMap (
            ServiceRequestMetaDataColumnsInfo::getCooksRequestMappingColumn,
            (e -> new SimpleExtractors ().apply (e , rawRequestData)))) ;//value

    SampleCICSDataHolder cicsDataHolder = (SampleCICSDataHolder)new CICSDataLoader ()
        .apply (sampleCICSDataHolder , collect2);

    System.out.println (cicsDataHolder);

  }




}


