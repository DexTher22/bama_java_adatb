
import java.util.ArrayList;



public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Adatbázis...");

        DataService dataService = new DataService(new Mariadb());
        ArrayList<Employee> empList = dataService.getEmployees();
        for (Employee emp : empList) {
            System.out.println(emp.getSalary());
        }
        // empList.forEach(emp -> {
        //     System.out.println(emp.getSalary());
        // });
    }
}
