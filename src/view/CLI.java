package ui;

import java.util.Scanner;

import managers.StudentManagers;
import model.Student;

public class CLI {
	private boolean EndFlag=false;

	public void start() {
		do{
			printMainMenu();
			mainMenuSelector();
		}while (EndFlag==false);
	}

	public void printMainMenu() {
		System.out.println("Please Select:");
		System.out.println("1- Student");
		System.out.println("2- Teacher");
		System.out.println("3- End");
	}

	private void mainMenuSelector() {
		Scanner sca = new Scanner(System.in);
		int cursur = sca.nextInt();
		switch (cursur) {
		case 1:
			System.out.println("Student has chosen,");
			printMenu();
            new StudentManagers();
            break;
		case 2:
			System.out.println("Teacher has chosen,");
			printMenu();
			break;
		case 3:
			System.out.println("Program Ended!");
			sca.close();
			EndFlag =true;

		}
	}

	private void printMenu() {
		System.out.println("Please select action:");
		System.out.println("1- Add");
		System.out.println("2- Remove (by ID)");
		System.out.println("3- List");
		System.out.println("4- Back to main menu");
	}

	public void print(Object object) {
		System.out.println(object.toString());
	}

	public static void print(Student[] students) {
		for (Student student : students) {
			System.out.println(student.toString());
		}
	}

}
