/**
 * 
 */
package com.graphql_java_generator.client.domain.forum;

import com.graphql_java_generator.client.request.InputParameter;
import com.graphql_java_generator.client.request.ObjectResponse;
import com.graphql_java_generator.client.request.QueryField;
import com.graphql_java_generator.client.request.RequestType;
import com.graphql_java_generator.exception.GraphQLRequestPreparationException;

/**
 * @author etienne-sf
 *
 */
public class GraphQLRequest extends ObjectResponse {

	/** {@inheritDoc} */
	public GraphQLRequest(String graphQLRequest) throws GraphQLRequestPreparationException {
		super(graphQLRequest);
	}

	/** {@inheritDoc} */
	public GraphQLRequest(String graphQLRequest, RequestType requestType, String queryName,
			InputParameter... inputParams) throws GraphQLRequestPreparationException {
		super(graphQLRequest, requestType, queryName, inputParams);
	}

	@Override
	public QueryField getQueryContext() throws GraphQLRequestPreparationException {
		return new QueryField(QueryTypeRootResponse.class, "query");
	}

	@Override
	public QueryField getMutationContext() throws GraphQLRequestPreparationException {
		return new QueryField(MutationTypeRootResponse.class, "mutation");
	}

	@Override
	public QueryField getSubscriptionContext() throws GraphQLRequestPreparationException {
		throw new GraphQLRequestPreparationException("Subscriptions are not managed yet");
	}

}