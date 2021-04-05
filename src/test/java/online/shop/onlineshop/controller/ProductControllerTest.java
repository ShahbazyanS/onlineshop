package online.shop.onlineshop.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithUserDetails;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
public class ProductControllerTest {

    private final String basePath = "http://localhost:8080/products";

    @Autowired
    private MockMvc mvc;

    @Test
    public void addProduct() throws Exception {
        ObjectNode objectNode = new ObjectMapper().createObjectNode();
        objectNode.put("name", "product1");
        objectNode.put("description", "beautiful product");
        objectNode.put("price", 12);

        mvc.perform(post(basePath + "/add")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectNode.toString()))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isOk());

    }

    @Test
    public void getProduct() throws Exception {
        mvc.perform(get(basePath + "/1000"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isOk());
    }

    @Test
    public void getAllProduct() throws Exception {
        mvc.perform(get(basePath + "/all"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isOk());
    }

    @Test
    public void findProductByCategory() throws Exception {
        mvc.perform(get(basePath + "/category/1000"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isOk());
    }

    @Test
    public void findProductByColors() throws Exception {
        mvc.perform(get(basePath + "/colors/2111"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isOk());
    }

    @Test
    public void findProductBySizes() throws Exception {
        mvc.perform(get(basePath + "/sizes/1000"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isOk());
    }

    @Test
    public void findProductByCountries() throws Exception {
        mvc.perform(get(basePath + "/madeIn/1000"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isOk());
    }

    @Test
    public void filterProductsByPrice() throws Exception {
        mvc.perform(get(basePath + "/filter/price/50/200"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isOk());
    }

    @Test
    public void filterProductsByCountryAndPrice() throws Exception {
        mvc.perform(get(basePath + "/filter/madeinAndPrice/1000/50/200"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isOk());
    }

    @Test
    public void filterProductsByCategoriesAndPrice() throws Exception {
        mvc.perform(get(basePath + "/filter/categoriesAndPrice/1000/100/200"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isOk());
    }

    @Test
    public void findByWords() throws Exception {
        mvc.perform(get(basePath + "/search/fash"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isOk());
    }

    @Test
    public void findRandomProductsByCategory() throws Exception {
        mvc.perform(get(basePath + "/randomCategories/1000"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isOk());
    }

    @Test
    public void lastAddedProducts() throws Exception {
        mvc.perform(get(basePath + "/last"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isOk());
    }

    @Test
    public void deleteProduct() throws Exception {
        mvc.perform(delete(basePath + "/4000"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isOk());

    }

    @Test
    @WithUserDetails("e.heto@mail.ru")
    public void updateProduct() throws Exception {
        ObjectNode objectNode = new ObjectMapper().createObjectNode();
        objectNode.put("name", "product1");
        objectNode.put("description", "beautiful product");
        objectNode.put("price", 12);

        mvc.perform(put(basePath + "/update/4000")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectNode.toString()))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isOk());
    }
}