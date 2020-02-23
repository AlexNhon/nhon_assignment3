package nhon_problem1;

import java.security.SecureRandom;
import java.util.Random;
import java.util.Scanner;

public class CAI4 {
	Random rand = new SecureRandom();
	Scanner scan = new Scanner(System.in);
	int userAnswer;
	int num1;
	int num2;
	int num3;
	int Answer;
	int responseNum;
	int correctCount;
	int additionalChoice;
	int userChoice;
	
	private void readDifficulty() {
		System.out.println("Choose a difficulty rating:");
		System.out.println("1: Numbers up to 1 digit");
		System.out.println("2: Numbers up to 2 digits");
		System.out.println("3: Numbers up to 3 digits");
		System.out.println("4: Numbers up to 4 digits");
		userChoice = scan.nextInt();		
	}
	
	private int generateQuestionArgument() {
		int randnum = 0;
		
		switch(userChoice) {
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
	
	private void readResponse() {
		num3 = scan.nextInt();
		setuserAnswer(num3);
	}
	
	private void askQuestion() {
		num1 = generateQuestionArgument();
		num2 = generateQuestionArgument();
		setAnswer(num1, num2);
		System.out.println("What is " + num1 + " times "+ num2 + "?");
	}
	
	private void quiz() {
		correctCount = 0;
		readDifficulty();
		
		for(int i = 0; i < 10; i++) {
			System.out.print("Question " + (i + 1) + ": ");
			askQuestion();
			readResponse();
			isAnswerCorrect();
		}
		
		displayCompletionMessage();
	}
	
	private void setAnswer(int num1, int num2) {
		Answer = num1 * num2;
	}
	
	public int getAnswer() {
		return Answer;
	}
	
	private void setuserAnswer(int num) {
		userAnswer = num;
	}
	
	public int getuserAnswer() {
		return userAnswer;
	}
	
	private void setcorrectCount() {
		correctCount = correctCount + 1;;
	}
	
	public int getcorrectCount() {
		return correctCount;
	}
	
	public static void main(String[] args) {
		CAI4 app = new CAI4();
		app.quiz();
	}
}
