import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { HomeComponent } from './components/home/home.component';

import { RegisteremployeComponent } from './components/employee/registeremploye/registeremploye.component';
import { RegisterComponent } from './components/attendance/register/register.component';
import { EmployeesComponent } from './components/employee/employees/employees.component';
import { AttenddancereportComponent } from './components/attendance/attenddancereport/attenddancereport.component';



const appRoutes: Routes = [
    { path: '',   redirectTo: '/home', pathMatch: 'full' },
	{path:'home',component:HomeComponent},
	{path:'attendance',component:RegisterComponent},
	{path:'createmployee',component:RegisteremployeComponent},
	{path:'employees',component:EmployeesComponent},
	{path:'attendancereport',component:AttenddancereportComponent},
	
];


@NgModule({
	imports: [
		RouterModule.forRoot(appRoutes)
	],
	exports: [
		RouterModule
	]
	
})

export class AppRoutingModule{}
export const routingComponents = [HomeComponent,RegisterComponent,RegisteremployeComponent,EmployeesComponent,AttenddancereportComponent]
