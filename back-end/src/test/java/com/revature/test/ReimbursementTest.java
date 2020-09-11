package com.revature.test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.revature.dao.IReimbursementDAO;
import com.revature.models.RStatus;
import com.revature.models.RType;
import com.revature.models.Reimbursement;
import com.revature.models.Role;
import com.revature.models.User;
import com.revature.models.templates.ManagerReimburseTemplate;
import com.revature.models.templates.ReimburseTemplate;
import com.revature.services.ReimburseService;

public class ReimbursementTest {
	@Mock
	private IReimbursementDAO mockedDao;
	private ReimburseService testInstance = new ReimburseService(mockedDao);
	private Reimbursement reim, templateReim, manTemplateReim, updatedReim;
	private ReimburseTemplate template;
	private ManagerReimburseTemplate manTemplate;
	private Timestamp timestamp;
	private User tae, manager;
	private List<Reimbursement> allReim = new ArrayList<>();
	private List<Reimbursement> retReim = new ArrayList<>();
	
	@Before
	public void setUp() throws Exception {
		timestamp = new Timestamp(System.currentTimeMillis());
		MockitoAnnotations.initMocks(this);
		testInstance = new ReimburseService(mockedDao);
		tae = new User(1, "taemyles", "o0hlkTlXq7JkMmFDyYCDtb39o94OKUtJ",
				"tae", "myles", "taemyles@gmail.com", new Role(2, "employee"));
		
		manager = new User(2, "managerUser", "o0hlkTlXq7JkMmFDyYCDtb39o94OKUtJ",
				"matt", "oberlies", "mattoberlies@gmail.com", new Role(1, "manager"));
		
		template = new ReimburseTemplate(500, "description", "imagestr", "food");
		
		manTemplate = new ManagerReimburseTemplate(1, 500, timestamp,
				"description", "imagestr", manager, "approved", "food");
		
		reim = new Reimbursement(1, 500, timestamp, null, "description",
				testInstance.utfToByte(template.getReceipt()), tae, null,
				new RStatus(1, "pending"), new RType(2, "food"));
		
		updatedReim = new Reimbursement(1, 500, timestamp, timestamp, "description", testInstance.utfToByte("imagestr"),
				tae, manager, new RStatus(2, "approved"), new RType(2, "food"));
		
		allReim = new ArrayList<>();
		retReim = new ArrayList<>();
		allReim.add(reim);
		retReim.add(reim);
		
		when(mockedDao.insert(reim)).thenReturn(1);
		when(mockedDao.findAll()).thenReturn(allReim);
	}

	@Test
	public void addReimbursementSuccessful() {
		templateReim = new Reimbursement(1, template.getAmount(), timestamp, null, template.getDescription(),
				testInstance.utfToByte(template.getReceipt()), tae, null, new RStatus(1, "pending"),
				new RType(2, template.getType()));
		assertEquals(reim, templateReim);
	}
	
	@Test
	public void addReimbursementAmountFailure() {
		templateReim = new Reimbursement(1, 55, timestamp, null, template.getDescription(),
				testInstance.utfToByte(template.getReceipt()), tae, null, new RStatus(1, "pending"),
				new RType(2, template.getType()));
		assertNotEquals(reim, templateReim);
	}
	
	@Test
	public void addReimbursementIdFailure() {
		templateReim = new Reimbursement(5, template.getAmount(), timestamp, null, template.getDescription(),
				testInstance.utfToByte(template.getReceipt()), tae, null, new RStatus(1, "pending"),
				new RType(2, template.getType()));
		assertNotEquals(reim, templateReim);
	}
	
	@Test
	public void addReimbursementSubmittedTimeFailure() {
		templateReim = new Reimbursement(1, template.getAmount(), new Timestamp(1L) , null, template.getDescription(),
				testInstance.utfToByte(template.getReceipt()), tae, null, new RStatus(1, "pending"),
				new RType(2, template.getType()));
		assertNotEquals(reim, templateReim);
	}
	
