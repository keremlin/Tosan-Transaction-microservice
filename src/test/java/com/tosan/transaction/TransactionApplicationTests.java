package com.tosan.transaction;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.tosan.transaction.exceptions.TransactionNotFoundException;
import com.tosan.transaction.model.DepositTransaction;
import com.tosan.transaction.model.TransactionStatus;
import com.tosan.transaction.model.TransactionType;
import com.tosan.transaction.repositories.TransactionRepository;
import com.tosan.transaction.services.TransactionServiceImpl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class TransactionApplicationTests {
	@InjectMocks
	private TransactionServiceImpl service;

	@Mock
	private TransactionRepository repo;

	DepositTransaction testCase;
	List<DepositTransaction> list=new ArrayList<>();

	@BeforeEach
	void beforeEach() {
		testCase = new DepositTransaction(0, null, 198, TransactionStatus.successful,
				TransactionType.transfer, 10009, 10008, 0, "this");
		list.add(testCase);
		list.add(new DepositTransaction(0, null, 198, TransactionStatus.successful,
		TransactionType.transfer, 10010, 10009, 0, "this"));

		when(repo.save(ArgumentMatchers.<DepositTransaction>any())).thenAnswer(i -> i.getArguments()[0]);
		when(repo.findBySourceOrDestination(10009,10009)).thenReturn(list);
		when(repo.findByNumber(10009)).thenReturn(Optional.of(testCase));
		when(repo.findByNumber(10008)).thenReturn(Optional.empty());
	}

	@Test
	void checkSaveTransaction() {
		assertEquals(198, service.registerTransaction(testCase).getTransactionAmount());
	}

	@Test
	void checkListOfTransactions() {
		assertEquals(2,service.getListOfTransaction(10009).size());
		assertEquals(198,service.getListOfTransaction(10009).get(0).getTransactionAmount());
	}

	@Test
	void checkFindTransactionById() {
		assertEquals(198, service.getTransactionByNumber(10009).getTransactionAmount());
	}

	@Test
	void checkFindTransactionByIdException() {
		assertThrows(TransactionNotFoundException.class, () -> service.getTransactionByNumber(10008));
	}

}
