package nhon_problem1;

import java.security.SecureRandom;
import java.util.Random;
import java.util.Scanner;

public class CAI2 {
	Random rand = new SecureRandom();
	Scanner scan = new Scanner(System.in);
	int userAnswer;
	int num1;
	int num2;
	int num3;
	int Answer;
	int responseNum;
	
	
	public void displayIncorrectResponse() {
		responseNum = rand.nextInt(4);
		switch(responseNum) {
		case 1:
			System.out.println("No. Please Try Again.");
			break;
		case 2:
			System.out.println("Wrong. Try once more.");
			break;
		case 3:
			System.out.println("Don't give up!");
			break;
		case 4:
			System.out.println("No. Keep trying.");
			break;
		}
		
	}
	public void displayCorrectResponse() {
		responseNum = rand.nextInt(4);
		switch(responseNum) {
		case 1:
			System.out.println("Very good!");
			break;
		case 2:
			System.out.println("Excellent!");
			break;
		case 3:
			System.out.println("Nice work!");
			break;
		case 4:
			System.out.println("Keep up the good work!");
			break;
		}
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
		CAI2 app = new CAI2();
		app.quiz();
	}

}
