/** Generated by the default template from graphql-java-generator */
package com.graphql_java_generator.domain.server.allGraphQLCases;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;

import org.dataloader.BatchLoaderEnvironment;
import org.dataloader.DataLoader;
import org.reactivestreams.Publisher;

import graphql.schema.DataFetchingEnvironment;

import java.util.Date;
import java.util.UUID;

/**
 * @author generated by graphql-java-generator
 * @see <a href="https://github.com/graphql-java-generator/graphql-java-generator">https://github.com/graphql-java-generator/graphql-java-generator</a>
 */
public interface DataFetchersDelegateCommented {
	
 
	/**
	 * This method loads the data for Commented.comments. 
	 * <BR/>
	 * 
	 * @param dataFetchingEnvironment 
	 *     The GraphQL {@link DataFetchingEnvironment}. It gives you access to the full GraphQL context for this DataFetcher
		 * @param origin 
	 *    The object from which the field is fetch. In other word: the aim of this data fetcher is to fetch the comments attribute
	 *    of the <I>origin</I>, which is an instance of {Commented}. It depends on your data modle, but it typically contains 
	 *    the id to use in the query.
			 * @throws NoSuchElementException 
	 *     This method may return a {@link NoSuchElementException} exception. In this case, the exception is trapped 
	 *     by the calling method, and the return is consider as null. This allows to use the {@link Optional#get()} method directly, without caring of 
	 *     whether or not there is a value. The generated code will take care of the {@link NoSuchElementException} exception. 
	 */
	public List<String> comments(DataFetchingEnvironment dataFetchingEnvironment, Commented origin);


}
