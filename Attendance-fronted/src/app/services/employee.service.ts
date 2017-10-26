import { Injectable } from '@angular/core';
import { Http, Response } from '@angular/http';
import { Headers, RequestOptions } from '@angular/http';
import { Observable } from 'rxjs';
import 'rxjs/add/operator/map';
import 'rxjs/add/operator/toPromise';


@Injectable()
export class EmployeeService {
  
  private employeUrl: string;

  constructor(private _http:Http) { }


    saveEmployee(employee){
	  	this.employeUrl = '/api/v1/employee';
	  	let headers = new Headers({ 'Content-Type': 'application/json' });
   		let options = new RequestOptions({ headers: headers });

	    return this._http.post(this.employeUrl,employee,options)
	  					  .map(res => res.json());
	  					  
    
  }

  private handleErrorObservable (error: Response | any) {
	console.error(error.message || error);
	return Observable.throw(error.message || error);
    }
    private handleErrorPromise (error: Response | any) {
	console.error(error.message || error);
	return Promise.reject(error.message || error);
    }	



}
