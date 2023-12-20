/*Ammar K
ICS3U
May 23 2022
Culminating Assingment
AI country guesses
*/
import java.util.Arrays;
import java.util.*;
import java.io.*;
import java.io.FileWriter;
class Main {
	public static void main(String[] args) throws IOException{
		String [] continent = new String [7]; //creating new string for each continent
		String [] ansCon = new String [7]; // creating new string for the asnwers from the user
	
		intro(); //calling the method that displays the rules and introductions
		Scanner contin = new Scanner (new File ("WhichCont/Continent.txt"));
		//adding it to the arrays
	    for(int x = 0; x <7; x++){
	 		continent[x]= contin.nextLine(); 	
		} 
		contin.close();
	
		PrintWriter sort = new PrintWriter ("WhichCont/AnswerforCont.txt"); //using printwriter to store the user asnwers into a text file 
		Scanner input = new Scanner(System.in);
	    	for(int x = 0; x < 7; x++){
				System.out.println(colors.YELLOW_BRIGHT+"Is the country in the continent of "+continent[x]+ "?"+colors.RESET); //asking the quesitons to find out which continent the country is in
				ansCon[x] = input.nextLine();
				while(!ansCon[x].equalsIgnoreCase("yes") && !ansCon[x].equalsIgnoreCase("no")){
					//colors used here
					System.out.println(colors.YELLOW_BRIGHT+"Please enter a yes or no"+colors.RESET);
					ansCon[x] = input.nextLine();
				}
				sort.println(ansCon[x]);
				if(ansCon[x].equalsIgnoreCase("yes")){
					x = 7;
					sort.close();
				}
			}
			sort.close();
	
		if(ansCon[0].equalsIgnoreCase("yes")){    //for Africa
			//assigning these values corresponsing to their text files
			String area = "Africa";
			String name2 = "answersAFRICA";
			String name3 = "QuesAfrica";
			game(area,name2,name3); //calling the main mehtod where the game runs
		}
			
		else if(ansCon[1].equalsIgnoreCase("yes")){ // for Asia
			//assigning these values corresponsing to their text files
			String area = "Asia";
			String name2 = "answersAsia";
			String name3 = "QuesAsia";
			game(area,name2,name3); //calling the main mehtod where the game runs
		}
		else if(ansCon[2].equalsIgnoreCase("yes")){ // for Australia
			//assigning these values corresponsing to their text files
			String area = "AustOcea";
			String name2 = "answersAust";
			String name3 = "QuesAust";
			game(area,name2,name3); //calling the main mehtod where the game runs
		}
		else if(ansCon[3].equalsIgnoreCase("yes")){ // for Europe
			//assigning these values corresponsing to their text files
			String area = "Europe";
			String name2 = "answersEurope";
			String name3 = "QuesEurope";
			game(area,name2,name3); //calling the main mehtod where the game runs
		}
		else if(ansCon[4].equalsIgnoreCase("yes")){ // for North America
			//assigning these values corresponsing to their text files
			String area = "NorthAmer";
			String name2 = "answersNorth";
			String name3 = "QuesNorth";
			game(area,name2,name3); //calling the main mehtod where the game runs
		}
		else if(ansCon[5].equalsIgnoreCase("yes")){ //for South America
			//assigning these values corresponsing to their text files
			String area = "SouthAmer";
			String name2 = "answersSouth";
			String name3 = "QuesSouth";
			game(area,name2,name3); //calling the main mehtod where the game runs
		}
		else if(ansCon[6].equalsIgnoreCase("yes")){  //for antarctica
			//no assigned variables and not calling method as antarctica has no countries
			System.out.println(colors.GREEN_BOLD_BRIGHT+"\n~_~_~_~_~_~_~_~_~_~_~_~_~_~_~_~_~_~_~_~_~_~_~_~_~_~_~_~_~_~_~_~_~_~_~_~_~_~_~\n"+colors.RESET);
			System.out.println(colors.PURPLE_BOLD_BRIGHT+"You are thinking of Antarctica as this Continent doesn't have any Countries"+colors.RESET);
			System.out.println(colors.GREEN_BOLD_BRIGHT+"\n~_~_~_~_~_~_~_~_~_~_~_~_~_~_~_~_~_~_~_~_~_~_~_~_~_~_~_~_~_~_~_~_~_~_~_~_~_~_~\n"+colors.RESET);
		} 
	}
	/*Method for the main part of the game, the game adds the text files into arrays, checks for user answers, displays questions, and also adds the countries and answers back into existing text files
	*pre: 3 string values. name of the Continent, names of the text files for specific continent.
	*post: no post. Only prints out the whole game
	*/  
	public static void game(String area,String name2, String name3)throws IOException{
		int num = 0;     //for the end stages of the game
		
		Scanner input = new Scanner(System.in);
		
		Scanner contine = new Scanner (new File ("Continents/"+area+"/"+area+".txt"));
		//adding it to the arrays
		String se = contine.next(); //this is always a number but in string
		int size =  Integer.parseInt(se); //converting string to integer
		String [] A = new String [size];
	    for(int x = 0; x < size; x++){
	 		A[x]= contine.nextLine(); 
		} 
		contine.close();
		
		String cny = ""; //assinging blank to intialize the variable
		//scanner for the question
		Scanner question = new Scanner (new File ("Continents/"+area+"/"+name3+".txt")); //using the variables to see which text file to call in
		//adding it to the arrays
		String seze = question.next();  //checking the number of questions there depending on the Continent
		int sizeQ =  Integer.parseInt(seze); // converting string to integer
		String [] quesA = new String [sizeQ];
	    for(int x = 0; x < sizeQ; x++){
	 		quesA[x]= question.nextLine(); // adding it to arrays
		} 
		question.close();
		//scanner for the answer
		Scanner answer = new Scanner (new File ("Continents/"+area+"/"+name2+".txt"));
		//adding it to the arrays
		String [] ansA = new String [size];
	    for(int x = 0; x < size; x++){
	 		ansA[x]= answer.nextLine(); 	
		} 
		answer.close();
		
		PrintWriter userA = new PrintWriter ("Continents/"+area+"/userAns.txt"); //adding the answers to each question into the text file
		String [] useAn = new String [sizeQ];
    	for(int x = 1; x <sizeQ; x++){
			//asking the questions then collecting answers
			System.out.println(colors.GREEN_BOLD_BRIGHT+"\n~_~_~_~_~_~_~_~_~_~_~_~_~_~_~_~_~_~_~_~_~_~_~_~_~_~_~\n"+colors.RESET);
			System.out.println(colors.BLUE+"Q"+(x)+". "+quesA[x]+" "+colors.RESET);
			useAn[x] = input.nextLine();
			
			if(useAn[x].equalsIgnoreCase("back")){ //if user wants to go back to change the answer
				System.out.println(colors.GREEN_BOLD_BRIGHT+"\n~_~_~_~_~_~_~_~_~_~_~_~_~_~_~_~_~_~_~_~_~_~_~_~_~_~_~\n"+colors.RESET);
				x--; // go back a question and also change the answers in array
				System.out.println("So you want to change your answer, no worries. Here's the last Question\n");
				System.out.println(colors.BLUE+"Q"+(x)+". "+quesA[x]+" "+colors.RESET);
				useAn[x] = input.nextLine();
			}
			//if user types something else the program asks to retype it as yes no or back
			while(!useAn[x].equalsIgnoreCase("yes") && !useAn[x].equalsIgnoreCase("no") && !useAn[x].equalsIgnoreCase("back")){
				System.out.println("Please enter a yes or no");
				useAn[x] = input.nextLine();
				}
			}
		for(int x = 1; x <sizeQ; x++){
		userA.print(useAn[x]+" ");
		}
		userA.close();
		
		Scanner counta = new Scanner (new File ("Continents/"+area+"/userAns.txt"));
		//adding it to the arrays
	 		String userAnsA = counta.nextLine(); 	
		counta.close();
		//checking if the country was guessed or not
		boolean decide = decide(ansA,userAnsA,A,size); //assinging a boolean variable and calling method
				
		if(!decide){ //if the method returns to be false ask the user for the country and add the country and answers to the text file
			System.out.println(colors.GREEN_BOLD_BRIGHT+"\n~_~_~_~_~_~_~_~_~_~_~_~_~_~_~_~_~_~_~_~_~_~_~_~_~_~_~\n"+colors.RESET);
			System.out.println("Hmm. sadness, it seems you have outsmarted me. I could'nt guess the country you are thinking. \n Would you like to tell me what Country you were thinking of?");
			cny = input.nextLine();
			replaceLines(size,A,area); // calling replace lines method
			addUser(userAnsA,area,name2); // calling method to add the answers/countries to text file
			num = 1; //only to help the end method work properly. Cheat code
			}
		addUser(cny,area,area);
		end(num); //printing out the end credits depending if the country was guessed or not
	}

