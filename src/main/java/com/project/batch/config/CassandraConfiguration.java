//package com.project.batch.config;
//
//import com.project.batch.model.Person;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.PropertySource;
//import org.springframework.core.env.Environment;
//import org.springframework.data.cassandra.config.AbstractCassandraConfiguration;
//import org.springframework.data.cassandra.config.SchemaAction;
//import org.springframework.data.cassandra.core.CassandraTemplate;
//import org.springframework.data.cassandra.repository.config.EnableCassandraRepositories;
//
//import com.datastax.driver.core.policies.DowngradingConsistencyRetryPolicy;
//import com.datastax.driver.core.policies.ExponentialReconnectionPolicy;
//import com.datastax.driver.core.policies.ReconnectionPolicy;
//import com.datastax.driver.core.policies.RetryPolicy;
//
//
//@Configuration
//@PropertySource(value = {"classpath:application.properties"})
//@EnableCassandraRepositories
//public class CassandraConfiguration  extends AbstractCassandraConfiguration {

//
//    private static final Logger LOG = LoggerFactory.getLogger(CassandraConfiguration.class);
//
//
//    @Autowired
//    private Environment propertyEnvironment;
//
//    // Cassandra value : keyspaceName, @Value : spring.data.cassandra -keyspace - contactPoint - port -
//    @Value("${spring.data.cassandra.keyspace-name}")
//    private String keyspaceName;
//
//    @Value("${spring.data.cassandra.contact-points}")
//    private String contactPoints;
//
//    @Value("${spring.data.cassandra.port}")
//    private String port;
//
//
//    @Value("${spring.data.cassandra.schema-action}")
//    private String schemaAction;
//
//    @Override
//    protected String getKeyspaceName() {
//        return keyspaceName;
//    }
//
//    @Override
//    protected String getContactPoints() {
//        return contactPoints;
//    }
//
//    @Override
//    protected int getPort() {
//        return Integer.parseInt(port);
//    }
//
//    @Override
//    public SchemaAction getSchemaAction() {
//        return SchemaAction.valueOf(schemaAction.toUpperCase());
//    }
//
//    @Override
//    public String[] getEntityBasePackages() {
//        return new String[] {Person.class.getPackage().getName()};
//    }
//
//    // Casandra template
//    @Bean(name = "cassandraTemplate")
//    public CassandraTemplate profileCassandraTemplate() throws Exception {
//        final CassandraTemplate cassandraTemplate = new CassandraTemplate(session().getObject(), cassandraConverter());
//        logCassandraTemplateCreation(cassandraTemplate);
//
//        return cassandraTemplate;
//    }
//
//    private static void logCassandraTemplateCreation(final CassandraTemplate cassandraTemplate) {
//    }
//
//
//    @Override
//    protected RetryPolicy getRetryPolicy() {
//        return DowngradingConsistencyRetryPolicy.INSTANCE;
//    }
//
//    @Override
//    protected ReconnectionPolicy getReconnectionPolicy() {
//        return new ExponentialReconnectionPolicy(200L, 5000L);
//    }
//
//
//}
