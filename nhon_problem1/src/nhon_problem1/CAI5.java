package nhon_problem1;

import java.security.SecureRandom;
import java.util.Random;
import java.util.Scanner;

public class CAI5 {
	Random rand = new SecureRandom();
	Scanner scan = new Scanner(System.in);
	int userAnswer;
	double userAnswerDiv;
	int num1;
	int num2;
	double divnum1;
	double divnum2;
	int num3;
	double num4;
	int Answer;
	double AnswerDiv;
	int responseNum;
	int correctCount;
	int additionalChoice;
	int difficultyChoice;
	int typeChoice;
	int fifthChoice;
	
	
	private void readProblemType() {
		System.out.println("Choose a question type:");
		System.out.println("1: Addition only");
		System.out.println("2: Multiplication only");
		System.out.println("3: Subtraction only");
		System.out.println("4: Division only");
		System.out.println("5: Combination");
		typeChoice = scan.nextInt();
	}
	
	private void readDifficulty() {
		System.out.println("Choose a difficulty rating:");
		System.out.println("1: Numbers up to 1 digit");
		System.out.println("2: Numbers up to 2 digits");
		System.out.println("3: Numbers up to 3 digits");
		System.out.println("4: Numbers up to 4 digits");
		difficultyChoice = scan.nextInt();		
	}
	
	private int generateQuestionArgument() {
		int randnum = 0;
		
		switch(difficultyChoice) {
		case 1:
			randnum = rand.nextInt(10);
			break;
		case 2:
			randnum = rand.nextInt(100);
			break;
		case 3:
			randnum = rand.nextInt(1000);
			break;
		case 4:
			randnum = rand.nextInt(10000);
			break;
		}
		
		return randnum;
	}
	
	private void readAdditionalQuiz() {
		System.out.println("Would you like to take another quiz?:");
		System.out.println("1: Yes");
		System.out.println("2: No");
		additionalChoice = scan.nextInt();
		
		if (additionalChoice == 1) {
			quiz();
		}
		else if(additionalChoice == 2) {
			System.out.println("<<<EXITING>>>");
			System.exit(0);
		}
	}
	
	private void displayCompletionMessage() {
		double score = (getcorrectCount() / 10.0) * 100;
		
		if(score >= 75) {
			System.out.println("Your score was " + score + "%");
			System.out.println("Congratulations! You are ready to go to the next level!");
			System.out.println("");
			readAdditionalQuiz();
		}
		else if(score < 75) {
			System.out.println("Your score was " + score + "%");
			System.out.println("Please ask your teacher for help.");
			System.out.println("");
			readAdditionalQuiz();
		}
			
		
	}
	
	private void displayIncorrectResponse() {
		responseNum = rand.nextInt(4);
		
		switch(responseNum) {
		case 0:
			System.out.println("No. Please Try Again.");
			break;
		case 1:
			System.out.println("Wrong. Try once more.");
			break;
		case 2:
			System.out.println("Don't give up!");
			break;
		case 3:
			System.out.println("No. Keep trying.");
			break;
		}
		
	}
	
	private void displayCorrectResponse() {
		responseNum = rand.nextInt(4);
		
		switch(responseNum) {
		case 0:
			System.out.println("Very good!");
			break;
		case 1:
			System.out.println("Excellent!");
			break;
		case 2:
			System.out.println("Nice work!");
			break;
		case 3:
			System.out.println("Keep up the good work!");
			break;
		}
	}
	
	private void isAnswerCorrect() {
		if(typeChoice >= 1 && typeChoice <=3 || fifthChoice >=0 && fifthChoice <=2) {
				int userNum = getuserAnswer();
				int answer = getAnswer();
				
				if (userNum == answer) {
					displayCorrectResponse();
					setcorrectCount();
				}
				else {
					displayIncorrectResponse();
				}	
		}
		else if(typeChoice == 4 || fifthChoice == 3) {
			double userNum = getuserAnswerDiv();
			double answer = getAnswerDiv();
			
			if (userNum == answer) {
				displayCorrectResponse();
				setcorrectCount();
			}
			else {
				displayIncorrectResponse();
			}	
		}
	}
	