	/*Boolean Method that checks the user answer and compares it to the whole array of already added answers and returns the variable ifFound.
	*pre: 3 string values/arrays and 1 int value. Answers from the text file, user answers, array with names of country, and size of the countries.
	*post: returns the boolean ifFound, either as true or false.
	*/  
	public static boolean decide(String [] ansA, String userAnsA, String []A, int size){ //
		int x  = 0;
		boolean ifFound = false;
		//checking if the user answer match any in the text files otherwise return false
		for(x = 0; x < size; x++) {
			if(ansA[x].equalsIgnoreCase(userAnsA)){
				System.out.println(colors.GREEN_BOLD_BRIGHT+"\n~_~_~_~_~_~_~_~_~_~_~_~_~_~_~_~_~_~_~_~_~_~_~_~_~_~_~\n"+colors.RESET);
				System.out.println(colors.PURPLE_BOLD_BRIGHT+"The country you are thinking of is "+A[x]+colors.RESET);
				x=size;
				ifFound = true;
			}	//else if(x==size-1)
		}
		return ifFound;
	}

	/*Method that updates the text file, adds the new country and increasing the country count by 1.
	*pre: 2 string values/arrays and 1 int value. Size of the country, names of the countries, and the name of the Continent (area).
	*post: returns the boolean ifFound, either as true or false.
	*/ 
	public static void replaceLines(int size, String []A,String area) throws IOException{
    PrintWriter country = new PrintWriter ("Continents/"+area+"/"+area+".txt");
		//prints the textfile again to change the number of countries there are and add more countries to it
		country.print(size+1);
    	for(int x = 0; x <size; x++){
			country.println(A[x]);
			}
		country.close();
	}
	/*Method that adds the string value to an existing text file.
	*pre: 3 string values. UserAnsA, area, and name2/area.
	*post: no post, jsut adds the string to the text file
	*/ 
	public static void addUser(String userAnsA,String area, String name2) throws IOException{

		//adding a single string value to an existing text file
		try(FileWriter g = new FileWriter("Continents/"+area+"/"+name2+".txt",true);
		BufferedWriter c = new BufferedWriter(g);
		PrintWriter o = new PrintWriter(c);){
		o.println(userAnsA);
		}
		catch(IOException i){
		i.printStackTrace();
		}
	}

