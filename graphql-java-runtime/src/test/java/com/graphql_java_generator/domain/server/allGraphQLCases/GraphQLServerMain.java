/** Generated by the default template from graphql-java-generator */
package com.graphql_java_generator.domain.server.allGraphQLCases;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.Charset;
import java.util.concurrent.CompletableFuture;

import org.dataloader.DataLoader;
import org.dataloader.DataLoaderRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.FilterType;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.context.request.WebRequest;

import com.graphql_java_generator.server.util.BatchLoaderDelegateWithContext;
import com.graphql_java_generator.util.GraphqlUtils;

import graphql.ExecutionInput;
import graphql.ExecutionResult;
import graphql.GraphQL;
import graphql.schema.GraphQLSchema;
import graphql.schema.idl.RuntimeWiring;
import graphql.schema.idl.SchemaGenerator;
import graphql.schema.idl.SchemaParser;
import graphql.schema.idl.TypeDefinitionRegistry;
import graphql.spring.web.servlet.ExecutionInputCustomizer;
import graphql.spring.web.servlet.GraphQLEndpointConfiguration;
import graphql.spring.web.servlet.GraphQLInvocation;
import graphql.spring.web.servlet.GraphQLInvocationData;
import graphql.spring.web.servlet.OnDemandDataLoaderRegistry;
import graphql.spring.web.servlet.components.DefaultGraphQLInvocation;

/**
 * @author generated by graphql-java-generator
 * @see <a href="https://github.com/graphql-java-generator/graphql-java-generator">https://github.com/graphql-java-generator/graphql-java-generator</a>
 */
@SpringBootApplication(excludeName = { "com.graphql_java_generator.spring.client.GraphQLAutoConfiguration",
		"graphql.spring.web.servlet.GraphQLEndpointConfiguration" })
@ComponentScan(basePackages = { "org.graphql.mavenplugin.junittest.allgraphqlcases_server_springconfiguration", "com.graphql_java_generator.server",
		"com.graphql_java_generator.util", "graphql.spring.web.servlet.components" }, 
	excludeFilters = {
		@ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, value = GraphQLEndpointConfiguration.class)
		})
@EnableJpaRepositories(basePackages = { "org.graphql.mavenplugin.junittest.allgraphqlcases_server_springconfiguration", "com.graphql_java_generator"  })
@EntityScan(basePackages = { "org.graphql.mavenplugin.junittest.allgraphqlcases_server_springconfiguration", "com.graphql_java_generator"  })
@EnableConfigurationProperties
public class GraphQLServerMain {

	@Autowired
	protected ApplicationContext applicationContext;

	@Autowired
	protected GraphQLWiring graphQLWiring;


	public static void main(String[] args) {
		SpringApplication.run(GraphQLServerMain.class, args);
	}
	
	@Bean
	protected GraphQLSchema graphQLSchema() throws IOException {
		Resource res;
		StringBuffer sdl = new StringBuffer();
		res = new ClassPathResource("/allGraphQLCases.graphqls");
		try(Reader reader = new InputStreamReader(res.getInputStream(), Charset.forName("UTF8"))) {
			sdl.append(FileCopyUtils.copyToString(reader));
		}
		res = new ClassPathResource("/allGraphQLCases_extends.graphqls");
		try(Reader reader = new InputStreamReader(res.getInputStream(), Charset.forName("UTF8"))) {
			sdl.append(FileCopyUtils.copyToString(reader));
		}
	
		TypeDefinitionRegistry typeRegistry = new SchemaParser().parse(sdl.toString());
	
		RuntimeWiring runtimeWiring = graphQLWiring.buildWiring();
		SchemaGenerator schemaGenerator = new SchemaGenerator();
		return schemaGenerator.makeExecutableSchema(typeRegistry, runtimeWiring);
	}
	
	@Bean
	public GraphQL graphQL(GraphQLSchema graphQLSchema) throws IOException {
		return GraphQL.newGraphQL(graphQLSchema).build();
	}
	
	@Bean
	protected OnDemandDataLoaderRegistry onDemandDataLoaderRegistry() {
		return new OnDemandDataLoaderRegistry() {
			@Override
			public DataLoaderRegistry getNewDataLoaderRegistry() {
				DataLoaderRegistry registry = new DataLoaderRegistry();
				DataLoader<Object, Object> dl;
	
				for (BatchLoaderDelegateWithContext<?, ?> batchLoaderDelegate : applicationContext
						.getBeansOfType(BatchLoaderDelegateWithContext.class).values()) {
					registry.register(batchLoaderDelegate.getName(), DataLoader.newDataLoader(batchLoaderDelegate));
				} // for
	
				return registry;
			}
		};
	}
}
