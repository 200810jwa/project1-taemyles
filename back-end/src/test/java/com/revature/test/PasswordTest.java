package com.revature.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import com.revature.services.PasswordService;

public class PasswordTest {
	@Mock
	private PasswordService passServ;
	private String pass;
	
	@Before
	public void setUp() throws Exception {
		passServ = new PasswordService();
		pass = "randomStr";
	}

	@Test
	public void testEncryptionSuccess() {
		String encrypted = passServ.encrypt(pass);
		String expected = "cu1dAHGRLqiN9eYghMpbRA==";
		assertEquals(expected, encrypted);
	}
	
	@Test
	public void testEncryptionFailure() {
		String encrypted = passServ.encrypt(pass);
		String expected = "cu1dAHGRLqiN9eYghMsdA==";
		assertNotEquals(expected, encrypted);
	}
	
	@Test
	public void testDecrpytionSuccess() {
		String encrypted = passServ.encrypt(pass);
		String decrypted = passServ.decrypt(encrypted);
		assertEquals(pass, decrypted);
	}
	
	@Test
	public void testDecrpytionFailure() {
		String encrypted = passServ.encrypt(pass);
		String decrypted = passServ.decrypt(encrypted);
		assertNotEquals("Nope", decrypted);
	}
}
