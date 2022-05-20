package com.company;

import static com.sun.tools.javac.jvm.ByteCodes.swap;

public class Main {

    public static void main(String[] args) {
        int a = 1;
        int b = 4;
        System.out.println(getGreatestCommonDivisor(25, 15));
    }

    public static int getGreatestCommonDivisor(int first, int second) {
        if (first < 10 || second < 10)
            return -1;
        int divisor = 1;
        if (first < second) {
            int f=0;
            int s=0;
            for (int i = 1; i < first+1; i++) {
                if (first%i==0)
                    f = i;
                if (second%i==0)
                    s = i;
                if (f==s)
                    divisor = f;
            }
        }
        else {
            int f=0;
            int s=0;
            for (int i = 1; i < second+1; i++) {
                if (first%i==0)
                    f = i;
                if (second%i==0)
                    s = i;
                if (f==s)
                    divisor = f;
            }
        }
        return divisor;
    }
    
}
