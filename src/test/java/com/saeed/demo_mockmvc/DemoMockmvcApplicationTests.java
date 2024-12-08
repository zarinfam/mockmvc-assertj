package com.saeed.demo_mockmvc;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.assertj.MockMvcTester;

@SpringBootTest
@AutoConfigureMockMvc
class DemoMockmvcApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private MockMvcTester mockMvcTester;

	@Test
	void helloEndpoint_shouldReturnHelloMessage_hamcrest() throws Exception {
		this.mockMvc.perform(get("/hello"))
				.andExpect(status().isOk())
				.andExpect(content().string(containsString("Hello Spring!")));
	}

	@Test
	void helloEndpoint_shouldReturnHelloMessage_assertj() throws Exception {
		this.mockMvc.perform(get("/hello"))
				.andExpect(status().isOk())
				.andExpect(result -> assertThat(result.getResponse().getContentAsString())
						.isEqualTo("Hello Spring!"));
	}

	@Test
	void helloEndpoint_shouldReturnHelloMessage_mockMvcTester() {
		mockMvcTester.get().uri("/hello").assertThat() // or - assertThat(mockMvcTester.get().uri("/hello"))
				.hasStatusOk()
				.bodyText().isEqualTo("Hello Spring!");
	}
}
