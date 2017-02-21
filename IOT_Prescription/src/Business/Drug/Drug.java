/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Drug;

/**
 *
 * @author Bhavna Menghrajani
 */
public class Drug {

	private static int count = 0;
	private String drugName;
	private int drugId;
	private String manufacturerName;
	private int manufacturer_Id;
	private double price;

	public int getContents() {
		return contents;
	}

	public void setContents(int contents) {
		this.contents = contents;
	}

	private int contents;

	public String getDrugName() {
		return drugName;
	}

	public void setDrugName(String drugName) {
		this.drugName = drugName;
	}

	public int getDrugId() {
		return drugId;
	}

	public void setDrugId(int drugId) {
		this.drugId = drugId;
	}

	public String getManufacturerName() {
		return manufacturerName;
	}

	public void setManufacturerName(String manufacturerName) {
		this.manufacturerName = manufacturerName;
	}

	public int getManufacturer_Id() {
		return manufacturer_Id;
	}

	public void setManufacturer_Id(int manufacturer_Id) {
		this.manufacturer_Id = manufacturer_Id;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Drug() {
		count++;
		drugId = count;
	}

	@Override
	public String toString() {
		return drugName;

	}

}
