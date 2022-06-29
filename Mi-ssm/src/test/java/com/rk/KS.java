package com.rk;
import java.util.Scanner;
public class KS {
    public static void main(String[] args) {
        System.out.println("请输入明文:");
        Scanner input = new Scanner(System.in);
        String str = input.next();
        byte[] byteArray = str.getBytes();  // string -> byte
        char[] c = new char[str.length()]; // 密文
        for (int i = 0; i < byteArray.length; i++) {
            if ((byteArray[i]-97)%26<23){  // 求余数排除xyz
                c[i] = (char)(byteArray[i]+3);
            }else{                           // xyz部分
                c[i] = (char)((byteArray[i]-26)+3);
            }
        }
        String cc = new String(c); //密文String
        System.out.println(cc);

    }
}
