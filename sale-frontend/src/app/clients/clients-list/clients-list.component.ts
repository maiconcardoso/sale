import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ClientService } from 'src/app/services/client.service';
import { Client } from '../clients';

@Component({
  selector: 'app-clients-list',
  templateUrl: './clients-list.component.html',
  styleUrls: ['./clients-list.component.css']
})
export class ClientsListComponent implements OnInit {

  clients: Client[] = [];

  constructor( private service: ClientService, private router: Router ) { }

  ngOnInit(): void {
    this.service.findAll().subscribe( response => {
      this.clients = response;
    })
  }

  saveClient(){
    this.router.navigate(['/clients-form']);
  }

}
