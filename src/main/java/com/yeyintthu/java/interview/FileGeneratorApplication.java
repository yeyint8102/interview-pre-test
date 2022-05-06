package com.yeyintthu.java.interview;

import java.io.IOException;
import java.util.Scanner;

public class FileGeneratorApplication {

	public static void main(String[] args) throws IOException {

		FileGenerator fileGenerator = new FileGeneratorImpl();
		boolean flag = true;
		do {
			try {
				Scanner scanner = new Scanner(System.in);
				System.out.print("\nEnter line count to write in the file: ");
				System.out.println(fileGenerator.generate(scanner.nextInt()).get());
				flag = false;
				scanner.close();
			} catch (Exception e) {
				System.err.println("\nPlease enter integer value only!");
			}
		} while (flag);
	}
}
