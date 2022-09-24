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
  selectClient: Client;
  successMessage: string = '';
  errorMessage: string = '';

  constructor( private service: ClientService, private router: Router, ) {
    this.selectClient = new Client();
   }

  ngOnInit(): void {
    this.service.findAll().subscribe( response => {
      this.clients = response;
    })
  }

  saveClient(){
    this.router.navigate(['/clients-form']);
  }

  openModalClientDelete(client: Client) {
    this.selectClient = client;
  }

  deleteClient() {
    this.service.delete(this.selectClient).subscribe(response =>  {
      this.successMessage = "Cliente deletado com sucesso!",
      this.ngOnInit()
    }, error => this.errorMessage = "Erro ao tentar deletar o cliente.") 
  }

}
