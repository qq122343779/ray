package org.ray.io.nio2;

import java.io.IOException;
import java.nio.file.FileStore;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileTime;

import org.junit.Test;

public class MetadataTest {

	Path file = Paths.get("myfile.txt");
	
	@Test
	public void basicFileAttributesTest() throws IOException {
		BasicFileAttributes attr = Files.readAttributes(file, BasicFileAttributes.class);

		System.out.println("creationTime: " + attr.creationTime());
		System.out.println("lastAccessTime: " + attr.lastAccessTime());
		System.out.println("lastModifiedTime: " + attr.lastModifiedTime());

		System.out.println("isDirectory: " + attr.isDirectory());
		System.out.println("isOther: " + attr.isOther());
		System.out.println("isRegularFile: " + attr.isRegularFile());
		System.out.println("isSymbolicLink: " + attr.isSymbolicLink());
		System.out.println("size: " + attr.size());
		
		System.out.println("setting lastModifiedTime:");
		long curr = System.currentTimeMillis();
		FileTime time = FileTime.fromMillis(curr);
		Files.setLastModifiedTime(file, time);
		attr = Files.readAttributes(file, BasicFileAttributes.class);
		System.out.println("lastModifiedTime: " + attr.lastModifiedTime());
	}
	
	@Test
	public void fileStoreTest() throws IOException {
		FileStore store = Files.getFileStore(Paths.get("D:/"));
		
		long total = store.getTotalSpace() / 1024 / 1024 / 1024;
		long used = (store.getTotalSpace() -
		             store.getUnallocatedSpace()) / 1024;
		long avail = store.getUsableSpace() / 1024;
		System.out.printf("total: %d GB, userd: %d, avail: %d", total, used, avail);
	}
	
}
