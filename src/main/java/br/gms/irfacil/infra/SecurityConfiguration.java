package br.gms.irfacil.infra;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.csrf.CsrfTokenRepository;
import org.springframework.security.web.csrf.HttpSessionCsrfTokenRepository;

import br.gms.irfacil.dao.UsuarioDAO;
import br.gms.irfacil.security.JWTAuthenticationFilter;
import br.gms.irfacil.security.JWTLoginFilter;
import br.gms.irfacil.security.UserDetailsServiceImpl;


@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

//	@Autowired
//	private UsuarioDAO usuarioDao;
	
	@Bean
	public UserDetailsService userDetailsService() {
		return new UserDetailsServiceImpl();
	}
	  
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().csrfTokenRepository(csrfTokenRepository());
		http.csrf().disable();
		http.authorizeRequests()
			.antMatchers("/usuario/logar").permitAll()
			.antMatchers("/usuario/inserirusuarioteste").permitAll()
			.antMatchers("/usuario/listar").permitAll()
			.anyRequest().authenticated()
			.and()
			
			// filtra requisições de login
			.addFilterBefore(new JWTLoginFilter("/usuario/logar", authenticationManager()),
            UsernamePasswordAuthenticationFilter.class)
		
			//Filtra outras requisições para verificar a presença do JWT no header
			.addFilterBefore(new JWTAuthenticationFilter(),
	                UsernamePasswordAuthenticationFilter.class);
		
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService())
			.passwordEncoder(new Md5PasswordEncoder());
//		auth.inMemoryAuthentication()
//			.withUser("admin")
//			.password("password")
//			.roles("ADMIN");
	}
	
	
	private CsrfTokenRepository csrfTokenRepository(){ 
	    HttpSessionCsrfTokenRepository repository = new HttpSessionCsrfTokenRepository(); 
	    repository.setSessionAttributeName("_csrf");
	    repository.setHeaderName("X-XSRF-TOKEN");
	    return repository; 
	}
	
	
}













