import entities.Address;
import entities.Employee;
import entities.Project;
import entities.Town;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.List;

public class Engine implements Runnable {

    private final EntityManager entityManager;
    private BufferedReader reader;

    public Engine(EntityManager em) {
        this.entityManager = em;
        reader = new BufferedReader(new InputStreamReader(System.in));
    }

    @Override
    public void run() {
        System.out.println("Enter number of task you want to test:");
        String input;
        try {
            input = reader.readLine();
            while (input != null && !input.equals("Stop")) {
                int numberOfTask = Integer.parseInt(input);
                switch (numberOfTask) {
                    case 2 -> changeCasingEx2();
                    case 3 -> containsEmployeeByNameEx3();
                    case 4 -> getEmployeesFirstNameWithSalaryOver50000Ex4();
                    case 5 -> getEmployeesFromDepartmentEx5();
                    case 6 -> addingNewAddressesAndUpdateEmployeeEx6();
                    case 7 -> addressWithEmployeeCountEx7();
                    case 8 -> getEmployeeAndProjectByEmployeeIdEx8();
                    case 9 -> findLatest10ProjectsEx9();
                    case 10 -> increaseSalariesEx10();
                    case 11 -> findEmployeesByFirstNameEx11();
                    case 12 -> maxSalariesForEachDepartmentEx12();
                    case 13 -> removeTownEx13();
                    default -> System.out.printf("We don't have a task with number %s." +
                            "Please enter valid number of task from 2 to 13%n", input);
                }
                System.out.println("Enter number of task you want to test or Stop:");
                input = reader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Thank you :)");
    }

    // -------------------------- 2 --------------------------

    private void changeCasingEx2() {
        entityManager.getTransaction().begin();
        Query query = entityManager.createQuery("UPDATE Town t SET t.name = UPPER(t.name) WHERE LENGTH(t.name) <= 5 ");
        int effectedRows = query.executeUpdate();

        System.out.println(effectedRows);

        entityManager.getTransaction().commit();
    }

    // -------------------------- 3 --------------------------

    private void containsEmployeeByNameEx3() throws IOException {
        System.out.println("Enter first and last name for person to check:");
        String[] input = reader.readLine().split("\\s+");
        if (input.length != 2){
            System.out.println("Invalid name");
            return;
        }
        String firstName = input[0];
        String lastName = input[1];
        Long singleResult = entityManager
                .createQuery("SELECT COUNT(e) FROM Employee e " +
                        "WHERE e.firstName = :first_name AND e.lastName = :last_name" , Long.class)
                .setParameter("first_name" , firstName)
                .setParameter("last_name" , lastName)
                .getSingleResult();

        System.out.println( singleResult == 1 ? "Yes" : "No");
    }

    // -------------------------- 4 --------------------------

    private void getEmployeesFirstNameWithSalaryOver50000Ex4() {
        entityManager.createQuery("SELECT e FROM Employee e WHERE e.salary > 50000", Employee.class)
                .getResultStream()
                .map(Employee::getFirstName)
                .forEach(System.out::println);
        System.out.println("If result you see only one name Brian comment this two rows in persistence.xml:\n" +
                "<property name=\"hibernate.show_sql\" value=\"true\"/>\n" +
                "<property name=\"hibernate.format_sql\" value=\"true\"/>");
        System.out.println("If result is incorrect use fresh database");
    }

    // -------------------------- 5 --------------------------

    private void getEmployeesFromDepartmentEx5() throws IOException {
        System.out.println("Enter valid department name:");
        String department = reader.readLine();

        List<Employee> employees = entityManager
                .createQuery("SELECT e FROM Employee e " +
                "WHERE e.department.name = :d_name " +
                "ORDER BY e.salary , e.id", Employee.class)
                .setParameter("d_name", department)
                .getResultList();

        if (employees.isEmpty()) {
            System.out.println("This department is invalid!");
        } else {
            employees.forEach(e -> System.out.printf("%s %s from %s - $%.2f%n",
                    e.getFirstName(),
                    e.getLastName(),
                    e.getDepartment().getName(),
                    e.getSalary()));
        }
    }

    // -------------------------- 6 --------------------------

    private void addingNewAddressesAndUpdateEmployeeEx6() throws IOException {
        System.out.println("Enter employee last name: (if you want try with Brown we have 3 people with this last name)");
        String employeeLastName = reader.readLine();

        List<Employee> employees = entityManager.createQuery("SELECT e FROM Employee e WHERE e.lastName = :l_name", Employee.class)
                .setParameter("l_name", employeeLastName)
                .getResultList();

        if (employees.isEmpty()){
            System.out.printf("We don't have employee with %s for last name!%n", employeeLastName);
            return;
        }
        System.out.println("Enter the address you want to add in database");
        String addressToAdd = reader.readLine();//"Vitoshka 15" from exercise

        Address address = createAddress(addressToAdd);

        entityManager.getTransaction().begin();
        for (Employee employee : employees) {
            employee.setAddress(address);
        }
        entityManager.getTransaction().commit();
        System.out.println("See database for result :)");
    }

    private Address createAddress(String addressText) {
        Address address = new Address();
        address.setText(addressText);

        entityManager.getTransaction().begin();
        entityManager.persist(address);
        entityManager.getTransaction().commit();

        return address;
    }

    // -------------------------- 7 --------------------------

    private void addressWithEmployeeCountEx7() {
        entityManager.createQuery("SELECT a FROM Address a " +
                "ORDER BY a.employees.size DESC", Address.class)
                .getResultList()
                .stream()
                .limit(10)
                .forEach(a -> System.out.printf("%s , %s - %d employees%n",
                        a.getText() ,
                        a.getTown().getName() ,
                        a.getEmployees().size()));

        System.out.println("If result is incorrect use fresh database");
    }

    // -------------------------- 8 --------------------------

    private void getEmployeeAndProjectByEmployeeIdEx8() throws IOException {
        System.out.println("Enter valid employee id:");
        int id = Integer.parseInt(reader.readLine());

        Employee employee = entityManager.find(Employee.class , id);
        if (employee == null){
            System.out.println("Invalid employee id");
            return;
        }
        System.out.printf("%s %s - %s%n", employee.getFirstName() , employee.getLastName() , employee.getJobTitle());
        employee.getProjects().stream().map(Project::getName).sorted().forEach(p -> System.out.printf("      %s%n", p));
    }

    // -------------------------- 9 --------------------------

    private void findLatest10ProjectsEx9() {
        List<Project> resultList = entityManager
                .createQuery("SELECT p FROM Project p ORDER BY p.startDate DESC", Project.class)
                .setMaxResults(10)
                .getResultList();

        resultList.stream().sorted(Comparator.comparing(Project::getName))
                .forEach(p -> System.out.printf("Project name: %s%n" +
                        "\t\tProject Description: %s%n" +
                        "\t\tProject Start Date:%s%n" +
                        "\t\tProject End Date: %s%n",
                        p.getName() , p.getDescription() , p.getStartDate() , p.getEndDate()));
    }

    // -------------------------- 10 --------------------------

    private void increaseSalariesEx10() {
        entityManager.getTransaction().begin();
        entityManager
                .createQuery("UPDATE Employee e SET e.salary = e.salary * 1.12 " +
                        "WHERE e.department.id IN (1,2,4,11)")
                .executeUpdate();

        entityManager.getTransaction().commit();

        entityManager.createQuery("SELECT e FROM Employee e WHERE e.department.id IN (1,2,4,11)", Employee.class)
                .getResultStream()
                .forEach(e -> System.out.printf("%s %s ($%.2f)%n",
                        e.getFirstName() ,
                        e.getLastName() ,
                        e.getSalary()));

        System.out.println("If result is incorrect use fresh database");
        System.out.println("Your employees thank you for the increase :)");
    }

    // -------------------------- 11 --------------------------

    private void findEmployeesByFirstNameEx11() throws IOException {
        System.out.println("Enter the template with which you want the first name to begin: (letters only)");
        String template = reader.readLine();

        entityManager.createQuery("SELECT e FROM Employee e WHERE e.firstName LIKE CONCAT(:template , '%') ", Employee.class)
                .setParameter("template" , template)
                .getResultStream()
                .forEach(e -> System.out.printf("%s %s - %s - ($%.2f)%n", e.getFirstName() , e.getLastName() ,
                        e.getJobTitle() , e.getSalary()));

    }

    // -------------------------- 12 --------------------------

    private void maxSalariesForEachDepartmentEx12() {
        List<Object[]> resultList = entityManager.createNativeQuery("SELECT d.name, MAX(e.salary) AS max_salary FROM departments as d " +
                "JOIN employees e on d.department_id = e.department_id " +
                "GROUP BY d.name " +
                "HAVING `max_salary` NOT BETWEEN 30000 AND 70000;")
                .getResultList();

        resultList.forEach(objects -> System.out.printf("%s %.2f%n", objects[0] , objects[1]));

        System.out.println("If result is not correct use clean database!");
    }

    // -------------------------- 13 --------------------------

    private void removeTownEx13() throws IOException {
        System.out.println("Enter valid town name:");
        String townName = reader.readLine();

        Town town = entityManager.createQuery("SELECT t FROM Town t WHERE t.name = :town_name ", Town.class)
                .setParameter("town_name" , townName)
                .getSingleResult();

        if (town == null){
            System.out.printf("Invalid town name %s%n", townName);
            return;
        }

        int deletedAddresses = removeAddressesByTownId(town.getId());

        entityManager.getTransaction().begin();
        entityManager.remove(town);
        entityManager.getTransaction().commit();

        System.out.printf("%d address in %s is deleted%n", deletedAddresses , town.getName());
    }

    private int removeAddressesByTownId(Integer id) {
        setAddressesInEmployeeIsNull(id);
        List<Address> addresses = entityManager
                .createQuery("SELECT a FROM Address a WHERE a.town.id = :p_id", Address.class)
                .setParameter("p_id" , id)
                .getResultList();

        entityManager.getTransaction().begin();
        addresses.forEach(entityManager::remove);
        entityManager.getTransaction().commit();

        return addresses.size();
    }

    private void setAddressesInEmployeeIsNull(Integer id) {
        List<Integer> addressesIds = entityManager
                .createNativeQuery("SELECT address_id FROM addresses WHERE town_id = :t_id")
                .setParameter("t_id", id)
                .getResultList();

        List<Employee> employees = entityManager.createQuery("SELECT e FROM Employee e WHERE e.address.id IN (:ids)")
                .setParameter("ids" , addressesIds)
                .getResultList();

        entityManager.getTransaction().begin();
        employees.forEach(e -> e.setAddress(null));
        entityManager.getTransaction().commit();
    }
}
