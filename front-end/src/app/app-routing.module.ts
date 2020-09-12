import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { LoginComponent } from './login/login.component';
import { HomeComponent } from './home/home.component';
import { ManagerComponent } from './pages/manager/manager.component';
import { EmployeeComponent } from './pages/employee/employee.component';
import { EmpformComponent } from './pages/empform/empform.component';
import { EmphistoryComponent } from './pages/emphistory/emphistory.component';
import { ManagercontrolpanelComponent } from './pages/managercontrolpanel/managercontrolpanel.component'
import { AboutComponent } from './about/about.component';

const routes: Routes = [
  { path: "home", component: HomeComponent },
  { path: "about", component: AboutComponent },
  { path: "login", component: LoginComponent },
  { path: "manager", component: ManagerComponent },
  { path: "employee", component: EmployeeComponent },
  { path: "empform", component: EmpformComponent },
  { path: "emphistory", component: EmphistoryComponent },
  { path: "managercontrolpanel", component: ManagercontrolpanelComponent },
  { path: "**", redirectTo: "home", pathMatch: 'full' }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }