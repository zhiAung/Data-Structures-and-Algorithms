/*八枚硬币,要求比较的次数最少，本质是使用分支方法，以二分之一的速率缩小氛围，这样是最快的*/
package a;
import java.math.BigInteger;
import java.util.*;
public class Main{   
	//自己定义方法的不需要都是static，但是你要在主函数中调用就需要static了，因为main是静态 的，在类加载时就加载了。
    public static  void main(String[] args)  {  
    	System.out.println("请输入10个硬币的质量：");
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
    	if (sum11>sum22) {//从这一步就可以得出a[0]>a[4],所以从a[0]和a[4]选一个和其他比较就可以了。
    		if(a[0]>a[1]) {//这里还有一个技巧，就是不断的交叉比较，而不是同组的比较，
    			           //这样就能有效利用前面比较得出的一部分信息，这样效率更高
    			String s=Integer.toString(a[0]);
    			return "第一枚硬币是假币"+s+"H";
    		}else {
    			String s=Integer.toString(a[4]);
    			return "第五枚硬币是假币"+s+"L";
    		}    		
    	}
    	else if(sum11==sum22) {
    		if(a[0]==a[2]) {
    			String s=Integer.toString(a[5]);
    			return "第六枚硬币是假币"+s+"L";
    		}else {
    			String s=Integer.toString(a[2]);
    			return "第三枚硬币是假币"+s+"H";
    		}   		
    	}else {//这一步说明，a[1]>a[3]
    		if(a[0]==a[1]) {
    			String s=Integer.toString(a[3]);
    			return "第四枚硬币是假币"+s+"L";
    		}else{
    			String s=Integer.toString(a[1]);
    			return "第二枚硬币是假币"+s+"H";
    		}   		
    	}
    	}else if(sum1==sum2) {//说明假币在a[6]a[7]之间在
    		if(a[6]>a[7]) {
    			if(a[0]==a[6]) {
    				String s=Integer.toString(a[7]);
        			return "第八枚硬币是假币"+s+"L";
    			}else {
    				String s=Integer.toString(a[6]);
        			return "第七枚硬币是假币"+s+"H";
    			}
    		}else {
    			if(a[0]==a[6]) {
    				String s=Integer.toString(a[7]);
        			return "第八枚硬币是假币"+s+"H";
    			}else {
    				String s=Integer.toString(a[6]);
        			return "第七枚硬币是假币"+s+"L";
    			}
    		}
    	}
    	else {
    		int	sum11=a[0]+a[3];
        	int	sum22=a[1]+a[4];
        	if (sum11>sum22) {//a[3]>a[1]]
        		if(a[0]==a[1]) {
        			String s=Integer.toString(a[3]);
        			return "第四枚硬币是假币"+s+"H";
        		}else {
        			String s=Integer.toString(a[1]);
        			return "第二枚硬币是假币"+s+"L";
        		}	
        	}
        	else if(sum11==sum22) {//a[5]>a[2]
        		if(a[0]==a[2]) {
        			String s=Integer.toString(a[5]);
        			return "第六枚硬币是假币"+s+"H";
        		}else {
        			String s=Integer.toString(a[2]);
        			return "第三枚硬币是假币"+s+"L";
        		}
        	}else {//a[4]>a[0]
        		if(a[0]==a[1]) {
        			String s=Integer.toString(a[4]);
        			return "第五枚硬币是假币"+s+"H";
        		}else {
        			String s=Integer.toString(a[0]);
        			return "第一枚硬币是假币"+s+"L";
        		}	
        	}   		
    	} 	
    }  
}


//再附一段别人简洁版的的

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
            System.out.print("\n假币 " + (i+1) + " 较重");   
        else   
            System.out.print("\n假币 " + (j+1) + " 较轻");   
    }  
      
    public static void main(String[] args) {  
        if(args.length == 0) {  
            System.out.println("输入假币重量（比10大或小）");  
            System.out.println("ex. java Coins 5");  
            return;  
        }  
          
        Coins eightCoins = new Coins();  
        eightCoins.setFake(Integer.parseInt(args[0]));  
        eightCoins.fake();  
    }  
}  


