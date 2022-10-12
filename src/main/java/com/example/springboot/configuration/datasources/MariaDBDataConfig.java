package com.example.springboot.configuration.datasources;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

@Configuration
@MapperScan(
        basePackages = {"com.example.springboot.dao.comp", "com.example.springboot.dao.sadelite"},        // Java interfaces with @Mapper
        sqlSessionTemplateRef = "MyBatisFirstSessionTemplate") // Template used
public class MariaDBDataConfig {

    // We are going to use annotation based queries, so that means no XML needed for this DataSource
    // Location of XML mappers
    //static final String MAPPER_LOCATION = "classpath:mybatis/mappers/**/*.xml";

    @Bean(name = "MyBatisFirstDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.mybatis.mariadb")
    public DataSource MyBatisFirstDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "MyBatisFirstSessionFactory")
    public SqlSessionFactory MyBatisFirstSessionFactory(@Qualifier("MyBatisFirstDataSource") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource);
        return sqlSessionFactoryBean.getObject();
    }

    @Bean(name = "MyBatisFirstTransactionManager")
    public DataSourceTransactionManager MyBatisFirstTransactionManager(@Qualifier("MyBatisFirstDataSource") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean(name = "MyBatisFirstSessionTemplate")
    public SqlSessionTemplate MyBatisFirstSessionTemplate(@Qualifier("MyBatisFirstSessionFactory") SqlSessionFactory sqlSessionFactory) {
        return new SqlSessionTemplate(sqlSessionFactory);
    }
}
