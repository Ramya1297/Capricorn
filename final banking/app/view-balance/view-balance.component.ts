import { Component, OnInit } from '@angular/core';
import {HttpClient, HttpParams,HttpHeaders} from '@angular/common/http';

@Component({
  selector: 'app-view-balance',
  templateUrl: './view-balance.component.html',
  styleUrls: ['./view-balance.component.css']
})
export class ViewBalanceComponent implements OnInit {
  public acc_num:Account[];
  public account_number=0;
 account:Account;
 balance;
 type;
  constructor( private objHttp:HttpClient) { }
acc_details;
  ngOnInit() {
    this.objHttp.get<Account[]>("http://localhost:8079/web/getAllAccounts/"+sessionStorage.getItem('customer_id'))
    .subscribe(
      data => {
        console.log("Get Request successful", data);
        this.acc_num=data;
        console.log(this.account_number);
           
               },
      error => {
                console.log("Error in http get"); 
                
            }
      
    );
  }
/*getBalance(){
  this.objHttp.get<Account>("http://localhost:8079/web/getBalance/"+this.acc_num.account_number)
  .subscribe(
    data => {
      console.log("Get Request successful", data);
   
             //this.acc_num=data.account_number;
            // this.acc_details=data;
             console.log(data);
              this.account=data;
              this.balance=this.account.balance;
              this.type=this.account.account_type;
             },
    error => {
              console.log("Error in http get"); 
              
          }
    
  );

}*/
}
class Account{
account_type;
account_number;
balance;
customer_id;
}
  
