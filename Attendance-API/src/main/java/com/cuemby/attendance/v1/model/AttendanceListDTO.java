package com.cuemby.attendance.v1.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AttendanceListDTO {

	List<AttendanceDTO> attendanceList = null;
}
