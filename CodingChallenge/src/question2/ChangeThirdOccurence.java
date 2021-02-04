package question2;

import java.util.Scanner;

public class ChangeThirdOccurence {

	Scanner sc = new Scanner(System.in);

	public String ReplaceToStar(String word, char character, int position) {

		String temp = "";
		int length = word.length();
		char characterExtracted;
		int firstTime = 0, indexValue = 0;
		int[] charAscii = new int[length];

		ty: for (int i = position; i < length; i++) {
			characterExtracted = word.charAt(i);
			if (characterExtracted != '*') {

				if (character == characterExtracted) {
					if (firstTime == 0) {
						temp = temp + "*";
						charAscii[indexValue] = character;
						indexValue++;
						firstTime++;
					} else {
						for (int j = 0; j < indexValue; j++) {
							if (characterExtracted == charAscii[j]) {
								temp = temp + characterExtracted;
								continue ty;
							}
						}
					}

				} else {
					temp = temp + characterExtracted;
				}
			} else {
				temp = temp + characterExtracted;
				continue;
			}

		}

		for (int i = position - 1; i >= 0; i--) {
			characterExtracted = word.charAt(i);

			temp = characterExtracted + temp;

		}
		return temp;

	}

	public String changeOccurence(String word) {

		int length = word.length();
		char character, character2;
		String temp = "";

		int index, count = 0, secondIndex = 0;
		for (int i = 0; i < length; i++) {
			character = word.charAt(i);
			index = word.indexOf(character, i+1);
			if(index!=-1) {
				for (int j = index; j < length; j++) {
					character2 = word.charAt(j);
					secondIndex = word.indexOf(character2, j+1);
					break;
				}

				if (secondIndex != -1) {
					temp = ReplaceToStar(word, character, secondIndex);
				}
				if (temp != "") {
					word = temp;
				}
			}
			
			

		}
		
		return word;
	}

	public static void main(String[] args) {

		ChangeThirdOccurence obj = new ChangeThirdOccurence();

		System.out.println("Enter the string");
		String word = obj.sc.next();
		String newWord=obj.changeOccurence(word);
		System.out.println(newWord);

	}

}
