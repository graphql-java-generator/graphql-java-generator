/**
 * 
 */
package com.graphql_java_generator.mavenplugin;

import java.io.File;
import java.util.Map;

import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.plugins.annotations.LifecyclePhase;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import com.graphql_java_generator.plugin.GenerateGraphQLSchema;
import com.graphql_java_generator.plugin.GenerateGraphQLSchemaDocumentParser;
import com.graphql_java_generator.plugin.conf.CommonConfiguration;
import com.graphql_java_generator.plugin.conf.GenerateGraphQLSchemaConfiguration;

import graphql.ThreadSafe;

/**
 * The <I>generateGraphQLSchema</I> goal generates GraphQL schema, based on the source GraphQL schemas.<BR/>
 * It can be used to:
 * <UL>
 * <LI>Generate several GraphQL schema files into one file, for instance with additional schema files that would use the
 * <I>extend</I> GraphQL keyword</LI>
 * <LI>Reformat the schema file</LI>
 * <LI>Generate the GraphQL schema with the Relay Connection stuff (Node interface, XxxEdge and XxxConnection types),
 * thanks to the <I>addRelayConnections</I> plugin parameter.
 * </UL>
 * <BR/>
 * This goal is, by default, attached to the Initialize maven phase, to be sure that the GraphQL schema are generated
 * before the code generation would need it, if relevant.
 * 
 * @author etienne-sf
 */
@Mojo(name = "generateGraphQLSchema", defaultPhase = LifecyclePhase.INITIALIZE)
@ThreadSafe
public class GenerateGraphQLSchemaMojo extends AbstractMojo {

	/**
	 * <P>
	 * True if the plugin is configured to add the relay connection capabilities, as
	 * <A HREF="https://relay.dev/docs/en/graphql-server-specification.html">described here</A> and specified on the
	 * <A HREF="https://relay.dev/graphql/connections.htm">.
	 * </P>
	 * <P>
	 * If set to true, the plugin will add:
	 * </P>
	 * <UL>
	 * <LI>The <I>Node</I> interface in the GraphQL schema (if not already defined). If this interface is already
	 * defined in the given schema, but is not compliant, then an error is thrown.</LI>
	 * <LI>The <I>@RelayConnexion</I> directive definition in the GraphQL schema (if not already defined). If this is
	 * already defined in the given schema, but is not compliant with the relay specification, then an error is
	 * thrown.</LI>
	 * <LI>The <I>Node</I> interface in the GraphQL schema (if not already defined). If this interface is already
	 * defined in the given schema, but is not compliant with the relay specification, then an error is thrown.</LI>
	 * <LI>The <I>PageInfo</I> type in the GraphQL schema (if not already defined). If this type is already defined in
	 * the given schema, but is not compliant with the relay specification, then an error is thrown.</LI>
	 * <LI>All the Edge and Connection type in the GraphQL schema, for each type that is marked by the
	 * <I>@RelayConnexion</I> directive.</LI>
	 * </UL>
	 */
	@Parameter(property = "com.graphql_java_generator.mavenplugin.addRelayConnections", defaultValue = CommonConfiguration.DEFAULT_ADD_RELAY_CONNECTIONS)
	boolean addRelayConnections;

	/**
	 * The main resources folder, typically '/src/main/resources' of the current project. That's where the GraphQL
	 * schema(s) are expected to be: in this folder, or one of these subfolders
	 */
	@Parameter(property = "com.graphql_java_generator.mavenplugin.schemaFileFolder", defaultValue = GenerateGraphQLSchemaConfiguration.DEFAULT_SCHEMA_FILE_FOLDER)
	File schemaFileFolder;

