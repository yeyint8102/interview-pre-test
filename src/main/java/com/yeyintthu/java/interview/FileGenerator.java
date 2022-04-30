package com.yeyintthu.java.interview;

import java.io.IOException;
import java.util.Optional;

public interface FileGenerator {
	public Optional<String> generate(int x) throws IOException;
}
