import { Component, OnInit } from '@angular/core';

import { EmployeeService } from '../../../services/employee.service';



@Component({
  selector: 'app-employees',
  templateUrl: './employees.component.html',
  styleUrls: ['./employees.component.css']
})
export class EmployeesComponent implements OnInit {


  employees: any;
  messageError:String ="";
  messageOK:String ="";

  constructor(private employeeService:EmployeeService) { }

  ngOnInit() {

  		this.employeeService.findAllEmployeesActive()
  						.subscribe(employe =>{  							
  							console.log(employe.employeeList); 
  							this.employees =  employe;					
  						},
  						error => {					        
  							console.log(error);
  							this.messageError = error._body;
  							
					      })
  						;

  }

  onDeleteEmployee(employeeId){
  	console.log(employeeId)
  	this.employeeService.deleteUser(employeeId)
  						.subscribe(employe =>{  							
  							console.log("Employee delete"); 
  							this.messageOK = "Employee Delete!";			
  						},
  						error => {
					        console.log("Save Data Error");
  							console.log(error);
  							this.messageError = error._body;
  							console.log(this.messageError);
					      })
  						;
  }

}
