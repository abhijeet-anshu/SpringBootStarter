package com.proxy;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.bean.ConversionValue;

@FeignClient(value="currency-exchange-service")//,url="http://localhost:8000")
@RibbonClient(name="currency-exchange-service")
public interface ConversionValueProxy {
	
	@GetMapping("/currency-exchange-DB/to/{to}/from/{from}")
	public ConversionValue getExchangeValue_DataBase(@PathVariable("from") String from, 
													 @PathVariable("to") String to);
	
	
}
