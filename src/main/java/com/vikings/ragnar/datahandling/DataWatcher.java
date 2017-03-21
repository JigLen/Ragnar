package com.vikings.ragnar.datahandling;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.ejb.Stateless;
import java.io.File;
import java.io.IOException;
import java.nio.file.*;

import static java.nio.file.StandardWatchEventKinds.ENTRY_CREATE;
import static java.nio.file.StandardWatchEventKinds.OVERFLOW;

/**
 * Created by carlmccann2 on 09/03/2017.
 */
@Startup
@Singleton
public class DataWatcher {
    @PostConstruct
    public void initialise(){
        Runnable run = () -> {
            try {
                WatchService watcher = FileSystems.getDefault().newWatchService();
                Path dir = Paths.get("res/incoming_data");
                dir = Paths.get("/Volumes/Data/Users/carlmccann2/IdeaProjects/Ragnar/res/incoming_data");
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




                            String relPathToFilename = dir.toString() + "/" + fileName.toString();

                            File f = new File(relPathToFilename);
                            f.setWritable(true);


                            if(fileName.toString().endsWith(".xlsx") || fileName.toString().endsWith(".xls")){
                                System.out.println("found excel file");
                                excelChanger.excelFileHandler(relPathToFilename);
                            }

                            //  spot sql files
                            if(fileName.toString().endsWith(".csv")){
                                System.out.println("Found csv file");
                                csvCleaner.clean(relPathToFilename);
                                csvPersister.persist(relPathToFilename);

                            }

                        }
                    }

                    // IMPORTANT: The key must be reset after processed
                    boolean valid = key.reset();
                    if (!valid) {
                        break;
                    }
                    Thread.sleep(10000);
                }

            } catch (IOException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };
        new Thread(run).start();

    }

    @PreDestroy
    public void destroy(){

    }
}
