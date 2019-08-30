import { Component, OnInit } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Router} from '@angular/router';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent {

  
  public first_name:string;
  public last_name:string;
  public email:string;
  public phone_number:number=0;
  public PAN:string="";
  public password:string="";
  public confirm_password:string="";
  
  status;
  constructor(private objHttp:HttpClient,private router:Router) { }

  ngOnInit() {
  }

  Registration()
  {
    this.objHttp.post("http://localhost:8079/web/register",
    {
      "first_name":this.first_name,
      "last_name":this.last_name,
      "email":this.email,
      "phone_number":this.phone_number,
      "PAN":this.PAN,
      "password":this.password,
      "confirm_Password ":this.confirm_password


    })
    .toPromise()
    .then(

      data=>{
        console.log("Registration successful",data);
        this.status="Registration successful";
        if(window.confirm('Registration successful..! Please login !!')){
                return this.router.navigate(["/nav"]);
       }
       return false;
        

      },
      error=>
      {
        console.log("Error",error);
        this.status="Error";
      }
    );

  

}

}

