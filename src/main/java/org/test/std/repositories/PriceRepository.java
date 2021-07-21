package org.test.std.repositories;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.test.std.models.Price;

/**
 * Simulamos la obtencion de datos de bd mediante este metodo que obtiene los
 * datos del fichero CSV
 *
 */
public class PriceRepository {

	public static final String SEPARATOR = ",";

	/**
	 * Method to read the CSV doc and create the list of prices
	 */
	public static List<Price> getStockPrices() {
		List<Price> listaPrecios = new ArrayList<>();

		try (InputStream inputStream = PriceRepository.class.getResourceAsStream("/message.csv");
				BufferedReader br = new BufferedReader(new InputStreamReader(inputStream))) {

			String line = br.readLine();
			while (null != line) {
				String[] fields = line.split(SEPARATOR);
				System.out.println(Arrays.toString(fields));
				Price p = new Price(Long.valueOf(fields[0]), fields[1], Double.valueOf(fields[2]),
						Double.valueOf(fields[3]), StringToDateTime(fields[4]));
				listaPrecios.add(p);

				line = br.readLine();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return listaPrecios;

	}

	/**
	 * Converter from string to localDateTime
	 * @param dateTime
	 * @return
	 */
	private static LocalDateTime StringToDateTime(String dateTime) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss.SSS");
		return LocalDateTime.parse(dateTime, formatter);
	}
}
