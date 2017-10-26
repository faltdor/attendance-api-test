import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ReactiveFormsModule } from '@angular/forms';
import { FormsModule } from '@angular/forms';
import { HttpModule } from '@angular/http';

import { AppRoutingModule } from './app.routes';

import { AppComponent } from './app.component';
import { NavbarComponent } from './components/navbar/navbar.component';
import { HomeComponent } from './components/home/home.component';

import { RegisteremployeComponent } from './components/employee/registeremploye/registeremploye.component';

import { EmployeeService } from './services/employee.service';
import { AttendanceService } from './services/attendance.service';

import { RegisterComponent } from './components/attendance/register/register.component';
import { EmployeesComponent } from './components/employee/employees/employees.component';




@NgModule({
  declarations: [
    AppComponent,
    NavbarComponent,
    HomeComponent,
    RegisteremployeComponent,
    RegisterComponent,
    EmployeesComponent
  ],
  imports: [
    BrowserModule,
     FormsModule,
    HttpModule,
    AppRoutingModule,
    ReactiveFormsModule
  ],
  providers: [EmployeeService,AttendanceService],
  bootstrap: [AppComponent]
})
export class AppModule { }
