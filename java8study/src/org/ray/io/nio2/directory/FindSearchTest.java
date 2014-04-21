package org.ray.io.nio2.directory;

import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.PathMatcher;
import java.nio.file.Paths;

import org.junit.Test;

public class FindSearchTest {

	@Test
	public void test() {
		Path path = Paths.get("D:/Ray/", "re.txt");
		System.out.println(Files.exists(path));
		
		PathMatcher matcher = FileSystems.getDefault().getPathMatcher("glob:*.{txt}");
		System.out.println(matcher.matches(path));
	}
	
}
