/**
* 再帰が苦手につき、練習
* 金額に応じて何通りの払い方があるかを求める
*
* @author chisaton
* @version Spring 2016
*
**/

enum Money
{
    QUARTER(25), DIME(10), NICKEL(5), PENNY(1);
    
    private int value;
    
    Money(int value) {
        this.value = value;
    }
    
    public int getValue(){
        return this.value;
    }
}

public class HowMany {
    public int howMany(int n) {
        if(n < 0) {
            return 0;
        } else if(n == 0) {
            return 1;
        } else {
        return howMany(n - Money.QUARTER.getValue()) +  howMany(n - Money.DIME.getValue()) +
         howMany(n - Money.NICKEL.getValue()) +  howMany(n - Money.PENNY.getValue());
        }
    }   
}