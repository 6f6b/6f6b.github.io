package com;

import java.util.ArrayList;

public class LeetCode {
    public LeetCode(){
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        int[] result = twoSum(nums,target);
        String s = "aaabbbcccccccc";
        System.out.println(strongPasswordChecker(s));
    }
    public int[] twoSum(int[] nums, int target) {
        for(int i=0;i<nums.length;i++){
            for(int j=i+1;j<nums.length;j++){
                if (nums[i]+nums[j] == target){
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{0,0};
    }

    public int strongPasswordChecker(String s) {
        //需要增
        //需要减
        //需要变

        //一个增操作{增、变
        //一个减操作{减
        //一个变操作{变

        //6到20位
        int addNum = 0;
        int reduceNum = 0;
        if (s.length() < 6){
            addNum = 6-s.length();
        }
        if (s.length() > 20){
            reduceNum = s.length()-20;
        }

        //至少一个大写、一个小写、一个数字
        int upperNum = 1;
        int lowerNum = 1;
        int digitNum = 1;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (upperNum == 1 && c >= 65 && c <=90){
                upperNum = 0;
            }
            if (lowerNum == 1 && c >= 97 && c <=122){
                lowerNum = 0;
            }
            if (digitNum == 1 && c >= 30 && c <= 39){
                digitNum = 0;
            }
            if (upperNum+lowerNum+digitNum == 0){
                break;
            }
        }
        int changeNum = upperNum+lowerNum+digitNum;
        //不能连续3个一样的字符
        /*需要找出有几个连续串，并记录每个串的长度*/
        ArrayList<Integer> seq = findSeq(s);
        {
            {
                if (addNum == 0){
                    if (changeNum == 0) {
                        if (seq.size() == 0){
                            return 0;
                        }
                        if (seq.size() > 0){
                            int n = retrieveChangeOperationNumWith(seq);
                            return n;
                        }
                    }
                    if (changeNum > 0){
                        if (seq.size() == 0){
                            return changeNum;
                        }
                        if (seq.size() > 0){
                            int n = retrieveChangeOperationNumWith(seq);
                            return max(changeNum,n);
                        }
                    }
                }
                if (addNum > 0){
                    if (changeNum == 0) {
                        if (seq.size() == 0){
                            return addNum;
                        }
                        if (seq.size() > 0){
                            int addN = retrieveAddOperationNumWith(seq);
                            int changeN = retrieveChangeOperationNumWith(seq);
                            if (addNum >= addN){return addNum;}
                            else{

                            }
                        }
                    }
                    if (changeNum > 0){
                        if (seq.size() == 0){
                            return max(addNum,changeNum);
                        }
                        if (seq.size() > 0){

                        }
                    }
                }
            }
            {
                if (reduceNum == 0){
                    if (changeNum == 0) {
                        if (seq.size() == 0){
                            return 0;
                        }
                        if (seq.size() > 0){

                        }
                    }
                    if (changeNum > 0){
                        if (seq.size() == 0){
                            return changeNum;
                        }
                        if (seq.size() > 0){

                        }
                    }
                }
                if (reduceNum > 0){
                    if (changeNum == 0) {
                        if (seq.size() == 0){
                            return reduceNum;
                        }
                        if (seq.size() > 0){

                        }
                    }
                    if (changeNum > 0){
                        if (seq.size() == 0){
                            return reduceNum+changeNum;
                        }
                        if (seq.size() > 0){

                        }
                    }
                }
            }
        }

        if (seq.size() == 0 && upperNum*lowerNum*digitNum != 0 && addNum == 0 && reduceNum == 0){
            return 0;
        }
        return 1;
    }

    public int max(int a,int b){
        return a > b ? a : b;
    }

    int retrieveChangeOperationNumWith(ArrayList<Integer> seq,int addNum){
        return 1;
    }

    public int retrieveChangeAfterAddOperationNumWith(ArrayList<Integer> seq,int addNum){
        if (addNum == 0){
            return retrieveChangeOperationNumWith(seq);
        }

        for (int i = 0; i < seq.size(); i++) {
            int n = seq.get(i);
//            op += n/3;
        }
        //to delete
        return 0;
    }

    //变需要的最少次数
    public int retrieveChangeOperationNumWith(ArrayList<Integer> seq){
        int op = 0;
        for (int i = 0; i < seq.size(); i++) {
            int n = seq.get(i);
            op += n/3;
        }
        return op;
    }
    //加需要的最少次数
    public int retrieveAddOperationNumWith(ArrayList<Integer> seq){
        int op = 0;
        for (int i = 0; i < seq.size(); i++) {
            int n = seq.get(i);
            op += n/2 - (n%2 == 0 ? 1 : 0);
        }
        return op;
    }
    //减需要的最少次数
    public int retrieveReduceOperationNumWith(ArrayList<Integer> seq){
        int op = 0;
        for (int i = 0; i < seq.size(); i++) {
            int n = seq.get(i);
            op += (n-2);
        }
        return op;
    }
    //减需要的最少次数
    public ArrayList<Integer> findSeq(String s){
        ArrayList<Integer> seq = new ArrayList<>();
        char prec = 0;
        int seqNum = 1;
        for (int i = 0; i < s.length(); i++) {
            char nowc = s.charAt(i);
            if (nowc == prec){
                seqNum = seqNum + 1;
                if (i == s.length()-1 && seqNum >= 3){
                    seq.add(seqNum);
                }
            }else{
                if (seqNum >= 3){
                    seq.add(seqNum);
                }
                seqNum = 1;
            }
            prec = nowc;
        }
        return seq;
    }
}
