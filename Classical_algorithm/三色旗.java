package a;
import java.math.BigInteger;
import java.util.*;
public class Main{
public static void main(String[] args) {
System.out.println("���������ӵ���ɫ�ַ���");
Scanner cin = new Scanner(System.in);
while(cin.hasNext()){
String n=cin.next();
char[] a=n.toCharArray();
int b=0,w=0,r=a.length-1;
int count=0;
while(w<=r) {
if(a[w]=='��')
{
w++;
}else if(a[w]=='��'){
char m=a[w];
a[w]=a[b];
a[b]=m;
w++;
b++;
count++;
}else if(a[w]=='��'){
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
System.out.print("��������"+count+"��");
}
cin.close();
}
}