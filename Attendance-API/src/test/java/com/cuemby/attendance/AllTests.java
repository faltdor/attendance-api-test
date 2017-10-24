package com.cuemby.attendance;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.cuemby.attendance.repositories.EmployeeRepositoryImplTest;
import com.cuemby.attendance.v1.model.mappers.EmployeeMapperImpl;

@RunWith(Suite.class)
@SuiteClasses({ AttendanceApiApplicationTests.class,
				EmployeeRepositoryImplTest.class,
				EmployeeMapperImpl.class
				
})		


public class AllTests {

}
