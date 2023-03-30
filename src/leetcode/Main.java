package leetcode;

//import java.util.*;
//
//public class Main {
//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        int n = in.nextInt();
//        List<Integer> list = new ArrayList<>();
//        Set<Integer> set = new HashSet<>();
//        list.add(2);
//        for (int i = 3; i < n; i++) {
//            boolean flag = true;
//            for (int j = 2; j <= Math.sqrt(i); j++) {
//                if (i % j == 0) {
//                    flag = false;
//                    break;
//                }
//            }
//            if (flag) {
//                set.add(i);
//                list.add(i);
//            }
//        }
//        Integer[] arr = list.toArray(new Integer[0]);
//        int len = arr.length;
//        int ansLeft = 0;
//        int ansRight = 0;
//
//        int flag2 = 0;
//
//        int k = 0;
//
//        if (set.contains(n)){
//            for (k = len - 2; k > 1; k--) {
//                for (int i = 0; i < len - 3; i++) {
//                    for (int j = i + 1; j < len - 2; j++) {
//                        if (arr[i] + arr[j] == arr[k]) {
//                            ansLeft = arr[i];
//                            ansRight = arr[j];
//                            flag2 = 1;
//                            break;
//                        }else if(arr[i] + arr[j] > arr[k]){
//                            flag2 = 2;
//                            break;
//                        }
//                    }
//                    if (flag2 == 1 || flag2 == 2) break;
//                }
//                if (flag2 == 1) break;
//            }
//        }else {
//            for (k = len - 1; k > 1; k--) {
//                for (int i = 0; i < len - 2; i++) {
//                    for (int j = i + 1; j < len - 1; j++) {
//                        if (arr[i] + arr[j] == arr[k]) {
//                            ansLeft = arr[i];
//                            ansRight = arr[j];
//                            flag2 = 1;
//                            break;
//                        }else if(arr[i] + arr[j] > arr[k]){
//                            flag2 = 2;
//                            break;
//                        }
//                    }
//                    if (flag2 == 1 || flag2 == 2) break;
//                }
//                if (flag2 == 1) break;
//            }
//        }
//
//        if (k == 1) {
//            System.out.println(-1);
//        } else {
//            System.out.println(ansLeft + " " + ansRight);
//        }
//    }
//}


import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        System.out.println("1\n" +
                "3 7\n" +
                "6 0 2\n" +
                "11 8 13 10");
    }
}




























