package com.my.jdk17;

import static java.nio.file.StandardWatchEventKinds.ENTRY_CREATE;
import static java.nio.file.StandardWatchEventKinds.ENTRY_DELETE;
import static java.nio.file.StandardWatchEventKinds.ENTRY_MODIFY;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.WatchEvent;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;
import java.util.concurrent.TimeUnit;

public class WatchDir {

	public static void main(String[] args) {
		Path waitingFolder = Paths.get(args[0]);
		WatchService watcher;
		WatchKey key;
		try {
			watcher = FileSystems.getDefault().newWatchService();
			key = waitingFolder.register(watcher, ENTRY_CREATE, ENTRY_DELETE,
					ENTRY_MODIFY);
			for (;;) {
				key = watcher.take();
				for (WatchEvent<?> event : key.pollEvents()) {
					WatchEvent<Path> ev = (WatchEvent<Path>) event;
					Path filename = ev.context();
					if (event.kind() == ENTRY_CREATE) {
						System.out.println(filename + " ENTRY_CREATE");
					} else if (event.kind() == ENTRY_DELETE) {
						System.out.println(filename + " ENTRY_DELETE");
					} else if (event.kind() == ENTRY_MODIFY) {
						System.out.println(filename + " ENTRY_MODIFY");
					}
					TimeUnit.SECONDS.sleep(5);
				}
				
				boolean valid = key.reset();
				if (!valid) {
					break;
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
