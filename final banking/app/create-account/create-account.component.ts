import { Component, OnInit } from '@angular/core';
import {HttpClient} from '@angular/common/http';

import {Router} from '@angular/router';

@Component({
  selector: 'app-create-account',
  templateUrl: './create-account.component.html',
  styleUrls: ['./create-account.component.css']
})
export class CreateAccountComponent implements OnInit {
account_type:string;
options:string[]=["Savings","Current"];
  constructor(private objHttp:HttpClient,private router:Router) { }

  ngOnInit() {
  }
  Create(){
    //later rempve this
    sessionStorage.setItem('customer_id',"10001");
    this.objHttp.post("http://localhost:8079/web/createNew",
    {
      "account_type":this.account_type,
      "customer_id":sessionStorage.getItem('customer_id')

    })
    .toPromise()
    .then(

      data=>{
       console.log("success");
       if(window.confirm('Account creation is Successful')){
        
      return this.router.navigate(['/dashboard']);
     }
     return false;
        
      },
      error=>
      {
        console.log("Error",error);
        
      }
    );
  }

}
