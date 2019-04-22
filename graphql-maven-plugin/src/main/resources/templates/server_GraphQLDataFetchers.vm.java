package ${package};

import java.util.List;

import javax.annotation.Resource;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

import graphql.schema.DataFetcher;

/**
 * @author generated by graphql-maven-plugin
 * @See https://github.com/graphql-java-generator/graphql-java-generator
 */
@Component
public class GraphQLDataFetchers {

	/** The logger for this instance */
	protected Logger logger = LogManager.getLogger();

#foreach ($dataFetcherDelegate in $dataFetcherDelegates)
	@Resource
	${dataFetcherDelegate.name} ${dataFetcherDelegate.camelCaseName};

#end

#foreach ($dataFetcherDelegate in $dataFetcherDelegates)
	////////////////////////////////////////////////////////////////////////////////////////////////
	// Data fetchers for ${dataFetcherDelegate.name}
	////////////////////////////////////////////////////////////////////////////////////////////////
#foreach ($dataFetcher in $dataFetcherDelegate.dataFetchers)

	public DataFetcher<#if(${dataFetcher.field.list})List<#end${dataFetcher.field.type.classSimpleName}#if(${dataFetcher.field.list})>#end> ${dataFetcher.camelCaseName}() {
		return dataFetchingEnvironment -> {
#foreach ($argument in $dataFetcher.field.inputParameters)
			${argument.type.classSimpleName} ${argument.camelCaseName} = dataFetchingEnvironment.getArgument("${argument.name}");
#end

#if (${dataFetcher.field.list})
			List<${dataFetcher.field.type.classSimpleName}> ret = ${dataFetcherDelegate.camelCaseName}.${dataFetcher.camelCaseName}(#foreach($argument in $dataFetcher.field.inputParameters)${argument.camelCaseName}#if($foreach.hasNext), #end#end);
			logger.debug("${dataFetcher.name}: {} found rows", ret.size());
			return ret;
#else
			${dataFetcher.field.type.classSimpleName} ret = ${dataFetcherDelegate.camelCaseName}.${dataFetcher.camelCaseName}(#foreach($argument in $dataFetcher.field.inputParameters)${argument.camelCaseName}#if($foreach.hasNext), #end#end);
			logger.debug("${dataFetcher.name}: {} found result", (ret==null)?"no":"1");
			return ret;
#end
		};
	}

#end
#end
}