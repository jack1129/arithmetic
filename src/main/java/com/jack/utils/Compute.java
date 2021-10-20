package com.jack.utils;

import java.util.StringTokenizer;

public class Compute {
    // 封装了具体运算，主要为对输入进行转换，对输出封装
    public String compute(String data1, String operation, String data2) {
        Fraction fraction = new Fraction();
        StringTokenizer resolve;
        String data;
        int data1_0 = 0, data1_1 = 0, data1_2 = 0, data2_0 = 0, data2_1 = 0, data2_2 = 0;
        if (!data1.contains("/")){
            data1_0 = Integer.parseInt(data1);
            data1_1 = 0;
            data2_2 = 1;
        }else if (data1.contains("'")) {
            resolve = new StringTokenizer(data1, "'");
            data1_0 = Integer.parseInt(resolve.nextToken());
            data = resolve.nextToken();
            resolve = new StringTokenizer(data, "/");
            data1_1 = Integer.parseInt(resolve.nextToken());
            data1_2 = Integer.parseInt(resolve.nextToken());
        } else {
            resolve = new StringTokenizer(data1, "/");
            data1_1 = Integer.parseInt(resolve.nextToken());
            data1_2 = Integer.parseInt(resolve.nextToken());
        }
        if (!data2.contains("/")){
            data2_0 = Integer.parseInt(data2);
            data2_1 = 0;
            data2_2 = 1;
        }else if (data2.contains("'")) {
            resolve = new StringTokenizer(data2, "'");
            data2_0 = Integer.parseInt(resolve.nextToken());
            data = resolve.nextToken();
            resolve = new StringTokenizer(data, "/");
            data2_1 = Integer.parseInt(resolve.nextToken());
            data2_2 = Integer.parseInt(resolve.nextToken());
        } else {
            resolve = new StringTokenizer(data2, "/");
            data2_1 = Integer.parseInt(resolve.nextToken());
            data2_2 = Integer.parseInt(resolve.nextToken());
        }


        Fraction r1,r2;
        if (data1_0 != 0){
            r1 = new Fraction(data1_0, data1_1, data1_2);
        }else {
            r1 = new Fraction(data1_1, data1_2);
        }
        if (data2_0 != 0){
            r2 = new Fraction(data2_0, data2_1, data2_2);
        }else {
            r2 = new Fraction(data2_1, data2_2);
        }

        String ans = null;
        Fraction result;
        int a, b, c;
        if (operation.equals("+")) {
            result = fraction.add(r1, r2);
            a = result.getInte();
            b = result.getNumerator();
            c = result.getDenominator();
            ans = fraction.Format(a * c + b,c);
//            if (a != 0){
//                System.out.println(data1 + " " + operation + " " + data2 + " = " + a + "'" + b + "/" + c);
//            }else {
//                System.out.println(data1 + " " + operation + " " + data2 + " = " + b + "/" + c);
//            }
        }

        if (operation.equals("-")) {
            result = fraction.sub(r1, r2);
            a = result.getInte();
            b = result.getNumerator();
            c = result.getDenominator();
            ans = fraction.Format(a * c + b,c);
//            if (a != 0){
//                System.out.println(data1 + " " + operation + " " + data2 + " = " + a + "'" + b + "/" + c);
//            }else {
//                System.out.println(data1 + " " + operation + " " + data2 + " = " + b + "/" + c);
//            }
        }

        if (operation.equals("*")) {
            result = fraction.muti(r1, r2);
            a = result.getInte();
            b = result.getNumerator();
            c = result.getDenominator();
            ans = fraction.Format(a * c + b,c);
//            if (a != 0){
//                System.out.println(data1 + " " + operation + " " + data2 + " = " + a + "'" + b + "/" + c);
//            }else {
//                System.out.println(data1 + " " + operation + " " + data2 + " = " + b + "/" + c);
//            }
        }

        if (operation.equals("÷")) {
            result = fraction.div(r1, r2);
            a = result.getInte();
            b = result.getNumerator();
            c = result.getDenominator();
            ans = fraction.Format(a * c + b,c);
//            if (a != 0){
//                System.out.println(data1 + " " + operation + " " + data2 + " = " + a + "'" + b + "/" + c);
//            }else {
//                System.out.println(data1 + " " + operation + " " + data2 + " = " + b + "/" + c);
//            }
        }
        return ans;
    }
}
