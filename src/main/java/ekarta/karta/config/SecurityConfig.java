package ekarta.karta.config;

import ekarta.karta.service.UserRoleDetailsService;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {


    private UserRoleDetailsService userRoleDetailsService;

    public SecurityConfig(UserRoleDetailsService userRoleDetailsService){
        this.userRoleDetailsService = userRoleDetailsService;
    }


    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        auth.userDetailsService(userRoleDetailsService).passwordEncoder(passwordEncoder);
    }

    @Override
   protected void configure(HttpSecurity http) throws Exception{
       http
               .authorizeRequests()
               .antMatchers("/admin/**").hasAnyRole("ADMIN")
               .antMatchers("/test").hasAnyRole("USER")
               .antMatchers("/login/**").anonymous()
               .antMatchers("/register").anonymous()
               .and()
               .formLogin()
               .usernameParameter("email")
               .passwordParameter("password")
               .loginPage("/login")
               .failureUrl("/login-error")
               .defaultSuccessUrl("/")
               .permitAll()
               .and()
               .logout()
               .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
               .and()
               .csrf().disable();
   }
}
