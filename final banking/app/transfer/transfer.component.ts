import { Component, OnInit } from '@angular/core';
import {Router} from '@angular/router';
import {HttpClient} from '@angular/common/http';
@Component({
  selector: 'app-transfer',
  templateUrl: './transfer.component.html',
  styleUrls: ['./transfer.component.css']
})
export class TransferComponent implements OnInit {

 public from_acc_num:number=0;
 public to_acc_num="";
 public amount;
 public check="";
 public status:string="";
 customer_id;
 public acc_num:any;
 gstatus:any;
constructor(private objHttp:HttpClient,private router:Router){

}

  ngOnInit() {
    //this.customer_id=sessionStorage.getItem('customer_id');
   // this.customer_id=10001;
    this.objHttp.get<Account[]>("http://localhost:8079/web/getAllAccounts/"+sessionStorage.getItem('customer_id'))
    .subscribe(
      data => {
        console.log("Get Request successful", data);
        this.acc_num=data;
               //this.acc_num=data.account_number;
               
               },
      error => {
                console.log("Error in http get"); 
                
            }
      
    );
  }
  
  click(){
    if(window.confirm('Are sure you to transfer ?')){
      this.Transfer();
    return true;
   }
   return false;
}
handleClick(){
  if(window.confirm('This is not allowed here.!!')){
    return true;
   }
   return false;
}
public selected()
{
  this.from_acc_num=this.from_acc_num;
}
Transfer(){
  console.log(this.from_acc_num);
  this.objHttp.post("http://localhost:8079/web/transfer",
  {
 	
      "from_acc_num":this.from_acc_num,
      "to_acc_num":this.to_acc_num,
      "amount":this.amount
  
  })
  .toPromise()
  .then(
    
      data => {
          console.log("data obj is ",data);
          this.gstatus=data;
          console.log(this.gstatus);
          if(this.gstatus.status=="success")
          {
            if(window.confirm("Transaction is successful")){
              return this.router.navigate(['/dashboard']);
             }
             return false;
            }
            else{
              if(window.confirm("In sufficient funds. Please check your balance")){
                return this.router.navigate(['/dashboard']);
               }
               return false;
              }
            
            
      
         
        
      },
      error => {
        
          console.log("Error", error);
         
          if(window.confirm(this.status)){
            return true;
           }
           return false;
      }
      
  );    


}
}
class Account{

  account_number
 account_type
  customer_id
  balance

}