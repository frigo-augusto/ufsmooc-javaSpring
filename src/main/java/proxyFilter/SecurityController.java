package proxyFilter;

import com.ufsmooc.ufsmooc.util.SecurityUtil;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

public class SecurityController extends WebSecurityConfigurerAdapter {



    //not finalized, copied example
    @Override
    protected void configure(final AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("user1").password(SecurityUtil.encryptPassword().encode("user1Pass")).roles("USER")
                .and()
                .withUser("user2").password(SecurityUtil.encryptPassword().encode("user2Pass")).roles("USER")
                .and()
                .withUser("admin").password(SecurityUtil.encryptPassword().encode("adminPass")).roles("ADMIN");
    }

    @Override
    protected void configure(final HttpSecurity http) throws Exception {
        http
                .csrf().
                disable().
                authorizeRequests().
                antMatchers("login/*").permitAll();
    }
}
