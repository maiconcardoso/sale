import { Component, OnInit } from '@angular/core';
import { Client } from 'src/app/clients/clients';
import { ClientService } from 'src/app/services/client.service';
import { LaborService } from 'src/app/services/labor.service';
import { Labor } from '../labor';

@Component({
  selector: 'app-labor-form',
  templateUrl: './labor-form.component.html',
  styleUrls: ['./labor-form.component.css']
})
export class LaborFormComponent implements OnInit {

  clients: Client[] = [];
  labor: Labor;
  success: boolean = false;
  errors: string[] = [];

  constructor(private clientService: ClientService, private laborService: LaborService) {
    this.labor = new Labor();
  }

  ngOnInit(): void {
    this.clientService.findAll().subscribe((response) => {
      this.clients = response;
    })
    
  }

  onSubmit() {
    this.laborService.save(this.labor).subscribe(response => {
      console.log(response);
      this.labor = response;
      this.success = true;
      this.errors = [];
    }, errorsResponse => {
      this.success = false;
      this.errors = errorsResponse.error.errors;
    })
  }

}
