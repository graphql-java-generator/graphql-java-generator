/** Generated by the default template from graphql-java-generator */
package com.graphql_java_generator.domain.client.starwars;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.graphql_java_generator.customscalars.CustomScalarRegistryImpl;
import com.graphql_java_generator.client.response.AbstractCustomJacksonDeserializer;
import com.graphql_java_generator.customscalars.GraphQLScalarTypeDate;
import com.graphql_java_generator.exception.GraphQLRequestExecutionException;

import graphql.schema.GraphQLScalarType;

import java.util.List;

/**
 * This class is a standard Deserializer for Jackson. It uses the {@link GraphQLScalarType} that is implemented by the project for this scalar
 */
public class CustomJacksonDeserializers {
	
	public static class List__InputValue extends AbstractCustomJacksonDeserializer<List<__InputValue>> {
		private static final long serialVersionUID = 1L;
		public List__InputValue() {
			super(
				null,
				true,
				__InputValue.class,
				null
			);
		}
	}

	public static class List__Type extends AbstractCustomJacksonDeserializer<List<__Type>> {
		private static final long serialVersionUID = 1L;
		public List__Type() {
			super(
				null,
				true,
				__Type.class,
				null
			);
		}
	}

	public static class List__Directive extends AbstractCustomJacksonDeserializer<List<__Directive>> {
		private static final long serialVersionUID = 1L;
		public List__Directive() {
			super(
				null,
				true,
				__Directive.class,
				null
			);
		}
	}

	public static class List__Field extends AbstractCustomJacksonDeserializer<List<__Field>> {
		private static final long serialVersionUID = 1L;
		public List__Field() {
			super(
				null,
				true,
				__Field.class,
				null
			);
		}
	}

	public static class ListEpisode extends AbstractCustomJacksonDeserializer<List<Episode>> {
		private static final long serialVersionUID = 1L;
		public ListEpisode() {
			super(
				null,
				true,
				Episode.class,
				null
			);
		}
	}

	public static class List__EnumValue extends AbstractCustomJacksonDeserializer<List<__EnumValue>> {
		private static final long serialVersionUID = 1L;
		public List__EnumValue() {
			super(
				null,
				true,
				__EnumValue.class,
				null
			);
		}
	}

	public static class ListCharacter extends AbstractCustomJacksonDeserializer<List<Character>> {
		private static final long serialVersionUID = 1L;
		public ListCharacter() {
			super(
				null,
				true,
				Character.class,
				null
			);
		}
	}

	public static class List__DirectiveLocation extends AbstractCustomJacksonDeserializer<List<__DirectiveLocation>> {
		private static final long serialVersionUID = 1L;
		public List__DirectiveLocation() {
			super(
				null,
				true,
				__DirectiveLocation.class,
				null
			);
		}
	}

}