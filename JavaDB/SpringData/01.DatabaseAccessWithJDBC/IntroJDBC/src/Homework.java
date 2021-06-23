import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.*;
import java.util.*;
import java.util.stream.Collectors;

public class Homework {
    private static final String CONNECTION_STRING = "jdbc:mysql://localhost:3306/";
    private static final String MINIONS_TABLE_NAME = "minions_db";

    private Connection connection;
    private Scanner scanner;

    public void setConnection(String username, String password) throws SQLException {
        Properties properties = new Properties();
        properties.setProperty("user", username);
        properties.setProperty("password", password);

        connection = DriverManager.getConnection(CONNECTION_STRING + MINIONS_TABLE_NAME, properties);
    }

    // --------------------------- 2 ------------------------------

    public void getVillainsNameEx2() throws SQLException {
        String query = "SELECT v.`name` AS `villains_name` , COUNT(*) AS `number_of_minions` FROM minions_villains AS mv\n" +
                "JOIN villains AS v\n" +
                "ON v.id = mv.villain_id\n" +
                "GROUP BY villain_id\n" +
                "HAVING `number_of_minions` > 15\n" +
                "ORDER BY `number_of_minions` DESC";

        PreparedStatement preparedStatement = connection.prepareStatement(query);

        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {
            System.out.println(resultSet.getString("villains_name") + " "
                    + resultSet.getInt("number_of_minions"));
        }
    }

    // --------------------------- 3 ------------------------------

    public void getMinionsNamesByVillainsIdEx3() throws SQLException {
        scanner = new Scanner(System.in);

        System.out.println("Enter villainId:");
        int villainId = Integer.parseInt(scanner.nextLine());

        String villainName = getVillainNameById(villainId, "villains");
        if (villainName == null) {
            System.out.printf("No villain with ID %d exists in the database.%n", villainId);
            return;
        }
        System.out.printf("Villain:%s%n", villainName);

        String query = "SELECT m.`name` , m.`age` , v.`name` FROM minions AS m\n" +
                "JOIN minions_villains AS mv\n" +
                "ON m.id = mv.minion_id\n" +
                "JOIN villains AS v\n" +
                "ON mv.villain_id = v.id\n" +
                "WHERE v.id = ?";

        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setInt(1, villainId);

        ResultSet resultSet = preparedStatement.executeQuery();

        int count = 1;
        while (resultSet.next()) {
            System.out.printf("%d. %s %d%n", count++, resultSet.getString("m.name"),
                    resultSet.getInt("m.age"));
        }
    }

    private String getVillainNameById(int villainId, String tableName) throws SQLException {
        String query = String.format("SELECT name FROM %s WHERE id = ?", tableName);

        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setInt(1, villainId);

        ResultSet resultSet = preparedStatement.executeQuery();

        return resultSet.next() ? resultSet.getString("name") : null;
    }

    // --------------------------- 4 ------------------------------

    public void addMinionInDatabaseEx4() throws SQLException {
        scanner = new Scanner(System.in);
        System.out.println("Enter minions info: name age town_name (with single space separator)");
        String[] minionInfo = scanner.nextLine().split("\\s+");
        String minionName = minionInfo[0];
        int minionAge = Integer.parseInt(minionInfo[1]);
        String townName = minionInfo[2];

        int townId = getEntityIdByName(townName , "towns");
        if (townId == -1){
            insertEntityInTowns(townName);
            System.out.printf("Town %s was added to the database.%n", townName);
        }

        int minionId = getEntityIdByName(minionName , "minions");
        if (minionId == -1){
            insertEntityInMinions(minionName , minionAge , getEntityIdByName(townName , "towns"));
        }

        System.out.println("Enter villain name like: (only name)");
        String villainName = scanner.nextLine();

        int villainId = getEntityIdByName(villainName , "villains");
        if (villainId == -1){
            insertEntityInVillains(villainName);
            System.out.printf("Villain %s was added to the database.%n", villainName);
        }

        String query = "INSERT INTO minions_villains VALUES (? , ?)";
        PreparedStatement ps = connection.prepareStatement(query);
        ps.setInt(1 , getEntityIdByName(minionName , "minions"));
        ps.setInt(2, getEntityIdByName(villainName , "villains"));
        ps.execute();
        System.out.printf("Successfully added %s to be minion of %s.%n", minionName, villainName);
    }

