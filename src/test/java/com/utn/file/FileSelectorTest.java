package com.utn.file;

import com.utn.files.FileSelector;
import com.utn.repositorio.InputFiles;
import org.assertj.core.util.Lists;
import org.junit.Assert;
import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by nicolaslamas on 20/11/17.
 */
public class FileSelectorTest {

    @Test
    public void testFileSelector() {
        InputFiles inputFiles = mock(InputFiles.class);
        when(inputFiles.findAll()).thenReturn(Lists.emptyList());
        FileSelector fileSelector = new FileSelector(inputFiles);
        Assert.assertEquals(2, fileSelector.getFilesToRead().size());
    }

}
