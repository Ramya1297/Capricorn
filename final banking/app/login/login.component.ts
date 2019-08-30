import { Component, OnInit } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {FormsModule} from '@angular/forms';
import {Router} from '@angular/router';
@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  public customer_id:string="";
  public password:string="";
 gstatus:any;
 dstatus:string;
  constructor(private objHttp:HttpClient, private router:Router) { }

  ngOnInit() {
  }
  Authenticate()
  {
    this.objHttp.post("http://localhost:8079/web/login",
    {
      "customer_id":this.customer_id,
      "password":this.password

    })
    .toPromise()
    .then(

      data=>{
        this.gstatus=data;
        if(this.gstatus.status=="success")
        {
        sessionStorage.setItem('customer_id',this.customer_id);
        this.dstatus="Login sucessful";
          this.router.navigate(['/dashboard']);
        }
        else{

          this.dstatus="error..!"
        }
      },
      error=>
      {
        console.log("Error",error);
        this.dstatus="Error";
      }
    );

  

}

}
class getStatus{
  status;
}
