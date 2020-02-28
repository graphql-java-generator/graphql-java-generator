package com.graphql_java_generator.client.domain.allGraphQLCases;


import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import javax.ws.rs.client.Client;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.fasterxml.jackson.databind.ObjectMapper;

import com.graphql_java_generator.annotation.GraphQLNonScalar;
import com.graphql_java_generator.annotation.GraphQLQuery;
import com.graphql_java_generator.client.GraphqlClientUtils;
import com.graphql_java_generator.client.QueryExecutor;
import com.graphql_java_generator.client.QueryExecutorImpl;
import com.graphql_java_generator.client.request.Builder;
import com.graphql_java_generator.client.request.InputParameter;
import com.graphql_java_generator.client.request.ObjectResponse;
import com.graphql_java_generator.exception.GraphQLRequestExecutionException;
import com.graphql_java_generator.exception.GraphQLRequestPreparationException;

import java.util.Date;

/**
 * @author generated by graphql-java-generator
 * @see <a href="https://github.com/graphql-java-generator/graphql-java-generator">https://github.com/graphql-java-generator/graphql-java-generator</a>
 */
public class AnotherMutationType {

	/** Logger for this class */
	private static Logger logger = LogManager.getLogger();

	final GraphqlClientUtils graphqlClientUtils = new GraphqlClientUtils();

	final QueryExecutor executor;

	/**
	 * This constructor expects the URI of the GraphQL server. This constructor works only for http servers, not for
	 * https ones.<BR/>
	 * For example: http://my.server.com/graphql
	 * 
	 * @param graphqlEndpoint
	 *            the http URI for the GraphQL endpoint
	 */
	public AnotherMutationType(String graphqlEndpoint) {
		this.executor = new QueryExecutorImpl(graphqlEndpoint);
		new CustomScalarRegistryInitializer().initCustomScalarRegistry();
	}

	/**
	 * This constructor expects the URI of the GraphQL server. This constructor works only for https servers, not for
	 * http ones.<BR/>
	 * For example: https://my.server.com/graphql<BR/><BR/>
	 * {@link SSLContext} and {@link HostnameVerifier} are regular Java stuff. You'll find lots of documentation on the web. 
	 * The StarWars sample is based on the <A HREF="http://www.thinkcode.se/blog/2019/01/27/a-jersey-client-supporting-https">http://www.thinkcode.se/blog/2019/01/27/a-jersey-client-supporting-https</A> blog.
	 * But this sample implements a noHostVerification, which of course, is the simplest but the safest way to go.
	 * 
	 * @param graphqlEndpoint
	 *            the https URI for the GraphQL endpoint
	 * @param sslContext
	 * @param hostnameVerifier
	 */
	public AnotherMutationType(String graphqlEndpoint, SSLContext sslContext, HostnameVerifier hostnameVerifier) {
		this.executor = new QueryExecutorImpl(graphqlEndpoint, sslContext, hostnameVerifier);
	}

	/**
	 * This constructor expects the URI of the GraphQL server and a configured JAX-RS client
	 * that gives the opportunity to customise the REST request<BR/>
	 * For example: http://my.server.com/graphql
	 *
	 * @param graphqlEndpoint
	 *            the http URI for the GraphQL endpoint
	 * @param client
	 *            {@link Client} javax.ws.rs.client.Client to support customization of the rest request
	 * @param objectMapper
	 *            {@link ObjectMapper} com.fasterxml.jackson.databind.ObjectMapper to support configurable mapping
	 */
	public AnotherMutationType(String graphqlEndpoint, Client client, ObjectMapper objectMapper) {
		this.executor = new QueryExecutorImpl(graphqlEndpoint, client, objectMapper);
		new CustomScalarRegistryInitializer().initCustomScalarRegistry();
	}

