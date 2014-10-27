package com.my.jdk17;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.StandardCopyOption;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Random;

public class NIO2Action {
	public void copyMove() throws IOException {
		Path srcPath = Paths.get("/tmp/src.txt");
		Path dstPath = Paths.get("/tmp/dst.txt");
		Files.copy(srcPath, dstPath, StandardCopyOption.COPY_ATTRIBUTES, StandardCopyOption.REPLACE_EXISTING);
		Files.move(srcPath, dstPath, StandardCopyOption.ATOMIC_MOVE);
	}

	public void retrieveDir() {
		Path srcPath = Paths.get("/tmp/test");
		try (DirectoryStream<Path> dir = Files.newDirectoryStream(srcPath)) {
			for (Path p : dir) {
				System.out.println(p);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void createSymbolicLink() {
		Path link = Paths.get("/tmp/test1");
		Path existingFile = Paths.get("/tmp/test");
		try {
			Files.createSymbolicLink(link, existingFile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void walkFileTree() {
		Path dir = Paths.get("/");
		try {
			Files.walkFileTree(dir, new SimpleFileVisitor<Path>() {
				@Override
				public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
					System.out.println(file);
					return FileVisitResult.CONTINUE;
				}
			});
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		new NIO2Action().walkFileTree();
		//FileSystemProvider
		Random r = new Random();
	}
}
