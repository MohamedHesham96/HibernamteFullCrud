/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Operations;

import static Operations.Util.HomeMenu;
import static Operations.Util.clear;
import static Operations.Util.deleteOperation;
import static Operations.Util.updateOperation;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import usermanagement.Employee;
import usermanagement.EmployeeInfo;
import usermanagement.HibernateUtil;

/**
 *
 * @author H
 */
public class Search {

    private static List<Employee> coverter(List<EmployeeInfo> employeeInfo) {

        List<Employee> employees = new ArrayList<Employee>();

        for (EmployeeInfo ei : employeeInfo) {
            employees.add(ei.getEmployee());
        }
        return employees;

    }

    public static void searchMenu() {

        Scanner scanner = new Scanner(System.in);

        System.out.println("--------------------------------");
        System.out.println("1. Search Again");
        System.out.println("2. Exit");

        System.out.print("Select what you Want >> ");
        int caseNumber = scanner.nextInt();

        switch (caseNumber) {

            case 1:
                searchOperation();
                break;

            case 2:
                Util.HomeMenu();
                break;
        }

    }

    public static void searchOperation() {
        clear();
        List<Employee> employees = new ArrayList<>();
        System.out.println("--------------------------------");
        System.out.println("        Search Operation        ");
        System.out.println("--------------------------------");

        System.out.println(" 1. Search By ID.");
        System.out.println(" 2. Search By Username.");
        System.out.println(" 3. Search By Email.");
        System.out.println(" 4. Search By First Name.");
        System.out.println(" 5. Search By Last Name.");
        System.out.println(" 6. Search By Age.");
        System.out.println(" 7. Search By Salary.");
        System.out.println(" 8. Search By Salary With Range.");
        System.out.println(" 9. Search By Job.");
        System.out.println("10. Search By Address.");
        System.out.println("11. Search By Phone.");
        System.out.println("--------------------------------");

        System.out.print("Select Search Way >> ");

        String caseNumber = (new Scanner(System.in)).next();

        switch (caseNumber) {

            case "1":
                System.out.print("Enter ID >> ");
                int id = (new Scanner(System.in)).nextInt();
                Util.clear();
                employees = searchByID(id);
                break;

            case "2":
                System.out.print("Enter Username >> ");
                String value = (new Scanner(System.in)).next();
                Util.clear();
                employees = searchByUserName(value);
                break;

            case "3":
                System.out.print("Enter Email >> ");
                value = (new Scanner(System.in)).next();
                Util.clear();
                employees = searchByEmail(value);
                break;

            case "4":
                System.out.print("Enter First Name >> ");
                value = (new Scanner(System.in)).next();
                employees = searchByFirstName(value);
                break;

            case "5":
                System.out.print("Enter Last Name >> ");
                value = (new Scanner(System.in)).next();
                searchByLastName(value);
                break;

            case "6":
                System.out.print("Enter Age >> ");
                int age = (new Scanner(System.in)).nextInt();
                employees = searchByAge(age);
                break;
            case "7":
                System.out.print("Enter Salary >> ");
                double salary = (new Scanner(System.in)).nextDouble();
                employees = searchBySalary(salary);
                break;

            case "8":
                System.out.print("Enter Low Salary Value >> ");
                double from = (new Scanner(System.in)).nextDouble();
                System.out.print("Enter High Salary Value >> ");
                double to = (new Scanner(System.in)).nextDouble();
                employees = searchBySalaryRange(from, to);
                break;

            case "9":
                System.out.print("Enter Job >> ");
                value = (new Scanner(System.in)).next();
                employees = searchByJob(value);
                break;

            case "10":
                System.out.print("Enter Address >> ");
                value = (new Scanner(System.in)).next();
                employees = searchByAddress(value);
                break;

            case "11":
                System.out.print("Enter Phone >> ");
                value = (new Scanner(System.in)).next();
                employees = searchByPhone(value);
                break;

        }

        if (employees.isEmpty()) {

            clear();
            System.out.println("No Result !! try Again...");
            searchMenu();
        } else {

            Util.clear();
            Util.displayList(employees);
            searchMenu();

        }
    }

