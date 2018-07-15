package a;
import java.math.BigInteger;
import java.util.*;
public class Main{
public static void main(String[] args) {
System.out.println("请输入旗子的颜色字符串");
Scanner cin = new Scanner(System.in);
while(cin.hasNext()){
String n=cin.next();
char[] a=n.toCharArray();
int b=0,w=0,r=a.length-1;
int count=0;
while(w<=r) {
if(a[w]=='白')
{
w++;
}else if(a[w]=='篮'){
char m=a[w];
a[w]=a[b];
a[b]=m;
w++;
b++;
count++;
}else if(a[w]=='红'){
char m=a[w];
a[w]=a[r];
a[r]=m;
r--;
count++;
}
}
for(int i=0;i<a.length;i++) {
System.out.print(a[i]);
}
System.out.println();
System.out.print("共交换了"+count+"次");
}
cin.close();
}
}