	/**
	 * This method is expected by the graphql-java framework. It will be called when this query is called. It offers a
	 * logging of the call (if in debug mode), or of the call and its parameters (if in trace mode).<BR/>
	 * This method takes care of writting the query name, and the parameter(s) for the query. The given queryResponseDef
	 * describes the format of the response of the server response, that is the expected fields of the {@link Human}
	 * GraphQL type. It can be something like "{ id name }", if you want these fields of this type. Please take a look at
	 * the StarWars, Forum and other samples for more complex queries.<BR/>
	 * This method is valid for queries/mutations/subscriptions which don't have bind variables, as there is no 
	 * <I>parameters</I> argument to pass the list of values.
	 * 
	 * @param queryResponseDef
	 *            The response definition of the query, in the native GraphQL format (see here above)
	 * @param human Parameter for the createHuman field of AnotherMutationType, as defined in the GraphQL schema
	 * @throws IOException
	 * @throws GraphQLRequestPreparationException
	 *             When an error occurs during the request preparation, typically when building the
	 *             {@link ObjectResponse}
	 * @throws GraphQLRequestExecutionException
	 *             When an error occurs during the request execution, typically a network error, an error from the
	 *             GraphQL server or if the server response can't be parsed
	 */
	@GraphQLNonScalar(graphQLTypeName = "Human", javaClass = Human.class)
	@GraphQLQuery
	public Human createHuman(String queryResponseDef, HumanInput human)
			throws GraphQLRequestExecutionException, GraphQLRequestPreparationException {
		logger.debug("Executing of query 'createHuman' in query mode: {} ", queryResponseDef);
		ObjectResponse objectResponse = getCreateHumanResponseBuilder().withQueryResponseDef(queryResponseDef).build();
		return createHumanWithBindValues(objectResponse, human, null);
	}

	/**
	 * This method is expected by the graphql-java framework. It will be called when this query is called. It offers a
	 * logging of the call (if in debug mode), or of the call and its parameters (if in trace mode).<BR/>
	 * This method takes care of writting the query name, and the parameter(s) for the query. The given queryResponseDef
	 * describes the format of the response of the server response, that is the expected fields of the {@link Human}
	 * GraphQL type. It can be something like "{ id name }", if you want these fields of this type. Please take a look at
	 * the StarWars, Forum and other samples for more complex queries.
	 * 
	 * @param queryResponseDef
	 *            The response definition of the query, in the native GraphQL format (see here above)
	 * @param human Parameter for the createHuman field of AnotherMutationType, as defined in the GraphQL schema
	 * @param parameters
	 *            The list of values, for the bind variables defined in the query. If there is no bind variable in the
	 *            defined Query, this argument may be null or an empty {@link Map}
	 * @throws IOException
	 * @throws GraphQLRequestPreparationException
	 *             When an error occurs during the request preparation, typically when building the
	 *             {@link ObjectResponse}
	 * @throws GraphQLRequestExecutionException
	 *             When an error occurs during the request execution, typically a network error, an error from the
	 *             GraphQL server or if the server response can't be parsed
	 */
	@GraphQLNonScalar(graphQLTypeName = "Human", javaClass = Human.class)
	@GraphQLQuery
	public Human createHumanWithBindValues(String queryResponseDef, HumanInput human, Map<String, Object> parameters)
			throws GraphQLRequestExecutionException, GraphQLRequestPreparationException {
		logger.debug("Executing of query 'createHuman' in query mode: {} ", queryResponseDef);
		ObjectResponse objectResponse = getCreateHumanResponseBuilder().withQueryResponseDef(queryResponseDef).build();
		return createHuman(objectResponse, human, parameters);
	}


