package com.company;

import java.io.PrintStream;
import java.sql.*;

import java.io.FileInputStream;
import java.util.prefs.BackingStoreException;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.CellReference;
import org.apache.poi.ss.usermodel.*;

public class Main {
    public static PrintStream out = System.out;
    public static void main(String[] args) throws SQLException {
        Statement stm = null;
        Connection connection = null;
        Savepoint savepoint = null;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://www.keespo.com/Learn_SQL","root","fengliu24");
            connection.setAutoCommit(false);
            savepoint = connection.setSavepoint();
            stm = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
            {
                stm.execute("DELETE from apps where id > 4");
            }
            String sql = "SELECT * FROM apps";
            ResultSet resultSet = stm.executeQuery(sql);

            resultSet.moveToInsertRow();
            for (int i=5;i<10;i++){
                if (i == 8){
                    resultSet.updateInt(1,4);
                    resultSet.updateString(2,"colo"+i);
                    resultSet.updateString(3,"www.colo.com"+i);
                    resultSet.updateString(4,"CN");
                    resultSet.insertRow();
                    connection.commit();
                }else{
                    resultSet.updateInt(1,i);
                    resultSet.updateString(2,"colo"+i);
                    resultSet.updateString(3,"www.colo.com"+i);
                    resultSet.updateString(4,"CN");
                    resultSet.insertRow();
                    connection.commit();
                }
            }
            resultSet.beforeFirst();

            //connection.commit();

            while (resultSet.next()){
                String name = resultSet.getString(2);
                out.println(name);
            }

        }catch (SQLException e){
            out.println(e.toString());
            //connection.rollback();
            //connection.rollback(savepoint);
        }finally {
            stm.close();
        }

    }
}
