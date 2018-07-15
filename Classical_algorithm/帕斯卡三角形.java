package a;
import java.math.BigInteger;
import java.util.*;
public class Main{
public static void main(String[] args) {
System.out.println("«Î ‰»În");
Scanner cin = new Scanner(System.in);
while(cin.hasNext()){
int n=cin.nextInt();
int[][] a=new int[n+1][n+1];
for(int i=0;i<n;i++) {
for(int k=0;k<n-i;k++) {
System.out.print(" ");
}
for(int j=0;j<i+1;j++) {
if(j==0||j==n-1) {
a[i][j]=1;
}
else {
a[i][j]=a[i-1][j-1]+a[i-1][j];
}
System.out.print(a[i][j]+" ");
}
System.out.println();
}
}
cin.close();
}
}