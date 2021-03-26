package online.shop.onlineshop.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
public class CountriesControllerTest {

    private final String basePath = "http://localhost:8080/countries";

    @Autowired
    private MockMvc mvc;

    @Test
    public void getCountries() throws Exception {
        mvc.perform(get(basePath + "/all"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isOk());
    }
}
