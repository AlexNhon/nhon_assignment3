package nhon_problem1;

import java.util.Random;
import java.security.SecureRandom;
import java.util.Scanner;

public class CAI1 {
	Scanner scan = new Scanner(System.in);
	int userAnswer;
	int num1;
	int num2;
	int num3;
	int Answer;
	
	public void displayIncorrectResponse() {
		System.out.println("No. Please Try Again.");
	}
	
	public void displayCorrectResponse() {
		System.out.println("Very good!");
	}
	
	public void isAnswerCorrect() {
		while(true) {
			int userNum = getuserAnswer();
			int answer = getAnswer();
			
			if (userNum == answer) {
				displayCorrectResponse();
				break;
			}
			else {
				displayIncorrectResponse();
				readResponse();
			}
		}	
	}
	
	public void readResponse() {
		num3 = scan.nextInt();
		setuserAnswer(num3);
	}
	
	public void askQuestion() {
		Random rand = new SecureRandom();
		
		num1 = rand.nextInt(10);
		num2 = rand.nextInt(10);
		setAnswer(num1, num2);
		System.out.println("What is " + num1 + " times "+ num2 + "?");
	}
	public void quiz() {
		askQuestion();
		readResponse();
		isAnswerCorrect();
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
	
	public static void main(String[] args) {
		CAI1 app = new CAI1();
		app.quiz();
	}

}
