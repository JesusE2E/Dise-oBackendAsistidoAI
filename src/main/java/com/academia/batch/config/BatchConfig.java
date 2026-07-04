package com.academia.batch.config;

import com.academia.batch.model.Estudiante;
import com.academia.batch.model.EstudianteReporte;
import com.academia.batch.proccessor.EstudianteProcesor;
import com.academia.batch.proccessor.ReporteEstudianteProcessor;
import javax.sql.DataSource;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.database.BeanPropertyItemSqlParameterSourceProvider;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.database.JdbcCursorItemReader;
import org.springframework.batch.item.database.builder.JdbcBatchItemWriterBuilder;
import org.springframework.batch.item.database.builder.JdbcCursorItemReaderBuilder;
import org.springframework.batch.item.data.MongoItemWriter;
import org.springframework.batch.item.data.builder.MongoItemWriterBuilder;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
public class BatchConfig {

    @Bean
    public PlatformTransactionManager transactionManager(DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }
@Bean
@StepScope
public FlatFileItemReader<Estudiante> readerEstudiantes() {
    return new FlatFileItemReaderBuilder<Estudiante>()
            .name("readerEstudiantes")
            .resource(new ClassPathResource("estudiantes.csv"))
            .linesToSkip(1)
            .delimited()
            .delimiter(",")
            .names("nombre", "grupo", "nota1", "nota2", "nota3")
            .targetType(Estudiante.class)
            .build();
}




    @Bean
    public EstudianteProcesor estudianteProcessor() {
        return new EstudianteProcesor();
    }

    @Bean
    public JdbcBatchItemWriter<Estudiante> writerEstudiantes(DataSource dataSource) {
        return new JdbcBatchItemWriterBuilder<Estudiante>()
                .dataSource(dataSource)
                .sql("INSERT INTO estudiantes_procesados (nombre, grupo, nota1, nota2, nota3, promedio) VALUES (:nombre, :grupo, :nota1, :nota2, :nota3, :promedio)")
                .itemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<>())
                .beanMapped()
                .build();
    }


    @Bean
    public Step paso1(JobRepository jobRepository, PlatformTransactionManager transactionManager,
                      FlatFileItemReader<Estudiante> readerEstudiantes,
                      EstudianteProcesor estudianteProcessor,
                      JdbcBatchItemWriter<Estudiante> writerEstudiantes) {
        return new StepBuilder("paso1", jobRepository)
                .<Estudiante, Estudiante>chunk(3, transactionManager)
                .reader(readerEstudiantes)
                .processor(estudianteProcessor)
                .writer(writerEstudiantes)
                .build();
    }



    @Bean
    public JdbcCursorItemReader<Estudiante> readerReporteDesdeMysql(DataSource dataSource) {
        return new JdbcCursorItemReaderBuilder<Estudiante>()
                .name("readerReporteDesdeMysql")
                .dataSource(dataSource)
                .sql("SELECT nombre, grupo, promedio FROM estudiantes_procesados")
                .rowMapper(new BeanPropertyRowMapper<>(Estudiante.class))
                .build();
    }


    @Bean
    public ReporteEstudianteProcessor reporteEstudianteProcessor() {
        return new ReporteEstudianteProcessor();
    }


    @Bean
    public MongoItemWriter<EstudianteReporte> writerReportesMongo(MongoTemplate mongoTemplate) {
        return new MongoItemWriterBuilder<EstudianteReporte>()
                .template(mongoTemplate)
                .collection("reportes_estudiantes")
                .build();
    }



    @Bean
    public Step paso2(JobRepository jobRepository, PlatformTransactionManager transactionManager,
                      JdbcCursorItemReader<Estudiante> readerReporteDesdeMysql,
                      ReporteEstudianteProcessor reporteEstudianteProcessor,
                      MongoItemWriter<EstudianteReporte> writerReportesMongo) {
        return new StepBuilder("paso2", jobRepository)
                .<Estudiante, EstudianteReporte>chunk(3, transactionManager)
                .reader(readerReporteDesdeMysql)
                .processor(reporteEstudianteProcessor)
                .writer(writerReportesMongo)
                .build();
    }



    @Bean
    public Job procesarCalificacionesJob(JobRepository jobRepository, Step paso1, Step paso2) {
        return new JobBuilder("procesarCalificacionesJob", jobRepository)
                .incrementer(new RunIdIncrementer())
                .start(paso1)
                .next(paso2)
                .build();
    }
}
