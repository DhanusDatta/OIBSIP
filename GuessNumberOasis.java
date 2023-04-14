/********************************************************************************************************
*Task                             : 01
*Programmer              	: Kolli Dhanus Datta
*Program name           	: GuessNumber.java
*Topics                  	: Fundamentals of java programming
                           	  Variables, Data types, operators & Control Statements, Escape sequences
*********************************************************************************************************/
import java.lang.*;
import java.util.Scanner;

public class GuessNumberOasis
{
    //Adding a method to determine the guess number with secret number
    public String determineGuess(int userNumber,int secretNumber,int count,int r,int t,int c)
	{
			if(userNumber<0 || userNumber>t)
			{
				return "\nYour guess is invalid!";
			} else if(userNumber == secretNumber)
			{
				int score = (11 - count) *((int)Math.pow(10,c-1));
				System.out.println("\t-------------------------------------------------------------");
				System.out.println("\t\t****Congratulation, You win the game!****");
				System.out.println();
				System.out.println("\t\t---->The number was " + userNumber);
				System.out.println("\t\t---->You used " + count + " turns to guess the right number ");
				System.out.println("\t\t---->Your score for this round "+r+" is " + score + " out of "+ t);
				System.out.println("\t-------------------------------------------------------------");
				return "\n";
			} else if(userNumber<secretNumber)
			{
				System.out.printf("\t Oops! Your guess is Too Low, try again.\n\t you have only %d chances to guess ",10-count);
				return "\n";
			} else if(userNumber>secretNumber)
			{
				System.out.printf("\t Oops! Your guess is Too High, try again.\n\t you have only %d chances to guess ",10-count);
				return "\n";
			} else
			{
				return "\nYour guess is incorrect.\nTry number: "+count;
			}
    }
	public int scor()
	{
		return res;
	}
}
class Practice
{
    public static void main(String...args)
	{
        Scanner con = new Scanner(System.in);
        int r;
		int c=2;
		for(r=1;r<5;r++)
		{
			int t=(int)Math.pow(10,c);
			int secretNumber = (int)(Math.random()*t)+1;    //random number from 1 to 100 
			int userNumber=0;
			GuessNumberOasis g1 = new GuessNumberOasis();
			int count =1;
			System.out.println("\t\t ------------------------------------------------");
			System.out.println("\t\t|              Welcome to the round "+r+"            |");
			System.out.println("\t\t ------------------------------------------------");
			System.out.println("\t In this round, You have to guess "+c+" digit number in 10 chances");
			while(userNumber!=secretNumber)
			{
				if(count<=10)
				{	
					System.out.print("\nEnter your guess between 1 and "+ t+": ");
					userNumber = con.nextInt();
					String result = g1.determineGuess(userNumber, secretNumber, count,r,t,c);
					System.out.println(result);
					count++;
				}
				else
				{
					System.out.println("\n-->You lost because you have exceeded the maximum attempts!!! \n--->The correct guess is "+secretNumber);
					if(r>1)
					{
						
						System.out.println("#####-->You have got "+r+" Stars<--#####");
					}
					break;
				}
			}
			if(count>=11)
			{
				break;
			}
			c++;
		}
    }
}
