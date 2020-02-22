import java.util.Scanner;

class RandomGame
{
	public static void main(String[] args)

	  {
		  final int max_tries = 5;

		  int tries = max_tries;
		  long min=1,max=50;
		  char choice = 'y';
		  long number;
		  Scanner input = new Scanner(System.in);
		  System.out.println("************GUASSING GAME***************");
		  System.out.println("Ypu have to Guases a Number: ");
		  System.out .println("You have " +tries +" tries to Guases a Number");
		  System.out.println("****************************************");
		  long genrate;
		  genrate = genrate_random(min,max);
		  do
		  {

			  System.out.println("\nGuass a NUMBER: ");
			  number = input.nextLong();
			  if(number==genrate)
			    {
				    System.out.println("************Congratulations you win***********");
				    System.out.println("Do you want to continue: (Y/N)");
				    choice = input.next(".").charAt(0);
				    if(choice=='y')
								 {
									tries=max_tries;
									   genrate = genrate_random(min,max);
								 }
			     }
			  else if (number<genrate)
			      {
					  System.out.println("Too Low: ");
					  tries--;
					   if(tries<=0)
					    {
						    System.out.println("Game over :(");
						    System.out.println("Genrated number was: " +genrate);
				            System.out.println("Do you want to continue: (Y/N)");
				            choice = input.next(".").charAt(0);
				            if(choice=='y')
					             {
									 tries=max_tries;
									    genrate = genrate_random(min,max);

								 }

					     }
					     else
					  System.out.println("You have " +tries + " tries left");
				  }
				  else
				     {
						System.out.println("Too Hiegh: " );
						 tries--;
						  if(tries<=0)
							{
								 System.out.println("Game over :(");
								 System.out.println("Genrated number was: " +genrate);
								 System.out.println("Do you want to continue: (Y/N)");
								 choice = input.next(".").charAt(0);
								 if(choice=='y')
								 {
									 tries=max_tries;
									    genrate = genrate_random(min,max);

								 }

					         }else
						System.out.println("You have " +tries + "left");
					 }
		  }
		  while(choice!='n');


	  }

	  public static long genrate_random(long min,long max)
	  {
		  long num = ((int)(Math.random()*(max-min+1)+min));
		  return num;
	  }
}