	private void readResponse() {
		if(typeChoice >=1 && typeChoice <=3) {
			num3 = scan.nextInt();
			setuserAnswer(num3);
		}
		else if(typeChoice == 4) {
			num4 = scan.nextDouble();
			setuserAnswerDiv(num4);
		}
		else if(typeChoice == 5) {
			if(fifthChoice >=0 && fifthChoice <=2) {
				num3 = scan.nextInt();
				setuserAnswer(num3);
			}
			else if(fifthChoice == 3) {
				num4 = scan.nextDouble();
				setuserAnswerDiv(num4);
			}
		}
		
	}
	
	private void askQuestion() {
		if(typeChoice == 4) {
			divnum1 = generateQuestionArgument();
			divnum2 = generateQuestionArgument();
			
			if(divnum2 == 0) {
				divnum2 = divnum2 + 1;
			}
			setAnswer();
		}
		else if (typeChoice >=1 && typeChoice <= 3){
			num1 = generateQuestionArgument();
			num2 = generateQuestionArgument();
			setAnswer();
		}
		
		switch(typeChoice) {
		case 1:
			System.out.println("What is " + num1 + " plus "+ num2 + "?");
			break;
		case 2:
			System.out.println("What is " + num1 + " times "+ num2 + "?");
			break;
		case 3:
			
			System.out.println("What is " + num1 + " minus "+ num2 + "?");
			break;
		case 4:
			System.out.println("What is " + divnum1 + " divided by "+ divnum2 + "? (Round up to 1 decimal place)");
			break;
		case 5: 
			// Combination of first 4 cases
			fifthChoice = rand.nextInt(4);
			switch(fifthChoice) {
			case 0:
				num1 = generateQuestionArgument();
				num2 = generateQuestionArgument();
				
				setAnswer();
				System.out.println("What is " + num1 + " plus "+ num2 + "?");
				break;
			case 1:
				num1 = generateQuestionArgument();
				num2 = generateQuestionArgument();
				
				setAnswer();
				System.out.println("What is " + num1 + " times "+ num2 + "?");
				break;
			case 2:
				num1 = generateQuestionArgument();
				num2 = generateQuestionArgument();
				
				setAnswer();
				System.out.println("What is " + num1 + " minus "+ num2 + "?");;
				break;
			case 3:
				divnum1 = generateQuestionArgument();
				divnum2 = generateQuestionArgument();
				
				if(divnum2 == 0) {
					divnum2 = divnum2 + 1;
				}
				setAnswer();
				System.out.println("What is " + divnum1 + " divided by "+ divnum2 + "? (Round up to 1 decimal place)");
				break;
			}
			break;
		}	
	}
	
	private void quiz() {
		correctCount = 0;
		fifthChoice = 10;
		
		readDifficulty();
		readProblemType();
		
		for(int i = 0; i < 10; i++) {
			System.out.print("Question " + (i + 1) + ": ");
			askQuestion();
			readResponse();
			isAnswerCorrect();
		}
		
		displayCompletionMessage();
	}
	
	private void setAnswer() {
		switch(typeChoice) {
		case 1:
			Answer = num1 + num2;
			break;
		case 2:
			Answer = num1 * num2;
			break;
		case 3:
			Answer = num1 - num2;
			break;
		case 4:
			AnswerDiv = divnum1 / divnum2;
			AnswerDiv = Math.round(AnswerDiv * 10) / 10.0;
			break;
		}
		
		switch(fifthChoice) {
		case 0:
			Answer = num1 + num2;
			break;
		case 1:
			Answer = num1 * num2;
			break;
		case 2:
			Answer = num1 - num2;
			break;
		case 3:
			AnswerDiv = divnum1 / divnum2;
			AnswerDiv = Math.round(AnswerDiv * 10) / 10.0;
			break;
		}
		
	}
	
	public int getAnswer() {
		return Answer;
	}
	
	public double getAnswerDiv() {
		return AnswerDiv;
	}
	
	private void setuserAnswer(int num) {
		userAnswer = num;
	}
	
	private void setuserAnswerDiv(double num) {
		userAnswerDiv = num;
	}
	
	public int getuserAnswer() {
		return userAnswer;
	}
	
	public double getuserAnswerDiv() {
		return userAnswerDiv;
	}
	
	private void setcorrectCount() {
		correctCount = correctCount + 1;;
	}
	
	public int getcorrectCount() {
		return correctCount;
	}
	
	public static void main(String[] args) {
		CAI5 app = new CAI5();
		app.quiz();
	}
}
