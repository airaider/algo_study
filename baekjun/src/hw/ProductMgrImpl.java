package hw;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class ProductMgrImpl implements IProductMgr {
	
	private String filename = "product.dat";
	private ArrayList<Product> products;
	private static ProductMgrImpl instance = new ProductMgrImpl(); 
	
	public ProductMgrImpl() {
		load();
	}
	

	public static ProductMgrImpl getinstance() {
		return instance;
	}
	

	
//	private String filename = "product.dat";
//	private ArrayList<Product> products;
//	private static ProductMgrImpl instance = new ProductMgrImpl();
//	
//	public ProductMgrImpl() {
//		load();
//	}
//	public static ProductMgrImpl getinstance() {
//		return instance;
//	}
//	
	private int findIndex(String no) {
		if(no!=null) {
			for(int i=0,size=products.size();i<size;i++) {
				if(no.equals(products.get(i).getNo())) {
					return i;
				}
			}
		}
		return -1;
	}
	
	@Override
	public void add(Product pr) throws DuplicateException {
		if(pr!=null) {
			String no = pr.getNo();
			int index = findIndex(no);
			if(index>-1) {
				throw new DuplicateException();
			}
			else {
				products.add(pr);
			}
		}
		else {
			
		}
	}

	@Override
	public List<Product> search() throws CodeNotFoundException {
		return products;
	}

	@Override
	public List<Product> search400() throws ProductNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Product> search50() throws ProductNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void save() {
		FileOutputStream fos = null;
		ObjectOutputStream oos = null;
		try {
			fos = new FileOutputStream(filename);
			oos = new ObjectOutputStream(fos);
			oos.writeObject(products);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			if(oos!=null) {
				try {
					oos.close();
				} catch (Exception e2) {
				}
			}
		}

	}

	@Override
	public void load() {
		FileInputStream fis = null;
		ObjectInputStream ois = null;
		File file = null;
		try {
			file = new File(filename);
			if(file.exists() && file.canRead()) {
				fis = new FileInputStream(file);
				ois = new ObjectInputStream(fis);
				products = (ArrayList)ois.readObject();
			}
			else {
				products = new ArrayList<Product>();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(ois!=null) {try {ois.close();} catch (Exception e2) {}}
		}

	}

}