	/**
	 * This method is expected by the graphql-java framework. It will be called when this query is called. It offers a
	 * logging of the call (if in debug mode), or of the call and its parameters (if in trace mode).<BR/>
	 * This method is valid for queries/mutations/subscriptions which don't have bind variables, as there is no 
	 * <I>parameters</I> argument to pass the list of values.  
	 * 
	 * @param objectResponse
	 *            The definition of the response format, that describes what the GraphQL server is expected to return
	 * @param human Parameter for the createHuman field of AnotherMutationType, as defined in the GraphQL schema
	 * @throws IOException
	 * @throws GraphQLRequestExecutionException
	 *             When an error occurs during the request execution, typically a network error, an error from the
	 *             GraphQL server or if the server response can't be parsed
	 */
	@GraphQLNonScalar(graphQLTypeName = "Human", javaClass = Human.class)
	@GraphQLQuery
	public Human createHuman(ObjectResponse objectResponse, HumanInput human)
			throws GraphQLRequestExecutionException  {
		return createHumanWithBindValues(objectResponse, human, null);
	}

	/**
	 * This method is expected by the graphql-java framework. It will be called when this query is called. It offers a
	 * logging of the call (if in debug mode), or of the call and its parameters (if in trace mode).
	 * 
	 * @param objectResponse
	 *            The definition of the response format, that describes what the GraphQL server is expected to return
	 * @param human Parameter for the createHuman field of AnotherMutationType, as defined in the GraphQL schema
	 * @param parameters
	 *            The list of values, for the bind variables defined in the query. If there is no bind variable in the
	 *            defined Query, this argument may be null or an empty {@link Map}
	 * @throws IOException
	 * @throws GraphQLRequestExecutionException
	 *             When an error occurs during the request execution, typically a network error, an error from the
	 *             GraphQL server or if the server response can't be parsed
	 */
	@GraphQLNonScalar(graphQLTypeName = "Human", javaClass = Human.class)
	@GraphQLQuery
	public Human createHumanWithBindValues(ObjectResponse objectResponse, HumanInput human, Map<String, Object> parameters)
			throws GraphQLRequestExecutionException  {
		if (logger.isTraceEnabled()) {
			logger.trace("Executing of mutation 'createHuman' with parameters: {} ", human);
		} else if (logger.isDebugEnabled()) {
			logger.debug("Executing of mutation 'createHuman'");
		}
	
		// Given values for the BindVariables
		parameters = (parameters != null) ? parameters : new HashMap<>();
		parameters.put("anotherMutationTypeCreateHumanHuman", human);

		if (!Human.class.equals(objectResponse.getFieldClass())) {
			throw new GraphQLRequestExecutionException("The ObjectResponse parameter should be an instance of "
					+ Human.class + ", but is an instance of " + objectResponse.getClass().getName());
		}

		AnotherMutationTypeCreateHuman ret = executor.execute("mutation", objectResponse, parameters, AnotherMutationTypeCreateHuman.class);
		
		return ret.createHuman;
	}

	/**
	 * This method is expected by the graphql-java framework. It will be called when this query is called. It offers a
	 * logging of the call (if in debug mode), or of the call and its parameters (if in trace mode).
	 * 
	 * @param objectResponse
	 *            The definition of the response format, that describes what the GraphQL server is expected to return
	 * @param human Parameter for the createHuman field of AnotherMutationType, as defined in the GraphQL schema
	 * @param paramsAndValues
	 *            This parameter contains all the name and values for the Bind Variables defined in the objectResponse
	 *            parameter, that must be sent to the server. Optional parameter may not have a value. They will be
	 *            ignored and not sent to the server. Mandatory parameter must be provided in this argument.<BR/>
	 *            This parameter contains an even number of parameters: it must be a series of name and values :
	 *            (paramName1, paramValue1, paramName2, paramValue2...)
	 * @throws IOException
	 * @throws GraphQLRequestExecutionException
	 *             When an error occurs during the request execution, typically a network error, an error from the
	 *             GraphQL server or if the server response can't be parsed
	 */
	@GraphQLNonScalar(graphQLTypeName = "Human", javaClass = Human.class)
	@GraphQLQuery
	public Human createHuman(ObjectResponse objectResponse, HumanInput human, Object... paramsAndValues)
			throws GraphQLRequestExecutionException  {
		if (logger.isTraceEnabled()) {
			StringBuffer sb = new StringBuffer();
			sb.append("Executing of query 'createHuman' with bind variables: ");
			boolean addComma = false;
			for (Object o : paramsAndValues) {
				if (o != null) {
					sb.append(o.toString());
					if (addComma)
						sb.append(", ");
					addComma = true;
				}
			}
			logger.trace(sb.toString());
		} else if (logger.isDebugEnabled()) {
			logger.debug("Executing of query 'createHuman' (with bind variables)");
		}

		if (!Human.class.equals(objectResponse.getFieldClass())) {
			throw new GraphQLRequestExecutionException("The ObjectResponse parameter should be an instance of "
					+ Human.class + ", but is an instance of " + objectResponse.getClass().getName());
		}

		Map<String, Object> bindVariableValues = graphqlClientUtils.generatesBindVariableValuesMap(paramsAndValues);
		bindVariableValues.put("anotherMutationTypeCreateHumanHuman", human);
		
		AnotherMutationTypeCreateHuman ret = executor.execute("mutation", objectResponse, bindVariableValues, AnotherMutationTypeCreateHuman.class);
		
		return ret.createHuman;
	}