	@Test
	public void addReimbursementResolvedTimeFailure() {
		templateReim = new Reimbursement(1, template.getAmount(), timestamp, new Timestamp(System.currentTimeMillis()), template.getDescription(),
				testInstance.utfToByte(template.getReceipt()), tae, null, new RStatus(1, "pending"),
				new RType(2, template.getType()));
		assertNotEquals(reim, templateReim);
	}
	
	@Test
	public void addReimbursementDescriptionFailure() {
		templateReim = new Reimbursement(1, template.getAmount(), timestamp, null, "not the desc",
				testInstance.utfToByte(template.getReceipt()), tae, null, new RStatus(1, "pending"),
				new RType(2, template.getType()));
		assertNotEquals(reim, templateReim);
	}
	
	@Test
	public void addReimbursementReceiptFailure() {
		templateReim = new Reimbursement(1, template.getAmount(), timestamp, null, template.getDescription(),
				testInstance.utfToByte("random str"), tae, null, new RStatus(1, "pending"),
				new RType(2, template.getType()));
		assertNotEquals(reim, templateReim);
	}
	
	@Test
	public void addReimbursementAuthorFailure() {
		templateReim = new Reimbursement(1, template.getAmount(), timestamp, null, template.getDescription(),
				testInstance.utfToByte(template.getReceipt()), manager, null, new RStatus(1, "pending"),
				new RType(2, template.getType()));
		assertNotEquals(reim, templateReim);
	}
	
	@Test
	public void addReimbursementResolverFailure() {
		templateReim = new Reimbursement(1, template.getAmount(), timestamp, null, template.getDescription(),
				testInstance.utfToByte(template.getReceipt()), tae, tae, new RStatus(1, "pending"),
				new RType(2, template.getType()));
		assertNotEquals(reim, templateReim);
	}
	
	@Test
	public void addReimbursementStatusFailure() {
		templateReim = new Reimbursement(1, template.getAmount(), timestamp, null, template.getDescription(),
				testInstance.utfToByte(template.getReceipt()), tae, null, new RStatus(2, "pending"),
				new RType(2, template.getType()));
		assertNotEquals(reim, templateReim);
	}
	
	@Test
	public void addReimbursementTypeFailure() {
		templateReim = new Reimbursement(1, template.getAmount(), timestamp, null, template.getDescription(),
				testInstance.utfToByte(template.getReceipt()), tae, null, new RStatus(1, "pending"),
				new RType(1, template.getType()));
		assertNotEquals(reim, templateReim);
	}
	
	@Test
	public void updateReimbursementSuccess() {
		manTemplateReim = new Reimbursement(manTemplate.getId(), manTemplate.getAmount(),
				timestamp, manTemplate.getTimeSubmitted(), manTemplate.getDescription(), testInstance.utfToByte(manTemplate.getReceipt())
				, tae, manager, new RStatus(2, "approved"), new RType(2, manTemplate.getType()));
		assertEquals(updatedReim, manTemplateReim);
	}
	
	@Test
	public void updateReimbursementIdFailure() {
		manTemplateReim = new Reimbursement(5, manTemplate.getAmount(),
				timestamp, manTemplate.getTimeSubmitted(), manTemplate.getDescription(), testInstance.utfToByte(manTemplate.getReceipt())
				, tae, manager, new RStatus(2, "approved"), new RType(2, manTemplate.getType()));
		assertNotEquals(updatedReim, manTemplateReim);
	}
	
	@Test
	public void updateReimbursementAmountFailure() {
		manTemplateReim = new Reimbursement(manTemplate.getId(), 12,
				timestamp, manTemplate.getTimeSubmitted(), manTemplate.getDescription(), testInstance.utfToByte(manTemplate.getReceipt())
				, tae, manager, new RStatus(2, "approved"), new RType(2, manTemplate.getType()));
		assertNotEquals(updatedReim, manTemplateReim);
	}
	
	@Test
	public void updateReimbursementSubmittedTimeFailure() {
		manTemplateReim = new Reimbursement(manTemplate.getId(), manTemplate.getAmount(),
				new Timestamp(2L), manTemplate.getTimeSubmitted(), manTemplate.getDescription(), testInstance.utfToByte(manTemplate.getReceipt())
				, tae, manager, new RStatus(2, "approved"), new RType(2, manTemplate.getType()));
		assertNotEquals(updatedReim, manTemplateReim);
	}
	