    private void insertEntityInVillains(String villainName) throws SQLException {
        String query = "INSERT INTO villains(name , evilness_factor) VALUES (? , ?)";

        PreparedStatement ps = connection.prepareStatement(query);
        ps.setString(1 , villainName);
        ps.setString(2 , "evil");
        ps.execute();
    }

    private void insertEntityInMinions(String minionName, int minionAge, int townId) throws SQLException {
        String query = "INSERT INTO minions(name , age , town_id) VALUES(? , ? , ?)";

        PreparedStatement ps = connection.prepareStatement(query);
        ps.setString(1 , minionName);
        ps.setInt(2 , minionAge);
        ps.setInt(3 , townId);

        ps.execute();
    }

    private void insertEntityInTowns(String townName) throws SQLException {
        String query = "INSERT INTO towns(name) values(?)";

        PreparedStatement ps = connection.prepareStatement(query);
        ps.setString(1 , townName);
        ps.execute();
    }

    private int getEntityIdByName(String name, String tableName) throws SQLException {
        String query = String.format("SELECT id FROM %s WHERE name = ?", tableName);

        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1 , name);

        ResultSet resultSet = preparedStatement.executeQuery();

        return resultSet.next() ? resultSet.getInt("id") : -1;
    }

    // --------------------------- 5 ------------------------------

    public void changeTownNameCasingEx5() throws SQLException {
        scanner = new Scanner(System.in);
        System.out.println("Enter country name:");
        String countryName = scanner.nextLine();
        String query = "UPDATE towns SET name = UPPER(name) WHERE country = ?";

        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1 , countryName);
        int townsNameAffected = statement.executeUpdate();
        if(townsNameAffected == 0){
            System.out.println("No town names were affected.%n");
        } else {
            System.out.printf("%d town names were affected.%n", townsNameAffected);
            String queryForUpdateCities = "SELECT name FROM towns WHERE country = ?";

            PreparedStatement preparedStatement = connection.prepareStatement(queryForUpdateCities);
            preparedStatement.setString(1 , countryName);
            ResultSet resultSet = preparedStatement.executeQuery();

            List<String> cities = new ArrayList<>();

            while (resultSet.next()){
                cities.add(resultSet.getString("name"));
            }
            System.out.println(cities);
        }
    }

    // --------------------------- 8 ------------------------------

    public void increaseMinionsAgeEx8() throws SQLException {
        scanner = new Scanner(System.in);
        System.out.println("Enter minions id with single space separator");
        List<Integer> minionsId = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toList());

        String query = "UPDATE minions SET age = age + 1 , name = LOWER(name) WHERE id = ?";

        for (Integer id : minionsId) {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, id);
            statement.execute();
        }

        String queryForAllMinions = "SELECT name , age FROM minions";
        PreparedStatement statement = connection.prepareStatement(queryForAllMinions);
        ResultSet resultSet = statement.executeQuery();

        while (resultSet.next()){
            System.out.printf("%s %d%n", resultSet.getString("name") , resultSet.getInt("age"));
        }
    }

    // --------------------------- 9 ------------------------------

    public void increaseMinionsAgeWithStoreProcedureEx9() throws SQLException {
        System.out.println("Enter minion id:");
        scanner = new Scanner(System.in);
        int minionId = Integer.parseInt(scanner.nextLine());

        String query = "CALL usp_get_older(?)";

        CallableStatement callableStatement = connection.prepareCall(query);
        callableStatement.setInt(1 , minionId);
        callableStatement.execute();

        String queryToPrintMinion = "SELECT name , age FROM minions WHERE id = ?";
        PreparedStatement statement = connection.prepareStatement(queryToPrintMinion);
        statement.setInt(1 , minionId);
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
            System.out.printf("%s %d%n", resultSet.getString("name"), resultSet.getInt("age"));
        }
    }




}
