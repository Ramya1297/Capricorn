import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { Ng2CarouselamosModule } from 'ng2-carouselamos';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { TransferComponent } from './transfer/transfer.component';
import {FormsModule} from '@angular/forms';
import { ValidateAccountPipe } from './validate-account.pipe';
import { CheckMatchPipe } from './check-match.pipe';
import { DifferPipe } from './differ.pipe';
import { DisableRightClickDirective } from './disable-right-click.directive';
import { HttpClientModule } from '@angular/common/http';
import { NavbarComponent } from './navbar/navbar.component';
import { HomeComponent } from './home/home.component';
import { AboutComponent } from './about/about.component';
import { ContactusComponent } from './contactus/contactus.component';
import { AccountStatementComponent } from './account-statement/account-statement.component';
import { LoginComponent } from './login/login.component';
import { RegisterComponent } from './register/register.component';
import { CreateAccountComponent } from './create-account/create-account.component';
import { ViewprofileComponent } from './viewprofile/viewprofile.component';
import { UpdateprofileComponent } from './updateprofile/updateprofile.component';
import { LengthValidatePipe } from './length-validate.pipe';
import { PasswordValidatePipe } from './password-validate.pipe';
import { LogoutComponent } from './logout/logout.component';
import { ViewBalanceComponent } from './view-balance/view-balance.component'; 
@NgModule({
  declarations: [
    AppComponent,
    TransferComponent,
    ValidateAccountPipe,
    CheckMatchPipe,
    DifferPipe,
    DisableRightClickDirective,
    NavbarComponent,
    HomeComponent,
    AboutComponent,
    ContactusComponent,
    AccountStatementComponent,
    LoginComponent,
    RegisterComponent,
    CreateAccountComponent,
    ViewprofileComponent,
    UpdateprofileComponent,
    LengthValidatePipe,
    PasswordValidatePipe,
    LogoutComponent,
    ViewBalanceComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule ,
    Ng2CarouselamosModule 
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { 
  
}