	/*Method that prints out the games intro and introduces the AI and rules.
	*pre: no Pre.
	*post: no post
	*/ 
	public static void intro(){
		//printing out the intro using the colors class to make it attractive
		System.out.println();
		System.out.println(colors.CYAN_BOLD_BRIGHT+"~_~_~_~_~_~_~_~_~_~_~_~_~_~_~_~_~_~_~_~_~_~_~_~_~_~\n");
		System.out.println("     WELCOME TO THE GREATEST AI GAME EVER MADE     ");
		System.out.println("\n~_~_~_~_~_~_~_~_~_~_~_~_~_~_~_~_~_~_~_~_~_~_~_~_~_~"+colors.RESET);
		System.out.println("\nHello my name is Radion, and I welcome you all to this fun little game I made.");
		System.out.println("\nYou can think of any Country from around the world and I will find out which country it is \nsolely through my expert thinking and observation skills.");
		System.out.println();
		System.out.println("I will ask you a series of questions so answer honestly and be amazed by seeing how a piece of \ntechnology can read people's minds.");
		System.out.println();
		System.out.println("Just as a headsup, I might use some vocabulary that some people may not understand \nso heres a few words I might use: \n		1. Landlocked means no water beside the country. \n		2. Shoreline means the border of any Country with the Ocean. \n		3. Dense means alot. ");
		System.out.println(colors.RED+"\nIf you would like to go back to change your answer you can just type in ['BACK']"+colors.RESET);
		System.out.println("\nYou can begin thinking of any Country you would like me to guess and here we go.");
		System.out.println(colors.GREEN_BOLD_BRIGHT+"\n~_~_~_~_~_~_~_~_~_~_~_~_~_~_~_~_~_~_~_~_~_~_~_~_~_~_~\n"+colors.RESET);
	}
	/*Method that prints out the ending messages.
	*pre: 1 int value , number that decides what to print
	*post: no post
	*/ 
	public static void end(int num){
		if(num == 1){ //if num is 1 which means country was not guessed by the program and user types the country
			System.out.println(colors.GREEN_BOLD_BRIGHT+"\n~_~_~_~_~_~_~_~_~_~_~_~_~_~_~_~_~_~_~_~_~_~_~_~_~_~_~\n"+colors.RESET);
			System.out.println("Thank you. I will be sure to add this to my memory. \nAs you know us Computers never forget anything.");
			System.out.println("Thank you for playing my little game, I hope you enjoyed and I wish you a very good day.");
		}	
		else if(num==0){ // the program guesses the country correctly and Radion gives his regards
			System.out.println(colors.GREEN_BOLD_BRIGHT+"\n~_~_~_~_~_~_~_~_~_~_~_~_~_~_~_~_~_~_~_~_~_~_~_~_~_~_~\n"+colors.RESET);
			System.out.println("Haha, it seems I have guessed the Country you were thinking of. \nNow you see how I can easily read your mind. This was fun please do play with me again and think of a harder Country.");
			System.out.println("Thank you for playing my little game, I hope you enjoyed and I wish you a very good day.");	
		}
	}
}