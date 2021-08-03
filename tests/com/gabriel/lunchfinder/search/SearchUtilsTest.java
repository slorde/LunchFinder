package com.gabriel.lunchfinder.search;

import static com.gabriel.lunchfinder.search.SearchUtils.containsString;
import static com.gabriel.lunchfinder.search.SearchUtils.valueGreaterOrEquals;
import static com.gabriel.lunchfinder.search.SearchUtils.valueLesserOrEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class SearchUtilsTest {

	@Test
	void shouldContainsPartialString() {
		assertTrue(containsString("teste 123", "123"));
		assertTrue(containsString("teste 123", "teste"));
		assertTrue(containsString("teste 123", "teste 123"));
	}

	@Test
	void shouldIgnoreCaseOnStringContains() {
		assertTrue(containsString("teste 123", "TESTE 123"));
		assertTrue(containsString("TESTE 123", "teste 123"));
	}

	@Test
	void shouldReturnFalseWhenNotContains() {
		assertFalse(containsString("teste 123", "teste 1234"));
		assertFalse(containsString("12345", "56"));
	}
	
	@Test
	void shouldCheckValueGreaterOrEquals() {
		assertTrue(valueGreaterOrEquals(2, 1));
		assertTrue(valueGreaterOrEquals(10, 9));
		assertTrue(valueGreaterOrEquals(1, 1));
		assertFalse(valueGreaterOrEquals(10, 11));
	}
	
	@Test
	void shouldCheckValueLesserOrEquals() {
		assertFalse(valueLesserOrEquals(2, 1));
		assertFalse(valueLesserOrEquals(10, 9));
		assertTrue(valueLesserOrEquals(1, 1));
		assertTrue(valueLesserOrEquals(10, 11));
	}
	
}
