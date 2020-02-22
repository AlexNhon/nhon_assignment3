package nhon_problem1;

import java.security.SecureRandom;
import java.util.Random;
import java.util.Scanner;

public class CAI3 {
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
		num1 = rand.nextInt(10);
		num2 = rand.nextInt(10);
		setAnswer(num1, num2);
		System.out.println("What is " + num1 + " times "+ num2 + "?");
	}
	private void quiz() {
		correctCount = 0;
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
		CAI3 app = new CAI3();
		app.quiz();
	}

}
