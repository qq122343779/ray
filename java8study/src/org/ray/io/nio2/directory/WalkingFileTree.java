package org.ray.io.nio2.directory;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;

import org.junit.Test;

public class WalkingFileTree {

	Path path = Paths.get("D:/Ray/OneNote笔记");
	
	@Test
	public void test() throws IOException {
		Files.walkFileTree(path, new PrintFileVisitor());
	}
	
	static class PrintFileVisitor extends SimpleFileVisitor<Path> {

		@Override
		public FileVisitResult visitFile(Path file, BasicFileAttributes attr)
				throws IOException {
			if (attr.isSymbolicLink()) {
	            System.out.format("Symbolic link: %s ", file);
	        } else if (attr.isRegularFile()) {
	            System.out.format("Regular file: %s ", file);
	        } else {
	            System.out.format("Other: %s ", file);
	        }
	        System.out.println("(" + attr.size() + "bytes)");
			return FileVisitResult.CONTINUE;
		}
		
		@Override
		public FileVisitResult postVisitDirectory(Path dir, IOException exc)
				throws IOException {
			System.out.format("Directory: %s%n", dir);
	        return FileVisitResult.CONTINUE;
		}

		@Override
		public FileVisitResult visitFileFailed(Path file, IOException exc)
				throws IOException {
			 System.err.println(exc);
		     return FileVisitResult.CONTINUE;
		}

		
	}
	
}
