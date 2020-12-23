package test;

import java.text.NumberFormat;
import java.util.Locale;
import java.util.Random;
import java.util.UUID;


public class Main {
    static public void main(String[] args) {
//        StringBuilder stringBuilder = new StringBuilder();
//        stringBuilder.append("Alo");
//        stringBuilder.append(" ");
//        stringBuilder.append("nghe");
//        stringBuilder.append(" ");
//        stringBuilder.append("ro");
//        stringBuilder.append(" ");
//        stringBuilder.append("tra");
//        stringBuilder.append(" ");
//        stringBuilder.append("loi");
//        System.out.println(stringBuilder);
//
//        stringBuilder.insert(15, " Dep trai day ");
//        System.out.println(stringBuilder);

//        String str1 = "abc";
//        String str2 = "abc";
//
//        String str3 = new String("okok");
//        String str4 = new String("okok");
//
//        System.out.println("Check String Pool");
//
//        if (str1 == str2) {
//            System.out.println("=");
//        } else {
//            System.out.println("!=");
//        }
//
//        System.out.println("Check Heap");
//
//        if (str3 == str4) {
//            System.out.println("==");
//        } else {
//            System.out.println("!==");
//        }

//        StringBuffer sb = new StringBuffer("Hello ab c rr fdsfs fdsfsd fsdfsd fdsfsd dsfsdfds fdsfsd");
//        System.out.println(sb);
//        sb.append("Java");//đến đây chuỗi ban đầu đã bị thay đổi
//        System.out.println(sb);//in Hello Java


//        String x = "   CodeGym_Viet_Nam    ";
//        System.out.println(x);
//        x = x.trim();
//        System.out.println(x);
//        int index = x.indexOf("_");
//        String y = x.substring(0, index);
//        System.out.println(y);

        NumberFormat nf = NumberFormat.getInstance(new Locale("en", "US"));
        String val = nf.format(200000000);
        System.out.println(val);
    }

}

