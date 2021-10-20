package com.jack.utils;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Calculator {
    private Queue<Character> input = new LinkedList<Character>();
    private String expString = "(1-3*(3.2-3.1)+7)";//default expression

    public Calculator() {
        init();
    }

    public Calculator(String exp) {
        expString = exp;
        init();
    }

    public double getResult() {
        return expression_value();
    }

    private void init() {
        for (int i = 0; i < expString.length(); i++) {
            input.offer(expString.charAt(i));
        }
    }

    private double expression_value() {//there maybe term in an expression
        double res = term_value();
        while (true && !input.isEmpty()) {
            char op = input.peek();
            if (op == '+' || op == '-') {
                input.poll();
                double val = term_value();
                if (op == '+')
                    res += val;
                else
                    res -= val;
            } else {
                break;
            }
        }
        return res;
    }

    private double term_value() {//there maybe factor in a term
        double res = factor_value();
        while (true && !input.isEmpty()) {
            char c = input.peek();

            if (c == '*' || c == '/') {
                input.poll();
                double val = factor_value();
                if (c == '*')
                    res *= val;
                else
                    res /= val;
            } else {
                break;
            }
        }
        return res;
    }

    private double factor_value() {//there maybe expression in a factor
        double res = 0;
        char c = input.peek();
        if (c == '(') {
            input.poll();
            res = expression_value();
            input.poll();
        } else {
            while (Character.isDigit(c)) {
                res = res * 10 + c - '0';
                input.poll();
                c = input.peek();
            }
            if (c == '.') {
                input.poll();
                c = input.peek();
                double t = 0.1;
                while (Character.isDigit(c)) {
                    res += (c - '0') * t;
                    t *= 0.1;
                    input.poll();
                    c = input.peek();
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.print("请输入应该表达式：");
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        Calculator cal = new Calculator(s);
        System.out.println(cal.getResult());
    }
}