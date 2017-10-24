package com.cuemby.attendance.controllers.v1;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.cuemby.attendance.controllers.v1.EmployeeController;
import com.cuemby.attendance.controllers.v1.RestResponseEntityExceptionHandler;
import com.cuemby.attendance.services.impl.EmployeeServiceImpl;
import com.cuemby.attendance.v1.model.EmployeeDTO;

public class EmployeeControllerTest {

	@Mock
	EmployeeServiceImpl employeeServiceImpl;

	@InjectMocks
	EmployeeController employeeController;

	MockMvc mockMvc;

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		mockMvc = MockMvcBuilders.standaloneSetup(employeeController)
				.setControllerAdvice(new RestResponseEntityExceptionHandler()).build();
	}

	@Test
	public void testGetallEmployees() throws Exception {
		// Given

		EmployeeDTO employee1 = new EmployeeDTO();
		employee1.setFirstName("Employee 1");
		employee1.setIdentification("1234567");

		EmployeeDTO employee2 = new EmployeeDTO();
		employee1.setFirstName("Employee 1");
		employee1.setIdentification("1234567");

		EmployeeDTO employee3 = new EmployeeDTO();
		employee1.setFirstName("Employee 1");
		employee1.setIdentification("1234567");

		List<EmployeeDTO> employeeList = Arrays.asList(employee1, employee2, employee3);

		when(employeeServiceImpl.listAll()).thenReturn(employeeList);

		mockMvc.perform(get(EmployeeController.BASE_URL).contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk());
		
		verify(employeeServiceImpl,times(1)).listAll();

	}

}
