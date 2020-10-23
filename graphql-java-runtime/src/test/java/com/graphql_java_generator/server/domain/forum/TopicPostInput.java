/** Generated by the default template from graphql-java-generator */
package com.graphql_java_generator.server.domain.forum;

import java.util.Date;

import com.graphql_java_generator.GraphQLField;
import com.graphql_java_generator.annotation.GraphQLInputType;
import com.graphql_java_generator.annotation.GraphQLScalar;

/**
 * @author generated by graphql-java-generator
 * @see <a href=
 *      "https://github.com/graphql-java-generator/graphql-java-generator">https://github.com/graphql-java-generator/graphql-java-generator</a>
 */
@GraphQLInputType("TopicPostInput")
public class TopicPostInput {

	public TopicPostInput() {
		// No action
	}

	@GraphQLScalar(fieldName = "authorId", graphQLTypeName = "ID", list = false, javaClass = String.class)
	String authorId;

	@GraphQLScalar(fieldName = "date", graphQLTypeName = "Date", list = false, javaClass = Date.class)
	Date date;

	@GraphQLScalar(fieldName = "publiclyAvailable", graphQLTypeName = "Boolean", list = false, javaClass = Boolean.class)
	Boolean publiclyAvailable;

	@GraphQLScalar(fieldName = "title", graphQLTypeName = "String", list = false, javaClass = String.class)
	String title;

	@GraphQLScalar(fieldName = "content", graphQLTypeName = "String", list = false, javaClass = String.class)
	String content;

	public void setAuthorId(String authorId) {
		this.authorId = authorId;
	}

	public String getAuthorId() {
		return authorId;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Date getDate() {
		return date;
	}

	public void setPubliclyAvailable(Boolean publiclyAvailable) {
		this.publiclyAvailable = publiclyAvailable;
	}

	public Boolean getPubliclyAvailable() {
		return publiclyAvailable;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getTitle() {
		return title;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getContent() {
		return content;
	}

	@Override
	public String toString() {
		return "TopicPostInput {" + "authorId: " + authorId + ", " + "date: " + date + ", " + "publiclyAvailable: "
				+ publiclyAvailable + ", " + "title: " + title + ", " + "content: " + content + "}";
	}

	/**
	 * Enum of field names
	 */
	public static enum Field implements GraphQLField {
		AuthorId("authorId"), Date("date"), PubliclyAvailable("publiclyAvailable"), Title("title"), Content("content");

		private String fieldName;

		Field(String fieldName) {
			this.fieldName = fieldName;
		}

		@Override
		public String getFieldName() {
			return fieldName;
		}

		@Override
		public Class<?> getGraphQLType() {
			return this.getClass().getDeclaringClass();
		}

	}

	public static Builder builder() {
		return new Builder();
	}

	/**
	 * Builder
	 */
	public static class Builder {
		private String authorId;
		private Date date;
		private Boolean publiclyAvailable;
		private String title;
		private String content;

		public Builder withAuthorId(String authorId) {
			this.authorId = authorId;
			return this;
		}

		public Builder withDate(Date date) {
			this.date = date;
			return this;
		}

		public Builder withPubliclyAvailable(Boolean publiclyAvailable) {
			this.publiclyAvailable = publiclyAvailable;
			return this;
		}

		public Builder withTitle(String title) {
			this.title = title;
			return this;
		}

		public Builder withContent(String content) {
			this.content = content;
			return this;
		}

		public TopicPostInput build() {
			TopicPostInput _object = new TopicPostInput();
			_object.setAuthorId(authorId);
			_object.setDate(date);
			_object.setPubliclyAvailable(publiclyAvailable);
			_object.setTitle(title);
			_object.setContent(content);
			return _object;
		}
	}
}
