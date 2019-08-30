import { Component, OnInit } from '@angular/core';
import {Router} from '@angular/router';
import {HttpClient} from '@angular/common/http';
@Component({
  selector: 'app-logout',
  templateUrl: './logout.component.html',
  styleUrls: ['./logout.component.css']
})
export class LogoutComponent implements OnInit {

  constructor(private objHttp:HttpClient,private router:Router) { }

  ngOnInit() {
    sessionStorage.clear();
    this.router.navigate(["/nav"]);
  }

}
