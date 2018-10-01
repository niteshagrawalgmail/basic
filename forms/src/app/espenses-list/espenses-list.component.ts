import { Component, OnInit } from '@angular/core';

import { Expenses } from '../expenses';
import { ExpenseService } from '../expense.service';

@Component({
  selector: 'app-espenses-list',
  templateUrl: './espenses-list.component.html',
  styleUrls: ['./espenses-list.component.css']
})
export class EspensesListComponent implements OnInit {

  constructor(private expenseService : ExpenseService) { }

  expenses : Expenses[] = null;
  totalExpense : number = null;

  ngOnInit() {

    this.getExpenses();

    // if(this.expenses){
    //   this.totalExpense = this.calculateTotalExpense();
    // }
    
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

}
