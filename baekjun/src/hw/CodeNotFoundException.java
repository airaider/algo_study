package hw;

public class CodeNotFoundException extends Exception {
	public CodeNotFoundException() {
		super("해당 제품번호가 존재하지 않습니다.");
	}
	public CodeNotFoundException(String msg) {
		super(msg);
	}
}
