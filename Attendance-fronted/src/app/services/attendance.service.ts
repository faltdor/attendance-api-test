import { Injectable } from '@angular/core';
import { Http, Response } from '@angular/http';
import { Headers, RequestOptions } from '@angular/http';
import { Observable } from 'rxjs';
import 'rxjs/add/operator/map';
import 'rxjs/add/operator/toPromise';


@Injectable()
export class AttendanceService {

  private attendanceUrl: string = "/api/v1/attendance";

  private headers = new Headers({ 'Content-Type': 'application/json' });
  private options = new RequestOptions({ headers: this.headers });

  constructor(private _http:Http) { }


  resgisterAttendance(attendance){
	    return this._http.post(this.attendanceUrl,attendance,this.options)
	  					  .map(res => res.json());  
    
  }

   getEmployeesAttendance(attendance){	
	    return this._http.post(this.attendanceUrl+"/employees",attendance,this.options)
	  					  .map(res => res.json()); 					  
    
  }


}
