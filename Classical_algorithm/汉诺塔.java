package a;
import java.math.BigInteger;
import java.util.*;
public class Main{
public static void main(String[] args) {
System.out.println("请输入n个盘子：");
Scanner cin = new Scanner(System.in);
while(cin.hasNext()){
int n=cin.nextInt();
char x='A',y='B',z='C';
haoi(n,x,y,z);
}
cin.close();
}
static void haoi(int n, char source,char depend,char purpose) {
if(n==1) {
move(n,source,purpose);
}
else {
haoi(n-1,source,purpose,depend);
move(n,source,purpose);
haoi(n-1,depend,source,purpose);
}
}
static int i=1;
static void move(int n, char source,char purpose) {
System.out.println("第"+(i++)+"步：将盘子"+n+"从"+source+"-------->移到"+purpose);
}
}