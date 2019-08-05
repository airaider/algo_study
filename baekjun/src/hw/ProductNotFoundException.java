package hw;

public class ProductNotFoundException extends Exception {
	public ProductNotFoundException() {
		super("제품을 찾을 수가 없습니다.");
	}
	public ProductNotFoundException(String msg) {
		super(msg);
	}
}
