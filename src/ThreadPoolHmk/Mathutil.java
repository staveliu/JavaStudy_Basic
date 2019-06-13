package ThreadPoolHmk;

public class Mathutil {

	public static boolean isPrime(int n) {
		if(n==1||n%2==0&&n!=2)
		{
			return false;
		}
		else
		{
			for(int i = 3; i < Math.sqrt(n); i += 2)
			{
				if(n%i == 0)
				{
					return false;
				}
			}
		}
		return true;
	}
}
