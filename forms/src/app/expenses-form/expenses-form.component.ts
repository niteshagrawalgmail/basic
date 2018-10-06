import { Component, OnInit } from '@angular/core';

import { Expenses } from '../expenses';
import { ExpenseService } from '../expense.service';
import { ToasterService } from '../toaster.service';
import { NgxSpinnerService } from 'ngx-spinner';


@Component({
  selector: 'app-expenses-form',
  templateUrl: './expenses-form.component.html',
  styleUrls: ['./expenses-form.component.css']
})
export class ExpensesFormComponent implements OnInit {

  constructor(private spinner: NgxSpinnerService, private expenseService : ExpenseService, private toasterService : ToasterService) { }

  categories = ['Shopping' , 'Travel' , 'Food' , 'Other' ];


  

  model = new Expenses(0, 0.0, 17091982, "THB", "Choose Category", "");

  submitted = false;

  onSubmit(){

    
    this.spinner.show();
    this.submitted = true;
    console.log(JSON.stringify(this.model));
    this.expenseService.addExpense(this.model).subscribe(response => {

      if(response.status === 200){
        this.spinner.hide();
        this.toasterService.success("Expenses App", "Data saved successfully");
      }
    });
    this.resetData();
  }

  ngOnInit() {
  }

  resetData(){
    this.model = new Expenses(0 , 0.0, 17091982, "THB", "Choose Category", "");
  }


 

  // get diagnostic(){
  //   return JSON.stringify(this.model);
  // }

}