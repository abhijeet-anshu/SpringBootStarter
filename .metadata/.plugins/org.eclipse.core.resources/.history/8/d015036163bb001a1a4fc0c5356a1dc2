package com.repository;

import java.util.Optional;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.bean.ExchangeValue;

@Repository
public interface CurrencyExchangeRepository extends JpaRepository<ExchangeValue, Long>{
	 Optional<ExchangeValue> findByFromAndTo(String from,String to);

}








//public interface CurrencyExchangeRepository {
//	
//	 Optional<ExchangeValue> findByFromAndTo(String from,String to);
//
//}
