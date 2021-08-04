package com.gabriel.lunchfinder;

import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
class LunchFinderApplicationTests {

	@Autowired
	private MockMvc mvc;

	@Test
	void notExist() throws Exception {
		mvc.perform(get("/restaurants?name=not exist&rating=1&distance=10&price=50&cuisineName=qualquer")
				.contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk());
	}

	@Test
	void shouldExist() throws Exception {
		mvc.perform(get("/restaurants?name=Delicious&rating=1&distance=3&price=50&cuisineName=Greek")
				.contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk());
	}

	@Test
	void shouldSearchARestaurantWithAllParameters() throws Exception {
		mvc.perform(get("/restaurants?name=Delicious&rating=1&distance=3&price=50&cuisineName=Greek")
				.contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
				.andExpect(jsonPath("$[0].name").value("Deliciousish")).andExpect(jsonPath("$[0].rating").value("1"))
				.andExpect(jsonPath("$[0].distance").value("3")).andExpect(jsonPath("$[0].price").value("50"))
				.andExpect(jsonPath("$[0].cuisine").value("Greek"));
	}

	@Test
	void shouldReturnOnlyFiveResults() throws Exception {
		mvc.perform(get("/restaurants?name=Delicious&rating=1&distance=10&price=50")
				.contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
				.andExpect(jsonPath("$[0].name").value("Deliciousgenix")).andExpect(jsonPath("$[0].rating").value("4"))
				.andExpect(jsonPath("$[0].distance").value("1")).andExpect(jsonPath("$[0].price").value("10"))
				.andExpect(jsonPath("$[0].cuisine").value("Spanish"))
				.andExpect(jsonPath("$[1].name").value("Deliciouszilla")).andExpect(jsonPath("$[1].rating").value("4"))
				.andExpect(jsonPath("$[1].distance").value("1")).andExpect(jsonPath("$[1].price").value("15"))
				.andExpect(jsonPath("$[1].cuisine").value("Chinese"))
				.andExpect(jsonPath("$[2].name").value("Havana Delicious"))
				.andExpect(jsonPath("$[2].rating").value("3")).andExpect(jsonPath("$[2].distance").value("1"))
				.andExpect(jsonPath("$[2].price").value("35")).andExpect(jsonPath("$[2].cuisine").value("Korean"))
				.andExpect(jsonPath("$[3].name").value("Bang Delicious")).andExpect(jsonPath("$[3].rating").value("5"))
				.andExpect(jsonPath("$[3].distance").value("2")).andExpect(jsonPath("$[3].price").value("15"))
				.andExpect(jsonPath("$[3].cuisine").value("Russian"))
				.andExpect(jsonPath("$[4].name").value("Crisp Delicious")).andExpect(jsonPath("$[4].rating").value("5"))
				.andExpect(jsonPath("$[4].distance").value("2")).andExpect(jsonPath("$[4].price").value("45"))
				.andExpect(jsonPath("$[4].cuisine").value("Russian"));
	}

	@Test
	void shouldFilterThreeRestaurant() throws Exception {
		mvc.perform(
				get("/restaurants?name=Table&rating=5&distance=10&price=50").contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk()).andExpect(jsonPath("$.*", hasSize(3)))
				.andExpect(jsonPath("$[0].name").value("Grove Table"))
				.andExpect(jsonPath("$[1].name").value("Tableadora"))
				.andExpect(jsonPath("$[2].name").value("Tableoont"));
	}

	@Test
	void shouldFilterDistance1() throws Exception {
		mvc.perform(get("/restaurants?rating=1&distance=1&price=50").contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk()).andExpect(jsonPath("$.*", hasSize(5)))
				.andExpect(jsonPath("$[0].distance").value("1")).andExpect(jsonPath("$[1].distance").value("1"))
				.andExpect(jsonPath("$[2].distance").value("1")).andExpect(jsonPath("$[3].distance").value("1"))
				.andExpect(jsonPath("$[4].distance").value("1"));
	}

	@Test
	void shouldFilterPartialCuisineName() throws Exception {
		mvc.perform(get("/restaurants?rating=1&distance=10&price=50&cuisineName=VIET")
				.contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
				.andExpect(jsonPath("$.*", hasSize(5))).andExpect(jsonPath("$[0].cuisine").value("Vietnamese"))
				.andExpect(jsonPath("$[1].cuisine").value("Vietnamese"))
				.andExpect(jsonPath("$[2].cuisine").value("Vietnamese"))
				.andExpect(jsonPath("$[3].cuisine").value("Vietnamese"))
				.andExpect(jsonPath("$[4].cuisine").value("Vietnamese"));
	}

	@Test
	void shouldInforRateBetween1and5() throws Exception {
		mvc.perform(get("/restaurants?rating=10&distance=10&price=50").contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isBadRequest())
				.andExpect(jsonPath("$.message").value("Customer Rating should be between 1 and 5"));
	}

	@Test
	void shouldInforDistanceBetween1and10() throws Exception {
		mvc.perform(get("/restaurants?rating=1&distance=11&price=50").contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isBadRequest())
				.andExpect(jsonPath("$.message").value("Distance should be between 1 mile and 10 miles"));
	}

	@Test
	void shouldInforPriceBetween10and50() throws Exception {
		mvc.perform(get("/restaurants?rating=1&distance=10&price=51").contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isBadRequest())
				.andExpect(jsonPath("$.message").value("Price should be between $10 and $50"));
	}
}
