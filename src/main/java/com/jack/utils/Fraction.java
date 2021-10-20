package com.jack.utils;


/**
 * @author jack
 * 分数四则运算  随机生成分数
 */
public class Fraction {
    int inte;  // 整数
    int numerator;  // 分子
    int denominator; // 分母

    public Fraction() {
    }


    public String Format(int a, int b) {
        if (a % b == 0){
            return a / b + "";
        }else if (a > b) {
            return a / b + "'" + a % b + "/" + b;
        } else return a + "/" + b;
    }

    public Fraction(int a, int b, int c) {
        if (b == 0) {
            inte = a;
            numerator = 0;
            denominator = c;
        } else {
            setNumeratorAndDenominator(a, b, c);
        }
    }

    void setNumeratorAndDenominator(int a, int b,int c) {  // 设置分子和分母
        int d = f(Math.abs(b), Math.abs(c));// 计算最大公约数
        inte = a;
        numerator = b / d;
        denominator = c / d;
        if (numerator < 0 && denominator < 0) {
            numerator = -numerator;
            denominator = -denominator;
        }
    }

    public Fraction(int a, int b) {
        if (a == 0) {
            numerator = 0;
            denominator = 1;
        } else {
            setNumeratorAndDenominator(a, b);
        }
    }

    void setNumeratorAndDenominator(int a, int b) {  // 设置分子和分母
        int c = f(Math.abs(a), Math.abs(b));         // 计算最大公约数
        numerator = a / c;
        denominator = b / c;
        if (numerator < 0 && denominator < 0) {
            numerator = -numerator;
            denominator = -denominator;
        }
    }

    int getInte() {
        return inte;
    }

    int getNumerator() {
        return numerator;
    }

    int getDenominator() {
        return denominator;
    }

    int f(int a, int b) {  // 求a和b的最大公约数
        if (a < b) {
            int c = a;
            a = b;
            b = c;
        }
        int r = a % b;
        while (r != 0) {
            a = b;
            b = r;
            r = a % b;
        }
        return b;
    }

    Fraction add(Fraction r1, Fraction r2) {  // 加法运算
        int a = r1.getInte();
        int b = r1.getNumerator();
        int c = r1.getDenominator();
        int d = r2.getInte();
        int e = r2.getNumerator();
        int f = r2.getDenominator();
        int newNumerator = (a * c + b) * f + c * (d * f + e);
        int newDenominator = c * f;
        Fraction result = new Fraction(newNumerator, newDenominator);
        return result;
    }

    Fraction sub(Fraction r1, Fraction r2) {  // 减法运算
        int a = r1.getInte();
        int b = r1.getNumerator();
        int c = r1.getDenominator();
        int d = r2.getInte();
        int e = r2.getNumerator();
        int f = r2.getDenominator();
        int newNumerator = (a * c + b) * f - c * (d * f + e);
        int newDenominator = c * f;
        Fraction result = new Fraction(newNumerator, newDenominator);
        return result;
    }

    Fraction muti(Fraction r1, Fraction r2) {  // 乘法运算
        int a = r1.getInte();
        int b = r1.getNumerator();
        int c = r1.getDenominator();
        int d = r2.getInte();
        int e = r2.getNumerator();
        int f = r2.getDenominator();
        int newNumerator = (a * c + b) * (d * f + e);
        int newDenominator = c * f;
        Fraction result = new Fraction(newNumerator, newDenominator);
        return result;
    }

    Fraction div(Fraction r1, Fraction r2) {  // 除法运算
        int a = r1.getInte();
        int b = r1.getNumerator();
        int c = r1.getDenominator();
        int d = r2.getInte();
        int e = r2.getNumerator();
        int f = r2.getDenominator();
        int newNumerator = (a * c + b) * f;
        int newDenominator = (d * f + e) * c;
        Fraction result = new Fraction(newNumerator, newDenominator);
        return result;
    }


    public String operation() {  // 生成运算符
        int a = (int) (Math.random() * 1000) % 4;
        String result = null;
        if (a == 0){
            result = "+";
        }else if (a == 1){
            result = "-";
        }else if (a == 2){
            result = "*";
        }else if (a == 3){
            result = "÷";
        }else result = "+";

        return result;
    }
}