	@Test
	public void updateReimbursementResolvedTimeFailure() {
		manTemplateReim = new Reimbursement(manTemplate.getId(), manTemplate.getAmount(),
				timestamp, new Timestamp(2L), manTemplate.getDescription(), testInstance.utfToByte(manTemplate.getReceipt())
				, tae, manager, new RStatus(2, "approved"), new RType(2, manTemplate.getType()));
		assertNotEquals(updatedReim, manTemplateReim);
	}
	
	@Test
	public void updateReimbursementDescriptionFailure() {
		manTemplateReim = new Reimbursement(manTemplate.getId(), manTemplate.getAmount(),
				timestamp, manTemplate.getTimeSubmitted(), "What", testInstance.utfToByte(manTemplate.getReceipt())
				, tae, manager, new RStatus(2, "approved"), new RType(2, manTemplate.getType()));
		assertNotEquals(updatedReim, manTemplateReim);
	}
	
	@Test
	public void updateReimbursementReceiptFailure() {
		manTemplateReim = new Reimbursement(manTemplate.getId(), manTemplate.getAmount(),
				timestamp, manTemplate.getTimeSubmitted(), manTemplate.getDescription(), testInstance.utfToByte("sdf")
				, tae, manager, new RStatus(2, "approved"), new RType(2, manTemplate.getType()));
		assertNotEquals(updatedReim, manTemplateReim);
	}
	
	@Test
	public void updateReimbursementAuthorFailure() {
		manTemplateReim = new Reimbursement(manTemplate.getId(), manTemplate.getAmount(),
				timestamp, manTemplate.getTimeSubmitted(), manTemplate.getDescription(), testInstance.utfToByte(manTemplate.getReceipt())
				, manager, manager, new RStatus(2, "approved"), new RType(2, manTemplate.getType()));
		assertNotEquals(updatedReim, manTemplateReim);
	}
	
	@Test
	public void updateReimbursementResolverFailure() {
		manTemplateReim = new Reimbursement(manTemplate.getId(), manTemplate.getAmount(),
				timestamp, manTemplate.getTimeSubmitted(), manTemplate.getDescription(), testInstance.utfToByte(manTemplate.getReceipt())
				, tae, tae, new RStatus(2, "approved"), new RType(2, manTemplate.getType()));
		assertNotEquals(updatedReim, manTemplateReim);
	}
	
	@Test
	public void updateReimbursementStatusFailure() {
		manTemplateReim = new Reimbursement(manTemplate.getId(), manTemplate.getAmount(),
				timestamp, manTemplate.getTimeSubmitted(), manTemplate.getDescription(), testInstance.utfToByte(manTemplate.getReceipt())
				, tae, manager, new RStatus(3, "pending"), new RType(2, manTemplate.getType()));
		assertNotEquals(updatedReim, manTemplateReim);
	}
	
	@Test
	public void updateReimbursementTypeFailure() {
		manTemplateReim = new Reimbursement(manTemplate.getId(), manTemplate.getAmount(),
				timestamp, manTemplate.getTimeSubmitted(), manTemplate.getDescription(), testInstance.utfToByte(manTemplate.getReceipt())
				, tae, manager, new RStatus(2, "approved"), new RType(2, "Nonedd"));
		assertNotEquals(updatedReim, manTemplateReim);
	}
	
	@Test
	public void viewAllReimbursementSuccess() {
		assertEquals(allReim.get(0), reim);
	}
	
	@Test
	public void viewAllReimbursementFailure() {
		assertNotEquals(allReim.get(0), updatedReim);
	}
	
	@Test
	public void viewUserReimbursementSuccess() {
		assertEquals(allReim.get(0), retReim.get(0));
	}
	
	@Test
	public void viewUserReimbursementFailure() {
		assertNotEquals(allReim.get(0), updatedReim);
	}
}
