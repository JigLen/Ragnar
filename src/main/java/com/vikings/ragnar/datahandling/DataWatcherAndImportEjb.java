package com.vikings.ragnar.datahandling;

import com.vikings.ragnar.entities.BaseDataEntity;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;
import javax.ejb.*;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.*;
import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.util.Collection;

import static java.nio.file.StandardWatchEventKinds.ENTRY_CREATE;
import static java.nio.file.StandardWatchEventKinds.OVERFLOW;

/**
 * Created by carlmccann2 on 09/03/2017.
 */

@Startup
@Singleton
public class DataWatcherAndImportEjb {
    @PersistenceContext EntityManager em;
    @Resource           SessionContext sessionContext;
    boolean watch = true;

    @PostConstruct
    public void initialise(){
        Runnable run = () -> {
            try {
                WatchService watcher = FileSystems.getDefault().newWatchService();
                Path dir = Paths.get("res/incoming_data");
                // Absolute Path will cause problems on other machines
                dir = Paths.get("/Volumes/Data/Users/carlmccann2/IdeaProjects/Ragnar/res/incoming_data");
                // could also have ENTRY_DELETE, ENTRY_MODIFY etc.
                dir.register(watcher, ENTRY_CREATE);
                System.out.println("Watch Service registered for dir: " + dir.getFileName());

                while(watch) {
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
                                long startTime = System.currentTimeMillis();
                                Collection<BaseDataEntity> toBePersisted = ExcelHandler.excelFileHandler(relPathToFilename);
                                System.out.println("Persisting entities");
                                for(BaseDataEntity baseDataEntity: toBePersisted){
                                    UserTransaction uTx = sessionContext.getUserTransaction();
                                    uTx.begin();
                                    em.persist(baseDataEntity);
                                    uTx.commit();
                                }
                                System.out.println("Persistence completed in: " +
                                        ((System.currentTimeMillis() - startTime) / 1000) + "s");
                            }
                        }
                    }
                    // IMPORTANT: The key must be reset after processed
                    boolean valid = key.reset();
                    if (!valid) {
                        break;
                    }
                    Thread.sleep(1000);
                }
            } catch (IOException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (NotSupportedException e) {
                e.printStackTrace();
            } catch (SystemException e) {
                e.printStackTrace();
            } catch (RollbackException e) {
                e.printStackTrace();
            } catch (HeuristicMixedException e) {
                e.printStackTrace();
            } catch (HeuristicRollbackException e) {
                e.printStackTrace();
            }
        };
        Thread thread = new Thread(run);
        thread.setDaemon(true);
        thread.start();
    }

    @PreDestroy
    public void destroy(){
        watch = false;
    }
}
