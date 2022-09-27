import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { LaborRoutingModule } from './labor-routing.module';
import { LaborFormComponent } from './labor-form/labor-form.component';
import { LaborListComponent } from './labor-list/labor-list.component';
import { FormsModule } from '@angular/forms';
import { RouterModule } from '@angular/router';


@NgModule({
  declarations: [
    LaborFormComponent,
    LaborListComponent
  ],
  imports: [
    CommonModule,
    LaborRoutingModule,
    FormsModule,
    RouterModule
  ],
  exports: [
    LaborFormComponent,
    LaborListComponent
  ]
})
export class LaborModule { }
