package com.utn.batch;

import com.utn.files.FileAppender;
import com.utn.files.FileSelector;
import com.utn.model.CuentaValorToWrite;
import com.utn.model.RowCuenta;
import com.utn.processor.RowCuentaProcessor;
import com.utn.repositorio.InputFiles;
import com.utn.writer.CuentaValorWriter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.*;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.launch.support.SimpleJobLauncher;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.repository.support.MapJobRepositoryFactoryBean;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.batch.support.transaction.ResourcelessTransactionManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.io.IOException;
import java.util.Date;

@Configuration
@EnableBatchProcessing
public class BatchCuentasConfiguration {

    private static final Logger log = LoggerFactory.getLogger(BatchCuentasConfiguration.class);

    @Autowired
    public JobBuilderFactory jobBuilderFactory;

    @Autowired
    public StepBuilderFactory stepBuilderFactory;

    @Autowired
    public FileAppender fileAppender;

    @Autowired
    private InputFiles inputFiles;

    @Bean
    public ResourcelessTransactionManager resourcelessTransactionManager() {
        return new ResourcelessTransactionManager();
    }

    @Bean
    public JobRepository jobRepository() throws Exception {
        return new MapJobRepositoryFactoryBean(resourcelessTransactionManager()).getObject();
    }

    @Bean
    public SimpleJobLauncher jobLauncher(JobRepository jobRepository) {
        SimpleJobLauncher simpleJobLauncher = new SimpleJobLauncher();
        simpleJobLauncher.setJobRepository(jobRepository);
        return simpleJobLauncher;
    }

    @Bean
    public FlatFileItemReader<RowCuenta> reader() throws IOException {
        FlatFileItemReader<RowCuenta> reader = new FlatFileItemReader<>();
        String absolutePath = fileAppender.generateAppendedFile(new FileSelector(inputFiles), "output_cuenta").getAbsolutePath();
        reader.setResource(new FileSystemResource(absolutePath));
        reader.setLineMapper(new DefaultLineMapper<RowCuenta>() {{
            setLineTokenizer(new DelimitedLineTokenizer() {{
                setNames(new String[] { "id","fechaInicio","fechaFin","roi","grossBooking","profit","cost"});
            }});
            setFieldSetMapper(new BeanWrapperFieldSetMapper<RowCuenta>() {{
                setTargetType(RowCuenta.class);
            }});
        }});
        return reader;
    }

    @Bean
    public RowCuentaProcessor processor() {
        return new RowCuentaProcessor();
    }

    @Bean
    public ItemWriter<CuentaValorToWrite> writer() throws Exception {
        return new CuentaValorWriter();
    }

    @Bean
    public Job importUserJob() throws Exception{
        return jobBuilderFactory.get("importUserJob")
                .incrementer(new RunIdIncrementer())
                .flow(step1())
                .end()
                .build();
    }

    @Bean
    public Step step1() throws Exception {
        return stepBuilderFactory.get("step1")
                .<RowCuenta, CuentaValorToWrite> chunk(10)
                .reader(reader())
                .processor(processor())
                .writer(writer())
                .build();
    }


    public void perform() throws Exception {

        log.error("Job Started at :" + new Date());

        JobParameters param = new JobParametersBuilder().addString("JobID", String.valueOf(System.currentTimeMillis()))
                .toJobParameters();

        JobExecution execution = jobLauncher(jobRepository()).run(importUserJob(), param);

        log.error("Job finished with status :" + execution.getStatus());
    }

}
