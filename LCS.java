import java.io.*;
public class LCS
{
	
	int longestCommonSubsequence(char a[], char b[])
	{
		int i, j, m, n;
		
		m = a.length;
		n = b.length;
		
		int temp[][] = new int[m+1][n+1];
		
		//Filling the first Row of temp[][] with 0
		for(i = 0; i < (m+1); i++)
		{
			temp[i][0] = 0;
		}
		
		//Filling the first Column of temp[][] with 0
		for(i = 0; i < (n+1); i++)
		{
					temp[0][i] = 0;
		}
		
		//Using dynamic programming to fill the temp[][] matrix 
		for(i = 1; i < (m+1); i++)
		{
			for(j = 1; j < (n+1); j++)
			{
				if (a[i-1] == b[j-1])
					temp[i][j] = (1 + temp[i-1][j-1]);
				
				else
					temp[i][j] = Math.max(temp[i-1][j], temp[i][j-1]);
				
				
			}
		}
		
		return(temp[m][n]);
	}
	
	public static void main(String args[])throws IOException
	{
		LCS lcs = new LCS();
		
		 String str1 = "ABCDGHLXYZQR";
	     String str2 = "AEDXYPHR";
	     
	     int result = lcs.longestCommonSubsequence(str1.toCharArray(), str2.toCharArray());
	     System.out.print("The length of LCS is " + result);
	}

}
