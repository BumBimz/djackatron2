package com.test.djackatron2.rest;

import static org.junit.Assert.*;

import org.junit.Test;

import com.test.djackatron2.model.Account;
import com.test.djackatron2.service.AccountRepository;


import static org.mockito.Mockito.*;

public class TestAccountController {
	@Test
	public void testFindOne(){
		//given
		Long accId= 1l;
		Account account = new Account(accId,"name1",100d);
	
		
		AccountRepository repository = mock(AccountRepository.class);
		when(repository.find(accId)).thenReturn(account);
		
		AccountController controller = new AccountController();
		controller.setAccountController(repository);
		
		//when
		Account result = controller.getOne(accId);
		
		//then
		assertEquals(accId,result.getId());
		verify(repository).find(accId);
	}

	@Test
	public void testSave(){
		//given
		Long accId= 1l;
		Account account = new Account(accId,"name1",100d);
	
		
		AccountRepository repository = mock(AccountRepository.class);
		when(repository.create(account)).thenReturn(account);
		
		AccountController controller = new AccountController();
		controller.setAccountController(repository);
		
		//when
		Account result = controller.save(account);
		
		//then
		assertEquals(accId,result.getId());
		verify(repository).create(account);
	}
	
	@Test
	public void testUpdate(){
		//given
		Long accId= 1l;
		Account account = new Account(accId,"name1",100d);
	
		
		AccountRepository repository = mock(AccountRepository.class);
		when(repository.update(account)).thenReturn(account);
		
		AccountController controller = new AccountController();
		controller.setAccountController(repository);
		
		//when
		Account result = controller.update(account);
		
		//then
		assertEquals(accId,result.getId());
		verify(repository).update(account);
	}

	@Test
	public void testDelete(){
		//given
		Long accId= 1l;
		Account account = new Account(accId,"name1",100d);
	
		
		AccountRepository repository = mock(AccountRepository.class);
		when(repository.delete(accId)).thenReturn(account);
		
		AccountController controller = new AccountController();
		controller.setAccountController(repository);
		
		//when
		Account result = controller.delete(accId);
		
		//then
		assertEquals(accId,result.getId());
		verify(repository).delete(accId);
	}	
}
