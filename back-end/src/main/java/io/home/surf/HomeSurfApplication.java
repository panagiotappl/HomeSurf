package io.home.surf;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * @author Dimitris Anastasopoulos
 *
 */
@SpringBootApplication
@ComponentScan(basePackages = { "io.home.surf" })
@EntityScan(basePackages = { "io.home.surf.model" })
@EnableJpaRepositories(basePackages = { "io.home.surf.dao" })
public class HomeSurfApplication {

  public static void main(String[] args) {
    SpringApplication.run(HomeSurfApplication.class, args);
  }

}
