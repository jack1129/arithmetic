package com.jack.utils;

public class Data {
    public String Data(String[] args) {
        Fraction fraction = new Fraction();

        int numerator = (int) (Math.random() * 1000) % Integer.parseInt(args[0]) + 1;  // 分子
        int denominator = (int) (Math.random() * 1000) % Integer.parseInt(args[0]) + 1; // 分母
        while (denominator * 10 <= numerator){
            denominator = (int) (Math.random() * 1000) % Integer.parseInt(args[0]) + 1;
        }

        return fraction.Format(numerator,denominator);
    }
}
