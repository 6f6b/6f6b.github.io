import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author LiuFeng
 */
public class IndexGenerator {
    public static void main(String[] args) {
        folderMethod2(".");
        System.out.println("success!");
    }

    public static void folderMethod2(String path) {
        File file = new File(path);
        if (file.isDirectory() && file.exists()){
            File[] files = file.listFiles();
            String title = file.getName();
            String html = String.format("<!DOCTYPE html><html lang=\"zh-CN\"><head><meta charset=\"UTF-8\"><title>%s</title></head><body><ul>\n",title,title);
            for (File subFile : files) {
                if (!validFile(subFile)){
                    continue;
                }

                if (subFile.isDirectory()) {
                    String e = String.format("<h2><li><a href=\"%s\">%s >></a></li></h2>\n",subFile.getName(),subFile.getName());
                    html += e;
                    folderMethod2(subFile.getPath());
                } else {
                    String name = subFile.getName().replace(".md","");
                    String e = String.format("<h2><li><a href=\"%s\">%s</a></li></h2>\n",name,name);
                    html += e;
                }
            }
            html += "</ul></body></html>";
            FileWriter fileWriter = null;
            try {
                // true表示不覆盖原来的内容，而是加到文件的后面。若要覆盖原来的内容，直接省略这个参数就好
                fileWriter = new FileWriter(file.getPath()+"/index.html");
                fileWriter.write(html);
            } catch (IOException ex) {
                ex.printStackTrace();
            } finally {
                try {
                    fileWriter.flush();
                    fileWriter.close();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        }
    }

    public static boolean validFile(File file){
        String fileName = file.getName();
        if (fileName.length() >= 2){
            char c = file.getName().charAt(0);
            if (c == '.'){
                return false;
            }
            if (fileName.contains("工程")){
                return false;
            }
            if (fileName.contains(".class")){
                return false;
            }
            if (fileName.contains("_config.yml")){
                return false;
            }
        }
        if (file.getName().equals("index.html")){
            return false;
        }
        return true;
    }
}
