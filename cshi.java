package ceshi;

import java.io.*;

public class cshi {
    public static void addContainsToFile(String filePath, int position, String contents) throws IOException {
        //1、参数校验
        File file = new File(filePath);
        System.out.println(file);
        if (!(file.exists() && file.isFile())) {
            System.out.println("文件不存在  ~ ");
            return;
        }

        if ((position < 0) || (position > file.length())) {
            System.out.println("position不合法 ~ ");
            return;
        }

        //2、创建临时文件
        File tempFile = File.createTempFile("sss", ".temp", new File("d:/"));
        FileOutputStream outputStream = new FileOutputStream(tempFile);
        FileInputStream inputStream = new FileInputStream(tempFile);
        tempFile.deleteOnExit();


        RandomAccessFile rw = new RandomAccessFile(file, "rw");
        //文件指定位置到 position
        rw.seek(position);

        int tmp;
        while ((tmp = rw.read()) != -1) {
            outputStream.write(tmp);
        }
        //6、将追加内容 contents 写入 position 位置
        rw.seek(position);
        rw.write(contents.getBytes());

        //7、将临时文件写回文件，并将创建的流关闭
        while ((tmp = inputStream.read()) != -1) {
            rw.write(tmp);
        }
        rw.close();
        outputStream.close();
        inputStream.close();
    }

    public static void main(String[] args) {
        String filePath = ("d:\\hehe.txt");
        String contents = new String("abc");
        try {
            addContainsToFile(filePath,3,contents);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
}