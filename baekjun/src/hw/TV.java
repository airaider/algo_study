package hw;

public class TV extends Product {
	private int inch;

	public TV() {
	}

	public TV(String no, String name, int price, int quantity, int inch) {
		super(no, name, price, quantity);
		setInch(inch);
	}

	public int getInch() {
		return inch;
	}

	public void setInch(int inch) {
		if(inch<=0) throw new IllegalArgumentException("0인치 불가");
		this.inch=inch;
	}

	@Override
	public String toString() {
		return "TV [inch=" + inch + super.toString().split("\\[")[1];
	}
	
}
