package de.Chatfilter.Main;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Chatfilter {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		final String string = scanner.nextLine();
		
		Pattern pattern = Pattern.compile("");
		Matcher matcher = pattern.matcher(string);
		
		if(matcher.find()) {
			
			System.out.println("Ich habe etwas gefunden!");
			System.out.println(matcher.group());
			
		}
		
	}
	
}
