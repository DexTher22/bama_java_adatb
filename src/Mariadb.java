import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Mariadb implements Database {

    private final String host = "localhost";
    private final String port = "3306";
    private final String name = "bama";
    private final String user = "bama";
    private final String pass = "titok";

    @Override
    public Connection connect() {
        try {
            return tryConnect();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            return null;
        }
    }
    private Connection tryConnect() throws SQLException {
        String url = "jdbc:mariadb://" + host + ":" + port + "/" + name;
        return DriverManager.getConnection(url, user, pass);
    }
    
}
