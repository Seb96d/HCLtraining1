package com.company;

import java.util.*;

public class Main {

    public static void main(String[] args) {
//        ArrayList<String> list = new ArrayList<>();
//
//        list.add("Hyzio");
//        list.add("Dyzio");
//        list.add("Zyzio");
//
//        for (String x : list)
//            System.out.println(x);
//
//        Iterator<String> iterator = list.iterator();
//
//        while(iterator.hasNext())
//            System.out.println(iterator.next());
//
//        HashMap<String,String> hashMap = new HashMap<>();
//        hashMap.put("name", "Seb");
//        hashMap.put("address","Poland");
//        hashMap.put("hobby","food");
//
//        Set<String> keys = hashMap.keySet();
//
//        for(Map.Entry<String, String> entry: hashMap.entrySet()) {
//            String key = entry.getKey();
//            Object value = entry.getValue();
//            System.out.println(key+"\t| "+value);
//        }
//
//
//        String Key = "Seb";
//        for(Map.Entry<String, String> entry: hashMap.entrySet()) {
//            if(entry.getValue() == Key) {
//                System.out.println("\nThe value of Key: " + Key + " is " + entry.getKey());
//                break;
//            }
//        }
//
//
        assignment();

    }

    public static void assignment(){
        char[] chars = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
        char pair;
        HashMap<Character,Integer> pairs = new HashMap<>();
        for (int i = 0; i < chars.length; i++) {
            System.out.print(chars[i]+ " : ");
            for (int j = i+1; j < chars.length; j++) {
                pair = (char) (chars[i] & chars[j]);
                System.out.print(chars[i]+""+chars[j]+" = "+pair+" | ");
                if (!pairs.containsKey(pair))
                    pairs.put(pair,1);
                else
                    pairs.put(pair,pairs.get(pair)+1);
            }
            System.out.println();
        }
        System.out.println(pairs);
        }
}

/*
Part 1.
char[]  =  {a ... z }
All possible combinations for set of 2 characters .... Ignore duplications .[a , b]  [b,a]

a { ab , ac , ad .......}
bc { bc , bd,... bz}


Part 2.
 [a b]  = (a & b)  ==> c

Part 3.

How many combination retuning each character ===>

 a > 10
 b > 5
 c > 23
 */