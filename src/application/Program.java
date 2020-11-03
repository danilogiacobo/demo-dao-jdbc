package application;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
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
		
		System.out.println("\n=== TEST 2: Seller findByDepartment ===");
		List<Seller> list = sellerDao.findByDepartment(new Department(2, ""));
		for (Seller seller : list) {
			System.out.println(seller);
		}
		
		System.out.println("\n=== TEST 3: Seller findAll ===");
		list = sellerDao.findAll();
		for (Seller seller : list) {
			System.out.println(seller);
		}
		
		//System.out.println("\n=== TEST 4: Seller insert ===");
		//Seller newSeller = new Seller(null, "Greg", "greg@gmail.com", new Date(), 4000.0, new Department(2, ""));
		//sellerDao.insert(newSeller);
		//System.out.println("Inserted! New id = " + newSeller.getId());
		
		System.out.println("\n=== TEST 5: Seller update ===");
		seller1 = sellerDao.findById(7);
		seller1.setName("Danielzinho");
		seller1.setBaseSalary(1234.56);
		seller1.setEmail("danielzinho@gmail.com");
		//seller1.setBirthDate(new Date("2020-08-18"));
		seller1.setDepartment(new Department(1, "Computers"));
		sellerDao.update(seller1);
		System.out.println("Update completed!"); 
		
		System.out.println("\n=== TEST 6: Seller delete ===");
		System.out.print("Enter id for delete test: ");
		int id = sc.nextInt();
		sellerDao.deleteById(id);
		System.out.println("Delete completed!"); 
		
		sc.close();
	}
}
