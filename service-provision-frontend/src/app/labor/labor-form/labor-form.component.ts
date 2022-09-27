import { Component, OnInit } from '@angular/core';
import { Client } from 'src/app/clients/clients';
import { ClientService } from 'src/app/services/client.service';
import { Labor } from '../labor';

@Component({
  selector: 'app-labor-form',
  templateUrl: './labor-form.component.html',
  styleUrls: ['./labor-form.component.css']
})
export class LaborFormComponent implements OnInit {

  clients: Client[] = [];
  labor: Labor;

  constructor(private clientService: ClientService) { 
    this.labor = new Labor();
  }

  ngOnInit(): void {
    this.clientService.findAll().subscribe((response) => {
      this.clients = response;
    })
  }

  onSubmit(){
    console.log(this.labor);
  }

}
