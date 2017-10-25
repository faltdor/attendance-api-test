package com.cuemby.attendance.services;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.cuemby.attendance.domain.Attendance;
import com.cuemby.attendance.domain.Employee;
import com.cuemby.attendance.repositories.IAttendanceRespository;
import com.cuemby.attendance.repositories.IEmployeeRepository;
import com.cuemby.attendance.services.exception.ResourceNotFoundException;
import com.cuemby.attendance.services.impl.AttendanceServiceImpl;
import com.cuemby.attendance.v1.model.AttendanceDTO;
import com.cuemby.attendance.v1.model.mappers.IAttendanceMapper;

public class AttendanceServiceImplTest {

	@Mock
	IAttendanceRespository attendanceRepository;

	@Mock
	IEmployeeRepository employeeRepository;

	AttendanceServiceImpl attendanceServiceImpl;

	DateTimeFormatter formatter;

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		this.attendanceServiceImpl = new AttendanceServiceImpl(attendanceRepository, IAttendanceMapper.INSTANCE,employeeRepository);
	}

	@Test
	public void testCreate() {
		// Given
		try {
			String dateAssistance = "2016-08-03";
			Attendance attendance = new Attendance();
			attendance.setId("23445");
			attendance.setEmployeeId("11111111");
			attendance.setCurrentDateAssistance(new SimpleDateFormat("yyyy-MM-dd").parse(dateAssistance));

			AttendanceDTO attendanceDTO = new AttendanceDTO();
			attendanceDTO.setEmployeeId("11111111");
			attendanceDTO.setCurrentDateAssistance(new SimpleDateFormat("yyyy-MM-dd").parse(dateAssistance));
			
			Employee employee1 = new Employee();
			employee1.setId("11111111");
			employee1.setFirstName("Emple 1");
			employee1.setIdentification("9999999");
			
			when(employeeRepository.getOne(anyString())).thenReturn(Optional.of(employee1));
			
			when(attendanceRepository.save(any(Attendance.class))).thenReturn(attendance);

			// When
			AttendanceDTO result = attendanceServiceImpl.create(attendanceDTO);

			// Them
			assertThat(result).isNotNull();
			assertThat(result.getId()).isNotNull();
			assertThat(result.getEmployeeId()).isEqualTo("11111111");

		} catch (ParseException e) {
			fail(e.getMessage());
		}

	}

	@Test
	public void testListAll() {
		// Given
		Map<String, Attendance> attendaceMap = new ConcurrentHashMap<>(3);

		try {
			String dateAssistance = "2016-08-03";
			Attendance attendance1 = new Attendance();
			attendance1.setEmployeeId("1234455");
			attendance1.setCurrentDateAssistance(new SimpleDateFormat("yyyy-MM-dd").parse(dateAssistance));
			attendaceMap.put("1", attendance1);

			Attendance attendance2 = new Attendance();
			attendance2.setEmployeeId("1234455");
			attendance2.setCurrentDateAssistance(new SimpleDateFormat("yyyy-MM-dd").parse(dateAssistance));
			attendaceMap.put("2", attendance2);

			Attendance attendance3 = new Attendance();
			attendance3.setEmployeeId("1234455");
			attendance3.setCurrentDateAssistance(new SimpleDateFormat("yyyy-MM-dd").parse(dateAssistance));
			attendaceMap.put("3", attendance3);

			when(attendanceRepository.findAll()).thenReturn(attendaceMap);

			// When
			List<AttendanceDTO> AttendanceList = attendanceServiceImpl.listAll();

			assertThat(AttendanceList).isNotNull();
			assertThat(AttendanceList).isNotEmpty();
			assertThat(AttendanceList.size()).isEqualTo(3);

		} catch (ParseException e) {
			fail(e.getMessage());
		}

	}

	

}
