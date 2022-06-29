package com.rk;
import java.util.Scanner;
public class WJNY {
    public static void main(String[] args) {
      /*  Scanner scanner = new Scanner(System.in);
        System.out.print("请输入密匙：");
        String s = scanner.next();
        WJNY mima = new WJNY();
        System.out.print("请输入明文：");
        String mingWen = scanner.next();
        String sl = mima.encryption(mingWen, s);
        System.out.println("加密后的密文是："+sl);*/
        int num1=5;
        int num2=1;
        System.out.println(num1&num2);
    }

    /**
     * 加密
     * @param plaintext 明文
     * @param secretKey 密钥
     * @return 密文
     */
    public String encryption(String plaintext,String secretKey){
        String ciphertext = "";
        char[][] chars = new char[2][plaintext.length()];
        for (int i = 0; i <plaintext.length() ; i++) {
            chars[0][i]=plaintext.charAt(i);
            chars[1][i]=secretKey.toUpperCase().charAt(i%(secretKey.length()));
        }
        char[] charArray = plaintext.toCharArray();
        for (int i = 0; i <charArray.length ; i++) {
            int j = charArray[i];
            if (j>=97&&j<=97+26){
                int k = chars[1][i];
                char te = (char) (((j - 97) + (k - 65)) % 26+65);
                ciphertext = ciphertext+te;
            }
            if (j>=65&&j<=65+26){
                int k = chars[1][i];
                char te = (char) (((j - 65) + (k - 65)) % 26+97);
                ciphertext = ciphertext+te;
            }
        }
        return  ciphertext;
    }
}
