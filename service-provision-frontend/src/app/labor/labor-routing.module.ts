import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LayoutComponent } from '../layout/layout.component';
import { LaborFormComponent } from './labor-form/labor-form.component';
import { LaborListComponent } from './labor-list/labor-list.component';

const routes: Routes = [
  { path: 'labors', component: LayoutComponent, children: [
    { path: 'form', component: LaborFormComponent },
    { path: 'list', component: LaborListComponent },
    { path: '', redirectTo: '/labors/list', pathMatch: 'full' }
  ] }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class LaborRoutingModule { }
