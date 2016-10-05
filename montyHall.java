import java.util.Scanner;
public class montyHall
{
	/**
	@param String[] args
	*/
	public static void main(String[] args)
	{
		//declaring all variables.
		int carDoor = (int) (Math.random() * 3 + 1);//the door with the car behind it
		int userDoor = getUserDoor();//the original userdoor (pre reveal)
		int revealed = revealDoor(carDoor, userDoor); //the door that was revealed to have a goat in it.
		int newDoor; //the users door if the user decides to switch doors
		boolean swap; //true or false based on if the user switches or not.
		
		System.out.println("There is a goat behind door number " + revealed);
		
		swap = getUserSwap();
		
		//if the user switches doors
		if (swap == true)
		{
			newDoor = swapDoor(revealed, userDoor);
			if(newDoor == carDoor)
				System.out.println("You Win! There was a car behind Door " + carDoor);
			if(newDoor != carDoor)
				System.out.println("Sorry, but the car was behind " + carDoor);

		}
		//if the user doesn't want to switch doors
		
		if (swap == false)
		{
			if (userDoor == carDoor)
				System.out.println("You Win! There was a car behind Door " + carDoor);
			if (userDoor != carDoor)
				System.out.println("Sorry, but the car was behind " + carDoor);

		}
		
	
		
	}
	//if the user switches doors, this will determine what doors are available to switch to and will switch to said doors
	/**
	@param takes in two integers, the users current door and the door revealed with a goat behind it.
	@return returns a door that is not the revealed door or the user door
	*/
	public static int swapDoor(int revealed, int userDoor)
	{

		for (int switchDoor = 1; switchDoor < 4; switchDoor++)
			{
				if(switchDoor != revealed && switchDoor != userDoor)
					return switchDoor;
			}
		return 5; 
	}
	//determines whether or not the user switches doors
	/**
	@return returns either true or false depending on what the user decides.
	*/
	public static boolean getUserSwap()
	{
		System.out.println("Would you like to swap doors? (Yes/No) ");
		Scanner tf = new Scanner(System.in);
		String truefalse = tf.nextLine();
		if(truefalse.equals("Yes") || truefalse.equals("yes"))
			return true;
		if(truefalse.equals("No") || truefalse.equals("no"))
			return false;
		else //if the answer is not yes or no, it calls itself again until a valid response is given
		{
			System.out.println("That's not a valid answer.");
			getUserSwap();
		}
		return false;
	}
	//reveals a door with a goat in it
	/**
	@param two ints, which contain the user door and the car door.
	@return an int, which is the door that has a goat behind it.
	*/
	public static int revealDoor(int invalid1, int invalid2)
	{
		int[] doors = {1,2,3};
		for(int revealDoor = 1; revealDoor < 4; revealDoor++)
		{
			if (revealDoor != invalid1 && revealDoor != invalid2)
			{
				return revealDoor;
			}
		
		}
	return -1; //this is so you don't get an error. you aren't supposed to get to this line.
		
	}
	//gets the users door
	
	/**
	@return returns an int taken from the user.
	*/
	
	public static int getUserDoor()
	{
		Scanner input = new Scanner(System.in);
		System.out.println("Pick a door, 1, 2, or 3");
		String doorNumber = input.nextLine();
		/*
		if (Integer.valueOf(doorNumber) == int)
		{
			return Integer.parseInt(doorNumber);
		}
		else
		{
			System.out.println("That's not a valid answer.");
			getUserDoor();
		}
		*/
		int door = Integer.parseInt(doorNumber);
		//Tests to make sure the input is valid
		if (door < 4 && door > 0)
		{
			return door;
		}
		else
		{
			System.out.println("That's not a valid answer");
			getUserDoor();
		}
		return -1;// should never get to this
	}
}