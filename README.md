# spring-rest-book

https://www.baeldung.com/spring-security-authentication-with-a-database

- First we need to enable Websecurity for Spring boot app

  ````
  @EnableWebSecurity
  public class SecurityConfigurer extends WebSecurityConfigurerAdapter {
  
      @Autowired
      MyUserDetailsService myUserDetailsService;
  
      @Override
      protected void configure(AuthenticationManagerBuilder auth) throws Exception{
          auth.userDetailsService(myUserDetailsService);
  
      }
      @Bean
      public PasswordEncoder passwordEncoder(){
          return NoOpPasswordEncoder.getInstance();
      }
  }
 
  