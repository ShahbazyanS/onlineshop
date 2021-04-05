package online.shop.onlineshop.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import online.shop.onlineshop.endpoint.UserController;
import online.shop.onlineshop.security.JwtTokenUtil;
import online.shop.onlineshop.service.EmailServiceImpl;
import online.shop.onlineshop.service.UserServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.test.context.support.WithUserDetails;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
public class UserControllerTest {


    private final String basePath = "http://localhost:8080/user";

    private MockMvc mock;
    private MockMvc mock1;
    @Autowired
    private MockMvc mvc;
    @Autowired
    private WebApplicationContext context;
    @Autowired
    private UserServiceImpl userService;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private JwtTokenUtil tokenUtil;
    @Autowired
    private EmailServiceImpl emailService;

    @BeforeEach
    public void setUp() {

        mock1 = MockMvcBuilders.standaloneSetup(new UserController(userService,
                passwordEncoder, modelMapper, tokenUtil,emailService))
                .build();

        mock = MockMvcBuilders
                .webAppContextSetup(context)
                .apply(springSecurity())
                .build();
    }

    @Test
    public void registerUser_Ok() throws Exception {
        ObjectNode objectNode = new ObjectMapper().createObjectNode();
        objectNode.put("name", "user");
        objectNode.put("email", "user@mail.com");
        objectNode.put("password", "user");
        objectNode.put("confirmPassword", "user");


        mvc.perform(post(basePath + "/add")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectNode.toString()))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isOk());
    }

    @Test
    public void auth_Ok() throws Exception {
        ObjectNode objectNode = new ObjectMapper().createObjectNode();
        objectNode.put("email", "e.heto@mail.ru");
        objectNode.put("password", "asdf1234");

        mvc.perform(post(basePath + "/auth")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectNode.toString()))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    @WithUserDetails("admin098@mail.com")
    public void getUser_OK() throws Exception {
        mock.perform(get(basePath + "/1001"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isOk());
    }

    @Test
    public void deleteUser() throws Exception {
        mock.perform(delete(basePath + "/1002"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isOk());
    }

    @Test
    public void activateUser() throws Exception{
        mvc.perform(get(basePath + "/activate?email=armyanin098@mail.ru&token=8e4ad650-1a4e-46b4-87f6-0beafe86b90e"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isOk());
    }

    @Test
    @WithUserDetails("admin098@mail.com")
    public void getAllUser_OK() throws Exception {
        mock.perform(get(basePath + "/allUsers"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isOk());
    }
}
