package com.bintohimo.rockpaperscissorslizardspock;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.json.JSONObject;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class RockPaperScissorsLizardSpockApplicationTests {

	@Autowired
	private MockMvc mockMvc;
	@Value("${url.path}")
	private String urlPath;
	@Value("${url.path.rockPaperScissors}")
	private String rockPaperScissors;
	@Value("${url.path.rockPaperScissorsLizardSpock}")
	private String rockPaperScissorsLizardSpock;

	private void testJson(MvcResult result) throws Exception {
		JSONObject jsonObject = new JSONObject(result.getResponse().getContentAsString());
		jsonObject.get("result");
		jsonObject.get("your-choice");
		jsonObject.get("opponents-choice");
		jsonObject.get("human-readable");
	}

	@Test
	public void get200RockPaperScissorsChoiceRock() throws Exception {
		testJson(mockMvc.perform(get(urlPath + rockPaperScissors + "?choice=rock")).andExpect(status().isOk()).andReturn());
	}

	@Test
	public void get200RockPaperScissorsChoicePaper() throws Exception {
		testJson(mockMvc.perform(get(urlPath + rockPaperScissors + "?choice=paper")).andExpect(status().isOk()).andReturn());
	}

	@Test
	public void get200RockPaperScissorsChoiceScissors() throws Exception {
		testJson(mockMvc.perform(get(urlPath + rockPaperScissors + "?choice=scissors")).andExpect(status().isOk()).andReturn());
	}

	@Test
	public void get400RockPaperScissorsBadRequest() throws Exception {
		mockMvc.perform(get(urlPath + rockPaperScissors + "?choice=unsupported")).andExpect(status().isBadRequest())
				.andExpect(content().string("Unsupported is not valid argument! Possible choices: [Rock, Paper, Scissors]"));
	}

	@Test
	public void get200RockPaperScissorsLizardSpockChoiceRock() throws Exception {
		testJson(mockMvc.perform(get(urlPath + rockPaperScissorsLizardSpock + "?choice=rock")).andExpect(status().isOk()).andReturn());
	}

	@Test
	public void get200RockPaperScissorsLizardSpockChoicePaper() throws Exception {
		testJson(mockMvc.perform(get(urlPath + rockPaperScissorsLizardSpock + "?choice=paper")).andExpect(status().isOk()).andReturn());
	}

	@Test
	public void get200RockPaperScissorsLizardSpockChoiceScissors() throws Exception {
		testJson(mockMvc.perform(get(urlPath + rockPaperScissorsLizardSpock + "?choice=scissors")).andExpect(status().isOk()).andReturn());
	}

	@Test
	public void get200RockPaperScissorsLizardSpockChoiceLizard() throws Exception {
		testJson(mockMvc.perform(get(urlPath + rockPaperScissorsLizardSpock + "?choice=lizard")).andExpect(status().isOk()).andReturn());
	}

	@Test
	public void get200RockPaperScissorsLizardSpockChoiceSpock() throws Exception {
		testJson(mockMvc.perform(get(urlPath + rockPaperScissorsLizardSpock + "?choice=spock")).andExpect(status().isOk()).andReturn());
	}

	@Test
	public void get400RockPaperScissorsLizardSpockBadRequest() throws Exception {
		mockMvc.perform(get(urlPath + rockPaperScissorsLizardSpock + "?choice=unsupported")).andExpect(status().isBadRequest())
				.andExpect(content().string("Unsupported is not valid argument! Possible choices: [Rock, Paper, Scissors, Lizard, Spock]"));
	}

}
