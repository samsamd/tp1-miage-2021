package com.acme.todolist;

import org.junit.jupiter.api.Test;

import com.acme.todolist.domain.TodoItem;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.Instant;
import java.time.temporal.ChronoUnit;

public class TodoItemTest {

	//On vérifie que la méthode isLate() renvoie le résultat attendu selon différents cas de test
	@Test
	void isItemNotLate() { // l'item créé à moins de 24h, isLate() doit renvoyer false
		TodoItem item = new TodoItem("1", Instant.now().minus(23,ChronoUnit.HOURS),"test renvoyant false");
		assertFalse(item.isLate());
	}
	
	@Test
	void isItemLate() { // l'item créé à plus de 24h, isLate() doit renvoyer true
		TodoItem item = new TodoItem("1", Instant.now().minus(25,ChronoUnit.HOURS),"test renvoyant true");
		assertTrue(item.isLate());
	}
	
	//On vérifie que finalContent() contient [LATE!] si l'item a plus de 24h et inversement si il a moins de 24h
	@Test
	void isItemContainsLate() { // l'item a moins de 24h, il ne doit pas contenir [LATE!] dans finalContent()
		TodoItem item = new TodoItem("1", Instant.now().minus(23,ChronoUnit.HOURS),"test renvoyant false");
		assertFalse(item.finalContent().contains("[LATE!]"));
	}
	
	@Test
	void isItemNotContainsLate() { // l'item a plus de 24h, il doit contenir [LATE!] dans finalContent()
		TodoItem item = new TodoItem("1", Instant.now().minus(25,ChronoUnit.HOURS),"test renvoyant true");
		assertTrue(item.finalContent().contains("[LATE!]"));
	}
}
