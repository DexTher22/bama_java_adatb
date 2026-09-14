import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class DataService {
    
    Database database;
    public DataService(Database database) {
        this.database = database;
    }

    public ArrayList<Employee> getEmployees() {
        try {
            return tryGetEmployees();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            return null;
        }
    }
    private ArrayList<Employee> tryGetEmployees() throws SQLException {
        ArrayList<Employee> empList = new ArrayList<>();

        //feltötlés

        Connection con = database.connect();
        String sql = "select * from employees";
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        while(rs.next()){
            Employee emp = new Employee();
            emp.setId(rs.getInt("id"));
            emp.setName(rs.getString("name"));
            emp.setCity(rs.getString("city"));
            emp.setSalary(rs.getInt("salary"));
            empList.add(emp);
        }
        con.close();

        return empList;
    }
}
