/**
* 再帰が苦手につき、練習
* 
* 再帰を使って階乗を求める
*
* @author chisaton
* @version Spring 2016
*
**/

public class Sum{
    public int numberSum(int num){
        if(num == 1){
            return 1;
        }else{
            return numberSum(num-1) + num;
        }
    }
}