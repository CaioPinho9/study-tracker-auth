package com.caio.pinho.auth.config;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

class PasswordEncoderTest {
	private final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

	@Test
	void shouldHashVerifyPassword() {
		String rawPassword = "password";

		String hashedPassword = passwordEncoder.encode(rawPassword);

		assertNotNull(hashedPassword);
		assertNotEquals(rawPassword, hashedPassword);
		assertTrue(passwordEncoder.matches(rawPassword, hashedPassword));
		assertFalse(passwordEncoder.matches("wrong-password", hashedPassword));
	}
}
