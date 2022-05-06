package com.yeyintthu.java.interview;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Optional;

import org.apache.commons.lang3.RandomStringUtils;

public class FileGeneratorImpl implements FileGenerator {

	@Override
	public Optional<String> generate(int x) throws IOException {

		if (isNotValidLineRange(x)) {
			identifyError(x);
			return Optional.of(Operations.FAIL.result);
		}

		File file = new File("Generated_File_" + System.currentTimeMillis() + ".txt");
		BufferedWriter writer = new BufferedWriter(new FileWriter(file));

		while (isValidLineRange(x)) {
			writeToFile(writer);
			x--;
		}
		writer.close();
		System.out.println("File Path: " + file.getCanonicalPath());
		return Optional.of(Operations.SUCCESS.result);
	}

	private static void identifyError(int x) {
		if (isLineRangeOver(x))
			System.err.println("Over the limited line range!");
		if (isLineRangeUnder(x))
			System.err.println("Under the limited line range!");
	}

	private static void writeToFile(BufferedWriter writer) throws IOException {
		writer.write(RandomStringUtils.randomAlphabetic(100));
		writer.newLine();
	}

	private static boolean isValidLineRange(int x) {
		return x > 0 && x < 230;
	}

	private static boolean isNotValidLineRange(int x) {
		return !isValidLineRange(x);
	}

	private static boolean isLineRangeOver(int x) {
		return x > 230;
	}

	private static boolean isLineRangeUnder(int x) {
		return x < 0;
	}
}
