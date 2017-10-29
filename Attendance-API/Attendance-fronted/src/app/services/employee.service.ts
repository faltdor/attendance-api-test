import { Injectable } from '@angular/core';
import { Http, Response } from '@angular/http';
import { Headers, RequestOptions } from '@angular/http';
import { Observable } from 'rxjs';
import 'rxjs/add/operator/map';
import 'rxjs/add/operator/toPromise';


@Injectable()
export class EmployeeService {
  
  private employeUrl: string = '/api/v1/employee';
  private headers = new Headers({ 'Content-Type': 'application/json' });
  private options = new RequestOptions({ headers: this.headers });

  constructor(private _http:Http) { }

  private employees: any;

  saveEmployee(employee){
	  	
	  	

	    return this._http.post(this.employeUrl,employee,this.options)
	  					  .map(res => res.json());
	  					  
    
  }


  searchByidentification(identification:string){
  	return this._http.get(this.employeUrl+"/"+identification)
	  					  .map(res => res.json());
  }

   findAllEmployeesActive(){
  	return this._http.get(this.employeUrl)
	  					  .map(res => {

                      this.employees =  res.json().employeeList;
                      return this.employees;
                });
  }

  deleteUser(userId){
    for (var i =0; i < this.employees.length; i++){
     if (this.employees[i].id === userId) {
        this.employees.splice(i,1);
        break;
     }
   }

    console.log(this.employees);
    return this._http.delete(this.employeUrl+"/"+userId,this.options)
                .map(res => res);
    

 }
  

  


}
