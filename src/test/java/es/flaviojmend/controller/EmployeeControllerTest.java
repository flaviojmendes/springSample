package es.flaviojmend.controller;

import es.flaviojmend.AppConfiguration;
import es.flaviojmend.data.entity.Employee;
import es.flaviojmend.data.repo.EmployeeRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

import java.util.Arrays;

import static org.hamcrest.Matchers.*;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Created by flavio on 23/08/16.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=AppConfiguration.class, loader=AnnotationConfigContextLoader.class)
@WebAppConfiguration
public class EmployeeControllerTest {

    private MockMvc mockMvc;

    @Autowired
    private EmployeeRepository employeeRepositoryMock;

    @Test
    public void findAll_EmployeesFound_ShouldReturnFoundTodoEntries() throws Exception {
        Employee first = new Employee()
                .setIdEmployee(1L)
                .setName("Josias")
                .setLastName("Balde")
                .setRegistrationNumber(3212);

        Employee second = new Employee()
                .setIdEmployee(2L)
                .setName("John")
                .setLastName("Doe")
                .setRegistrationNumber(3213);

        when(employeeRepositoryMock.findAll()).thenReturn(Arrays.asList(first, second));

        mockMvc.perform(get("/employee"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(TestUtil.APPLICATION_JSON_UTF8))
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].id", is(1)))
                .andExpect(jsonPath("$[0].description", is("Lorem ipsum")))
                .andExpect(jsonPath("$[0].title", is("Foo")))
                .andExpect(jsonPath("$[1].id", is(2)))
                .andExpect(jsonPath("$[1].description", is("Lorem ipsum")))
                .andExpect(jsonPath("$[1].title", is("Bar")));

        verify(employeeRepositoryMock, times(1)).findAll();
        verifyNoMoreInteractions(employeeRepositoryMock);
    }

}
