package com.controllers;

import java.math.BigDecimal;

import org.apache.logging.log4j.Level;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.bean.ConversionValue;
import com.repository.CurrencyExchangeRepository;

@RestController
public class CurrencyExchangeController {

	@GetMapping("/currency-exchange-dummy/to/{to}/from/{from}")
	public ConversionValue getExchangeValue(@PathVariable String to, @PathVariable String from) {
		return new ConversionValue(1l, from, to, BigDecimal.valueOf(1000));
	}

	@Autowired
	Environment env;

	@GetMapping("/currency-exchange-port/to/{to}/from/{from}")
	public ConversionValue getExchangeValue_port(@PathVariable String to, @PathVariable String from) {
		ConversionValue ex = new ConversionValue(1l, from, to, BigDecimal.valueOf(1000));
		ex.setPort(Integer.parseInt(env.getProperty("local.server.port")));
		return ex;
	}

	@Autowired
	CurrencyExchangeRepository repository;

	// *** read the data from repository**//
	@GetMapping("/currency-exchange-DB/to/{to}/from/{from}")
	public ConversionValue getExchnageValue_DataBase(@PathVariable String from, @PathVariable String to) {

		ConversionValue exchangeValue = repository.findByFromAndTo(from, to).get();
		exchangeValue.setPort(Integer.parseInt(env.getProperty("local.server.port")));
		return exchangeValue;
	}

}
