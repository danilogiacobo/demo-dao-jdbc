package application;

import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;
import model.entities.Seller;

public class Program2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("=== TEST 1: Department findById ===");
		
		DepartmentDao departmentDao = DaoFactory.createDepartmentDao();
		Department dep1 = departmentDao.findById(6);
		System.out.println(dep1);
		Department dep2 = departmentDao.findById(2);
		System.out.println(dep2);
		
		System.out.println("\n=== TEST 2: Department findAll ===");
		List<Department> list = departmentDao.findAll();
		for (Department department : list) {
			System.out.println(department);
		}
		
		//System.out.println("\n=== TEST 3: Department insert ===");
		//Department newDepartment = new Department(null, "Toys");
		//departmentDao.insert(newDepartment);
		//System.out.println("Inserted! New id = " + newDepartment.getId());
		
		System.out.println("\n=== TEST 3: Department update ===");
		dep1 = departmentDao.findById(7);
		dep1.setName("Fruits");
		departmentDao.update(dep1);
		System.out.println("Update completed!"); 
		
		System.out.println("\n=== TEST 4: Department delete ===");
		System.out.print("Enter id for delete test: ");
		int id = sc.nextInt();
		departmentDao.deleteById(id);
		System.out.println("Delete completed!");		
		
		sc.close();
	}
}
