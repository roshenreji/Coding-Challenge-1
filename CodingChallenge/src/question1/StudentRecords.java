package question1;

import java.util.Scanner;

public class StudentRecords {

	Scanner sc = new Scanner(System.in);

	public void displayMessages() {
		System.out.println();
		System.out.println("These are the choices: ");
		System.out.println("1. Add Student Details");
		System.out.println("2. Upgrade grade and section of a Student");
		System.out.println("3. Sort Student list based on the grade");
		System.out.println("4. Exit");
	}

	public StudentDetails[] doubleCapacity(StudentDetails[] obj) {

		int length = obj.length * 2;
		StudentDetails[] temp = new StudentDetails[length];

		for (int i = 0; i < obj.length; i++) {
			temp[i] = obj[i];
		}

		obj = temp;

		return obj;
	}

	public StudentDetails[] addStudentDetails(StudentDetails[] obj, int index) {

		if (index + 1 == obj.length)
			obj = doubleCapacity(obj);

		System.out.println("Enter the Id of the Student: ");
		int id = sc.nextInt();
		sc.nextLine();

		System.out.println("Enter the name of the Student: ");
		String name = sc.nextLine();

		System.out.println("Enter the grade of the Student(1-12)");
		int grade = sc.nextInt();

		System.out.println("Enter the session of the student");
		char section = sc.next().charAt(0);

		obj[index] = new StudentDetails();
		obj[index].setId(id);
		obj[index].setName(name);
		obj[index].setGrade(grade);
		obj[index].setSection(section);

		return obj;

	}

	public boolean idPresentOrNot(StudentDetails[] obj, int index, int id) {

		boolean flag = false;

		for (int i = 0; i < index; i++) {
			if (obj[i].getId() == id) {
				flag = true;
				break;
			}
		}

		return flag;
	}

	public StudentDetails[] updatingGradeAndSection(StudentDetails[] obj, int index, int id, int grade, char section) {

		for (int i = 0; i < index; i++) {
			if (obj[i].getId() == id) {
				obj[i].setGrade(grade);
				obj[i].setSection(section);

			}
		}

		return obj;

	}
	
	public StudentDetails[] sortStudentList(StudentDetails[] obj, int index) {
		
		StudentDetails temp;
		for(int i=0;i<index;i++) {
			for(int j=0;j<index-i-1;j++) {
				if(obj[j].getGrade()>obj[j+1].getGrade()) {
					temp=obj[j];
					obj[j]=obj[j+1];
					obj[j+1]=temp;
					
				}
			}
		}
		
		return obj;
	}

	public static void main(String[] args) {
		boolean isValid = true;
		int size = 2, index = 0;
		StudentDetails[] students = new StudentDetails[size];

		StudentRecords obj = new StudentRecords();

		do {
			new StudentRecords().displayMessages();
			int choice = new StudentRecords().sc.nextInt();

			switch (choice) {

			case 1:
				students = new StudentRecords().addStudentDetails(students, index);
				index++;
				break;

			case 2:

				System.out.println("Enter the id of the Student whose grade and section needs to be updated: ");
				int id = obj.sc.nextInt();

				boolean flag = obj.idPresentOrNot(students, index, id);
				if (flag == true) {

					System.out.println("Enter the new Grade");
					int grade = obj.sc.nextInt();
					System.out.println("Enter the new Session");
					char section = obj.sc.next().charAt(0);
					students = obj.updatingGradeAndSection(students, index, id, grade, section);

				}
				else
					System.out.println("Entered Id is not present in the Database");
				
				break;
				
			case 3:
				System.out.println("Printing Student Details based on the grade");
				int count=1;
				for(int i=0;i<index;i++) {
					System.out.println();
					System.out.println(count+"\t Student Id:"+ students[i].getId());
					System.out.println("\t Student Name:"+ students[i].getName());
					System.out.println("\t Student Grade:"+ students[i].getGrade());
					System.out.println("\t Student Section:"+ students[i].getSection());
					count++;
				}
				
				break;
				
			case 4:
				isValid=false;
				
				default:
					System.out.println("Invalid Option");

			}
		} while (isValid);

	}

}
