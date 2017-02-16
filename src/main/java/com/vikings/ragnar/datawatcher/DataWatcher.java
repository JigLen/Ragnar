package com.vikings.ragnar.datawatcher;

import com.vikings.ragnar.datavalidation.DataCleaner;

import java.io.IOException;
import java.nio.file.*;

import static java.nio.file.StandardWatchEventKinds.*;

/**
 * Created by carlmccann2 on 12/02/2017.
 *
 * Made Following this code
 * http://www.codejava.net/java-se/file-io/file-change-notification-example-with-watch-service-api
 */

public class DataWatcher {
    public DataWatcher(){

        try {
            WatchService watcher = FileSystems.getDefault().newWatchService();
            Path dir = Paths.get("res/incoming_data");

            // could also have ENTRY_DELETE, ENTRY_MODIFY etc.
            dir.register(watcher, ENTRY_CREATE);
            System.out.println("Watch Service registered for dir: " + dir.getFileName());

            while(true) {
                WatchKey key;
                try {
                    key = watcher.take();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    return;
                }
                for (WatchEvent<?> event : key.pollEvents()) {
                    // get event type
                    WatchEvent.Kind<?> kind = event.kind();

                    // get file name
                    @SuppressWarnings("unchecked")
                    WatchEvent<Path> ev = (WatchEvent<Path>) event;
                    Path fileName = ev.context();

                    System.out.println(kind.name() + ": " + fileName);

                    if (kind == OVERFLOW) {
                        continue;
                    }
                    else if (kind == ENTRY_CREATE) {
                        //  spot sql files
                        if(fileName.toString().endsWith(".csv")){
                            System.out.println("Found csv file");
                            String relPathToFilename = dir.toString() + "/" + fileName.toString();
                            DataCleaner.clean(relPathToFilename);

                        }
                    }
                }

                // IMPORTANT: The key must be reset after processed
                boolean valid = key.reset();
                if (!valid) {
                    break;
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

//    public static void main(String[] args) {
//        DataWatcher dataWatcher = new DataWatcher();
//    }
}