	/**
	 * Get the {@link ObjectResponse.Builder} for the Human, as expected by the createHuman query.
	 * 
	 * @return
	 * @throws GraphQLRequestPreparationException
	 */
	public Builder getCreateHumanResponseBuilder() throws GraphQLRequestPreparationException {
		Builder builder = new Builder(getClass(), "createHuman");
		builder.withInputParameter(InputParameter.newBindParameter("human","anotherMutationTypeCreateHumanHuman", false, null));
		return builder;
	}
	
	/**
	 * This method is expected by the graphql-java framework. It will be called when this query is called. It offers a
	 * logging of the call (if in debug mode), or of the call and its parameters (if in trace mode).<BR/>
	 * This method takes care of writting the query name, and the parameter(s) for the query. The given queryResponseDef
	 * describes the format of the response of the server response, that is the expected fields of the {@link AllFieldCases}
	 * GraphQL type. It can be something like "{ id name }", if you want these fields of this type. Please take a look at
	 * the StarWars, Forum and other samples for more complex queries.<BR/>
	 * This method is valid for queries/mutations/subscriptions which don't have bind variables, as there is no 
	 * <I>parameters</I> argument to pass the list of values.
	 * 
	 * @param queryResponseDef
	 *            The response definition of the query, in the native GraphQL format (see here above)
	 * @param input Parameter for the createAllFieldCases field of AnotherMutationType, as defined in the GraphQL schema
	 * @throws IOException
	 * @throws GraphQLRequestPreparationException
	 *             When an error occurs during the request preparation, typically when building the
	 *             {@link ObjectResponse}
	 * @throws GraphQLRequestExecutionException
	 *             When an error occurs during the request execution, typically a network error, an error from the
	 *             GraphQL server or if the server response can't be parsed
	 */
	@GraphQLNonScalar(graphQLTypeName = "AllFieldCases", javaClass = AllFieldCases.class)
	@GraphQLQuery
	public AllFieldCases createAllFieldCases(String queryResponseDef, AllFieldCasesInput input)
			throws GraphQLRequestExecutionException, GraphQLRequestPreparationException {
		logger.debug("Executing of query 'createAllFieldCases' in query mode: {} ", queryResponseDef);
		ObjectResponse objectResponse = getCreateAllFieldCasesResponseBuilder().withQueryResponseDef(queryResponseDef).build();
		return createAllFieldCasesWithBindValues(objectResponse, input, null);
	}

