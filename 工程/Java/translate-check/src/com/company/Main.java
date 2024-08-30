package com.company;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {
        String notice = "\n参数缺失：\n1.路        径:必要参数，如：/Users/feng/gits/RPlus.iOS.Doctor/RPlusHealthDoctor";
        if (args.length == 0){
            System.out.println(notice);
            return;
        }

        //1.路径
        String dir = args[0];
        //2.pattern
        String pattern = "\"id_(.*?)\"";
        if (args.length >= 2){pattern = args[1];}

        String fileName = "";
        ArrayList<String> filelist = new ArrayList<>();
        String [] filters = new String[] {"zh.strings"};
        findFileList(new File(dir),filelist,filters);
        for (int i = 0; i < filelist.size(); i++) {
            String e = filelist.get(i);
            if (e.contains("zh.strings")){
                fileName = e;
                break;
            }
        }
        if (fileName.length() == 0){
            System.out.println("路径输入错误，没找到zh.strings文件");
            return;
        }

        Set<String> set = findTextFromFile(fileName,pattern);
        List<String> list = findTextFromDir(dir,pattern);
        ArrayList<String> lackList = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            String e = list.get(i);
            if (!set.contains(e) && e.length() > 10){
                lackList.add(e);
                System.out.println(e);
            }
        }
        System.out.println(lackList.size());
    }

    public static List<String> findChineses(String str){
        ArrayList<String> list = new ArrayList<>();
        if (str.contains("//") || str.contains("Log")){
            return list;
        }
        String pattern = "\".*?\"";
        // 创建 Pattern 对象
        Pattern r = Pattern.compile(pattern);
        // 现在创建 matcher 对象
        Matcher m = r.matcher(str);
        while (m.find()){
            String chinesePattern = "[\u4e00-\u9fa5]";
            // 创建 Pattern 对象
            Pattern cr = Pattern.compile(chinesePattern);
            // 现在创建 matcher 对象
            Matcher cm = cr.matcher(m.group(0));
            if (cm.find()){
                list.add(m.group(0));
            }
        }
        return list;
    }

    //在一段文字中找匹配
    public static List<String> findTextFromString(String str,String pattern){
        ArrayList list =  new ArrayList<String>();

        // 创建 Pattern 对象
        Pattern r = Pattern.compile(pattern);
        // 现在创建 matcher 对象
        Matcher m = r.matcher(str);
        while (m.find()){
            list.add(m.group(0));
        }

        List<String> chineseList = findChineses(str);
        list.addAll(chineseList);

        return list;
    }

    //在一个文件中找匹配
    public static Set<String> findTextFromFile(String fileName,String pattern){
        File file = new File(fileName);
        BufferedReader reader = null;
        ArrayList<String> results = new ArrayList<>();
        try {
            reader = new BufferedReader(new FileReader(file));
            String tempString = null;
            int line = 1;
            // 一次读入一行，直到读入null为文件结束
            while ((tempString = reader.readLine()) != null) {
                // 显示行号
                List list = findTextFromString(tempString,pattern);
                results.addAll(list);
                line++;
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e1) {
                }
            }
        }
        Set<String> set = new TreeSet<>();
        set.addAll(results);
        return set;
    }

    //找出目录下的所有文件
    public static void findFileList(File dir, List<String> fileNames,String[] fileFilters) {
        if (!dir.exists() || !dir.isDirectory()) {// 判断是否存在目录
            return;
        }
        String[] files = dir.list();// 读取目录下的所有目录文件信息
        for (int i = 0; i < files.length; i++) {// 循环，添加文件名或回调自身
            File file = new File(dir, files[i]);
            if (file.isFile()) {// 如果文件
                String fileName = file.getName();
                boolean fileValid = fileFilters.length == 0 ? true : false;
                for (int j = 0; j < fileFilters.length; j++) {
                    if (fileName.contains(fileFilters[j])){
                        fileValid = true;
                        break;
                    }
                }
                if (fileValid){
                    fileNames.add(dir + "/" + file.getName());// 添加文件全路径名
                }
            } else {// 如果是目录
                findFileList(file, fileNames,fileFilters);// 回调自身继续查询
            }
        }
    }

    //找出目录下的所有匹配文本
    public static List<String> findTextFromDir(String dirPath,String pattern){
        File dir = new File(dirPath);
        ArrayList<String> fileList = new ArrayList<>();
        String [] filters = new String[] {".swift",".m"};
        findFileList(dir,fileList,filters);

        Set<String> ts = new TreeSet<String>();
        for (int i = 0; i < fileList.size(); i++) {
            Set set = findTextFromFile(fileList.get(i),pattern);
            ts.addAll(set);
        }
        List<String> list = new ArrayList<>();
        list.addAll(ts);
        return list;
    }
}
