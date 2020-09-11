package com.revature.test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.revature.dao.IUserDAO;
import com.revature.models.Role;
import com.revature.models.User;
import com.revature.models.templates.LoginTemplate;

public class UserTest {
	@Mock
	private IUserDAO mockedDao;
	private LoginTemplate loginTemplate;
	private User tae, manager;
	
	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		tae = new User(1, "tae", "myles",
				"taemyles", "o0hlkTlXq7JkMmFDyYCDtb39o94OKUtJ", "taemyles@gmail.com", new Role(2, "employee"));
		
		manager = new User(2, "managerUser", "o0hlkTlXq7JkMmFDyYCDtb39o94OKUtJ",
				"matt", "oberlies", "mattoberlies@gmail.com", new Role(1, "manager"));
		
		loginTemplate = new LoginTemplate("taemyles", "o0hlkTlXq7JkMmFDyYCDtb39o94OKUtJ");

		when(mockedDao.findByUsername(tae.getUsername())).thenReturn(tae);
	}

	@Test
	public void employeeLoginSuccess() {
		assertEquals(loginTemplate.getUsername().equals(tae.getUsername()),
				loginTemplate.getPassword().equals(tae.getPassword()));
	}
	
	@Test
	public void employeeLoginFailure() {
		assertNotEquals(loginTemplate.getUsername().equals("notauser"),
				loginTemplate.getPassword().equals(tae.getPassword()));
	}

	@Test
	public void managerLoginSuccess() {
		assertEquals(loginTemplate.getUsername().equals(manager.getUsername()),
				loginTemplate.getPassword().equals(manager.getPassword()));
	}
	@Test
	public void managerLoginFailure() {
		assertEquals(loginTemplate.getUsername().equals("wronguser"),
				loginTemplate.getPassword().equals(manager.getPassword()));
	}
}
