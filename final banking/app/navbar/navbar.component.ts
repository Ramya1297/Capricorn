import { Component, OnInit } from '@angular/core';
import { Ng2CarouselamosModule } from 'ng2-carouselamos';


@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit {

  title:string="my app";
 
    items: Array<any> = []

  constructor() {
    this.items = [
       { name: 'assets/bank4.jpg' },
      { name: 'assets/bank5.jpg' },
      { name: 'assets/bank7.jpg' },
      { name: 'assets/bank10.jpg' },
      { name: 'assets/bank4.jpg' },
      { name: 'assets/bank5.jpg' },
           { name: 'assets/bank7.jpg' },
      { name: 'assets/bank10.jpg' },
      { name: 'assets/bank4.jpg' },
      { name: 'assets/bank5.jpg' },
      { name: 'assets/bank7.jpg' },
      
     
      
     
    ]
  }
  

  ngOnInit() {
  }


}
