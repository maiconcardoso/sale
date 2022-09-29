import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-labor-list',
  templateUrl: './labor-list.component.html',
  styleUrls: ['./labor-list.component.css']
})
export class LaborListComponent implements OnInit {

  clientName: string;
  month: number;
  months: number[];

  constructor() { 
    this.months = [1, 2, 3, 4, 5, 6, 7, 8, 10, 11, 12];
  }

  ngOnInit(): void {
  }

  searchClient() {
    console.log(this.clientName, this.month);
  }

}
