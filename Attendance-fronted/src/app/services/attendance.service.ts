import { Injectable } from '@angular/core';
import { Http, Response } from '@angular/http';
import { Headers, RequestOptions } from '@angular/http';
import { Observable } from 'rxjs';
import 'rxjs/add/operator/map';
import 'rxjs/add/operator/toPromise';


@Injectable()
export class AttendanceService {

  private attendanceUrl: string = "/api/v1/attendance";

  constructor(private _http:Http) { }


    resgisterAttendance(attendance){
	  	
	  	let headers = new Headers({ 'Content-Type': 'application/json' });
   		let options = new RequestOptions({ headers: headers });

	    return this._http.post(this.attendanceUrl,attendance,options)
	  					  .map(res => res.json());
	  					  
    
  }


}
