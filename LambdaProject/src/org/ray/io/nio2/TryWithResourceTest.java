package org.ray.io.nio2;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class TryWithResourceTest {

	public static void main(String[] args) {
		Charset cs = Charset.forName("UTF-8");
		String str = "HAHAHAHAHA11";
		Path file = Paths.get("TryWithResourceTest.log");
		try (BufferedWriter writer = Files.newBufferedWriter(file, cs)) {
			writer.write(str, 0, str.length());
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
}
