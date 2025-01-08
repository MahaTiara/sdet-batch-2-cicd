package stepDefinitions.jdbc;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DataBaseTesting {

    List<String> actualNames = new ArrayList<>();

    @Given("Establish new connection")
    public void establish_new_connection() {
        String url = "jdbc:mariadb://3.16.40.221/my_jdbc_db";
        String user = "admin";
        String password = "admin";

        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            System.out.println("Connected to the database!");
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM employees");

            System.out.println("Employees Data: ");

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String department = resultSet.getString("department");
                double salary = resultSet.getDouble("salary");

                System.out.println("ID : " + id);
                System.out.println("name : " + name);
                System.out.println("department : " + department);
                System.out.println("salary: " + salary);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Given("I query all employee names from the {string} table")
    public void iQueryAllEmployeeNamesFromTheTable(String employees) {
    }

    @Then("I should get the following names:")
    public void iShouldGetTheFollowingNames(DataTable dataTable) {
//        String url = "jdbc:mariadb://3.16.40.221/my_jdbc_db";
//        String user = "admin";
//        String password = "admin";
//
//        try (Connection connection = DriverManager.getConnection(url, user, password)) {
//            System.out.println("Connected to the database!");
//            Statement statement = connection.createStatement();
//            ResultSet resultSet = statement.executeQuery("SELECT * FROM employees");
//
//            System.out.println("Employees Data: ");
//
//            while (resultSet.next()) {

//                List<String> actualNames =
//                        List < String > expectedNames =
//                                Assert.assertEquals(actualNames, expectedNamesList);
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
    }
}
