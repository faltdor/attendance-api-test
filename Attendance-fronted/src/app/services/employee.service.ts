import { Injectable } from '@angular/core';
import { Http, Response } from '@angular/http';
import { Headers, RequestOptions } from '@angular/http';
import { Observable } from 'rxjs';
import 'rxjs/add/operator/map';
import 'rxjs/add/operator/toPromise';


@Injectable()
export class EmployeeService {
  
  private employeUrl: string = '/api/v1/employee';

  constructor(private _http:Http) { }


  saveEmployee(employee){
	  	
	  	let headers = new Headers({ 'Content-Type': 'application/json' });
   		let options = new RequestOptions({ headers: headers });

	    return this._http.post(this.employeUrl,employee,options)
	  					  .map(res => res.json());
	  					  
    
  }


  searchByidentification(identification:string){
  	return this._http.get(this.employeUrl+"/"+identification)
	  					  .map(res => res.json());
  }

  


}