import { Component, OnInit } from '@angular/core';

import { Attendance }    from '../../../model/attendance';

import { AttendanceService } from '../../../services/attendance.service';
import { EmployeeService } from '../../../services/employee.service';


@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

 

  model:Attendance;
  messageError:String ="";
  messageOK:String ="";

  submitted = false;

  constructor(private attendanceService:AttendanceService,private employeeService:EmployeeService ) { }

  ngOnInit() {
  	 let dateNow =  new Date();

  	 this.model = new Attendance("",dateNow);

  	 
 
  }

  onSubmit() { 
  			 this.attendanceService.resgisterAttendance(this.model)
  	 						.subscribe(response =>{

  	 						},
  	 						error => {
					        console.log("Save Data Error");
  							console.log(error);
  							this.messageError = error._body;
  							console.log(this.messageError);
					      },
					      () => {
					        // No errors, route to new page
					        console.log("Save Data Ok");
					        this.messageOK = "Attendance Registered";
					        this.newEmploye();
					      })
  						;
  }

  newEmploye() {
    this.model = new Attendance('', new Date());
    this.messageError='';
  }

}
