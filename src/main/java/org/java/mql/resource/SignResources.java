package org.java.mql.resource;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import org.java.mql.config.JwtUtil;
import org.java.mql.models.User;
import org.java.mql.reponse.ErrorReponse;
import org.java.mql.reponse.LoginResponse;
import org.java.mql.repository.UserRepository;
import org.java.mql.request.LoginRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

@Path("/auth")
public class SignResources {
	@Autowired
	private AuthenticationManager authenticationManager;
	@Autowired
	private JwtUtil jwtUtil;
	@Autowired
	private UserRepository userRepository;

	@POST
	@Path("/login")
	@Consumes("application/json")
	@Produces("application/json")
	public ResponseEntity login(LoginRequest request) {
		try {

			Authentication a = authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
			User user = userRepository.findByUsername(a.getName());
			String token = jwtUtil.createToken(user);
			return ResponseEntity.ok(new LoginResponse(a.getName(), token));

		} catch (BadCredentialsException e) {
			ErrorReponse errorResponse = new ErrorReponse(HttpStatus.BAD_REQUEST, "Invalid username or password");
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
		}

		catch (Exception e) {
			ErrorReponse errorResponse = new ErrorReponse(HttpStatus.BAD_REQUEST, e.getMessage());
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
		}
	}

	@POST
	@Path("/register")
	@Consumes("application/json")
	@Produces("application/json")
	public ResponseEntity register(LoginRequest request) {
		System.out.println("jjjj");
		try {
			// Check if the username is already taken
			User user = userRepository.findByUsername(request.getUsername());
			if (user != null) {
				ErrorReponse errorResponse = new ErrorReponse(HttpStatus.BAD_REQUEST, "Username already exists");
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
			}
			// Save the user to the database
			user = new User();
			user.setUsername(request.getUsername());
			user.setPassword(request.getPassword());
			userRepository.save(user);

			return ResponseEntity.ok("registration succes");

		} catch (BadCredentialsException e) {
			ErrorReponse errorResponse = new ErrorReponse(HttpStatus.BAD_REQUEST, "Invalid username or password");
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
		} catch (Exception e) {
			ErrorReponse errorResponse = new ErrorReponse(HttpStatus.BAD_REQUEST, e.getMessage());
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
		}
	}

}
