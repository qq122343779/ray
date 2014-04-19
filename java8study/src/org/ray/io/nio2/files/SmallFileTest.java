package org.ray.io.nio2.files;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

import org.junit.Test;

public class SmallFileTest {

	Path file = Paths.get("myfile.txt");
	
	@Test
	public void test() throws IOException {
		byte[] allbytes = Files.readAllBytes(file);
		Files.write(file, allbytes, StandardOpenOption.TRUNCATE_EXISTING);
	}
	
	@Test
	public void testBuffered() {
		try (BufferedReader br = Files.newBufferedReader(file, Charset.forName("UTF-8"))) {
			String line = null;
			while ((line = br.readLine()) != null) {
				System.out.println(line);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
 }
