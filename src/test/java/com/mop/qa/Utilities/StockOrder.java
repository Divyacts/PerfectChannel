package com.mop.qa.Utilities;

import java.io.Serializable;
import java.util.ArrayList;

public class StockOrder implements Serializable {
	private String count;
	private ArrayList<String> StockOrder;
	private ArrayList<String> ItemNumbers;
	private ArrayList<String> Barcodes;
	private ArrayList<String> finalBarcodes;
	private ArrayList<String> PoSoNumber;

	public ArrayList<String> getPoSoNumber() {
		return PoSoNumber;
	}

	public void setPoSoNumber(ArrayList<String> poSoNumber) {
		PoSoNumber = poSoNumber;
	}

	public ArrayList<String> getFinalBarcodes() {
		return finalBarcodes;
	}

	public void setFinalBarcodes(ArrayList<String> finalBarcodes) {
		this.finalBarcodes = finalBarcodes;
	}

	public ArrayList<String> getItemNumbers() {
		return ItemNumbers;
	}

	public void setItemNumbers(ArrayList<String> itemNumbers) {
		ItemNumbers = itemNumbers;
	}

	public ArrayList<String> getBarcodes() {
		return Barcodes;
	}

	public void setBarcodes(ArrayList<String> barcodes) {
		Barcodes = barcodes;
	}

	public String getCount() {
		return count;
	}

	public void setCount(String count) {
		this.count = count;
	}

	public ArrayList<String> getStockOrder() {
		return StockOrder;
	}

	public void setStockOrder(ArrayList<String> stockOrder) {
		StockOrder = stockOrder;
	}

}
