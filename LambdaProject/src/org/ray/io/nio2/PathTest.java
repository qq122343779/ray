package org.ray.io.nio2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.junit.Test;

public class PathTest {

	@Test
	public void test() {
		Path path = Paths.get(System.getProperty("user.home"), "mypath", "foo.log");
		
		System.out.format("toString: %s%n", path.toString());
		System.out.format("getFileName: %s%n", path.getFileName());
		System.out.format("getName(0): %s%n", path.getName(0));
		System.out.format("getNameCount: %d%n", path.getNameCount());
		System.out.format("subpath(0,2): %s%n", path.subpath(0,2));
		System.out.format("getParent: %s%n", path.getParent());
		System.out.format("getRoot: %s%n", path.getRoot());
	}
	
	@Test
	public void allpathsTest() {
		Path path = Paths.get(System.getProperty("user.home"), "mypath");
		for (Path p : path) {
			System.out.println(p);
		}
	}
	
	@Test
	public void isSameFile() throws IOException {
		Path path1 = Paths.get("D:/0work/deppon/DPAP/trunk/DOC/06 部门管理/02 部门活动/每日伙食-财务状况-2014.xlsx");
		Path path2 = Paths.get("C:/Users/Administrator/Desktop/每日伙食");
		System.out.println(Files.isSameFile(path1, path2));
	}
	
	@Test
	public void copy() throws IOException {
		Path file = Paths.get("TryWithResourceTest.log");
		Path file1 = Paths.get("TryWithResourceTest_bak.log");
		Files.copy(file, file1, StandardCopyOption.REPLACE_EXISTING);
	}
}
