import java.math.BigDecimal;
import java.math.RoundingMode;

public class Item {
	
	private String name;
	private int count;
	private double price;
	private double totalPrice;
	private int basicTaxes;
	private int importTaxes;
	private double taxes;
	private boolean isImported;
	private boolean isBasicTax;
	
	public Item(String name, int count, double price, boolean isImported,boolean isBasicTax) {
		
		this.name = name;
		this.count = count;
		this.price = price;
		this.isImported = isImported;
		this.isBasicTax = isBasicTax;
		this.basicTax();
		this.importTax();
		this.computation();
	}

	public double getTotalPrice() {
		return totalPrice;
	}
	
	public double getTaxes() {
		return taxes;
	}

	private void basicTax() {
		if(isBasicTax) {
			basicTaxes = 10;
		}
		else {
			basicTaxes = 0;
		}
	}
	
	private void importTax() {
		if(isImported) {
			importTaxes = 5;
		}
		else {
			importTaxes = 0;
		}
	}
	
	private void computation() {
		taxes = ((basicTaxes+importTaxes) * (price * count))/(100);
		totalPrice = (price * count) +  taxes;

	}

	@Override
	public String toString() {
		String result = new String();
		BigDecimal bd = new BigDecimal(Double.toString(totalPrice));
		bd = bd.setScale(2, RoundingMode.HALF_UP);
		if(!isImported) {
			result = count + " " + name + ": " + bd;
		}
		else {
			
			result = count + " imported" + " " + name + ": " + bd;
		}
		return result;
	}

}
