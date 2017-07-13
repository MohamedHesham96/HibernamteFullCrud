/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Operations;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import usermanagement.Employee;
import usermanagement.EmployeeInfo;
import usermanagement.HibernateUtil;
import usermanagement.UserManagement;

/**
 *
 * @author H
 */
public class Util {

    public static void clear() {
        for (int i = 0; i <= 100; i++) {
            System.out.println("");
        }
    }

    public static void displayAll() {

        Util.clear();

        Session s = HibernateUtil.getSessionFactory().openSession();

        Criteria criteria = s.createCriteria(Employee.class);

        List<Employee> employee = criteria.list();

        System.out.println("----------------------------");
        System.out.println("        All Employees       ");
        System.out.println("----------------------------");

        displayList(employee);
    }

    public static void displayList(List<Employee> list) {

        Iterator<Employee> iterator = list.iterator();
        while (iterator.hasNext()) {
            System.out.println("----------------------------");

            Employee employee = iterator.next();

            System.out.println("ID: " + employee.getId());
            System.out.println("Username: " + employee.getUsername());
            System.out.println("Email: " + employee.getEmail());
            System.out.println("Password: " + employee.getPassword());

            System.out.println("First Name: " + employee.getInfo().getFirstName());
            System.out.println("Last Name: " + employee.getInfo().getLastName());
            System.out.println("Job: " + employee.getInfo().getJob());
            System.out.println("Salary: " + employee.getInfo().getSalary());
            System.out.println("age: " + employee.getInfo().getAge());
            System.out.println("Address: " + employee.getInfo().getAddress());
            System.out.println("Phone: " + employee.getInfo().getPhone());
        }

    }

    public static void insertOperation() {

        clear();

        Employee e = new Employee();
        EmployeeInfo info = new EmployeeInfo();

        Scanner scanner = new Scanner(System.in);

        System.out.println("--------------------------");
        System.out.println("     insert Operation     ");
        System.out.println("--------------------------");

        System.out.print("Enter Username >> ");
        e.setUsername(scanner.next());

        System.out.print("Enter Email >> ");
        e.setEmail(scanner.next());

        System.out.print("Enter Password >> ");
        e.setPassword(scanner.next());

        System.out.print("Enter First Name >> ");
        info.setFirstName(scanner.next());

        System.out.print("Enter Last Name >> ");
        info.setLastName(scanner.next());

        System.out.print("Enter Job >> ");
        info.setJob(scanner.next());

        System.out.print("Enter Salary >> ");
        info.setSalary(scanner.nextInt());

        System.out.print("Enter age >> ");
        info.setAge(scanner.nextInt());

        System.out.print("Enter Phone >> ");
        info.setPhone(scanner.next());

        System.out.print("Enter Address >> ");
        info.setAddress(scanner.next());

        e.setInfo(info);

        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(e);
        session.getTransaction().commit();
        session.close();
    }

    public static void updateOperation() {

        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        clear();
        System.out.print("Enter Employee ID >> ");
        Scanner scanner = new Scanner(System.in);
        int id = scanner.nextInt();

        Employee e = (Employee) session.get(Employee.class, id);

        if (e == null) {

            clear();
            System.out.println("There is No Employee With This ID (" + id + ")!! try Again...");
            updateOperation();

        } else {
            List<Employee> listEmp = new ArrayList<>();
            listEmp.add(e);

            Util.clear();

            System.out.println("--------------------------");
            System.out.println("Employee Information");
            System.out.println("--------------------------");

            displayList(listEmp);

            System.out.println("--------------------------\n");

            System.out.println(" 1. Update Username.");
            System.out.println(" 2. Update Email.");
            System.out.println(" 3. Update Password.");
            System.out.println(" 4. Update first Name.");
            System.out.println(" 5. Update Last Name.");
            System.out.println(" 6. Update Age.");
            System.out.println(" 7. Update Adress.");
            System.out.println(" 8. Update Phone.");
            System.out.println(" 9. Update Job.");
            System.out.println("10. Update Salary.\n");

            System.out.print("Select what you Want To update >> ");

            int number = scanner.nextInt();

            String value = "";

            switch (number) {
                case 1:
                    System.out.print("Enter New Username >> ");
                    value = scanner.next();
                    e.setUsername(value);
                    break;

                case 2:
                    System.out.print("Enter New Email >> ");
                    value = scanner.next();
                    e.setUsername(value);
                    break;

                case 3:
                    System.out.print("Enter New Password >> ");
                    value = scanner.next();
                    e.setPassword(value);
                    break;

                case 4:
                    System.out.print("Enter New First Name >> ");
                    value = scanner.next();
                    e.getInfo().setFirstName(value);
                    break;

                case 5:
                    System.out.print("Enter New Last Name >> ");
                    value = scanner.next();
                    e.getInfo().setLastName(value);
                    break;

                case 6:
                    System.out.print("Enter New Age >> ");
                    value = scanner.next();
                    e.getInfo().setAge(Integer.parseInt(value));
                    break;

                case 7:
                    System.out.print("Enter New Address >> ");
                    value = scanner.next();
                    e.getInfo().setAddress(value);
                    break;

                case 8:
                    System.out.print("Enter New Phone >> ");
                    value = scanner.next();
                    e.getInfo().setPhone(value);
                    break;

                case 9:
                    System.out.print("Enter Nwe Job >> ");
                    value = scanner.next();
                    e.getInfo().setJob(value);
                    break;

                case 10:
                    System.out.print("Enter Nwe Salary >> ");
                    value = scanner.next();
                    e.getInfo().setSalary(Double.parseDouble(value));
                    break;

            }

            session.save(e);
            session.getTransaction().commit();
            session.close();

            clear();

            System.out.println("--------------------------");
            System.out.println("Update.. Done Successfully");
            System.out.println("--------------------------");

            updateMenu();
        }
    }

