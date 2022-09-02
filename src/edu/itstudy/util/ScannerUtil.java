package edu.itstudy.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class ScannerUtil {
    private static Scanner sc=new Scanner(System.in);
    public static int readInt() {
        int i=0;
        while (true) {
            String str = readkeyBoard(3, false);
            try {

                i = Integer.parseInt(str);
            } catch (Exception e) {
                System.out.println("请选择影片序号(INDEX):");
            }
            return i;
        }
    }

    public static Date readDate(String pattern) {
        Date date=null;
        while (true) {
            String date_str = readkeyBoard(pattern.length(), false);
            SimpleDateFormat sdf = new SimpleDateFormat(pattern);
            try {
               date= sdf.parse(date_str);
            } catch (ParseException e) {
                System.out.println("时间格式有误，请重新输入：");
            continue;
            }
            break;
        }
        return date;
    }
    public static Date readDate(String pattern,Date defaultValue) {
        Date date=null;
        while (true) {
            String date_str = readkeyBoard(pattern.length(), true);
            if("".equals(date_str)){
                return defaultValue;
            }
            SimpleDateFormat sdf = new SimpleDateFormat(pattern);
            try {
                date= sdf.parse(date_str);
            } catch (ParseException e) {
                System.out.println("时间格式有误，请重新输入：");
                continue;
            }
            break;
        }
        return date;
    }

    /**
     * 从控制台读入一个字符串，为空则返回默认值
     * @param limit 指定最大长度
     * @return
     */
    public static String readString(int limit){
        return readkeyBoard(limit,false);
    }

    /**
     * 从控制台读入一个字符串，为空则返回默认值
     * @param limit  指定最大长度
     * @param defaultValue  直接敲回车返回的默认值
     * @return
     */
    public static String readString(int limit,String defaultValue){
       String str= readkeyBoard(limit,true);
       return "".equals(str) ? defaultValue : str;
    }
    public static char readMenuSelect(int size){
        char c=' ';
        while (true) {
            String str = readkeyBoard(1, false);
             c = str.charAt(0);
             boolean r=true;
             for(int i=1;i<=size;i++){
                 r=r&&(c!=(i+'0'));
                 if(!r){
                     break;
                 }
             }
            if (r) {
                System.out.println("输入有误，请重新输入");
            } else {
                break;
            }
        }
        return c;
    }
    private static String readkeyBoard(int limit,boolean blankReturn){
        String line=null;
        while (sc.hasNextLine()) {
           line = sc.nextLine();
            line = line.trim();//去掉前后空格
            //判断line=""是否直接敲回车返回
            if (line.length() == 0) {
                if (blankReturn) {
                    return line;
                } else {
                    continue;
                }
            }
            if(line.length()>limit){
                System.out.println("输入的长度(不大于"+limit+")有误，请重新输入：");
                continue;
            }
            break;
        }
        return line;
    }
}
