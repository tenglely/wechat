package com.wechat.util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

/**
 * 工具类
 * 用于关键词屏蔽
 * @author liten
 *
 */
public class Keyword {
	
	/**
	 * 屏蔽关键词
	 * @param word
	 * @param path
	 * @return
	 */
	public static String keyword(String word,String path){
        String charset = "utf-8";
        //String path="D:/新建文件夹/wechat_real/src/main/webapp/image/";
        File file = new File(path,"keyword.txt");
        long fileByteLength = file.length();
        byte[] content = new byte[(int)fileByteLength];
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream(file);
            fileInputStream.read(content);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fileInputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        String str = null;
		try {
			str = new String(content,charset);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		int a=str.indexOf(word);
		if(a>=0){
			word="******";
		}
		System.out.println(word);
		return word;
	}
	
	/**
	 * 添加需屏蔽的关键词
	 * @param word
	 * @param path
	 * @throws IOException
	 */
	public static void addKeyword(String word,String path) throws IOException{
		String charset = "utf-8";
        //String path="D:/新建文件夹/wechat_real/src/main/webapp/image/";
        File file = new File(path,"keyword.txt");
        long fileByteLength = file.length();
        byte[] content = new byte[(int)fileByteLength];
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream(file);
            fileInputStream.read(content);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fileInputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        String str = null;
		try {
			str = new String(content,charset);
			System.out.println(str);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		 File writename = new File(path,"keyword.txt"); // 相对路径，如果没有则要建立一个新的output。txt文件   
         BufferedWriter out = new BufferedWriter(new FileWriter(writename));  
         out.write(str+" "+word); // \r\n即为换行  
         out.flush(); // 把缓存区内容压入文件  
         out.close(); // 最后记得关闭文件  
	}
	
	/**
	 * 取出所有需屏蔽的关键词
	 * @param path
	 * @return
	 */
	public static String allkeyword(String path){
		String charset = "utf-8";
        //String path="D:/新建文件夹/wechat_real/src/main/webapp/image/";
        File file = new File(path,"keyword.txt");
        long fileByteLength = file.length();
        byte[] content = new byte[(int)fileByteLength];
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream(file);
            fileInputStream.read(content);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fileInputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        String str = null;
		try {
			str = new String(content,charset);
			System.out.println(str);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return str;
	}
	
}
