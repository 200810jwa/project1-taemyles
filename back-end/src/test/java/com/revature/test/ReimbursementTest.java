package com.revature.test;

import static org.junit.Assert.*;

import java.sql.Timestamp;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.revature.dao.IReimbursementDAO;
import com.revature.models.RStatus;
import com.revature.models.RType;
import com.revature.models.Reimbursement;
import com.revature.models.Role;
import com.revature.models.User;
import com.revature.services.ReimburseService;

public class ReimbursementTest {
	@Mock
	private IReimbursementDAO mockedDao;
	private ReimburseService testInstance = new ReimburseService(mockedDao);
	private Reimbursement reim;
	private User tae;
	
	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		testInstance = new ReimburseService(mockedDao);
		tae = new User(1, "taemyles", "o0hlkTlXq7JkMmFDyYCDtb39o94OKUtJ",
				"tae", "myles", "taemyles@gmail.com", new Role(2, "employee"));
		reim = new Reimbursement(1, 500, new Timestamp(System.currentTimeMillis()), null, "description",
				null, tae, null, new RStatus(1, "pending"), new RType(2, "food"));
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		fail("Not yet implemented");
	}

}
