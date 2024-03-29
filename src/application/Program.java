package application;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		SellerDao sellerDao = DaoFactory.createSellerDao();

		System.out.println("=== TEST 1: seller FindById ====");
		Seller seller = sellerDao.findById(3);

		System.out.println(seller);

		System.out.println("\n=== TEST 2: seller FindByDepartment ====");
		Department department = new Department(2, null);
		List<Seller> list = sellerDao.findByDepartment(department);

		for (Seller obj : list) {
			System.out.println(obj);
		}

		System.out.println("\n=== TEST 3: seller FindAll ====");
		list = sellerDao.findAll();

		for (Seller obj : list) {
			System.out.println(obj);
		}
		
		System.out.println("\n=== TEST 4: seller INSERT ====");
		Seller newSeller = new Seller(null, "Lyvia", "teste@lyvia.com", LocalDate.now(), 4000.0, department);
		sellerDao.insert(newSeller);
		System.out.println("Inserted! new id = " + newSeller.getId());
		
		
		System.out.println("\n=== TEST 5: seller Update ====");
		seller = sellerDao.findById(1);
		seller.setName("Batman");
		sellerDao.update(seller);
		System.out.println("Update Completed");
		
		
		System.out.println("\n=== TEST 6: seller Delete ====");
		System.out.println("Enter id for delete test: ");
		int id = sc.nextInt();
		sellerDao.deleteById(id);
		System.out.println("Delete completed");
		
		sc.close();
		
	}

}
