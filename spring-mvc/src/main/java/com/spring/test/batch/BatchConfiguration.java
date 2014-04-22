package com.spring.test.batch;

import org.hibernate.SessionFactory;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.database.HibernateItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.orm.hibernate3.HibernateOperations;

import com.spring.test.hibernate.model.BoardUser;

@Configuration
@EnableBatchProcessing
public class BatchConfiguration {
	@Autowired
	HibernateOperations hibernateTemplate;

	// tag::readerwriterprocessor[]
	@Bean
	public ItemReader<BoardUser> reader() {
		FlatFileItemReader<BoardUser> reader = new FlatFileItemReader<BoardUser>();
		reader.setResource(new ClassPathResource("sample-data.csv"));
		reader.setLineMapper(new DefaultLineMapper<BoardUser>() {
			{
				setLineTokenizer(new DelimitedLineTokenizer() {
					{
						setNames(new String[] { "id", "passwd", "userName",
								"age", "role" });
					}
				});
				setFieldSetMapper(new BeanWrapperFieldSetMapper<BoardUser>() {
					{
						setTargetType(BoardUser.class);
					}
				});
			}
		});
		return reader;
	}

	@Bean
	public ItemProcessor<BoardUser, BoardUser> processor() {
		return new BoardUserItemProcessor();
	}

	@Bean
	public ItemWriter<BoardUser> writer() {
		HibernateItemWriter<BoardUser> writer = new HibernateItemWriter<BoardUser>();
		writer.setHibernateTemplate(hibernateTemplate);

		return writer;
	}

	// end::readerwriterprocessor[]

	// tag::jobstep[]
	@Bean
	public Job importUserJob(JobBuilderFactory jobs, Step s1) {
		return jobs.get("importUserJob").incrementer(new RunIdIncrementer())
				.flow(s1).end().build();
	}

	@Bean
	public Step step1(StepBuilderFactory stepBuilderFactory,
			ItemReader<BoardUser> reader, ItemWriter<BoardUser> writer,
			ItemProcessor<BoardUser, BoardUser> processor) {
		return stepBuilderFactory.get("step1").<BoardUser, BoardUser> chunk(10)
				.reader(reader).processor(processor).writer(writer).build();
	}
	// end::jobstep[]
}
