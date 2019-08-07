package com.mycorp.messaging.security;

//@Configuration
//@EnableWebSecurity
public class WebSecurityConfig  {

    //extends WebSecurityConfigurerAdapter
    /*@Override
    protected void configure(HttpSecurity http) throws Exception {
        //http.authorizeRequests().antMatchers("/messages").hasRole("MANAGERS").antMatchers("/messages")
        //        .hasRole("EMPLOYEES").anyRequest().fullyAuthenticated().and().formLogin();
        http.authorizeRequests().antMatchers(HttpMethod.GET).hasRole("MANAGERS").anyRequest().fullyAuthenticated().and().formLogin();
        http.authorizeRequests().antMatchers(HttpMethod.POST).hasRole("MANAGERS").anyRequest().permitAll();
        http.csrf().disable();
        //http.authorizeRequests().antMatchers("/h2-console").permitAll();
    }

    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.ldapAuthentication().userDnPatterns("uid={0},ou=people").userSearchBase("ou=people")
                .userSearchFilter("uid={0}").groupSearchBase("ou=groups").groupSearchFilter("uniqueMember={0}")
                .contextSource(contextSource()).passwordCompare().passwordEncoder(new LdapShaPasswordEncoder())
                .passwordAttribute("userPassword");
    }

    @Bean
    public DefaultSpringSecurityContextSource contextSource() {
        return  new DefaultSpringSecurityContextSource(
                Collections.singletonList("ldap://localhost:12345"), "dc=memorynotfound,dc=com");
    }*/
}
