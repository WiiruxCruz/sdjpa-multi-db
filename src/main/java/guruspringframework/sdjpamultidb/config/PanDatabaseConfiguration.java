package guruspringframework.sdjpamultidb.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import com.zaxxer.hikari.HikariDataSource;

@Configuration
public class PanDatabaseConfiguration {
	@Bean
	@Primary
	@ConfigurationProperties("spring.pan.datasource")
	public DataSourceProperties panDataSourceProperties() {
		return new DataSourceProperties();
	}
	
	@Primary
	@Bean
	public DataSource panDataSource( @Qualifier("panDataSourceProperties") DataSourceProperties panDataSourceProperties) {
		return panDataSourceProperties.initializeDataSourceBuilder()
				.type(HikariDataSource.class)
				.build();
	}
}