    public static void deleteOperation() {

        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        clear();
        System.out.println("--------------------------");
        System.out.println("     Delete Operation     ");
        System.out.println("--------------------------");

        System.out.print("Enter Employee ID >> ");
        Scanner scanner = new Scanner(System.in);

        int id = scanner.nextInt();

        Employee e = (Employee) session.get(Employee.class, id);

        if (e == null) {

            clear();
            System.out.println("There is No Employee With This ID (" + id + ")!! try Again...");
            deleteOperation();

        } else {

            System.out.println("Are You Sure To Delete This ?");

            System.out.println("Press Y or y To Confirm.");
            System.out.println("Press Any Key To Cansel.");

            String confirm = scanner.next();

            if (confirm.equals("Y") || confirm.equals("y")) {
                session.delete(e);
                session.getTransaction().commit();
                System.out.println("----------------------------");
                System.out.println("Delete... Done Successfully.");
                System.out.println("----------------------------");
            } else {
                System.out.println("----------------------------");
                System.out.println("Delete Operation is Canseled");
                System.out.println("----------------------------");
            }

            session.close();

            deleteMenu();
        }

    }

    public static void systemInfo() {

        clear();
        Session session = HibernateUtil.getSessionFactory().openSession();

        Criteria q = session.createCriteria(EmployeeInfo.class);

        System.out.println("--------------------------");
        System.out.println("    System Information    ");
        System.out.println("--------------------------");

        String maxAge = q.setProjection(Projections.max("age")).list().toString();
        System.out.println("Max Age: " + maxAge);

        String minAge = q.setProjection(Projections.min("age")).list().toString();
        System.out.println("Min Age: " + minAge);

        String avgAge = q.setProjection(Projections.avg("age")).list().toString();
        System.out.println("AVG Age: " + avgAge);

        String empCount = q.setProjection(Projections.rowCount()).list().toString();
        System.out.println("Max Salary: " + empCount);

        String maxSalary = q.setProjection(Projections.max("salary")).list().toString();
        System.out.println("Max Salary: " + maxSalary);

        String minSalary = q.setProjection(Projections.min("salary")).list().toString();
        System.out.println("Min Salary: " + minSalary);

        String avgSalary = q.setProjection(Projections.avg("salary")).list().toString();
        System.out.println("AVG Salary: " + avgSalary);

        String sumSalary = q.setProjection(Projections.sum("salary")).list().toString();
        System.out.println("Sum Salary: " + sumSalary);

        System.out.println("--------------------------");

        systemmInfoMenu();

    }

    public static void updateMenu() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("1. Update Again");
        System.out.println("2. Exit");

        System.out.print("Select what you Want >> ");
        int caseNumber = scanner.nextInt();

        switch (caseNumber) {

            case 1:
                updateOperation();
                break;

            case 2:
                HomeMenu();
                break;
        }
    }

    public static void deleteMenu() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("1. Delete Again");
        System.out.println("2. Exit");

        System.out.print("Select what you Want >> ");
        int caseNumber = scanner.nextInt();

        switch (caseNumber) {

            case 1:
                deleteOperation();
                break;

            case 2:
                HomeMenu();
                break;
        }
    }

    public static void systemmInfoMenu() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("1. Exit");

        System.out.print("Press (1) To Exit >> ");
        int caseNumber = scanner.nextInt();

        switch (caseNumber) {

            case 1:
                HomeMenu();
                break;
        }
    }

    public static void HomeMenu() {
        clear();
        UserManagement.main((new String[5]));
    }
}
