import { Component, OnInit } from '@angular/core';

import { Employee }    from '../../../model/employee';

import { EmployeeService } from '../../../services/employee.service';


@Component({
  selector: 'app-registeremploye',
  templateUrl: './registeremploye.component.html',
  styleUrls: ['./registeremploye.component.css']
})
export class RegisteremployeComponent implements OnInit {

  model = new Employee( 'First name','Last Name','123467','Manager',6000,'2017-11-17', 8);
  submitted = false;

   
  messageError:String ="";
  messageOK:String ="";


  constructor(private employeeService:EmployeeService) { }

  ngOnInit() {


  }
 
  onSubmit() { 
  	//this.submitted = true; 
  	console.log(JSON.stringify(this.model));
  	this.employeeService.saveEmployee(this.model)
  						.subscribe(employe =>{  							
  							console.log("Save date Subscribe");  						
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
					        this.messageOK = "Employee Registered";
					        this.newEmploye();
					      })
  						;
  }
 
  newEmploye() {
    this.model = new Employee('', '','','',0,'',0);
    this.messageError='';
  }


}
