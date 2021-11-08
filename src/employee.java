import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.*;
import java.util.ArrayList;

public class employee {

    public static void  main(String[] args) {
        jdbc jb=new jdbc();
        jb.jdbcconnection();
        jb.updaterecords();
        jb.insertrecords_getAutoIDRecords();
        jb.batch_processing();

    }
}
