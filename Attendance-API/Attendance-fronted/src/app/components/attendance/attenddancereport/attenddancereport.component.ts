import { Component, OnInit } from '@angular/core';

import { AttendanceService } from '../../../services/attendance.service';


@Component({
  selector: 'app-attenddancereport',
  templateUrl: './attenddancereport.component.html',
  styleUrls: ['./attenddancereport.component.css']
})
export class AttenddancereportComponent implements OnInit {
  
  employees: any[] ;
  messageError:String ="";
  messageOK:String ="";
  filterModel : any = {};

  constructor(private attendanceService:AttendanceService) { }

  ngOnInit() {
  		
  }


  onSubmit(){
  	
  	this.messageError = "";
  	this.attendanceService.getEmployeesAttendance(this.filterModel)
  						.subscribe(employee =>{  							
  							console.log(employee); 
  							this.employees =  employee.attendanceeEmployees;					
  						},
  						error => {					        
  							console.log(error);
  							this.messageError = error._body;
  							this.employees = null;
					      })
  						;

  }

}
