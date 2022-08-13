package com.boilerr.weatherrest;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
@SpringBootTest
class WeatherRestApplicationTests {

	@Test
	void contextLoads() {
	}


	class RestApplicationTests {

		@Test
		void contextLoads() {
		}

		@Test
		public void noParamGreetingShouldReturnDefaultMessage() throws Exception {

		}

		@Test
		public void paramGreetingShouldReturnTailoredMessage() throws Exception {

		}
	






	@Test
	void contextLoads() {
	}
	@Autowired
	private MockMvc mockMvc;

	@Test
	public void noParamGreetingShouldReturnDefaultMessage() throws Exception {

		this.mockMvc.perform(get("/color")).andDo(print()).andExpect(status().isOk())
				.andExpect(jsonPath("$.name").value("Color, Blue!"));
	}

	@Test
	public void paramGreetingShouldReturnTailoredMessage() throws Exception {

		this.mockMvc.perform(get("/color").param("name", "White"))
				.andDo(print()).andExpect(status().isOk())
				.andExpect(jsonPath("$.name").value("Color, White!"));
	}
}
