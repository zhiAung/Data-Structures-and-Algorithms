/*��öӲ��,Ҫ��ȽϵĴ������٣�������ʹ�÷�֧�������Զ���֮һ��������С��Χ������������*/
package a;
import java.math.BigInteger;
import java.util.*;
public class Main{   
	//�Լ����巽���Ĳ���Ҫ����static��������Ҫ���������е��þ���Ҫstatic�ˣ���Ϊmain�Ǿ�̬ �ģ��������ʱ�ͼ����ˡ�
    public static  void main(String[] args)  {  
    	System.out.println("������10��Ӳ�ҵ�������");
        Scanner cin = new Scanner(System.in);  
        int []a=new int[10];
        
        while(cin.hasNext()){
        	for(int i=0;i<8;i++) {
        	  a[i]=cin.nextInt();
        	  
        	}
        	String ss=    func(a);
            System.out.println(ss);
 }
        
        cin.close();      
    }
    public  static  String func(int a[]) {
    	int sum1=a[0]+a[1]+a[2];
    	int sum2=a[3]+a[4]+a[5];
    	if (sum1>sum2) {
    	int	sum11=a[0]+a[3];
    	int	sum22=a[1]+a[4];
    	if (sum11>sum22) {//����һ���Ϳ��Եó�a[0]>a[4],���Դ�a[0]��a[4]ѡһ���������ȽϾͿ����ˡ�
    		if(a[0]>a[1]) {//���ﻹ��һ�����ɣ����ǲ��ϵĽ���Ƚϣ�������ͬ��ıȽϣ�
    			           //����������Ч����ǰ��Ƚϵó���һ������Ϣ������Ч�ʸ���
    			String s=Integer.toString(a[0]);
    			return "��һöӲ���Ǽٱ�"+s+"H";
    		}else {
    			String s=Integer.toString(a[4]);
    			return "����öӲ���Ǽٱ�"+s+"L";
    		}    		
    	}
    	else if(sum11==sum22) {
    		if(a[0]==a[2]) {
    			String s=Integer.toString(a[5]);
    			return "����öӲ���Ǽٱ�"+s+"L";
    		}else {
    			String s=Integer.toString(a[2]);
    			return "����öӲ���Ǽٱ�"+s+"H";
    		}   		
    	}else {//��һ��˵����a[1]>a[3]
    		if(a[0]==a[1]) {
    			String s=Integer.toString(a[3]);
    			return "����öӲ���Ǽٱ�"+s+"L";
    		}else{
    			String s=Integer.toString(a[1]);
    			return "�ڶ�öӲ���Ǽٱ�"+s+"H";
    		}   		
    	}
    	}else if(sum1==sum2) {//˵���ٱ���a[6]a[7]֮����
    		if(a[6]>a[7]) {
    			if(a[0]==a[6]) {
    				String s=Integer.toString(a[7]);
        			return "�ڰ�öӲ���Ǽٱ�"+s+"L";
    			}else {
    				String s=Integer.toString(a[6]);
        			return "����öӲ���Ǽٱ�"+s+"H";
    			}
    		}else {
    			if(a[0]==a[6]) {
    				String s=Integer.toString(a[7]);
        			return "�ڰ�öӲ���Ǽٱ�"+s+"H";
    			}else {
    				String s=Integer.toString(a[6]);
        			return "����öӲ���Ǽٱ�"+s+"L";
    			}
    		}
    	}
    	else {
    		int	sum11=a[0]+a[3];
        	int	sum22=a[1]+a[4];
        	if (sum11>sum22) {//a[3]>a[1]]
        		if(a[0]==a[1]) {
        			String s=Integer.toString(a[3]);
        			return "����öӲ���Ǽٱ�"+s+"H";
        		}else {
        			String s=Integer.toString(a[1]);
        			return "�ڶ�öӲ���Ǽٱ�"+s+"L";
        		}	
        	}
        	else if(sum11==sum22) {//a[5]>a[2]
        		if(a[0]==a[2]) {
        			String s=Integer.toString(a[5]);
        			return "����öӲ���Ǽٱ�"+s+"H";
        		}else {
        			String s=Integer.toString(a[2]);
        			return "����öӲ���Ǽٱ�"+s+"L";
        		}
        	}else {//a[4]>a[0]
        		if(a[0]==a[1]) {
        			String s=Integer.toString(a[4]);
        			return "����öӲ���Ǽٱ�"+s+"H";
        		}else {
        			String s=Integer.toString(a[0]);
        			return "��һöӲ���Ǽٱ�"+s+"L";
        		}	
        	}   		
    	} 	
    }  
}


//�ٸ�һ�α��˼���ĵ�

public class Coins {  
    private int[] coins;  
      
    public Coins() {  
        coins = new int[8];  
        for(int i = 0; i < 8; i++)   
            coins[i] = 10;   
    }  
      
    public void setFake(int weight) {  
        coins[(int) (Math.random() * 7)] = weight;  
    }  
      
    public void fake() {  
        if(coins[0]+coins[1]+coins[2] ==   
           coins[3]+coins[4]+coins[5]) {   
            if(coins[6] > coins[7])   
                compare(6, 7, 0);   
            else   
                compare(7, 6, 0);   
        }   
        else if(coins[0]+coins[1]+coins[2] >   
                coins[3]+coins[4]+coins[5]) {   
            if(coins[0]+coins[3] == coins[1]+coins[4])   
                compare(2, 5, 0);   
            else if(coins[0]+coins[3] > coins[1]+coins[4])   
                compare(0, 4, 1);   
            if(coins[0]+coins[3] < coins[1]+coins[4])   
                compare(1, 3, 0);   
        }   
        else if(coins[0]+coins[1]+coins[2] <   
                coins[3]+coins[4]+coins[5]) {   
            if(coins[0]+coins[3] == coins[1]+coins[4])   
                compare(5, 2, 0);   
            else if(coins[0]+coins[3] > coins[1]+coins[4])   
                compare(3, 1, 0);   
            if(coins[0]+coins[3] < coins[1]+coins[4])   
                compare(4, 0, 1);   
        }   
    }  
      
    protected void compare(int i, int j, int k) {  
        if(coins[i] > coins[k])   
            System.out.print("\n�ٱ� " + (i+1) + " ����");   
        else   
            System.out.print("\n�ٱ� " + (j+1) + " ����");   
    }  
      
    public static void main(String[] args) {  
        if(args.length == 0) {  
            System.out.println("����ٱ���������10���С��");  
            System.out.println("ex. java Coins 5");  
            return;  
        }  
          
        Coins eightCoins = new Coins();  
        eightCoins.setFake(Integer.parseInt(args[0]));  
        eightCoins.fake();  
    }  
}  


