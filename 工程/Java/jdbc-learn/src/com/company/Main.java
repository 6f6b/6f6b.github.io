package com.company;

import java.io.PrintStream;
import java.sql.*;

import java.io.FileInputStream;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.CellReference;
import org.apache.poi.ss.usermodel.*;

public class Main {
    public static PrintStream out = System.out;
    public static void main(String[] args) {
        Statement stm = null;
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://dev.shukangyun.com:53314/rplus_evaluation","PostopDev","PostopDevPwd@MySQL");
            stm = connection.createStatement();
            String sql = "SELECT * FROM assessment_item_lang_pack";
            ResultSet resultSet = stm.executeQuery(sql);

            Workbook wb = null;
            try {
                FileInputStream inputStream = new FileInputStream("/Users/feng/Desktop/西班牙/开发提供/Resources/测评视频动作名称/动作名称.xlsx");
                wb = new HSSFWorkbook(inputStream);
            } catch (Exception e) {
//                System.out.println(e.toString());
            }
//            Sheet sheet = wb.getSheetAt(0);
        }catch (SQLException e){
            out.println(e.toString());
        }finally {

        }

    }
}
