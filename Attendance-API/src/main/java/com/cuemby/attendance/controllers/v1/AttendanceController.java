package com.cuemby.attendance.controllers.v1;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.cuemby.attendance.services.impl.AttendanceServiceImpl;
import com.cuemby.attendance.v1.model.AttendanceDTO;
import com.cuemby.attendance.v1.model.AttendanceListDTO;

@RestController
@RequestMapping(AttendanceController.BASE_URL)
public class AttendanceController {

	public static final String BASE_URL = "/api/v1/attendance";

	private final AttendanceServiceImpl attendanceServiceImpl;

	public AttendanceController(AttendanceServiceImpl attendanceServiceImpl) {
		this.attendanceServiceImpl = attendanceServiceImpl;
	}

	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public AttendanceListDTO getallAttendance() {
		return new AttendanceListDTO(attendanceServiceImpl.listAll());
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public AttendanceDTO saveAttendance(@Valid @RequestBody AttendanceDTO attendanceDto) {
		return attendanceServiceImpl.create(attendanceDto);
	}

}
