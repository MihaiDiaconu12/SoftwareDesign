import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { SetupComponent } from './components/setup/setup.component';
import { HttpClientModule } from '@angular/common/http';
import { AdminregComponent } from './components/adminreg/adminreg.component';
import { AdminactivitiesComponent } from './components/adminactivities/adminactivities.component';
import { ClientpageComponent } from './components/clientpage/clientpage.component';



@NgModule({
  declarations: [
    AppComponent,
    SetupComponent,
    AdminregComponent,
    AdminactivitiesComponent,
    ClientpageComponent,
   
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
