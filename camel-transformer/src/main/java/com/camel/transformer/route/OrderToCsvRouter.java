package com.camel.transformer.route;

import com.camel.transformer.processor.OrderToCsvBean;
import lombok.AllArgsConstructor;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class OrderToCsvRouter extends RouteBuilder {


   @Override
   public void configure() throws Exception {
      from("direct:start")
              // format inhouse to csv using a bean
              .bean(OrderToCsvBean.class)
              // and save it to a file
              .to("file://orders/received?fileName=report-${header.Date}.csv");
   }
}
