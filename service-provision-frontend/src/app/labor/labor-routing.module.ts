import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LaborFormComponent } from './labor-form/labor-form.component';
import { LaborListComponent } from './labor-list/labor-list.component';

const routes: Routes = [
  { path: 'labor-form', component: LaborFormComponent },
  { path: 'labor-list', component: LaborListComponent }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class LaborRoutingModule { }
