package com.utn.batch;

import com.utn.files.FileAppender;
import com.utn.files.FileSelector;
import com.utn.repositorio.InputFiles;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * Created by nicolaslamas on 18/11/17.
 */
@Component
public class JobScheduler {

    @Autowired
    private JobLauncher jobLauncher;

    @Autowired
    private Job job;

    @Autowired
    public FileAppender fileAppender;

    @Autowired
    private InputFiles inputFiles;

    @Scheduled(cron = "*/5 * * * * *")
    public void runJob() throws JobParametersInvalidException,
            JobExecutionAlreadyRunningException, JobRestartException, JobInstanceAlreadyCompleteException, IOException {

        String absolutePath = fileAppender.generateAppendedFile(new FileSelector(inputFiles), "output_cuenta")
                .getAbsolutePath();


        JobParameters param = new JobParametersBuilder()
                .addString("JobID", String.valueOf(System.currentTimeMillis()))
                .addString("pathToFile",absolutePath).toJobParameters();

        jobLauncher.run(job,param );
    }
}