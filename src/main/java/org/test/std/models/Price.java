package org.test.std.models;

import java.time.LocalDateTime;

public class Price {

	/**
	 * Identifier (unique)
	 */
	private long id;
	/**
	 * instrumentName
	 */
	private String instrumentName;
	/**
	 * sell price
	 */
	private double bid;
	/**
	 * buy price
	 */
	private double ask;
	private LocalDateTime timeStamp;

	public Price() {

	}

	public Price(long id, String instrumentName, double bid, double ask, LocalDateTime timeStamp) {
		this.id = id;
		this.instrumentName = instrumentName;
		this.bid = bid;
		this.ask = ask;
		this.timeStamp = timeStamp;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getInstrumentName() {
		return instrumentName;
	}

	public void setInstrumentName(String instrumentName) {
		this.instrumentName = instrumentName;
	}

	public double getBid() {
		return bid;
	}

	public void setBid(double bid) {
		this.bid = bid;
	}

	public double getAsk() {
		return ask;
	}

	public void setAsk(double ask) {
		this.ask = ask;
	}

	public LocalDateTime getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(LocalDateTime timeStamp) {
		this.timeStamp = timeStamp;
	}

	@Override
	public String toString() {
		return "\n\nPrice\n" + "----------------------\n" + " Id: " + id + "\n InstrumentName: " + instrumentName
				+ "\n BID: " + Math.round(bid * 1000.0) / 1000.0 + "\n ASK: " + Math.round(ask * 1000.0) / 1000.0 + "\n Date: "
				+ timeStamp;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Price other = (Price) obj;
		if (id != other.id)
			return false;
		return true;
	}

}
