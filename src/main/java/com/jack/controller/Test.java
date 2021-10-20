package com.jack.controller;

import com.jack.utils.Compute;
import com.jack.utils.Data;
import com.jack.utils.Fraction;
import java.util.ArrayList;
import java.util.List;

/**
 * @author jack
 * 为了测试分数四则运算
 */
public class Test {
    public static void main(String[] args) {

        Fraction cal = new Fraction();
        Compute compute = new Compute();
        Data data1 = new Data();
        List<String> data = new ArrayList<>();
        List<String> operation = new ArrayList<>();
        int operatorNum = 0;


        operatorNum = 4;  // 运算符的个数
        data.add(0, data1.Data(args));

        System.out.print(data.get(0));
        for (int i = 0; i < operatorNum; i++) {
            operation.add(i, cal.operation());
            data.add(i + 1, data1.Data(args));
            System.out.print(" " + operation.get(i) + " " + data.get(i + 1));
        }


        // 根据用户输入进行具体运算
        for (int i = operatorNum; i > 0; i--) {
            data.add(i -1, compute.compute(data.get(i), operation.get(i - 1), data.get(i - 1)));
        }
        System.out.print(" = " + data.get(0));
//	  }
    }
}

