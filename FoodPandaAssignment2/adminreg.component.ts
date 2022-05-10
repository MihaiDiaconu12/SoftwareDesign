import { Component, OnInit } from '@angular/core';
import { AppComponent } from 'src/app/app.component';

@Component({
  selector: 'app-adminreg',
  templateUrl: './adminreg.component.html',
  styleUrls: ['./adminreg.component.css']
})
export class AdminregComponent implements OnInit {

  password2 = '';
  passwordVerify='maresusta';
  constructor(public app: AppComponent) {
    
   }

  ngOnInit(): void {
  }

  loginAdmin(): void{
    console.log("Chestie");
    if(this.password2===this.passwordVerify){
      this.app.logInAdmin=true;
    }else
    {
      console.log("Schmarren");
    }
  }

}
