/**
* 再帰が苦手につき、練習
* 
* 再帰を用いて最大値を求める
*
* @author chisaton
* @version Spring 2016
*
**/


import java.util.*;
public class Max {
    public int getMax(ArrayList<Integer> nums) {
        if(nums.size() == 0) {
            return 0;
        } else {
            int num = nums.remove(nums.size()-1);
            return Math.max(getMax(nums), num);
        }
    }
}