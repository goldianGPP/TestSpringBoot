package com.example.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;

import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Service;

import com.example.test.model.User;
import com.example.test.repository.UserRepository;
import com.example.test.service.UserService;

@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
public class UserServiceTestCase {
	
	private UserService service;
	
	@Mock
	private UserRepository repository;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		service = new UserService(repository);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		List<User> user =  service.getUsers("goldian");
        assertEquals(0, repository.findByNamaContainingIgnoreCase("goldian").size());
	}

}
