package com.utn.files;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.io.*;

/**
 * Created by nicolaslamas on 18/11/17.
 */
@Component
public class FileAppender {
    private static final Logger log = LoggerFactory.getLogger(FileAppender.class);


    public File generateAppendedFile(FileSelector fileSelector, String fileName) throws IOException {

        File output = File.createTempFile(fileName, ".csv");
        try (FileWriter fw = new FileWriter(output); BufferedWriter bw = new BufferedWriter(fw)) {
            for (File file : fileSelector.getFilesToRead()) {
                try (FileReader fr = new FileReader(file); BufferedReader br = new BufferedReader(fr)) {
                    String line;

                    while ((line = br.readLine()) != null) {
                            bw.write(line);
                            bw.newLine();
                        }
                    }
                }
            }
        log.info("File for csv batch is: " + output.getAbsolutePath());
        fileSelector.persistUsedFiles();
        return output;
    }
}
