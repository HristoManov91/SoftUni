import entities.Address;
import entities.Employee;
import entities.Project;
import entities.Town;

import javax.persistence.EntityManager;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;

public class Engine implements Runnable{

    private final EntityManager entityManager;
    private final BufferedReader reader;

    public Engine(EntityManager entityManager) {
        this.entityManager = entityManager;
        this.reader = new BufferedReader(new InputStreamReader(System.in));
    }

    @Override
    public void run() {
//        changeCasingEx2();
//        try {
//            containsEmployeeEx3();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        employeesWithSalaryOver50000Ex4();
//        employeesFromDepartmentEx5();
//        try {
//            addingNewAddressAndUpdatingEmployeeEx6();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

//        addressesWithEmployeeCountEx7();

//        try {
//            getEmployeeWithProjectEx8();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

//        findLatest10ProjectsEx9();

        increaseSalariesEx10();
    }

    private void increaseSalariesEx10() {
        entityManager.getTransaction().begin();
        entityManager.createQuery("UPDATE Employee e SET e.salary = e.salary * 1.12 " +
                "WHERE e.department.id IN (1,2,4,11)")
                .executeUpdate();
        entityManager.getTransaction().commit();

        entityManager.createQuery("SELECT e FROM Employee e WHERE e.department.id IN (1,2,4,11)",Employee.class)
                .getResultStream()
                .forEach(employee -> System.out.printf("%s %s ($%.2f)%n",employee.getFirstName() , employee.getLastName(),
                        employee.getSalary()));
    }

    private void findLatest10ProjectsEx9() {
        List<Project> projects = entityManager
                .createQuery("SELECT p FROM Project p " +
                        "ORDER BY p.startDate DESC")
                .setMaxResults(10)
                .getResultList();

        projects.stream().sorted(Comparator.comparing(Project::getName))
                .forEach(project -> System.out.printf("Project name: %s%n" +
                        "\tProject Description: %s%n" +
                        "\tProject Start Date: %s%n" +
                        "\tProject End Date: %s%n", project.getName() , project.getDescription() , project.getStartDate(),
                project.getEndDate()));
    }

    private void getEmployeeWithProjectEx8() throws IOException {
        System.out.println("Enter valid employee id:");
        int id = Integer.parseInt(reader.readLine());

        Employee employee = entityManager.find(Employee.class , id);

        System.out.printf("%s %s - %s %n", employee.getFirstName() , employee.getLastName() , employee.getJobTitle());
        employee.getProjects().stream().sorted(Comparator.comparing(Project::getName))
                .forEach(project -> System.out.printf("\t%s%n", project.getName()));
    }

    private void addressesWithEmployeeCountEx7() {
        List<Address> addresses = entityManager.createQuery("SELECT a FROM Address a " +
                "ORDER BY a.employees.size DESC ", Address.class)
                .setMaxResults(10)
                .getResultList();

        addresses.forEach(address -> {
            System.out.printf("%s , %s - %d %n", address.getText() , address.getTown().getName() ,
                    address.getEmployees().size());
        });
    }

    private void addingNewAddressAndUpdatingEmployeeEx6() throws IOException {
        Address address = createAddress("Vitoshka 15");

        System.out.println("Enter employee last name:");
        String lastName = reader.readLine();

        Employee employee = entityManager.createQuery("SELECT e FROM Employee e " +
                "WHERE e.lastName = :name", Employee.class).setParameter("name" , lastName).getSingleResult();

        entityManager.getTransaction().begin();
        employee.setAddress(address);
        entityManager.getTransaction().commit();
    }

    private Address createAddress(String addressText) {
        Address address = new Address();
        address.setText(addressText);

        entityManager.getTransaction().begin();
        entityManager.persist(address);
        entityManager.getTransaction().commit();

        return address;
    }

    private void employeesFromDepartmentEx5() {
        entityManager
                .createQuery("SELECT e FROM Employee e " +
                        "WHERE e.department.name = 'Research and Development' " +
                        "ORDER BY e.salary, e.id", Employee.class)
                .getResultList()
                .forEach(employee -> {
                    System.out.printf("%s %s from Research and Development - $%.2f%n",
                            employee.getFirstName() , employee.getLastName() , employee.getSalary());
                });


    }

    private void employeesWithSalaryOver50000Ex4() {
        entityManager.createQuery("SELECT e FROM Employee e WHERE e.salary > 50000", Employee.class)
                .getResultStream()
                .map(Employee::getFirstName)
                .forEach(System.out::println);
    }


    private void containsEmployeeEx3() throws IOException {
        System.out.println("Enter employee full:");
        String fullName = reader.readLine();

        List<Employee> names = entityManager.createQuery("SELECT e FROM Employee e " +
                "WHERE concat(e.firstName , ' ' , e.lastName) = :name", Employee.class)
                .setParameter("name" , fullName)
                .getResultList();

        System.out.println(names.isEmpty() ? "No" : "Yes");
    }

    private void changeCasingEx2() {
        List<Town> towns = entityManager
                .createQuery("SELECT t FROM Town  t " +
                        "WHERE LENGTH(t.name) <= 5", Town.class)
                .getResultList();
        entityManager.getTransaction().begin();
        towns.forEach(entityManager::detach);

        for (Town town : towns) {
            town.setName(town.getName().toLowerCase());
        }
        towns.forEach(entityManager::merge);
        entityManager.flush();
        entityManager.getTransaction().commit();
        System.out.println();
    }
}
