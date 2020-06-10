import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static PrintStream out = System.out;

    public static void main(String[] args) {
        ExcelMapper excelMapper = new ExcelMapper();
//        String tran_path   = "/Users/feng/Desktop/workstation/Tobetranslate/05-Glossary.xlsx";
//        String final_path = "/Users/feng/Desktop/workstation/Files/0103-translates.xlsx";
//        excelMapper.global_add_new(tran_path,final_path);
        //excelMapper.global_deduplication("/Users/feng/Desktop/workstation/final.xlsx");

//        String fileName = "13-V 1.8 new added";
//        String newP = String.format("/Users/feng/Desktop/workstation/Tobetranslate/%s.xlsx",fileName);
//        String originP = String.format("/Users/feng/Desktop/workstation/Tobetranslateorigin/%s.xlsx",fileName);
//        String toP = "/Users/feng/Desktop/workstation/to.xlsx";
//        excelMapper.take_duplicate(originP,newP,toP);

//        String oldP = "/Users/feng/Desktop/The_first_half_of_documents/0106Glossary_ES.xls";
//        String newP = "/Users/feng/Desktop/xiba/Files/0103-translates.xlsx";
//        String toP = "/Users/feng/Desktop/xiba/to.xlsx";
//        excelMapper.replace_tran(oldP,newP,toP);
        String des = "/Users/feng/Desktop/xiba/Files/0103-translates.xlsx";
        String sou = "/Users/feng/Desktop/20200610.xlsx";
        excelMapper.merge(des,sou);

//        resolveAction();
        //resolveOperation();
//        handleWords();
    }

    //xiu
    public static void handleWords(){
        Workbook wb = null;
        try {
            String file = "/Users/feng/Desktop/西班牙/开发提供/Resources/global站点翻译资源/language.xlsx";
            FileInputStream inputStream = new FileInputStream(file);
            wb = WorkbookFactory.create(inputStream);
            Sheet sheet = wb.getSheetAt(0);

            // 获得行数
            int rows = sheet.getLastRowNum();
            for (int i=1;i<=rows;i++){
                //out.println(String.format("%d",i));
                Row row = sheet.getRow(i);
                Cell cell = row.getCell(2);
                String va = cell.getStringCellValue();
                Cell writeCell = row.createCell(3,CellType.STRING);
                writeCell.setCellValue("(西班牙)"+va);
                out.println(va);
            }
            //输出流
            FileOutputStream fileout = new FileOutputStream(file);
            //协出
            wb.write(fileout);
            //关闭流
            fileout.close();
            out.println("success");
        }catch (Exception e){
            out.println(e.getMessage());
        }
    }

    //操作
    public static void resolveAction(){
        Statement stm = null;
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://dev.shukangyun.com:53314/rplus_evaluation", "PostopDev", "PostopDevPwd@MySQL");
            stm = connection.createStatement();
            String sql = "SELECT * FROM assessment_item_lang_pack";
            ResultSet resultSet = stm.executeQuery(sql);

            Workbook wb = null;
            try {
                FileInputStream inputStream = new FileInputStream("/Users/feng/Desktop/西班牙/开发提供/Resources/测评视频动作名称/动作名称.xlsx");
                wb = WorkbookFactory.create(inputStream);
                Sheet sheet = wb.getSheetAt(0);

                // 获得行数
                int rows = sheet.getLastRowNum();
                // 获得列数
                int cols = 12;

                Row firsRow = sheet.getRow(0);
                ArrayList<String> column_names = new ArrayList();
                ArrayList<Integer> column_indexs = new ArrayList();
                for (int i=0;i<firsRow.getPhysicalNumberOfCells();i++){
                    Cell cell = firsRow.getCell(i);
                    if (cell == null){
                        continue;
                    }
                    if (cell.getStringCellValue().contains("Spanish")){
                        continue;
                    }
                    column_names.add(cell.getStringCellValue());
                    column_indexs.add(i);
                }


                for (String name:column_names) {
                    out.println(name);
                }

                for (Integer index:column_indexs) {
                    out.println(index);
                }

                for (int row = 1; row <= rows; ++row) {
                    Row r = sheet.getRow(row);
                    String insertSql = "INSERT INTO assessment_item_lang_pack (";
                    for (int i=0;i<column_names.size();i++){
                        insertSql += column_names.get(i);
                        if (i != column_names.size()-1){
                            insertSql += ",";
                        }
                    }
                    insertSql += ") VALUES (";

                    for(int i=0;i<column_indexs.size();i++){
                        String columnName = column_names.get(i);
                        Cell cell = r.getCell(column_indexs.get(i));
                        String value = null;
                        if (cell != null){
                            value = cell.getStringCellValue();
                        }
                        if (value == null){
                            insertSql += "null";
                        }else{
                            //value特殊处理
                            if (columnName.equals("assessment_unit")){
                                value = "(西班牙)"+value;
                            }
                            if (columnName.equals("display_name")){
                                value = "(西班牙)"+value;
                            }
                            if (columnName.equals("locale")){
                                value = "es_US";
                            }
                            if (columnName.equals("name")){
                                value = "(西班牙)"+value;
                            }
                            if (columnName.equals("category_cn")){
                                value = "(西班牙)"+value;
                            }
                            insertSql += String.format("\"%s\"",value);

                        }
                        if (i != column_indexs.size()-1){
                            insertSql += ",";
                        }
                    }
                    insertSql += ");";
                    out.println(insertSql);

                }
            } catch (Exception e) {
                System.out.println(e.toString());
            }
        }catch (Exception e){
            out.println(e.toString());
        }
    }
    //动作名称
    public static void resolveOperation() {
        Statement stm = null;
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://dev.shukangyun.com:53314/rplus_evaluation", "PostopDev", "PostopDevPwd@MySQL");
            stm = connection.createStatement();

            Workbook wb = null;
            try {
                FileInputStream inputStream = new FileInputStream("/Users/feng/Desktop/西班牙/开发提供/Resources/测评视频动作名称/操作.xlsx");
                wb = WorkbookFactory.create(inputStream);
                Sheet sheet = wb.getSheetAt(0);

                // 获得行数
                int rows = sheet.getLastRowNum();
                // 获得列数
                int cols = 12;

                Row firsRow = sheet.getRow(0);
                ArrayList<String> column_names = new ArrayList();
                ArrayList<Integer> column_indexs = new ArrayList();
                for (int i=0;i<firsRow.getPhysicalNumberOfCells();i++){
                    Cell cell = firsRow.getCell(i);
                    if (cell == null){
                        continue;
                    }
                    if (cell.getStringCellValue().contains("Spanish")){
                        continue;
                    }
                    column_names.add(cell.getStringCellValue());
                    column_indexs.add(i);
                }


                for (String name:column_names) {
                    out.println(name);
                }

                for (Integer index:column_indexs) {
                    out.println(index);
                }

                for (int row = 1; row <= rows; ++row) {
                    Row r = sheet.getRow(row);
                    String insertSql = "INSERT INTO assessment_item_view_lang_pack (";
                    for (int i=0;i<column_names.size();i++){
                        insertSql += column_names.get(i);
                        if (i != column_names.size()-1){
                            insertSql += ",";
                        }
                    }
                    insertSql += ") VALUES (";

                    for(int i=0;i<column_indexs.size();i++){
                        String columnName = column_names.get(i);
                        Cell cell = r.getCell(column_indexs.get(i));
                        String value = null;
                        if (cell != null){
                            value = cell.getStringCellValue();
                        }
                        if (value == null){
                            insertSql += "null";
                        }else{
                            //value特殊处理
                            if (columnName.equals("locale")){
                                value = "es_US";
                            }
                            if (columnName.equals("view_name")){
                                value = "(西班牙)"+value;
                            }
                            if (columnName.equals("view_operations")){
                                //value = "(西班牙)"+value;
                                Pattern pattern = Pattern.compile("\"title\":\"(.*?)\"");
                                Matcher matcher = pattern.matcher(value);
                                if (matcher.find()){
                                    String toReplace = matcher.group(1);
                                    value = value.replaceAll(toReplace,"(西班牙)"+toReplace);
                                }
                            }
                            value = value.replace("\"","\\\"");
                            insertSql += String.format("\"%s\"",value);

                        }
                        if (i != column_indexs.size()-1){
                            insertSql += ",";
                        }
                    }
                    insertSql += ");";
                    out.println(insertSql);

                }
            } catch (Exception e) {
                System.out.println(e.toString());
            }
        }catch (Exception e){
            out.println(e.toString());
        }
    }
}
