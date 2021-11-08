import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.*;

public class jdbc {
    Connection conn = null;
    public void jdbcconnection() {
        try {

            conn =
                    DriverManager.getConnection("jdbc:mysql://localhost:3306/phpmyadmin",
                            "phpmyadmin", "root");
            System.out.print("Database is connected !");
        } catch (Exception e) {
            System.out.print("Do not connect to DB - Error:" + e);
        }
    }
    public void updaterecords() {
        try
        {
        PreparedStatement stmt = conn.prepareStatement("update employee set EmpName =? where Id=?");
        stmt.setString(1,"rasmi");
        stmt.setInt(2,1);
        int i = stmt.executeUpdate();
        System.out.println(i+"records updated");
    }
     catch (Exception e) {
        System.out.print("Do not connect to DB - Error:" + e);
    }
    }

    public void insertrecords_getAutoIDRecords()
    {

        try {
            PreparedStatement stmt1 = conn.prepareStatement("insert into employee (EmpName)values(?)", Statement.RETURN_GENERATED_KEYS);

            stmt1.setString(1, "aarav");

            int i1 = stmt1.executeUpdate();
            System.out.println(i1 + " records Inserted");
            ResultSet result1 = stmt1.getGeneratedKeys();
            if (result1 != null && result1.next()) {
                System.out.println("Generated Emp Id: " + result1.getInt(1));
            }
        }
        catch (Exception e) {
            System.out.print("Do not connect to DB - Error:" + e);
        }

    }


    public void batch_processing()
    {
        try {
            PreparedStatement psbatch = conn.prepareStatement("insert into employee values(?,?)");
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            while (true) {
                System.out.println("enter Id");
                String strId = br.readLine();
                int id = Integer.parseInt(strId);
                System.out.println("enter emp_name");
                String strname = br.readLine();

                psbatch.setInt(1, id);
                psbatch.setString(2, strname);

                psbatch.addBatch();
                System.out.println("Want to add more  y/n");
                String ans = br.readLine();
                if (ans.equals("n")) {
                    break;
                }
            }
            psbatch.executeBatch();
            System.out.println("record successfully saved");
        }
        catch (Exception e) {
            System.out.print("Do not connect to DB - Error:" + e);
        }

    }
}