	/**
	 * This method is expected by the graphql-java framework. It will be called when this query is called. It offers a
	 * logging of the call (if in debug mode), or of the call and its parameters (if in trace mode).<BR/>
	 * This method takes care of writting the query name, and the parameter(s) for the query. The given queryResponseDef
	 * describes the format of the response of the server response, that is the expected fields of the {@link AllFieldCases}
	 * GraphQL type. It can be something like "{ id name }", if you want these fields of this type. Please take a look at
	 * the StarWars, Forum and other samples for more complex queries.
	 * 
	 * @param queryResponseDef
	 *            The response definition of the query, in the native GraphQL format (see here above)
	 * @param input Parameter for the createAllFieldCases field of AnotherMutationType, as defined in the GraphQL schema
	 * @param parameters
	 *            The list of values, for the bind variables defined in the query. If there is no bind variable in the
	 *            defined Query, this argument may be null or an empty {@link Map}
	 * @throws IOException
	 * @throws GraphQLRequestPreparationException
	 *             When an error occurs during the request preparation, typically when building the
	 *             {@link ObjectResponse}
	 * @throws GraphQLRequestExecutionException
	 *             When an error occurs during the request execution, typically a network error, an error from the
	 *             GraphQL server or if the server response can't be parsed
	 */
	@GraphQLNonScalar(graphQLTypeName = "AllFieldCases", javaClass = AllFieldCases.class)
	@GraphQLQuery
	public AllFieldCases createAllFieldCasesWithBindValues(String queryResponseDef, AllFieldCasesInput input, Map<String, Object> parameters)
			throws GraphQLRequestExecutionException, GraphQLRequestPreparationException {
		logger.debug("Executing of query 'createAllFieldCases' in query mode: {} ", queryResponseDef);
		ObjectResponse objectResponse = getCreateAllFieldCasesResponseBuilder().withQueryResponseDef(queryResponseDef).build();
		return createAllFieldCases(objectResponse, input, parameters);
	}


	/**
	 * This method is expected by the graphql-java framework. It will be called when this query is called. It offers a
	 * logging of the call (if in debug mode), or of the call and its parameters (if in trace mode).<BR/>
	 * This method is valid for queries/mutations/subscriptions which don't have bind variables, as there is no 
	 * <I>parameters</I> argument to pass the list of values.  
	 * 
	 * @param objectResponse
	 *            The definition of the response format, that describes what the GraphQL server is expected to return
	 * @param input Parameter for the createAllFieldCases field of AnotherMutationType, as defined in the GraphQL schema
	 * @throws IOException
	 * @throws GraphQLRequestExecutionException
	 *             When an error occurs during the request execution, typically a network error, an error from the
	 *             GraphQL server or if the server response can't be parsed
	 */
	@GraphQLNonScalar(graphQLTypeName = "AllFieldCases", javaClass = AllFieldCases.class)
	@GraphQLQuery
	public AllFieldCases createAllFieldCases(ObjectResponse objectResponse, AllFieldCasesInput input)
			throws GraphQLRequestExecutionException  {
		return createAllFieldCasesWithBindValues(objectResponse, input, null);
	}

	/**
	 * This method is expected by the graphql-java framework. It will be called when this query is called. It offers a
	 * logging of the call (if in debug mode), or of the call and its parameters (if in trace mode).
	 * 
	 * @param objectResponse
	 *            The definition of the response format, that describes what the GraphQL server is expected to return
	 * @param input Parameter for the createAllFieldCases field of AnotherMutationType, as defined in the GraphQL schema
	 * @param parameters
	 *            The list of values, for the bind variables defined in the query. If there is no bind variable in the
	 *            defined Query, this argument may be null or an empty {@link Map}
	 * @throws IOException
	 * @throws GraphQLRequestExecutionException
	 *             When an error occurs during the request execution, typically a network error, an error from the
	 *             GraphQL server or if the server response can't be parsed
	 */
	@GraphQLNonScalar(graphQLTypeName = "AllFieldCases", javaClass = AllFieldCases.class)
	@GraphQLQuery
	public AllFieldCases createAllFieldCasesWithBindValues(ObjectResponse objectResponse, AllFieldCasesInput input, Map<String, Object> parameters)
			throws GraphQLRequestExecutionException  {
		if (logger.isTraceEnabled()) {
			logger.trace("Executing of mutation 'createAllFieldCases' with parameters: {} ", input);
		} else if (logger.isDebugEnabled()) {
			logger.debug("Executing of mutation 'createAllFieldCases'");
		}
	
		// Given values for the BindVariables
		parameters = (parameters != null) ? parameters : new HashMap<>();
		parameters.put("anotherMutationTypeCreateAllFieldCasesInput", input);

		if (!AllFieldCases.class.equals(objectResponse.getFieldClass())) {
			throw new GraphQLRequestExecutionException("The ObjectResponse parameter should be an instance of "
					+ AllFieldCases.class + ", but is an instance of " + objectResponse.getClass().getName());
		}

		AnotherMutationTypeCreateAllFieldCases ret = executor.execute("mutation", objectResponse, parameters, AnotherMutationTypeCreateAllFieldCases.class);
		
		return ret.createAllFieldCases;
	}

