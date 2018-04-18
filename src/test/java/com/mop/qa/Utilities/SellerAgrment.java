package com.mop.qa.Utilities;

import java.io.Serializable;
import java.util.ArrayList;

public class SellerAgrment implements Serializable {
	private String count;
	private ArrayList<String> SellerAgreement;

	public String getCount() {
		return count;
	}

	public void setCount(String count) {
		this.count = count;
	}

	public ArrayList<String> getSellerAgreement() {
		return SellerAgreement;
	}

	public void setSellerAgreement(ArrayList<String> sellerAgreement) {
		this.SellerAgreement = sellerAgreement;
	}

}
