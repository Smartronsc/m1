package com.androidcommand.app;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.cassandra.config.AbstractCassandraConfiguration;
import org.springframework.data.cassandra.config.CassandraClusterFactoryBean;
import org.springframework.data.cassandra.core.mapping.CassandraMappingContext;
import org.springframework.data.cassandra.repository.config.EnableCassandraRepositories;

import com.datastax.driver.core.PlainTextAuthProvider;

@Configuration
@EnableCassandraRepositories(basePackages = {"com.androidcommand.app"})

public class CassandraConfig extends AbstractCassandraConfiguration {
    
    @Override
    protected String getKeyspaceName() {
        return "rant";
    }
 
    @Bean
    public CassandraClusterFactoryBean cluster() {
        CassandraClusterFactoryBean cluster = 
          new CassandraClusterFactoryBean();
        PlainTextAuthProvider sap = new PlainTextAuthProvider("cassandra","cassandra");
        System.out.println("In CassandraConfiguration: sap " + sap.toString());
        cluster.setAuthProvider(sap);
        cluster.setContactPoints("192.168.1.4");
        cluster.setPort(9042);
        System.out.println("In CassandraConfiguration: cluster " + cluster.getKeyspaceActions().listIterator().toString());
        return cluster;
    }
 
    @Bean
    public CassandraMappingContext cassandraMapping() 
      throws ClassNotFoundException {
        return new CassandraMappingContext();
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