import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { EspensesListComponent } from './espenses-list/espenses-list.component';
import { ExpensesFormComponent } from './expenses-form/expenses-form.component';
import { HomeComponent } from './home/home.component';

const routes: Routes = [
  { path: '', component: HomeComponent, pathMatch: 'full' },
  { path: 'expenses', component: EspensesListComponent },
  { path: 'expenses/create', component: ExpensesFormComponent }
];

@NgModule({
  exports: [ RouterModule ],
  imports: [ RouterModule.forRoot(routes) ],
})
export class AppRoutingModule { }
