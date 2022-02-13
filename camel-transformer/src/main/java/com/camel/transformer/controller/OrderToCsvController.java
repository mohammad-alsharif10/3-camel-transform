package com.camel.transformer.controller;

import lombok.AllArgsConstructor;
import org.apache.camel.ProducerTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orderToCsv")
@AllArgsConstructor
public class OrderToCsvController {

   private final ProducerTemplate producerTemplate;

   @GetMapping("/bean")
   public String bean() {
      String inhouse = "0000005555000001144120091209  2319@1108";
      producerTemplate.sendBodyAndHeader("direct:start", inhouse, "Date", "20091209");
      return "ok";
   }
}
