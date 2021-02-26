package online.shop.onlineshop.config;


import online.shop.onlineshop.security.JwtAuthenticationEntryPoint;
import online.shop.onlineshop.security.JwtAuthenticationTokenFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;


@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {


    @Qualifier("currentUserDetailServiceImpl")
    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtAuthenticationEntryPoint unauthorizedHandler;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                // don't create session
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .exceptionHandling().authenticationEntryPoint(unauthorizedHandler)
                .and()
                .authorizeRequests()
                //User security config
                .antMatchers(HttpMethod.GET, "/user/activate").permitAll()
                .antMatchers(HttpMethod.POST, "/user/**").permitAll()
                .antMatchers(HttpMethod.GET, "/user/**").hasAnyAuthority( "ADMIN")
                .antMatchers(HttpMethod.GET, "/user/get").hasAnyAuthority("USER","ADMIN")
                .antMatchers(HttpMethod.PUT, "/user/**").hasAnyAuthority("USER", "ADMIN")
                .antMatchers(HttpMethod.DELETE, "/user/delete").hasAnyAuthority("USER", "ADMIN")
                .antMatchers(HttpMethod.DELETE, "/user/delete/**").hasAnyAuthority( "ADMIN")

                //Personal Info security config
                .antMatchers(HttpMethod.POST, "/personal_info/**").hasAnyAuthority("USER", "ADMIN")
                .antMatchers(HttpMethod.GET, "/personal_info/**").hasAnyAuthority("USER", "ADMIN")
                .antMatchers(HttpMethod.PUT, "/personal_info/**").hasAnyAuthority("USER", "ADMIN")
                .antMatchers(HttpMethod.DELETE, "/personal_info/**").hasAnyAuthority("USER", "ADMIN")

                //Cart security config
                .antMatchers(HttpMethod.GET, "/shopping_cart/**").hasAnyAuthority("USER", "ADMIN")
                .antMatchers(HttpMethod.POST, "/shopping_cart/**").hasAnyAuthority("USER", "ADMIN")
                .antMatchers(HttpMethod.PUT, "/shopping_cart/**").hasAnyAuthority("USER", "ADMIN")
                .antMatchers(HttpMethod.DELETE, "/shopping_cart/**").hasAnyAuthority("USER", "ADMIN")

                //Product security config
                .antMatchers(HttpMethod.POST, "/product/**").hasAnyAuthority("ADMIN")
                .antMatchers(HttpMethod.GET, "/product/**").permitAll()
                .antMatchers(HttpMethod.PUT, "/product/**").hasAnyAuthority("ADMIN")
                .antMatchers(HttpMethod.DELETE, "/product/**").hasAnyAuthority("ADMIN")

                //Images security config
                .antMatchers(HttpMethod.POST, "/image/**").hasAnyAuthority("ADMIN")
                .antMatchers(HttpMethod.GET, "/image/**").permitAll()
                .antMatchers(HttpMethod.PUT, "/image/**").hasAnyAuthority("ADMIN")
                .antMatchers(HttpMethod.DELETE, "/image/**").hasAnyAuthority("ADMIN")

                //Order security config
                .antMatchers(HttpMethod.GET, "/order/**").hasAnyAuthority("USER", "ADMIN")
                .antMatchers(HttpMethod.POST, "/order/**").hasAnyAuthority("USER", "ADMIN")
                .antMatchers(HttpMethod.PUT, "/order/**").hasAnyAuthority("USER", "ADMIN")
                .antMatchers(HttpMethod.DELETE, "/order/**").hasAnyAuthority("USER", "ADMIN")

                //Shipping info security config
                .antMatchers(HttpMethod.GET, "/address/**").hasAnyAuthority("USER", "ADMIN")
                .antMatchers(HttpMethod.POST, "/address/**").hasAnyAuthority("USER", "ADMIN")
                .antMatchers(HttpMethod.PUT, "/address/**").hasAnyAuthority("USER", "ADMIN")
                .antMatchers(HttpMethod.DELETE, "/address/**").hasAnyAuthority("USER", "ADMIN")


                .anyRequest().permitAll();



        // Custom JWT based security filter
        http
                .addFilterBefore(authenticationTokenFilterBean(), UsernamePasswordAuthenticationFilter.class);

        // disable page caching
        http.headers().cacheControl();
    }


    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .userDetailsService(userDetailsService)
                .passwordEncoder(passwordEncoder);
    }

    @Bean
    public PasswordEncoder encoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public JwtAuthenticationTokenFilter authenticationTokenFilterBean() throws Exception {
        return new JwtAuthenticationTokenFilter();
    }


}
