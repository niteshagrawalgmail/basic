import { Component, OnInit } from '@angular/core';

import { Expenses } from '../expenses';
import { ExpenseService } from '../expense.service';

@Component({
  selector: 'app-expenses-form',
  templateUrl: './expenses-form.component.html',
  styleUrls: ['./expenses-form.component.css']
})
export class ExpensesFormComponent implements OnInit {

  constructor(private expenseService : ExpenseService) { }

  categories = ['Shopping' , 'Travel' , 'Food' , 'Other' ];


  

  model = new Expenses(0, 0.0, 17091982, "THB", "Choose Category", "");

  submitted = false;

  onSubmit(){
    this.submitted = true;
    console.log(JSON.stringify(this.model));
    this.expenseService.addExpense(this.model);
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