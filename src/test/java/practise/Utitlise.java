package practise;

/**
*@author sushma.goud
*
*/

public class Utitlise {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int sum=add(20,40);
		System.out.println(sum);
		System.out.println(add(sum,78));
		System.out.println(add(100,sum));
		
		int sub=sub(20,40);
		System.out.println(sub);
		System.out.println(sub(sub,78));
		System.out.println(add(100,sub));
			

	}
public static int add(int a, int b)
{
	int c=a+b;
	return c;
}
public static int sub(int a,int b)
{
	int c=a-b;
	return c;
}
}
