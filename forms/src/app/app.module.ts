import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule }   from '@angular/forms';

import { AppComponent } from './app.component';
import { ExpensesFormComponent } from './expenses-form/expenses-form.component';
import { HttpClientModule }    from '@angular/common/http';
import { EspensesListComponent } from './espenses-list/espenses-list.component';

// import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
// import { ToastModule } from 'ng2-toastr/ng2-toastr';


@NgModule({
  declarations: [
    AppComponent,
    ExpensesFormComponent,
    EspensesListComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpClientModule
    // BrowserAnimationsModule,
    // ToastModule.forRoot() 
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
