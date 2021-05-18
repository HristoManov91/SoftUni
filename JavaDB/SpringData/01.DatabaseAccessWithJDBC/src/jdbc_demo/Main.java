package jdbc_demo;

import java.sql.*;
import java.util.Properties;
import java.util.Scanner;

public class Main {
    public static String DB_URL = "jdbc:mysql://localhost:3306/soft_uni";

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter DB username (<Enter> for 'root'): ");
        String username = scanner.nextLine().trim();
        username = username.length() > 0 ? username : "root";

        System.out.println("Enter DB password (<Enter> for '12345'): ");
        String password = scanner.nextLine().trim();
        password = password.length() > 0 ? password : "12345";

        //1. Load DB Driver
        Class.forName("com.mysql.cj.jdbc.Driver");
        System.out.println("DB driver loaded successfully.");

        //2. Connect to DB
        Properties props = new Properties();
        props.setProperty("username", username);
        props.setProperty("password", password);
        //DriverManager.getConnection("jdbc:mysql://localhost:3306/soft_uni", username , password);
        Connection con = DriverManager.getConnection(DB_URL, username, password);
        System.out.println("Connect to DB successfully.");

        System.out.println("Enter minimal salary (<Enter> for '40000'): ");
        String salaryStr = scanner.nextLine().trim();
        salaryStr = salaryStr.length() > 0 ? salaryStr : "40000";
        double salary = 40000;
        try {
            salary = Double.parseDouble(salaryStr);
        } catch (NumberFormatException ex) {
            System.err.printf("Invalid number: '%s'", salaryStr);
        }

        //3. Create prepared statement
        PreparedStatement ps = con.prepareStatement("SELECT * FROM employees WHERE salary > ?");
        ps.setDouble(1, salary);
        ResultSet rs = ps.executeQuery();

        //4. Print result
        while (rs.next()) {
            System.out.printf("| %10d | %-15.15s | %-15.15s | %10.2f |",
                    rs.getLong("employee_id"),
                    rs.getString("first_name"),
                    rs.getString("last_name"),
                    rs.getDouble("salary")
            );
            System.out.print(System.lineSeparator());
        }

        con.close();
    }
}
