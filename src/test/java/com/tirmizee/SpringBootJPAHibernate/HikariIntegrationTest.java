package com.tirmizee.SpringBootJPAHibernate;


import static org.junit.Assert.assertEquals;

import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.tirmizee.RunSpringBootHibernate;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = RunSpringBootHibernate.class)
public class HikariIntegrationTest {

	@Autowired
    private DataSource dataSource;
 
    @Test
    public void hikariConnectionPoolIsConfigured() {
        assertEquals("com.zaxxer.hikari.HikariDataSource", dataSource.getClass().getName());
    }
    
}
