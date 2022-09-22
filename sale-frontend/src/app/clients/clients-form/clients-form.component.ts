import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
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

  constructor( private service: ClientService, private router: Router ) {
    this.client = new Client();
   }

  ngOnInit(): void {
  }

  onSubmit() {
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


  backToList(){
    this.router.navigate(['/clients-list'])
  }

}
