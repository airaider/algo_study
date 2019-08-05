package hw;

public class Refrigerator extends Product {
	private int liter;

	public Refrigerator() {
	}

	public Refrigerator(String no, String name, int price, int quantity, int liter) {
		super(no, name, price, quantity);
		setLiter(liter);
	}

	public int getLiter() {
		return liter;
	}

	public void setLiter(int liter) {
		if(liter<=0) throw new IllegalArgumentException("0리터 불가");
	}

	@Override
	public String toString() {
		return "Refrigerator [liter=" + liter + super.toString().split("\\[")[1];
	}
	
}
