import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { NavbarComponent } from './navbar/navbar.component';
import { LoginComponent } from './login/login.component';
import { HomeComponent } from './home/home.component';
import { EmployeeComponent } from './pages/employee/employee.component';
import { ManagerComponent } from './pages/manager/manager.component';
import { EmpformComponent } from './pages/empform/empform.component';
import { EmphistoryComponent } from './pages/emphistory/emphistory.component';
import { ManagercontrolpanelComponent } from './pages/managercontrolpanel/managercontrolpanel.component';
import { MyFilterPipe } from './my-filter.pipe';
import { AboutComponent } from './about/about.component';
import { RegisterComponent } from './register/register.component';


@NgModule({
  declarations: [
    AppComponent,
    NavbarComponent,
    LoginComponent,
    HomeComponent,
    EmployeeComponent,
    ManagerComponent,
    EmpformComponent,
    EmphistoryComponent,
    ManagercontrolpanelComponent,
    MyFilterPipe,
    AboutComponent,
    RegisterComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
