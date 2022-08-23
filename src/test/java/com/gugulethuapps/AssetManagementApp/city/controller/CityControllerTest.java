package com.gugulethuapps.AssetManagementApp.city.controller;

import com.gugulethuapps.AssetManagementApp.city.model.City;
import com.gugulethuapps.AssetManagementApp.city.repository.CityRepository;
import com.gugulethuapps.AssetManagementApp.city.service.CityService;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsString;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.willReturn;
import static org.mockito.Mockito.doNothing;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(SpringExtension.class)
@WebMvcTest(CityController.class)
@RequiredArgsConstructor
class CityControllerTest {
    @Autowired
    MockMvc mockMvc;

    @MockBean
    CityService service;

    @MockBean
    CityRepository repository;

//    @MockBean
//    private CityMapper mapper;

    private City city;

    @BeforeEach
    public void init() {
        city = new City();
        city.setId(1);
        city.setName("Test");
        city.setCode("Code");
        city.setDetails("Test");
    }

    @AfterEach
    public void cleanUp() {city = null; }

    @Test
    void findAll() throws Exception {
        mockMvc.perform(get("/cities"))
                .andDo(print())
                //.andExpect(view().name("city"))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("meta name")));
    }

    @Test
    void findById() {
    }

    @Test
    void addNew() throws Exception{
//        given(service.save(city)).willReturn(city);
//
//
//        mockMvc.perform(post("/cities/addNew")
//                .accept(MediaType.APPLICATION_JSON)
//                .contentType(MediaType.APPLICATION_JSON));
    }

    @Test
    void update() {
    }

    @Test
    void delete() {
    }

}