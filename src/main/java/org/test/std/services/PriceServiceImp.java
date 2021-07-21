package org.test.std.services;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.test.std.models.Price;
import org.test.std.repositories.PriceRepository;

@Service("PriceService")
@Transactional
public class PriceServiceImp implements PriceService {

	public List<Price> getStockPrices() {
		return PriceRepository.getStockPrices();

	}
}
