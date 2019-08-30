import { Component, OnInit } from '@angular/core';
import {HttpClient, HttpParams,HttpHeaders} from '@angular/common/http';

export const headers = new HttpHeaders()
                          .set("Access-Control-Allow-Origin", "*");
@Component({
  selector: 'app-viewprofile',
  templateUrl: './viewprofile.component.html',
  styleUrls: ['./viewprofile.component.css']
})
export class ViewprofileComponent implements OnInit {

  //define var
  customer_id;
  first_name;
  last_name;
  phone_number;
  email;
  account_number;
  PAN;
  customers:Customer;

  constructor( private httpObj:HttpClient) { 
    
    this.show_details();

  }
  public show_details(){
    
    this.httpObj.get<Customer>("http://localhost:8079/web/customers/"+sessionStorage.getItem('customer_id'))
    .subscribe(
      data => {console.log("Get Request successful", data);
                this.customers = data;
                this.customer_id=this.customers.customer_id;
                this.first_name=this.customers.first_name;
                this.last_name=this.customers.last_name;
                this.phone_number=this.customers.phone_number;
                this.email=this.customers.email;
                this.account_number=this.customers.account_number;
                this.PAN=this.customers.PAN;

               
               },
      error => {
                console.log("Error in http get"); 
                
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
    PAN;
  
  }
