import { Component, OnInit } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Router} from '@angular/router';
@Component({
  selector: 'app-account-statement',
  templateUrl: './account-statement.component.html',
  styleUrls: ['./account-statement.component.css']
})

export class AccountStatementComponent implements OnInit{

  //test:string[]=["ally","lilly","pally"];
  months:string[]=["January","February","March","April","May","June","July","August","september","october","November","December"];
  private selectedLink: string="";   
  public propsdata:any;     
  public str:string="lastten";
  public selectmonth:string="";
  
 public acc_num:any;
  
 public from_acc_num:number=0;
 public to_acc_num="";


 constructor(private objHttp:HttpClient,private router:Router){

}
  ngOnInit() {
    //this.customer_id=sessionStorage.getItem('customer_id');
   // this.customer_id=10001;
    this.objHttp.get<Account[]>("http://localhost:8079/web/getAllAccounts/"+sessionStorage.getItem('customer_id'))
    .subscribe(
      data => {
        console.log("Get Request successful", data);
        console.log(data);
        console.log(this.acc_num);
        this.acc_num=data;
console.log(this.acc_num);
               //this.acc_num=data.account_number;
               
               },
      error => {
                console.log("Error in http get"); 
                
            }
      
    );
  }

  setradio(e: string): void   
  {  
    this.selectedLink = e; 
  }  
  
    isSelected(name: string): boolean   
  {  
  // if no radio button is selected, always return false so every nothing is shown 
        if (!this.selectedLink) { 
           
            return false;  
  }  
  // if current radio button is selected, return true, else return false  
        return (this.selectedLink === name); 
    }  
    // to get the selected month
    public selected()
    {
      this.selectmonth=this.selectmonth;
    }
    
    public credited()
    {
      if(this.isSelected('bydate'))
      {
        this.str="http://localhost:8079/web/creditbydate/"+this.from_acc_num;
      }
      else if(this.isSelected('bymonth'))
      {
        this.str="http://localhost:8079/web/creditbymonth/"+this.from_acc_num;
      }
      else{
        //console.log(this.from_acc_num);
        this.str="http://localhost:8079/web/creditlastten/"+this.from_acc_num;
      }

      this.getCall()
    }
    // debited transactions
        public debited()
    {
      if(this.isSelected('bydate'))
      {
        this.str="http://localhost:8079/web/debitbydate/"+this.from_acc_num;
      }
      else if(this.isSelected('bymonth'))
      {
        this.str="http://localhost:8079/web/debitbymonth/"+this.from_acc_num;
      }
      else{

        this.str="http://localhost:8079/web/debitlastten/"+this.from_acc_num;
      }

      this.getCall()
    }
public getCall(){
  //later rempve this
    this.objHttp.get(this.str) 
              .toPromise()
              .then(
                (data)=>{this.propsdata=data},
                (error)=>{ console.error(error);}
                
              )
              .catch((err)=>{

                console.log("In catch block");
                console.error(err);
              })
              .finally(()=>{

                console.log("in finally block");
              });


            }
            public selectaccount()
            {
              this.from_acc_num=this.from_acc_num;
            }
}

class Transaction{
  tid;
	 from_acc_num;
	 to_acc_num;
	amount;
	 date;
	 from_acc_type;
	 to_acc_type;
}