package a;
import java.math.BigInteger;
import java.util.*;
public class Main{
public static void main(String[] args) {
System.out.println("«Î ‰»În");
Scanner cin = new Scanner(System.in);
while(cin.hasNext()){
int n=cin.nextInt();
int[] a=new int[n+1];
for(int i=1;i<n+1;i++) {
System.out.print(sum(i,a)+" ");
}
}
cin.close();
}
static int sum(int n ,int[] a) {
if(n==1||n==2) {
a[n]=1;
}else {
a[n]=sum(n-1,a)+sum(n-2,a);
}
return a[n];
}
}