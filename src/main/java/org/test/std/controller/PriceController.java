package org.test.std.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.test.std.models.Price;
import org.test.std.services.PriceService;

@RestController
@RequestMapping("/price")
public class PriceController {

	@Autowired
	PriceService priceService;

	@GetMapping("/getStockPrices")
	public List<Price> getStockPrices() {
		List<Price> stockPrices = priceService.getStockPrices();

		return stockPrices.stream().map(PriceController::addComission).collect(Collectors.toList());

	}

	/**
	 * Add commisison to buy and sell
	 * 
	 * @param price
	 * @return
	 */
	private static Price addComission(Price price) {
		price.setAsk(price.getAsk() + price.getAsk() * 0.1);
		price.setBid(price.getBid() - price.getAsk() * 0.1);
		return price;
	}

}
