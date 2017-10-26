import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { HomeComponent } from './components/home/home.component';

import { RegisteremployeComponent } from './components/employee/registeremploye/registeremploye.component';


const appRoutes: Routes = [
    { path: '',   redirectTo: '/home', pathMatch: 'full' },
	{path:'home',component:HomeComponent},
	{path:'createmployee',component:RegisteremployeComponent},
	//{path:'artist/:id',component:ArtistComponent},
	//{path:'album/:id',component:AlbumComponent}

	
//	{ path: '**', component: 'PageNotFoundComponent' }
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
export const routingComponents = [HomeComponent,RegisteremployeComponent]
