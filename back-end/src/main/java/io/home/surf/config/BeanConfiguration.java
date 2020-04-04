package io.home.surf.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Dimitris Anastasopoulos
 *
 */
@Configuration
public class BeanConfiguration {
  
  @Bean
  public ModelMapper modelMapper() {
    return new ModelMapper();
  }

}
