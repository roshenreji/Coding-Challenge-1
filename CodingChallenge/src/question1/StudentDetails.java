package question1;

public class StudentDetails {

	private int id;
	private String name;
	private int grade;
	private char section;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
		System.out.println("ID Updated");
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
		System.out.println("Name Updated");
	}
	public int getGrade() {
		return grade;
	}
	public void setGrade(int grade) {
		this.grade = grade;
		System.out.println("Grade Updated");
	}
	public char getSection() {
		return section;
	}
	public void setSection(char section) {
		this.section = section;
		System.out.println("Section Updated");
	}
	
	
	
}
