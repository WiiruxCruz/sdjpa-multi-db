package guruspringframework.sdjpamultidb.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.zaxxer.hikari.HikariDataSource;


@Configuration
public class CardDatabaseConfiguration {
	@Bean
	@ConfigurationProperties("spring.card.datasource")
	public DataSourceProperties cardDatasourceProperties() {
		return new DataSourceProperties();
	}
	
	@Bean
	public DataSource cardDataSource(@Qualifier("cardDataSourceProperties") DataSourceProperties cardDataSourceProperties) {
		return cardDataSourceProperties.initializeDataSourceBuilder()
				.type(HikariDataSource.class)
				.build();
	}
}
