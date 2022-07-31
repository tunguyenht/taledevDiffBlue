package com.taledev;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@ContextConfiguration(classes = {TaledevController.class})
@ExtendWith(SpringExtension.class)
class TaledevControllerTest {
    @Autowired
    private TaledevController taledevController;

    /**
     * Method under test: {@link TaledevController#fibonacci(int, int)}
     */
    @Test
    void testFibonacci() throws Exception {
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/taledev");
        MockMvcBuilders.standaloneSetup(taledevController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("[1,1,2,3,5,8,13,21,34,55]"));
    }

    /**
     * Method under test: {@link TaledevController#fibonacci(int, int)}
     */
    @Test
    void testFibonacci2() throws Exception {
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/taledev", "Uri Variables");
        MockMvcBuilders.standaloneSetup(taledevController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("[1,1,2,3,5,8,13,21,34,55]"));
    }
}

