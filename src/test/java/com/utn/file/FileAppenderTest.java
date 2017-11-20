package com.utn.file;

import com.utn.files.FileAppender;
import com.utn.files.FileSelector;
import com.utn.repositorio.InputFiles;
import org.assertj.core.util.Lists;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.util.stream.Stream;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by nicolaslamas on 20/11/17.
 */
public class FileAppenderTest {

    private FileAppender fileAppender = new FileAppender();
    private FileSelector fileSelector;

    @Before
    public void setUp() {
        fileAppender = new FileAppender();
        InputFiles inputFiles = mock(InputFiles.class);
        when(inputFiles.findAll()).thenReturn(Lists.emptyList());
        fileSelector = new FileSelector(inputFiles);
    }

    @Test
    public void testFileAppener() throws IOException {
        long numberOfLines;
        File testFile =  fileAppender.generateAppendedFile(fileSelector, "test-output");
        try (Stream<String> lines = Files.lines(testFile.toPath(), Charset.defaultCharset())){
            numberOfLines = lines.count();
        }
        Assert.assertEquals(4, numberOfLines);
    }

}
