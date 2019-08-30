import { Component, OnInit } from '@angular/core';

import {HttpClient, HttpParams,HttpHeaders} from '@angular/common/http';

export const headers = new HttpHeaders()
                          .set("Access-Control-Allow-Origin", "*");
@Component({
  selector: 'app-updateprofile',
  templateUrl: './updateprofile.component.html',
  styleUrls: ['./updateprofile.component.css']
})
export class UpdateprofileComponent implements OnInit {

  //define var
  customer_id;
  first_name;
  last_name;
  phone_number;
  email;
  account_number;
  pan;
  customers:Customer;


  constructor( private httpObj:HttpClient) { 
    this.show_details();
  }
  
  public show_details(){
   // sessionStorage.setItem('customer_id','23');

    const params = new HttpParams().set('customer_id',sessionStorage.getItem('customer_id'));
   
    this.httpObj.get<Customer>("http://localhost:8079/web/customers/"+sessionStorage.getItem('customer_id'))
    .subscribe(
      data => {console.log("Get Request successful", data);
                this.customers = data;
             
                this.customer_id=this.customers.customer_id;
                this.first_name=this.customers.first_name;
                this.last_name=this.customers.last_name;
                this.phone_number=this.customers.phone_number;
                this.email=this.customers.email;
               
                this.pan=data.pan;

               
               },
      error => {
                console.log("Error in http get"); 
                
            }
      
    );

  }

  
  public Update(){
    this.httpObj.put("http://localhost:8079/web/update",
    {
     
      "customer_id":this.customers.customer_id,
      "first_name":this.first_name,
      "last_name":this.last_name,
      "phone_number":this.phone_number,
      "email":this.email,
  
      "pan": this.pan
    })
    .toPromise()
    .then(
    data =>{
      console.log("Transaction is successful",data);
      if(window.confirm("Update successful")){
        return true;
       }
       return false;
    
      

    },
error=>{
  console.log("Error",error);
}
    );
  }

  ngOnInit() {
   

  }
} 
 class Customer{

  customer_id;
  first_name;
  last_name;
  phone_number;
  email;
  account_number;
  pan;

}
  