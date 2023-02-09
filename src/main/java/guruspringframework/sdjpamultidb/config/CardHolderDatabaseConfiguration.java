package guruspringframework.sdjpamultidb.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.zaxxer.hikari.HikariDataSource;

@Configuration
public class CardHolderDatabaseConfiguration {
	@Bean
	@ConfigurationProperties("spring.cardholder.datasource")
	public DataSourceProperties cardHolderDataSourceProperties() {
		return new DataSourceProperties();
	}
	
	@Bean
	public DataSource cardHolderDataSource(@Qualifier("cardHolderDataSourceProperties") DataSourceProperties cardHolderDataSourceProperties) {
		return cardHolderDataSourceProperties.initializeDataSourceBuilder()
				.type(HikariDataSource.class)
				.build();
	}
}
