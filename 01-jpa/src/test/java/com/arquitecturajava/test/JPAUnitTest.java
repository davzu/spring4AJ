package com.arquitecturajava.test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;

public class JPAUnitTest {
	
	static EntityManagerFactory emf;
	protected EntityManager em;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		Persistence.generateSchema("curso", null);
		emf = Persistence.createEntityManagerFactory("curso");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		emf.close();
	}

	@Before
	public void setUp() throws Exception {
		em = emf.createEntityManager();
	}

	@After
	public void tearDown() throws Exception {
		em.clear();
		em.close();
	}

}