    public static List<Employee> searchByID(int id) {

        Session s = HibernateUtil.getSessionFactory().openSession();

        Criteria criteria = s.createCriteria(Employee.class);

        criteria.add(Restrictions.eq("id", id));

        List<Employee> employee = criteria.list();

        return employee;
    }

    public static List<Employee> searchByUserName(String username) {

        Session s = HibernateUtil.getSessionFactory().openSession();

        Criteria criteria = s.createCriteria(Employee.class);

        criteria.add(Restrictions.ilike("username", username, MatchMode.ANYWHERE));

        List<Employee> employee = criteria.list();

        return employee;
    }

    public static List<Employee> searchByEmail(String email) {

        Session s = HibernateUtil.getSessionFactory().openSession();

        Criteria criteria = s.createCriteria(Employee.class);

        criteria.add(Restrictions.ilike("email", email, MatchMode.ANYWHERE));

        List<Employee> employee = criteria.list();

        return employee;
    }

    public static List<Employee> searchByFirstName(String firstName) {

        Session s = HibernateUtil.getSessionFactory().openSession();

        Criteria q = s.createCriteria(EmployeeInfo.class);
        q.add(Restrictions.ilike("firstName", firstName, MatchMode.ANYWHERE));

        List<EmployeeInfo> employeeInfo = q.list();

        return coverter(employeeInfo);

    }

    public static List<Employee> searchByLastName(String lastName) {

        Session s = HibernateUtil.getSessionFactory().openSession();

        Criteria q = s.createCriteria(EmployeeInfo.class);
        q.add(Restrictions.ilike("lastName", lastName, MatchMode.ANYWHERE));

        List<EmployeeInfo> employeeInfo = q.list();

        return coverter(employeeInfo);

    }

    public static List<Employee> searchByPhone(String phone) {

        Session s = HibernateUtil.getSessionFactory().openSession();

        Criteria q = s.createCriteria(EmployeeInfo.class);
        q.add(Restrictions.eq("phone", phone));

        List<EmployeeInfo> employeeInfo = q.list();

        return coverter(employeeInfo);

    }

    public static List<Employee> searchByAddress(String Address) {

        Session s = HibernateUtil.getSessionFactory().openSession();

        Criteria q = s.createCriteria(EmployeeInfo.class);
        q.add(Restrictions.ilike("address", Address, MatchMode.ANYWHERE));

        List<EmployeeInfo> employeeInfo = q.list();

        return coverter(employeeInfo);

    }

    public static List<Employee> searchByAge(int age) {

        Session s = HibernateUtil.getSessionFactory().openSession();

        Criteria q = s.createCriteria(EmployeeInfo.class);
        q.add(Restrictions.eq("age", age));

        List<EmployeeInfo> employeeInfo = q.list();

        return coverter(employeeInfo);

    }

    public static List<Employee> searchBySalary(double salary) {

        Session s = HibernateUtil.getSessionFactory().openSession();

        Criteria q = s.createCriteria(EmployeeInfo.class);
        q.add(Restrictions.eq("salary", salary));

        List<EmployeeInfo> employeeInfo = q.list();

        return coverter(employeeInfo);

    }

    public static List<Employee> searchBySalaryRange(double from, double to) {

        Session s = HibernateUtil.getSessionFactory().openSession();

        Criteria q = s.createCriteria(EmployeeInfo.class);
        q.add(Restrictions.between("salary", from, to));

        List<EmployeeInfo> employeeInfo = q.list();

        return coverter(employeeInfo);

    }

    public static List<Employee> searchByJob(String job) {

        Session s = HibernateUtil.getSessionFactory().openSession();

        Criteria q = s.createCriteria(EmployeeInfo.class);
        q.add(Restrictions.ilike("job", job, MatchMode.ANYWHERE));

        List<EmployeeInfo> employeeInfo = q.list();

        return coverter(employeeInfo);

    }

}
