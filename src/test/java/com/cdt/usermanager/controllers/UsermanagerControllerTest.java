package com.cdt.usermanager.controllers;

import com.cdt.usermanager.domains.UserData;
import com.cdt.usermanager.services.UserManagerService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.NoSuchElementException;

import static org.mockito.ArgumentMatchers.any;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(UsermanagerController.class)
public class UsermanagerControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserManagerService service;

    @BeforeEach
    public void setUp() {

    }


    @Test
    public void test01() throws Exception {
        // Trato de obtener un usuario que no existe
        // Given

        // When
        Mockito.when(service.getUser("123")).thenThrow(NoSuchElementException.class);

        // Then
        mockMvc.perform(get("/users/123")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());
    }

    @Test
    public void test02() throws Exception {
        // Creo un usuariuo invalido
        // Given

        // When
        Mockito.when(service.createUser(any())).thenThrow(DataIntegrityViolationException.class);

        // Then
        mockMvc.perform(post("/users")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\n" +
                                "}"))
                .andExpect(status().isBadRequest());
    }

    @Test
    public void test03() throws Exception {
        // Creo y obtengo un usuario correctamente
        // Given
        UserData userData = new UserData();
        userData.setName("Juan Perez");
        userData.setEmail("juan@mail.com");
        userData.setAge(35);

        // When
        Mockito.when((service.createUser(userData))).thenReturn(userData);
        Mockito.when(service.getUser(userData.getId())).thenReturn(userData);

        // Then
        mockMvc.perform(post("/users")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\n" +
                                "    \"name\": \"Juan Perez\",\n" +
                                "    \"email\": \"juan@mail.com\",\n" +
                                "    \"age\": 35\n" +
                                "}"))
                .andExpect(status().isOk());
    }
}