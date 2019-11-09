package com.androidcommand.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.cassandra.config.AbstractCassandraConfiguration;
import org.springframework.data.cassandra.config.CassandraClusterFactoryBean;
import org.springframework.data.cassandra.config.SchemaAction;
import org.springframework.data.cassandra.core.mapping.BasicCassandraMappingContext;
import org.springframework.data.cassandra.core.mapping.CassandraMappingContext;
import org.springframework.data.cassandra.repository.config.EnableCassandraRepositories;

import com.datastax.driver.core.PlainTextAuthProvider;

import freemarker.core.Environment;

/* The magic to this class is all provided by AbstractCassandraConfiguration and the @EnableCassandraRepositories annotation. The only method that 100% needs to be implemented is getKeyspaceName. */

@Configuration
@EnableCassandraRepositories("com.androidcommand.app")
@PropertySource("classpath:/home/server/eclipse-workspace/springrbs/src/main/resources/application.properties")
public class CassandraConfig extends AbstractCassandraConfiguration {
	
	@Autowired
	private Environment env;

	
    @Value("${cassandra.keyspace}")
    private String keySpace; 
    
    @Override
    protected String getKeyspaceName() {
        return "rant";
    }
 
    @Value("${cassandra.basePackages}")
    private String basePackages;
    
    @Override
    public String[] getEntityBasePackages() {
      return new String[] {basePackages};
    }
    
    @Bean
    public CassandraClusterFactoryBean cluster() {
        CassandraClusterFactoryBean cluster = 
          new CassandraClusterFactoryBean();
        PlainTextAuthProvider sap = new PlainTextAuthProvider("cassandra","cassandra");
        System.out.println("CassandraConfiguration: sap " + sap.toString());
//        PlainTextAuthProvider sap = new PlainTextAuthProvider(env. ,env.    );
        cluster.setAuthProvider(sap);
        cluster.setContactPoints("192.168.1.5");
        cluster.setPort(9142);
//        cluster.setContactPoints(env.getProperty("cassandra.contactpoints"));
//        cluster.setPort(Integer.parseInt(env.getProperty("cassandra.port")));

        return cluster;
    }
 
    @Bean
    public CassandraMappingContext cassandraMapping() 
      throws ClassNotFoundException {
        return new BasicCassandraMappingContext();
    }
    
/*  @Value("${cassandra.contactpoints}")
    private String contactPoints;

    @Value("${cassandra.port}")
    private int port;

    @Override
    protected String getKeyspaceName() {
      return keySpace;
    }

    @Override
    protected String getContactPoints() {
      return contactPoints;
    }

    @Override
    protected int getPort() {
      return port;
    }
*/
}