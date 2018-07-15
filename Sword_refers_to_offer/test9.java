public class Solution {
    public int Fibonacci(int n) {
        int re=0;
        int no=1;
        while(n!=0){
            no+=re;
            re=no-re;
            n--;
        }
        return re;
    }
}