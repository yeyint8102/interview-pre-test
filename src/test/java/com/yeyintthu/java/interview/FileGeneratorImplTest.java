package com.yeyintthu.java.interview;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import java.io.IOException;
import java.util.Optional;

import org.junit.Test;

public class FileGeneratorImplTest {

	FileGenerator fileGenerator = new FileGeneratorImpl();

	@Test
	public void generateTest() throws IOException {
		assertEquals("To test success scenario", Optional.of(Operations.SUCCESS.result), fileGenerator.generate(4));
		assertEquals("To test success scenario", Optional.of(Operations.SUCCESS.result), fileGenerator.generate(229));
		assertEquals("To test fail scenario", Optional.of(Operations.FAIL.result), fileGenerator.generate(-9));
		assertEquals("To test fail scenario", Optional.of(Operations.FAIL.result), fileGenerator.generate(380));
		assertTrue(fileGenerator.generate(333).isPresent());
		assertFalse(fileGenerator.generate(4).isEmpty());
	}

}
