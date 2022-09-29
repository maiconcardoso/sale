import { Component, OnInit } from '@angular/core';
import { LaborService } from 'src/app/services/labor.service';
import { LaborProvision } from './labor-provision';

@Component({
  selector: 'app-labor-list',
  templateUrl: './labor-list.component.html',
  styleUrls: ['./labor-list.component.css']
})
export class LaborListComponent implements OnInit {

  clientName: string;
  month: number;
  months: number[];
  laborList: LaborProvision[] = [];
  message: any;

  constructor(private laborService: LaborService) { 
    this.months = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12];
  }

  ngOnInit(): void {
  }

  searchClient() {
    this.laborService.searchLaborByClientName(this.clientName, this.month).subscribe(response => {
      this.laborList = response;
      if (this.laborList.length <= 0) {
        this.message = "Elementos não encontrados.";
      } else {
        this.message = null;
      }
    })
  }

}
