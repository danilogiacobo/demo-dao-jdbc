package application;

import java.util.List;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {
		//Department obj = new Department(1, "Books");
		//System.out.println(obj);
		//Seller seller = new Seller(21, "Bob", "bob@gmail.com", new Date(), 3000.0, obj);
		//System.out.println(seller);
		
		System.out.println("=== TEST 1: Seller findById ===");
		
		SellerDao sellerDao = DaoFactory.createSellerDao();
		Seller seller1 = sellerDao.findById(1);
		System.out.println(seller1);
		Seller seller2 = sellerDao.findById(2);
		System.out.println(seller2);
		
		System.out.println("=== TEST 2: Seller findByDepartment ===");
		List<Seller> list = sellerDao.findByDepartment(new Department(2, ""));
		for (Seller seller : list) {
			System.out.println(seller);
		}
	}

}
