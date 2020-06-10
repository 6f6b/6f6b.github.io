import org.apache.poi.openxml4j.util.ZipSecureFile;
import org.apache.poi.ss.usermodel.*;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExcelMapper {
    public PrintStream out = System.out;

    public void merge(String destination,String source){
        Workbook wb_des = null;
        Workbook wb_sou = null;
        ZipSecureFile.setMinInflateRatio(-1.0d);
        try {
            FileInputStream des_input = new FileInputStream(destination);
            wb_des = WorkbookFactory.create(des_input);
            Sheet sheet_des = wb_des.getSheetAt(0);
            int row_num_des = sheet_des.getLastRowNum();

            FileInputStream sou_input = new FileInputStream(source);
            wb_sou = WorkbookFactory.create(sou_input);
            Sheet sheet_sou = wb_sou.getSheetAt(0);
            int row_num_sou = sheet_sou.getLastRowNum();

            for (int i = 0; i <= row_num_sou; i++) {
                Row row_sou = sheet_sou.getRow(i);
                if (row_sou == null) {
                    continue;
                }
                Cell cell_sou_en = row_sou.getCell(0);
                Cell cell_sou_es = row_sou.getCell(1);

                if (cell_sou_en == null || cell_sou_es == null) {
                    continue;
                }

                String sou_en = cell_sou_en.getStringCellValue();
                String spanish = cell_sou_es.getStringCellValue();

                if (sou_en == null || spanish == null) {
                    continue;
                }

                boolean find = false;
                int row_index = 0;

                for (int j=0;j<=row_num_des;j++){
                    Row row_des = sheet_des.getRow(j);
                    if (row_des == null) {
                        continue;
                    }
                    Cell cell_des_en = row_des.getCell(0);
                    if (cell_des_en == null) {
                        continue;
                    }

                    String des_en = cell_des_en.getStringCellValue();
                    if (sou_en == null) {
                        continue;
                    }

                    if (des_en.trim().toUpperCase().equals(sou_en.trim().toUpperCase())){
                        find = true;
                        row_index = j;
                        break;
                    }
                }
                if (find == true){
                    if (spanish.length() < 1){continue;}
                    Row row = sheet_des.getRow(row_index);
                    Cell spanishCell = row.getCell(1);
                    if (spanishCell == null){
                        spanishCell = row.createCell(1);
                    }
                    spanishCell.setCellValue(spanish);
                    out.println(String.format("&匹配成功:%s\n西班：%s",sou_en,spanish));
                    out.println("***********************************");
                }else{
                    out.println(String.format("$匹配失败:%s",sou_en));
                    out.println("###################################");
                }
            }

            //输出流
            FileOutputStream fileout = new FileOutputStream(destination);
            //写出
            wb_des.write(fileout);
            //关闭流
            fileout.close();

            des_input.close();
            sou_input.close();

            wb_des.close();
            wb_sou.close();
        }catch (Exception e){
            out.println(String.format("error:%s",e.getMessage()));
        }

    }

    /*global*/
    public void replace_tran(String esPath,String englishPath,String toPath){
        Workbook wb_new = null;
        Workbook wb_old = null;
        Workbook wb_to = null;
        ZipSecureFile.setMinInflateRatio(-1.0d);
        try {
            FileInputStream old_input = new FileInputStream(esPath);
            wb_old = WorkbookFactory.create(old_input);
            Sheet es_sheet = wb_old.getSheetAt(0);
            int es_rows = es_sheet.getLastRowNum();

            FileInputStream new_input = new FileInputStream(englishPath);
            wb_new = WorkbookFactory.create(new_input);
            Sheet english_sheet = wb_new.getSheetAt(0);
            int english_rows = english_sheet.getLastRowNum();

            FileInputStream to_input = new FileInputStream(toPath);
            wb_to = WorkbookFactory.create(to_input);
            Sheet to_sheet = wb_to.getSheetAt(0);

            for (int j = 0; j <= es_rows; j++) {
                Row newRow = es_sheet.getRow(j);
                if (newRow == null) {
                    continue;
                }
                Cell es_english_cell = newRow.getCell(1);
                if (es_english_cell == null) {
                    continue;
                }

                String es_english = es_english_cell.getStringCellValue();
                if (es_english == null) {
                    continue;
                }

                boolean find = false;
                String spanish = null;
                int row_index = 0;
                for (int i = 1; i <= english_rows; i++) {
                    Row row = english_sheet.getRow(i);
                    if (row == null){continue;}
                    Cell english_cell = row.getCell(0);
                    if (english_cell == null){ continue; }
                    String englishString = english_cell.getStringCellValue();
                    if (englishString == null){continue;}

                    if (es_english.trim().equals(englishString.trim())) {
                        find = true;
                        spanish = newRow.getCell(2).getStringCellValue();
                        row_index = i;
                        break;
                    }
                    String new_english = getNewString(to_sheet, es_english);
//                    out.println(String.format("新：%s",new_english));
                    if (new_english != null && new_english.equals(englishString.trim())) {
                        find = true;
                        spanish = newRow.getCell(2).getStringCellValue();
                        row_index = i;
                        break;
                    }
                }
                if (find == false){
//                    out.println(String.format("%s--没找到匹配值",es_english));
//                    out.println("$####################################");

                }else{
                    if (es_english.length() < 1){continue;}
                    out.println(String.format("英语：%s\n西班牙：%s\nrow:%d",es_english,spanish,row_index));
                    Row row = english_sheet.getRow(row_index);
                    Cell spanishCell = row.getCell(1);
                    if (spanishCell == null){
                        spanishCell = row.createCell(1);
                    }
                    spanishCell.setCellValue(spanish);
                    out.println("$********************************************");

                }
            }

            //输出流
            FileOutputStream fileout = new FileOutputStream(englishPath);
            //写出
            wb_new.write(fileout);
            //关闭流
            fileout.close();

            new_input.close();
            old_input.close();
            to_input.close();

            wb_new.close();
            wb_old.close();
            wb_to.close();
        }catch (Exception e){
            out.println(String.format("error:%s",e.getMessage()));
        }
    }

    public String getNewString(Sheet to_sheet,String old){
        int to_rows = to_sheet.getLastRowNum();
        for (int k = 0; k <= to_rows; k++) {
            Row to_row = to_sheet.getRow(k);
            if (to_row == null) {
                continue;
            }
            Cell to_cell_old = to_row.getCell(0);
            Cell to_cell_new = to_row.getCell(1);
            if (to_cell_old == null || to_cell_new == null) {
                continue;
            }
            String to_old_value = to_cell_old.getStringCellValue();
            String to_new_value = to_cell_new.getStringCellValue();
            if (to_old_value == null || to_new_value == null) {
                continue;
            }

            if (old.trim().equals(to_old_value.trim())) {
                return to_new_value;
            }
        }
        return null;
    }

    //添加新的翻译内容
    public void global_add_new(String new_trans,String old_trans){
        Workbook wb_new = null;
        Workbook wb_old = null;
        ZipSecureFile.setMinInflateRatio(-1.0d);
        try {
            FileInputStream new_input = new FileInputStream(new_trans);
            wb_new = WorkbookFactory.create(new_input);
            Sheet new_sheet = wb_new.getSheetAt(0);
            int new_rows = new_sheet.getLastRowNum();

            FileInputStream old_input = new FileInputStream(old_trans);
            wb_old = WorkbookFactory.create(old_input);
            Sheet old_sheet = wb_old.getSheetAt(0);
            int old_rows = old_sheet.getLastRowNum();

            for (int i = 1; i <= new_rows; i++) {
                Row row = new_sheet.getRow(i);
                if (row == null){continue;}
                Cell cell = row.getCell(0);
                if (cell == null){ continue; }
                String cellValue = cell.getStringCellValue();
                if (cellValue == null){continue;}


                String insertValue = cellValue;
//                if (insertValue.length() == 0 || insertValue == null){continue;}
//                if (cellValue.contains("{\"") || cellValue.contains("br>") || cellValue.contains("<p")){
//                    out.println(cellValue);
//                    out.println("**********************************");
//                    continue;
//                }
                insert(insertValue.trim(),old_sheet);
                //out.println(String.format("%d-%s",i,insertValue));
            }

            //输出流
            FileOutputStream fileout = new FileOutputStream(old_trans);
            //写出
            wb_old.write(fileout);
            //关闭流
            fileout.close();

            new_input.close();
            old_input.close();
            wb_new.close();
            wb_old.close();
        }catch (Exception e){
            out.println(String.format("error:%s",e.getMessage()));
        }

    }
    private void insert(String insertValue,Sheet sheet){
        int rows = sheet.getLastRowNum();
        boolean canInsert = true;
        for (int i=1;i<=rows;i++){
            Row row = sheet.getRow(i);
            Cell cell = row.getCell(0);
            String value = cell.getStringCellValue();
            if (insertValue.equals(value)){
                canInsert = false;
                out.println(String.format("已存在-->%s",insertValue));
                return;
            }
        }
        Row row = sheet.createRow(rows+1);
        row.createCell(0).setCellValue(insertValue);
    }


    /**
     *
     * @param str1
     * @param str2
     */
    public void levenshtein(String str1,String str2) {
        //计算两个字符串的长度。
        int len1 = str1.length();
        int len2 = str2.length();
        //建立上面说的数组，比字符长度大一个空间
        int[][] dif = new int[len1 + 1][len2 + 1];
        //赋初值，步骤B。
        for (int a = 0; a <= len1; a++) {
            dif[a][0] = a;
        }
        for (int a = 0; a <= len2; a++) {
            dif[0][a] = a;
        }
        //计算两个字符是否一样，计算左上的值
        int temp;
        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    temp = 0;
                } else {
                    temp = 1;
                }
                //取三个值中最小的
                dif[i][j] = min(dif[i - 1][j - 1] + temp, dif[i][j - 1] + 1,
                        dif[i - 1][j] + 1);
            }
        }
        //System.out.println("字符串\""+str1+"\"与\""+str2+"\"的比较");
        //取数组右下角的值，同样不同位置代表不同字符串的比较
        //System.out.println("差异步骤："+dif[len1][len2]);
        //计算相似度
        float similarity =1 - (float) dif[len1][len2] / Math.max(str1.length(), str2.length());
        if (similarity >= 0.7 && similarity != 1.0 && similarity < 0.75){
            out.println("*****************************************************");
            out.println(str1);
            out.println(str2);
            System.out.println("相似度："+similarity);
        }
    }

    //得到最小值
    private int min(int... is) {
        int min = Integer.MAX_VALUE;
        for (int i : is) {
            if (min > i) {
                min = i;
            }
        }
        return min;
    }

    public void take_duplicate(String origin_path,String new_path,String to_path){
        Workbook wb_new = null;
        Workbook wb_old = null;
        Workbook wb_to = null;
        ZipSecureFile.setMinInflateRatio(-1.0d);
        try {

            FileInputStream new_input = new FileInputStream(new_path);
            wb_new = WorkbookFactory.create(new_input);
            Sheet new_sheet = wb_new.getSheetAt(0);
            int new_rows = new_sheet.getLastRowNum();

            FileInputStream old_input = new FileInputStream(origin_path);
            wb_old = WorkbookFactory.create(old_input);
            Sheet old_sheet = wb_old.getSheetAt(0);
            int old_rows = old_sheet.getLastRowNum();

            FileInputStream to_input = new FileInputStream(to_path);
            wb_to = WorkbookFactory.create(to_input);
            Sheet to_sheet = wb_to.getSheetAt(0);
            int to_rows = to_sheet.getLastRowNum();

            for (int i = 1; i <= new_rows; i++) {
                int cellIndex = 4;
                Row row = new_sheet.getRow(i);
                if (row == null){continue;}
                Cell cell = row.getCell(cellIndex);
                if (cell == null){ continue; }
                String cellValue = cell.getStringCellValue();
                if (cellValue == null){continue;}

                Row _row = old_sheet.getRow(i);
                if (_row == null){continue;}
                Cell _cell = _row.getCell(cellIndex);
                if (_cell == null){ continue; }
                String _cellValue = _cell.getStringCellValue();
                if (_cellValue == null){continue;}

                if (!_cellValue.trim().equals(cellValue.trim())){
                    out.println(String.format("旧：%s",_cellValue));
                    out.println(String.format("新：%s",cellValue));
                    out.println("******************************************");
                }

            }

            for (int i = 1; i <= new_rows; i++) {
                int cellIndex = 4;
                Row row = new_sheet.getRow(i);
                if (row == null){continue;}
                Cell cell = row.getCell(cellIndex);
                if (cell == null){ continue; }
                String cellValue = cell.getStringCellValue();
                if (cellValue == null){continue;}

                Row _row = old_sheet.getRow(i);
                if (_row == null){continue;}
                Cell _cell = _row.getCell(cellIndex);
                if (_cell == null){ continue; }
                String _cellValue = _cell.getStringCellValue();
                if (_cellValue == null){continue;}

                if (!_cellValue.trim().equals(cellValue.trim())){
                    out.println(String.format("旧：%s",_cellValue));
                    out.println(String.format("新：%s",cellValue));
                    out.println("******************************************");
//                    insertTwo(_cellValue.trim(),cellValue.trim(),to_sheet);
                }

            }

            //输出流
            FileOutputStream fileout = new FileOutputStream(to_path);
            //写出
            wb_to.write(fileout);
            //关闭流
            fileout.close();

            new_input.close();
            old_input.close();
            to_input.close();
            wb_new.close();
            wb_old.close();
            wb_to.close();
        }catch (Exception e){
            out.println(String.format("error:%s",e.getMessage()));
        }
    }

    private void insertTwo(String oldI,String newI,Sheet sheet){
        int rows = sheet.getLastRowNum();
        boolean canInsert = true;
        for (int i=1;i<=rows;i++){
            Row row = sheet.getRow(i);
            Cell cell = row.getCell(0);
            String value = cell.getStringCellValue();
            if (oldI.equals(value)){
                canInsert = false;
                out.println(String.format("已存在-->%s",oldI));
                return;
            }
        }
        Row row = sheet.createRow(rows+1);
        row.createCell(0).setCellValue(oldI);
        row.createCell(1).setCellValue(newI);
    }

    public static void main(String[] args) {

    }

    //开发文档剔除json
    private void global_clear_developer_json(String p){

    }

    //翻译文档去重
    public void global_deduplication(String translate_path){
        Workbook wb = null;
        ZipSecureFile.setMinInflateRatio(-1.0d);
        try {
            FileInputStream new_input = new FileInputStream(translate_path);
            wb = WorkbookFactory.create(new_input);
            Sheet new_sheet = wb.getSheetAt(0);
            int new_rows = new_sheet.getLastRowNum();

            for (int i = 0; i <= new_rows; i++) {
                Row row = new_sheet.getRow(i);
                if (row == null){continue;}
                Cell cell = row.getCell(0);
                if (cell == null){ continue; }
                String cellValue = cell.getStringCellValue();
                if (cellValue == null){continue;}
                for (int j=0;j <= new_rows;j++){
                    Row _row = new_sheet.getRow(j);
                    if (_row == null){continue;}
                    Cell _cell = _row.getCell(0);
                    if (_cell == null){ continue; }
                    String _cellValue = _cell.getStringCellValue();
                    if (_cellValue == null){continue;}
                    levenshtein(cellValue,_cellValue);
                }
                //out.println(String.format("%d-%s",i,cellValue));
            }

            new_input.close();
            wb.close();
        }catch (Exception e){
            out.println(String.format("error:%s",e.getMessage()));
        }
    }
    //翻译到开发
    public void global_dev_to_translate(String dev_path,String translate_path){

    }
    //开发到翻译
}
