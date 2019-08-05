package hw;

public class DuplicateException extends Exception {
	public DuplicateException() {
		super("이미 존재하는 제품 번호입니다.");
	}
	public DuplicateException(String msg) {
		super(msg);
	}
}