	/**
	 * <P>
	 * The pattern to find the graphql schema file(s). The default value is "/*.graphqls" meaning that the maven plugin
	 * will search all graphqls files in the "/src/main/resources" folder (please check also the <I>schemaFileFolder</I>
	 * plugin parameter).
	 * </P>
	 * <P>
	 * You can put the star (*) joker in the filename, to retrieve several files at ones, for instance
	 * <I>/myschema*.graphqls</I> will retrieve the <I>/src/main/resources/myschema.graphqls</I> and
	 * <I>/src/main/resources/myschema_extend.graphqls</I> files.
	 * <P>
	 */
	@Parameter(property = "com.graphql_java_generator.mavenplugin.schemaFilePattern", defaultValue = GenerateGraphQLSchemaConfiguration.DEFAULT_SCHEMA_FILE_PATTERN)
	String schemaFilePattern;

	/**
	 * <P>
	 * Map of the code templates to be used: this allows to override the default templates, and control exactly what
	 * code is generated by the plugin.
	 * </P>
	 * <P>
	 * You can override any of the Velocity templates of the project. The list of templates is defined in the enum
	 * CodeTemplate, that you can <A HREF=
	 * "https://github.com/graphql-java-generator/graphql-maven-plugin-project/blob/master/graphql-maven-plugin-logic/src/main/java/com/graphql_java_generator/plugin/CodeTemplate.java">check
	 * here</A>.
	 * </P>
	 * <P>
	 * You can find a sample in the <A HREF=
	 * "https://github.com/graphql-java-generator/graphql-maven-plugin-project/blob/master/graphql-maven-plugin-samples/graphql-maven-plugin-samples-CustomTemplates-client/pom.xml">CustomTemplates
	 * client sample</A>.
	 * </P>
	 * <P>
	 * <B>Important notice:</B> Please note that the default templates may change in the future. And some of these
	 * modifications would need to be reported into the custom templates. We'll try to better expose a stable public API
	 * in the future.
	 * </P>
	 */
	@Parameter(property = "com.graphql_java_generator.mavenplugin.templates")
	Map<String, String> templates;

	/** The encoding for the generated resource files */
	@Parameter(property = "com.graphql_java_generator.mavenplugin.resourceEncoding", defaultValue = GenerateGraphQLSchemaConfiguration.DEFAULT_RESOURCE_ENCODING)
	String resourceEncoding;

	/** The folder where the generated GraphQL schema will be stored */
	@Parameter(property = "com.graphql_java_generator.mavenplugin.targetFolder", defaultValue = GenerateGraphQLSchemaConfiguration.DEFAULT_TARGET_FOLDER)
	File targetFolder;

	/**
	 * The name of the target filename, in which the schema is generated. This file is stored in the folder, defined in
	 * the <I>targetFolder</I> plugin parameter.
	 */
	@Parameter(property = "com.graphql_java_generator.mavenplugin.targetSchemaFileName", defaultValue = GenerateGraphQLSchemaConfiguration.DEFAULT_TARGET_SCHEMA_FILE_NAME)
	String targetSchemaFileName;

	@Override
	public void execute() throws MojoExecutionException, MojoFailureException {
		try {
			getLog().debug("Starting generation of java classes from graphqls files");

			// We'll use Spring IoC
			GenerateGraphQLSchemaSpringConfiguration.mojo = this;
			AbstractApplicationContext ctx = new AnnotationConfigApplicationContext(
					GenerateGraphQLSchemaSpringConfiguration.class);

			// Let's log the current configuration (this will do something only when in debug mode)
			ctx.getBean(GenerateGraphQLSchemaConfiguration.class).logConfiguration();

			GenerateGraphQLSchemaDocumentParser documentParser = ctx.getBean(GenerateGraphQLSchemaDocumentParser.class);
			documentParser.parseDocuments();

			GenerateGraphQLSchema generateGraphQLSchema = ctx.getBean(GenerateGraphQLSchema.class);
			generateGraphQLSchema.generateGraphQLSchema();

			ctx.close();

			getLog().debug("Finished generation of the GraphQL schema");

		} catch (Exception e) {
			throw new MojoExecutionException(e.getMessage(), e);
		}
	}

}