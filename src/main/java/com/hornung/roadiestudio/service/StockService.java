package com.hornung.roadiestudio.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hornung.roadiestudio.model.Stock;
import com.hornung.roadiestudio.repository.Stocks;

@Service
public class StockService {
	
	@Autowired
	private Stocks stock;
	
//	public void save(com.hornung.roadiestudio.model.Stock stock){
//
//		//TODO regras de negócio
//		this.stock.save(stock);
//	}
	
	public void save(Stock stock) {
		this.stock.save(stock);
	}
	
	public void delete(int codStock) {
		this.stock.delete(codStock);
	}


}
