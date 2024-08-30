package com.company.nio;

import java.io.IOException;
import java.nio.file.*;
import java.util.Iterator;

/**
 * @author LiuFeng
 */
public class PathDemo {
    public static void main(String[] args) {
//        Path path = Paths.get("/Users/feng/Desktop/IMG_5045.HEIC");
//
//        System.out.format("toString: %s%n", path.toString());
//        System.out.format("getFileName: %s%n", path.getFileName());
//        System.out.format("getName(0): %s%n", path.getName(0));
//        System.out.format("getNameCount: %d%n", path.getNameCount());
//        System.out.format("subpath(0,2): %s%n", path.subpath(0,2));
//        System.out.format("getParent: %s%n", path.getParent());
//        System.out.format("getRoot: %s%n", path.getRoot());
//        System.out.format("%b", Files.isReadable(path));

//        Iterable<Path> pathIterator = FileSystems.getDefault().getRootDirectories();
//        for (Path p:pathIterator) {
//            surf(p);
//        }
        Path path = Paths.get("classpath:");
        surf(path);
    }

    public static void surf(Path p){
        System.out.println("当前遍历目录----------------------------------------------------"+p.toString());
        try {
            DirectoryStream<Path> stream = Files.newDirectoryStream(p, new DirectoryStream.Filter<Path>() {
                @Override
                public boolean accept(Path entry) throws IOException {
                    return true;
                    //return Files.isDirectory(entry);
                }
            });
            for (Path file: stream) {
                if (Files.isDirectory(file)){
                    System.out.println(file.getFileName()+"--文件夹");

                }else{
                    System.out.println(file.getFileName()+"--文件");
                }
            }
            stream = Files.newDirectoryStream(p, new DirectoryStream.Filter<Path>() {
                @Override
                public boolean accept(Path entry) throws IOException {
                    return Files.isDirectory(entry);
                }
            });
            for (Path file: stream) {
                if (Files.isDirectory(file)){
                    surf(file);
                }
            }
        } catch (Exception e){
            System.err.println(e);
        }
    }
}
