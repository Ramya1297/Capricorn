import { NgModule } from '@angular/core';
import { Routes } from '@angular/router';
import { RouterModule } from '@angular/router';
import {CreateAccountComponent} from 'src/app/create-account/create-account.component';
import {LoginComponent} from 'src/app/login/login.component';
import {NavbarComponent} from 'src/app/navbar/navbar.component';
import {RegisterComponent} from 'src/app/register/register.component';
import {TransferComponent} from 'src/app/transfer/transfer.component';
import {UpdateprofileComponent} from 'src/app/updateprofile/updateprofile.component';
import {ViewprofileComponent} from 'src/app/viewprofile/viewprofile.component';
import {LogoutComponent } from 'src/app/logout/logout.component';
import {AccountStatementComponent} from 'src/app/account-statement/account-statement.component';
import {ViewBalanceComponent} from 'src/app/view-balance/view-balance.component';
const router: Routes = [
{path:'',redirectTo:'nav',pathMatch:"full"},
{path:'nav',component:NavbarComponent},
{path:'register',component:RegisterComponent},
{path:'login',component:LoginComponent},
{path:'dashboard',component:ViewprofileComponent},
{path:'transfer',component:TransferComponent},
{path:'logout',component:LogoutComponent },
{path:'accstmt',component:AccountStatementComponent},
{path:'update',component:UpdateprofileComponent},
{path:'add',component:CreateAccountComponent},
{path:'balance',component:ViewBalanceComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(router)],
  exports: [RouterModule]
})
export class AppRoutingModule { 


  
}
