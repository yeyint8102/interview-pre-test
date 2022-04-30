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
		FileGeneratorImpl fileGenerator = new FileGeneratorImpl();
		File file = new File("Generated_File_" + System.currentTimeMillis() + ".txt");

		if (!fileGenerator.isValidLineRange(x))
			return Optional.of(Operations.FAIL.result);

		BufferedWriter writer = new BufferedWriter(new FileWriter(file));

		while (fileGenerator.isValidLineRange(x)) {
			writer.write(RandomStringUtils.randomAlphabetic(100));
			writer.newLine();
			x--;
		}
		writer.close();
		return Optional.of(Operations.SUCCESS.result);
	}

	private boolean isValidLineRange(int x) {
		return x > 0 && x < 230;
	}

}
