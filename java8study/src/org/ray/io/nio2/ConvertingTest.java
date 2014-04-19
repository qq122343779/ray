package org.ray.io.nio2;

import java.nio.file.Path;
import java.nio.file.Paths;

public class ConvertingTest {

	public static void main(String[] args) {
		Path inputPath = Paths.get(args[0]);
		
		System.out.printf("fullpath: %s", inputPath.toAbsolutePath());
	}
	
}
