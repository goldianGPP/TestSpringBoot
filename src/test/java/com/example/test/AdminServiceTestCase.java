package com.example.test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.verify;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.test.repository.AdminRepository;
import com.example.test.service.AdminService;

@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
public class AdminServiceTestCase {
	
	private AdminService service;
	
	@Mock
	private AdminRepository repository;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		service = new AdminService(repository);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		service.getAdmin();
		verify(repository).findAll();
	}

}
