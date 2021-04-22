import java.io.File;
import java.nio.file.Files;
import java.util.ArrayList;

/**
 * @author LiuFeng
 */
public class IndexGenerator {
    public static void main(String[] args) {
        folderMethod2("./");
    }

    public static void folderMethod2(String path) {
        File file = new File(path);
        if (file.isDirectory() && file.exists()){
            File[] files = file.listFiles();
            String title = file.getName();
            String html = String.format("<!DOCTYPE html><html lang=\"zh-CN\"><head><meta charset=\"UTF-8\"><title>%s</title></head><body><h1>%s</h1><ul>\n",title,title);
            for (File subFile : files) {
                if (!validFile(file)){
                    continue;
                }

                if (subFile.isDirectory()) {
                    System.out.println("文件夹:" + file.getPath()+subFile.getName());
                    String e = String.format("<li><a href=\"%s\">%s</a></li>\n",subFile.getName(),file.getPath()+subFile.getName());
                    html += e;
                    folderMethod2(subFile.getPath());
                } else {
                    System.out.println("文件:" +file.getPath()+ subFile.getName());
                    String name = subFile.getName().replace(".md","");
                    String e = String.format("<li><a href=\"%s\">%s</a></li>\n",name,file.getPath()+name);
                    html += e;
                }
            }
            html += "</ul></body></html>";
        }
    }

    public static boolean validFile(File file){
        String c = file.getName().substring(0,0);
        if (c.equals(".")){
            return false;
        }
        if (file.getName().equals("index.html")){
            return false;
        }
        return true;
    }
}
