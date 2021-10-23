package com.jack.controller;

import com.jack.utils.Compute;
import com.jack.utils.Data;
import com.jack.utils.Fraction;
import com.jack.utils.TxtIO;
import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * @author jack
 * 为了测试分数四则运算
 */
public class Main {
    public static void main(String[] args) {

        Fraction cal = new Fraction();
        Compute compute = new Compute();
        Data data1 = new Data();
        TxtIO IO = new TxtIO();
        List<String> data = new ArrayList<>();
        List<String> operation = new ArrayList<>();
        int operatorNum = 0;


        operatorNum = 4;  // 运算符的个数

        String txtTitle,text;
        for (int j = 0;j < 10; j++) {
            data.add(0, data1.Data(args));
            System.out.print(data.get(0));
            txtTitle = data.get(0);
            for (int i = 0; i < operatorNum; i++) {
                operation.add(i, cal.operation());
                data.add(i + 1, data1.Data(args));
                System.out.print(" " + operation.get(i) + " " + data.get(i + 1));
                text = " " + operation.get(i) + " " + data.get(i + 1);
                txtTitle = txtTitle + text;
            }
            System.out.println();
            IO.writeTxt(txtTitle,"Exercises.txt");
        }


        // 根据用户输入进行具体运算
        for (int i = operatorNum; i > 0; i--) {
            data.add(i -1, compute.compute(data.get(i), operation.get(i - 1), data.get(i - 1)));
        }
        System.out.print(" = " + data.get(0));
//	  }
    }
}

