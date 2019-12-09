package com.toffee.dsa.programmingTopic;

import java.io.File;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author: glz
 * @Description: //广度优先遍历文件夹  并输出所有文件名称
 * @Date: Create in 8:47 2019/11/4
 */
public class BreadthFirstTravesalFolder {
    public static  void main (String[] args) {
        String folderPath = "D:\\projects\\一站式检索\\一站式检索、检索智判原型页面";
        LinkedList<String> filePathList = new LinkedList<>();
        filePathList.add(folderPath);
        CycleTravesal(filePathList);
    }

    /**
     * 递归遍历文件夹
     * @param filePathList
     */
    private static void RecursiveTravesal(LinkedList<String> filePathList) {
        //如果队列为空 直接返回
        if (filePathList == null || filePathList.size() == 0) {
            return ;
        }
        //获取队列头元素  并移除
        String filePath = filePathList.removeFirst();
        File file = new File(filePath);
        //如果头元素是文件  则直接输入路径和名称
        if (file.isFile()) {
            System.out.println(file.getAbsolutePath());
        } else {
            //如果是文件夹的话则遍历处理所有的子文件 以及目录 子文件直接输出 子目录添加到队列中
            File[] childrenFile = file.listFiles();
            for (File child : childrenFile) {
                if (child.isFile()) {
                    System.out.println(child.getAbsolutePath());
                } else {
                    filePathList.add(child.getAbsolutePath());
                }
            }
        }

        //判断  如果队列不为空  则递归调用此方法
        if (!filePathList.isEmpty()) {
            RecursiveTravesal(filePathList);
        }
    }

    /**
     * 循环遍历文件夹
     * @param filePathList
     */
    private static void CycleTravesal(LinkedList<String> filePathList) {
        //如果队列为空 直接返回
        while (filePathList != null && filePathList.size() != 0) {
            //获取队列头元素  并移除
            String filePath = filePathList.removeFirst();
            File file = new File(filePath);
            if (file != null) {
                System.out.println(file.getAbsolutePath());

                //如果是文件夹的话则遍历处理所有的子文件 以及目录 子文件直接输出 子目录添加到队列中
                File[] childrenFile = file.listFiles();
                for (File child : childrenFile) {
                    if (child.isFile()) {
                        System.out.println(child.getAbsolutePath());
                    } else {
                        filePathList.add(child.getAbsolutePath());
                    }
                }
            }
        }
    }
}
