/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package usermanagement;

import Operations.Search;
import Operations.Util;
import java.util.Scanner;
import org.hibernate.Session;

/**
 *
 * @author H
 */
public class UserManagement {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        /*  for (int i = 1; i <= 10; i++) {

            EmployeeInfo info = new EmployeeInfo();

            info.setFirstName("ahmed" + i);
            info.setLastName("gamal" + i);
            info.setAddress("address_" + i);

            info.setSalary(500 + (i * 50));
            info.setPhone("01121000" + i);
            info.setJob("job_" + i);
            info.setAge(30 + i);

            Employee e = new Employee();
            e.setUsername("username" + i);

            e.setPassword("pass" + i);
            e.setEmail("mail_" + i + "@gmail.com");
            e.setInfo(info);

            Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(e);
            session.getTransaction().commit();
        }
         */
        Scanner scanner = new Scanner(System.in);

        System.out.println("--------------------------");
        System.out.println("------     Home     ------");
        System.out.println("--------------------------");
        System.out.println("1. Display All Employees.");
        System.out.println("2. Add new Employee.");
        System.out.println("3. Search For an Employee.");
        System.out.println("4. update an Employees.");
        System.out.println("5. delete an Employee.");
        System.out.println("6. System Information.");
        System.out.println("--------------------------");

        System.out.print("Select What you Want Form this Operations >> ");

        String caseNumber = scanner.next();

        switch (caseNumber) {

            case "1":
                Util.displayAll();
                break;

            case "2":
                Util.insertOperation();
                break;

            case "3":
                Search.searchOperation();
                break;

            case "4":
                Util.updateOperation();
                break;

            case "5":
                Util.deleteOperation();
                break;

            case "6":
                Util.systemInfo();
                break;

        }

    }

}
