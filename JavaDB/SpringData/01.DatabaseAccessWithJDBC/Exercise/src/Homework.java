import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;
import java.util.Properties;

public class Homework {

    private static final String CONNECTION_STRING = "jdbc:mysql://localhost:3306/";
    private static final String MINIONS_TABLE_NAME = "minions_db";

    private Connection connection;
    private BufferedReader reader;

    public void setConnection(String username, String password) throws SQLException {
        Properties properties = new Properties();
        properties.setProperty("user", username);
        properties.setProperty("password", password);

        connection = DriverManager.getConnection(CONNECTION_STRING + MINIONS_TABLE_NAME, properties);
    }

    public void getVillainsNamesEx2() throws SQLException {
        String query = "SELECT v.name ,COUNT(mv.minion_id) AS 'count' FROM villains AS v\n" +
                "JOIN minions_villains mv on v.id = mv.villain_id\n" +
                "GROUP BY v.id\n" +
                "HAVING count > 15\n" +
                "ORDER BY `count` DESC;";

        PreparedStatement statement = connection.prepareStatement(query);

        ResultSet rs = statement.executeQuery();

        while (rs.next()) {
            System.out.printf("%s %d%n", rs.getString("name"), rs.getInt("count"));
        }
    }

    public void getMinionNamesEx3() throws IOException, SQLException {
        reader = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Enter villain id:");
        int villainId = Integer.parseInt(reader.readLine());

        String villainName = getEntityNameById(villainId, "villains");
        if (villainName == null) {
            System.out.printf("No villain with ID %d exists in the database.%n", villainId);
            return;
        }

        System.out.printf("Villain: %s%n", villainName);

        String query = "SELECT m.name , m.age FROM minions AS m\n" +
                "JOIN minions_villains AS mv ON m.id = mv.minion_id\n" +
                "WHERE mv.villain_id = ?";

        PreparedStatement statement = connection.prepareStatement(query);
        statement.setInt(1 , villainId);
        ResultSet rs = statement.executeQuery();

        int count = 1;
        while (rs.next()){
            System.out.printf("%d. %s %d%n", count++ , rs.getString("name") , rs.getInt("age"));
        }
    }

    private String getEntityNameById(int entityId, String tableName) throws SQLException {
        String query = String.format("SELECT name FROM %s WHERE id = ?", tableName);

        PreparedStatement statement = connection.prepareStatement(query);
        statement.setInt(1, entityId);

        ResultSet resultSet = statement.executeQuery();

        return resultSet.next() ? resultSet.getString("name") : null;
    }

    public void addMinionEx4() throws IOException, SQLException {
        System.out.println("Enter minions info: name , age , town_name");
        String[] minionInfo = reader.readLine().split("\\s+");
        String minionName = minionInfo[0];
        int minionAge = Integer.parseInt(minionInfo[1]);
        String townName = minionInfo[2];

        int townId = getEntityIdByName(townName, "towns");
        if (townId == -1){
            insertEntityInTowns(townName);
            System.out.printf("Town %s was added to the database.%n", townName);
        }

        int minionId = getEntityIdByName(minionName , "minions");
        if (minionId == -1){
            insertMinionInMinions(minionName , minionAge , getEntityIdByName(townName , "towns"));
        }

        System.out.println("Enter villain name:");
        String villainName = reader.readLine();

        int villainId = getEntityIdByName(villainName , "villains");
        if (villainId == -1){
            insertEntityInVillains(villainName);
            System.out.printf("Villain %s was added to the database.%n", villainName);
        }

        
    }

    private void insertEntityInVillains(String villainName) throws SQLException {
        String query = "INSERT INTO villains(name) value(?)";

        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1 , villainName);
        statement.execute();
    }

    private void insertMinionInMinions(String minionName, int minionAge, int townId) throws SQLException {
        String query = "INSERT INTO minions(name , age , town_id) value(? , ? , ?)";

        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1 , minionName);
        statement.setInt(2 , minionAge);
        statement.setInt(3 , townId);
        statement.execute();
    }

    private int getEntityIdByName(String name, String tableName) throws SQLException {
        String query = String.format("SELECT id FROM %s WHERE name = ?", tableName);

        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1 , name);
        ResultSet rs = statement.executeQuery();

        return rs.next() ? rs.getInt("id") : -1;
    }

    private void insertEntityInTowns(String townName) throws SQLException {
        String query = "INSERT INTO towns(name) value(?)";

        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1 , townName);
        statement.execute();
    }
}
