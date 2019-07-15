package com.example.demo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author ZhangP
 * @Description
 * @since 2019-01-31 15:52
 */
public class OptionalDemo {

    private static ThreadPoolExecutor threadPool= new ThreadPoolExecutor(10, 20,
            3, TimeUnit.SECONDS, new LinkedBlockingQueue<Runnable>());

    public static void main(String[] args) {
        // 绝对路径
        long startTime=System.currentTimeMillis();
        File rootFile = new File("E:\\LearnPython");
        List<File> allFileList = new ArrayList<>();
        String search = "python";
        findMaxAndMinFile(rootFile, allFileList, search);
        for (File file : allFileList) {
            //创建基于文件的输入流
            try {
                FileInputStream fis = new FileInputStream(file);
                //创建字节数组，其长度就是文件的长度
                byte[] all = new byte[(int) file.length()];
                //以字节流的形式读取文件所有内容
                fis.read(all);
                for (byte b : all) {
                    //打印出来是65 66
                    System.out.println(b);
                }

                //每次使用完流，都应该进行关闭
                fis.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        long endTime=System.currentTimeMillis();
        System.out.println("程序运行时间： "+(endTime-startTime)+"ms");
    }

    static void findMaxAndMinFile(File file, List<File> allFileList, String search) {
        if (file.isDirectory()) {
            File[] fs = file.listFiles();
            for (int i = 0; i < fs.length; i++) {
                if (fs[i].isFile()) {
//                    String fileContent = readFileConent(fs[i]);
                    File threadFile = fs[i];
//                    if (fileContent.contains(search)) {
//                        System.out.printf("找到子目标字符串%s,在文件:%s%n", search, threadFile);
//                    }
                    threadPool.execute(new Runnable() {
                        @Override
                        public void run() {
                            String fileContent = readFileConent(threadFile);
                            if (fileContent.contains(search)) {
                                System.out.printf("找到子目标字符串%s,在文件:%s%n", search, threadFile);
                            }
                        }
                    });
                } else if (fs[i].isDirectory()) {
                    findMaxAndMinFile(fs[i], allFileList, search);
                }
            }
        }
    }

    private static String readFileConent(File file) {
        try (FileReader fr = new FileReader(file)) {
            char[] all = new char[(int) file.length()];
            fr.read(all);
            return new String(all);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
