package org.ray.io.nio2;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.PathMatcher;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;

public class Find {

	static void usage() {
        System.err.println("java Find <path>" + " -name \"<glob_pattern>\"");
        System.exit(-1);
    }
	
	public static void main(String[] args) throws IOException {
	        if (args.length < 3 || !args[1].equals("-name")) {
	        	usage();
	        }

	        Path startingDir = Paths.get(args[0]);
	        String pattern = args[2];

	        Finder finder = new Finder(pattern);
	        Files.walkFileTree(startingDir, finder);
	        finder.done();
	    }
	
	public static class Finder extends SimpleFileVisitor<Path> {
		
		private final PathMatcher matcher;
		private int numMatches = 0;
		
		public Finder(String pattern) {
			this.matcher = FileSystems.getDefault().getPathMatcher("glob:" + pattern);
		}
		
		// Compares the glob pattern against
        // the file or directory name.
        void find(Path file) {
            Path name = file.getFileName();
            if (name != null && matcher.matches(name)) {
                numMatches++;
                System.out.println(file);
            }
        }

        // Prints the total number of
        // matches to standard out.
        void done() {
            System.out.println("Matched: " + numMatches);
        }
        
        // Invoke the pattern matching
        // method on each file.
        @Override
        public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) {
            find(file);
            return FileVisitResult.CONTINUE;
        }

        // Invoke the pattern matching
        // method on each directory.
        @Override
        public FileVisitResult preVisitDirectory(Path dir,
                BasicFileAttributes attrs) {
            find(dir);
            return FileVisitResult.CONTINUE;
        }

        @Override
        public FileVisitResult visitFileFailed(Path file, IOException exc) {
            System.err.println(exc);
            return FileVisitResult.CONTINUE;
        }
	}
}