	/**
	 * This method is expected by the graphql-java framework. It will be called when this query is called. It offers a
	 * logging of the call (if in debug mode), or of the call and its parameters (if in trace mode).
	 * 
	 * @param objectResponse
	 *            The definition of the response format, that describes what the GraphQL server is expected to return
	 * @param input Parameter for the createAllFieldCases field of AnotherMutationType, as defined in the GraphQL schema
	 * @param paramsAndValues
	 *            This parameter contains all the name and values for the Bind Variables defined in the objectResponse
	 *            parameter, that must be sent to the server. Optional parameter may not have a value. They will be
	 *            ignored and not sent to the server. Mandatory parameter must be provided in this argument.<BR/>
	 *            This parameter contains an even number of parameters: it must be a series of name and values :
	 *            (paramName1, paramValue1, paramName2, paramValue2...)
	 * @throws IOException
	 * @throws GraphQLRequestExecutionException
	 *             When an error occurs during the request execution, typically a network error, an error from the
	 *             GraphQL server or if the server response can't be parsed
	 */
	@GraphQLNonScalar(graphQLTypeName = "AllFieldCases", javaClass = AllFieldCases.class)
	@GraphQLQuery
	public AllFieldCases createAllFieldCases(ObjectResponse objectResponse, AllFieldCasesInput input, Object... paramsAndValues)
			throws GraphQLRequestExecutionException  {
		if (logger.isTraceEnabled()) {
			StringBuffer sb = new StringBuffer();
			sb.append("Executing of query 'createAllFieldCases' with bind variables: ");
			boolean addComma = false;
			for (Object o : paramsAndValues) {
				if (o != null) {
					sb.append(o.toString());
					if (addComma)
						sb.append(", ");
					addComma = true;
				}
			}
			logger.trace(sb.toString());
		} else if (logger.isDebugEnabled()) {
			logger.debug("Executing of query 'createAllFieldCases' (with bind variables)");
		}

		if (!AllFieldCases.class.equals(objectResponse.getFieldClass())) {
			throw new GraphQLRequestExecutionException("The ObjectResponse parameter should be an instance of "
					+ AllFieldCases.class + ", but is an instance of " + objectResponse.getClass().getName());
		}

		Map<String, Object> bindVariableValues = graphqlClientUtils.generatesBindVariableValuesMap(paramsAndValues);
		bindVariableValues.put("anotherMutationTypeCreateAllFieldCasesInput", input);
		
		AnotherMutationTypeCreateAllFieldCases ret = executor.execute("mutation", objectResponse, bindVariableValues, AnotherMutationTypeCreateAllFieldCases.class);
		
		return ret.createAllFieldCases;
	}

	/**
	 * Get the {@link ObjectResponse.Builder} for the AllFieldCases, as expected by the createAllFieldCases query.
	 * 
	 * @return
	 * @throws GraphQLRequestPreparationException
	 */
	public Builder getCreateAllFieldCasesResponseBuilder() throws GraphQLRequestPreparationException {
		Builder builder = new Builder(getClass(), "createAllFieldCases");
		builder.withInputParameter(InputParameter.newBindParameter("input","anotherMutationTypeCreateAllFieldCasesInput", false, null));
		return builder;
	}
	
}