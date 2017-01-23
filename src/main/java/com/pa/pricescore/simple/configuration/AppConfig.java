package com.pa.pricescore.simple.configuration;

import com.mongodb.MongoClient;
import org.apache.catalina.filters.CorsFilter;
import org.springframework.boot.context.embedded.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;

import static org.apache.catalina.filters.CorsFilter.PARAM_CORS_ALLOWED_HEADERS;
import static org.apache.catalina.filters.CorsFilter.PARAM_CORS_ALLOWED_METHODS;
import static org.elasticsearch.node.NodeBuilder.nodeBuilder;


/**
 * Created by Jek on 03.07.16.
 */
@Configuration
@EnableElasticsearchRepositories(basePackages = "org/springframework/data/elasticsearch/repositories")
public class AppConfig
{
    @Bean
    public MongoDbFactory mongoDbFactory() throws Exception {
        return new SimpleMongoDbFactory(new MongoClient(), "pricedb");
    }

    @Bean
    public MongoTemplate mongoTemplate() throws Exception {

        return new MongoTemplate(mongoDbFactory());

    }

    @Bean
    public FilterRegistrationBean corsFilterRegistrationBean() {
        final FilterRegistrationBean frb = new FilterRegistrationBean(new CorsFilter());
        frb.addInitParameter(PARAM_CORS_ALLOWED_HEADERS, "Origin,Accept,X-Requested-With,Content-Type,Access-Control-Request-Method,Access-Control-Request-Headers,Authorization");
        frb.addInitParameter(PARAM_CORS_ALLOWED_METHODS, "GET,POST,PUT,DELETE,HEAD,OPTIONS");

        return frb;
    }

    @Bean
    public ElasticsearchOperations elasticsearchTemplate() {
        return new ElasticsearchTemplate(nodeBuilder().local(true).node().client());
    }


}
