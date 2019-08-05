package hw;

import java.util.List;

public interface IProductMgr {
	void add(Product pr) throws DuplicateException;
	List<Product> search() throws CodeNotFoundException;
	List<Product> search400() throws ProductNotFoundException;
	List<Product> search50() throws ProductNotFoundException;
	void save();
	void load();
	
}
