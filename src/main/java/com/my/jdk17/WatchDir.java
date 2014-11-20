package com.my.jdk17;

import static java.nio.file.StandardWatchEventKinds.ENTRY_CREATE;
import static java.nio.file.StandardWatchEventKinds.ENTRY_DELETE;
import static java.nio.file.StandardWatchEventKinds.ENTRY_MODIFY;

import java.io.BufferedWriter;
import java.nio.charset.Charset;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.concurrent.TimeUnit;

public class WatchDir {

	public static void main(String[] args) {
		boolean b = "abc".endsWith("");
		Path waitingFolder = Paths.get(args[0]);
		WatchService watcher;
		WatchKey key;
		try(BufferedWriter bw = Files.newBufferedWriter(waitingFolder.getParent().resolve(Paths.get("watch.log")), Charset.defaultCharset())) {
			watcher = FileSystems.getDefault().newWatchService();
			key = waitingFolder.register(watcher, ENTRY_CREATE, ENTRY_DELETE,
					ENTRY_MODIFY);
			for (;;) {
				key = watcher.take();
                bw.write("Evnent group start");
                bw.newLine();
				for (WatchEvent<?> event : key.pollEvents()) {

                    try {
                        WatchEvent<Path> ev = (WatchEvent<Path>) event;
                        Path filename = waitingFolder.resolve(ev.context());
                        String e = null;
                        if (event.kind() == ENTRY_CREATE) {
                        	e = "ENTRY_CREATE";
                        } else if (event.kind() == ENTRY_DELETE) {
                            e = "ENTRY_DELETE";
                        } else if (event.kind() == ENTRY_MODIFY) {
                            e = "ENTRY_MODIFY";
                        }

                        bw.write(String.format("File name: %s, File size: [%d], %s", filename, Files.readAttributes(filename, BasicFileAttributes.class).size(), e));
                        bw.newLine();

                       
                    }
                    catch (Exception e){
                        //e.printStackTrace();
                    }
					//TimeUnit.SECONDS.sleep(5);
				}
				bw.write("Evnent group end");
                bw.newLine();
                TimeUnit.SECONDS.sleep(10);
				boolean valid = key.reset();
				if (!valid) {
					break;
				}
                bw.flush();
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 

	}

}