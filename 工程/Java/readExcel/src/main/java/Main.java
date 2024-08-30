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
//        String des = "/Users/feng/Desktop/WORK/language.xlsx";
//        String sou = "/Users/feng/Desktop/WORK/0103.xlsx";
//        excelMapper.merge(des,sou);

//        resolveAction();
        resolveOperation();
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
                FileInputStream inputStream = new FileInputStream("/Users/feng/Desktop/开发提供/Resources/测评视频动作名称/动作名称.xlsx");
                wb = WorkbookFactory.create(inputStream);
                Sheet sheet = wb.getSheetAt(0);

                String key_assessment_id                    = "assessment_id";
                String key_assessment_unit                  = "assessment_unit";
                String key_description                      = "description";
                String key_display_description              = "display_description";
                String key_display_name                     = "display_name";
                String key_locale                           = "locale";
                String key_name                             = "name";
                String key_category_cn                      = "category_cn";

                // 获得行数
                int rows = sheet.getLastRowNum();
                ArrayList<String> insert_sqls   = new ArrayList();
                ArrayList<String> update_sqls   = new ArrayList();

                for (int i=1;i<=rows;i++) {
                    Row row = sheet.getRow(i);

                    Cell cell_assessment_id                         = getCell(row, 0);
                    Cell cell_assessment_unit                       = getCell(row, 1);
                    Cell cell_assessment_unit_spanish               = getCell(row, 2);
                    Cell cell_description                           = getCell(row, 3);
                    Cell cell_display_description                   = getCell(row, 4);
                    Cell cell_display_name                          = getCell(row, 5);
                    Cell cell_display_name_spanish                  = getCell(row, 6);
                    Cell cell_display_name_english_new              = getCell(row, 7);
                    Cell cell_locale                                = getCell(row, 8);
                    Cell cell_name                                  = getCell(row, 9);
                    Cell cell_name_spanish                          = getCell(row, 10);
                    Cell cell_name_english_new                      = getCell(row, 11);
                    Cell cell_category_cn                           = getCell(row, 12);

                    String value_assessment_id              = getStringValueWith(cell_assessment_id);
                    String value_assessment_unit            = getStringValueWith(cell_assessment_unit);
                    String value_assessment_unit_spanish    = getStringValueWith(cell_assessment_unit_spanish);
                    String value_description                = getStringValueWith(cell_description);
                    String value_display_description        = getStringValueWith(cell_display_description);
                    String value_display_name               = getStringValueWith(cell_display_name);
                    String value_display_name_spanish       = getStringValueWith(cell_display_name_spanish);
                    String value_display_name_english_new   = getStringValueWith(cell_display_name_english_new);
                    String value_locale                     = getStringValueWith(cell_locale);
                    String value_name                       = getStringValueWith(cell_name);
                    String value_name_spanish               = getStringValueWith(cell_name_spanish);
                    String value_name_english_new           = getStringValueWith(cell_name_english_new);
                    String value_category_cn                = getStringValueWith(cell_category_cn);

                    ArrayList<String> keys   = new ArrayList();
                    keys.add(key_assessment_id);
                    keys.add(key_assessment_unit);
                    keys.add(key_description);
                    keys.add(key_display_description);
                    keys.add(key_display_name);
                    keys.add(key_locale);
                    keys.add(key_name);
                    keys.add(key_category_cn);

                    ArrayList<String> values = new ArrayList();
                    values.add(value_assessment_id);
                    values.add(value_assessment_unit_spanish);
                    values.add(value_description);
                    values.add(value_display_description);
                    values.add(value_display_name_spanish);
                    values.add("es_US");
                    values.add(value_name_spanish);
                    values.add(value_category_cn);


                    String insert_sql = "INSERT INTO assessment_item_lang_pack VALUES(";
                    for (int j=0;j<keys.size();j++){
                        String key   = keys.get(j);
                        String value = values.get(j);
                        if (value == null || value.length() < 1){
                            insert_sql += String.format("NULL",value);
                        }else{
                            insert_sql += String.format("\'%s\'",value);
                        }
                        if (j != keys.size()-1){
                            insert_sql += ",";
                        }
                    }
                    insert_sql += ");";
                    insert_sqls.add(insert_sql);

                    if (value_display_name_english_new.length() > 1){
                        String update_sql = "UPDATE assessment_item_lang_pack SET";
                        update_sql = String.format("%s %s=\"%s\" WHERE %s=\"%s\" AND %s=\"%s\";",update_sql,key_display_name,value_display_name_english_new,key_assessment_id,value_assessment_id,key_locale,"en_US");
                        update_sqls.add(update_sql);
                    }
                    if (value_name_english_new.length() > 1){
                        String update_sql = "UPDATE assessment_item_lang_pack SET";
                        update_sql = String.format("%s %s=\"%s\" WHERE %s=\"%s\" AND %s=\"%s\";",update_sql,key_name,value_name_english_new,key_assessment_id,value_assessment_id,key_locale,"en_US");
                        update_sqls.add(update_sql);
                    }
                }

                for (String s : insert_sqls){
                    out.println(s);
                }
                out.println("\n\n\n");
                for (String s : update_sqls){
                    out.println(s);
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
                FileInputStream inputStream = new FileInputStream("/Users/feng/Desktop/开发提供/Resources/测评视频动作名称/操作.xlsx");
                wb = WorkbookFactory.create(inputStream);
                Sheet sheet = wb.getSheetAt(0);

                String key_assessment_item_view_id = "assessment_item_view_id";
                String key_locale                  = "locale";
                String key_view_name               = "view_name";
                String key_view_operations         = "view_operations";

                // 获得行数
                int rows = sheet.getLastRowNum();
                ArrayList<String> insert_sqls   = new ArrayList();
                ArrayList<String> update_sqls   = new ArrayList();
                for (int i=1;i<=rows;i++){
                    Row row = sheet.getRow(i);

                    Cell cell_assessment_item_view_id   = getCell(row,0);
                    Cell cell_locale                    = getCell(row,1);
                    Cell cell_view_name                 = getCell(row,2);
                    Cell cell_view_name_spanish         = getCell(row,3);
                    Cell cell_view_name_english_new     = getCell(row,4);
                    Cell cell_view_operations           = getCell(row,5);
                    Cell cell_view_operations_spanish   = getCell(row,6);

                    String value_assessment_item_view_id   = getStringValueWith(cell_assessment_item_view_id);
                    String value_locale                    = getStringValueWith(cell_locale);
                    String value_view_name                 = getStringValueWith(cell_view_name);
                    String value_view_name_spanish         = getStringValueWith(cell_view_name_spanish);
                    String value_view_name_english_new     = getStringValueWith(cell_view_name_english_new);
                    String value_view_operations           = getStringValueWith(cell_view_operations);
                    String value_view_operations_spanish   = getStringValueWith(cell_view_operations_spanish);
                    if (value_view_operations_spanish == null || value_view_operations_spanish.length() < 1){
                        value_view_operations_spanish = "[]";
                    }

                    //out.println("*********************************************");
                    ArrayList<String> keys   = new ArrayList();
                    keys.add(key_assessment_item_view_id);
                    keys.add(key_locale);
                    keys.add(key_view_name);
                    keys.add(key_view_operations);

                    ArrayList<String> values = new ArrayList();
                    values.add(value_assessment_item_view_id);
                    values.add("es_US");
                    values.add(value_view_name_spanish);
                    values.add(value_view_operations_spanish);

                    String insert_sql = "INSERT INTO assessment_item_view_lang_pack VALUES(";
                    for(int j=0;j<keys.size();j++){
                        String key   = keys.get(j);
                        String value = values.get(j);
                        if (value == null || value.length() < 1){
                            insert_sql += String.format("NULL",value);
                        }else{
                            insert_sql += String.format("\'%s\'",value);
                        }
                        if (j != keys.size()-1){
                            insert_sql += ",";
                        }
                    }
                    insert_sql += ");";
                    insert_sqls.add(insert_sql);

                    String update_sql = "UPDATE assessment_item_view_lang_pack SET";
                    if (value_view_name_english_new.length() > 1){
                        update_sql = String.format("%s %s=\"%s\" WHERE %s=\"%s\" AND %s=\"%s\";",update_sql,key_view_name,value_view_name_english_new,key_assessment_item_view_id,value_assessment_item_view_id,key_locale,"en_US");
                        update_sqls.add(update_sql);
                    }
                }

                for (String sql : insert_sqls){
                    out.println(sql);
                }
                out.println("\n\n\n");
                for (String sql : update_sqls){
                    out.println(sql);
                }

            } catch (Exception e) {
                System.out.println(e.toString());
            }
        }catch (Exception e){
            out.println(e.toString());
        }
    }

    public static Cell getCell(Row row,int index){
        Cell cell = row.getCell(index);
        if (cell == null){
            cell = row.createCell(index);
        }
        return cell;
    }

    public static String getStringValueWith(Cell cell){
        String str;
        try{
            str = cell.getStringCellValue();
        }catch (Exception e){
            Integer intv = (int)cell.getNumericCellValue();
            str = String.format("%d",intv);
        }
        return str;
    }
}
