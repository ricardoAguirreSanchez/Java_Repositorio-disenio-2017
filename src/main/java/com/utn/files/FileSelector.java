package com.utn.files;

import com.utn.model.InputFile;
import com.utn.repositorio.InputFiles;
import org.assertj.core.util.Lists;

import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by nicolaslamas on 18/11/17.
 */
public class FileSelector {


    private InputFiles inputFiles;

    public FileSelector(InputFiles inputFiles){
        this.inputFiles = inputFiles;
    }
    private List<InputFile> getAllFilesFromDB(){
        return Lists.newArrayList(inputFiles.findAll());
    }

    private List<File> getAllFilesInFolder() {
        //TODO fix esta excepcion cuadno no existe un archivo adentro de la carpeta CSV
        File[] files = new File(getClass().getClassLoader().getResource("csv/").getFile()).listFiles();
        return Arrays.asList(files);
    }

    public List<File> getFilesToRead(){
        List<InputFile> dbFiles = getAllFilesFromDB();
        return  getAllFilesInFolder().stream()
                .filter(f -> !dbFiles.stream()
                        .map(InputFile::getName)
                        .collect(Collectors.toList())
                        .contains(f.getName()))
                .collect(Collectors.toList());
    }

    public void persistUsedFiles() {
        getFilesToRead().forEach(input -> {
            InputFile inputFile= new InputFile();
            inputFile.setName(input.getName());
            inputFiles.save(inputFile);
        });

    }
}
