import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { ClientService } from 'src/app/services/client.service';
import { Client } from '../clients';

@Component({
  selector: 'app-clients-form',
  templateUrl: './clients-form.component.html',
  styleUrls: ['./clients-form.component.css']
})
export class ClientsFormComponent implements OnInit {

  client: Client;
  success: boolean = false;
  errors: string[] = [];

  constructor( private service: ClientService, private router: Router, private activatedRoute: ActivatedRoute ) {
    this.client = new Client();
   }

  ngOnInit(): void {
    const id = JSON.parse(this.activatedRoute.snapshot.paramMap.get('id')!);
    if (id != null) {
      this.service.findById(id).subscribe(response => {
        this.client = response;
      })
    }
    
  }

  onSubmit() {
    if (this.client.id) {
      this.service.update(this.client).subscribe(response => {
        this.client = response;
        this.success = true;
        this.errors = [];
      }, errorResponse => {
        this.errors = ['Erro ao atualizar o cliente']
      })
    }

    if (!this.client.id) {
      this.service.save(this.client).subscribe(response => {
        this.client = response;
        this.success = true;
        this.errors = [];
        this.client = response;
      }, errorResponse => {
        this.success = false;
        this.errors = errorResponse.error.errors;
      })
    }
  }


  backToList(){
    this.router.navigate(['/clients-list'])
  }

}
