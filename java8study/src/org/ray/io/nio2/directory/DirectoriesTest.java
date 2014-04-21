package org.ray.io.nio2.directory;

import java.nio.file.DirectoryStream;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.junit.Test;

public class DirectoriesTest {

	@Test
	public void testRootDicretories() {
		for (Path path : FileSystems.getDefault().getRootDirectories()) {
			System.out.println(path);
		}
	}
	
	@Test
	public void testDirStream() {
		try (DirectoryStream<Path> stream = Files.newDirectoryStream(Paths.get("D:/ray"))) {
			stream.forEach(path -> System.out.println(path));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testFilterGlobbing() {
		try (DirectoryStream<Path> stream = Files.newDirectoryStream(Paths.get("D:/ray/Books"), "*.{rar}")) {
			stream.forEach(path -> System.out.println(path));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testMyFilter() {
		try (DirectoryStream<Path> stream = Files.newDirectoryStream(
				Paths.get("D:/ray/Books"), 
				path -> Files.isDirectory(path))) {
			stream.forEach(path -> System.out.println(path));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
