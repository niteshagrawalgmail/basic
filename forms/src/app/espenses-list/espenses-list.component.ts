import { Component, OnInit } from '@angular/core';

import { Expenses } from '../expenses';
import { ExpenseService } from '../expense.service';
import { NgxSpinnerService } from 'ngx-spinner';

@Component({
  selector: 'app-espenses-list',
  templateUrl: './espenses-list.component.html',
  styleUrls: ['./espenses-list.component.css']
})
export class EspensesListComponent implements OnInit {

  constructor(private spinner: NgxSpinnerService, private expenseService : ExpenseService) { }

  expenses : Expenses[] = null;
  totalExpense : number = null;

  ngOnInit() {

    /** spinner starts on init */
    this.spinner.show();

    this.getExpenses();

    // if(this.expenses){
    //   this.totalExpense = this.calculateTotalExpense();
    // }
    setTimeout(() => {
        /** spinner ends after 5 seconds */
        this.spinner.hide();
    }, 1000);
    
  }

  getExpenses() : void{

     this.expenseService.getExpenses().subscribe(expenses => this.expenses = expenses,
     error => console.log("Error: ", error),
      () => this.calculateTotalExpense()  
      );

  }

  calculateTotalExpense(){

    let sum : number = 0;
    for (let i of this.expenses) {
        sum = sum + i.amount;
    }
    this.totalExpense =  sum;
  }

  deleteExpense(expense_){
    
    // first remove from model then make serve call to delete 
    for (var i = 0; i < this.expenses.length; i++)
    if (this.expenses[i].id === expense_.id) { 
        this.expenses.splice(i, 1);
        break;
    }
    this.calculateTotalExpense();
  }

}
