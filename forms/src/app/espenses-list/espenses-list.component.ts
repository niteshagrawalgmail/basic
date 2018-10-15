import { Component, OnInit } from '@angular/core';

import { Expenses } from '../expenses';
import { ExpenseService } from '../expense.service';
import { NgxSpinnerService } from 'ngx-spinner';
import { ToasterService } from '../toaster.service';

@Component({
  selector: 'app-espenses-list',
  templateUrl: './espenses-list.component.html',
  styleUrls: ['./espenses-list.component.css']
})
export class EspensesListComponent implements OnInit {

  constructor(private spinner: NgxSpinnerService, private expenseService : ExpenseService,  private toasterService : ToasterService) { }

  expenses : Expenses[] = null;
  totalExpense_THB : number = null;
  totalExpense_INR : number = null;

  ngOnInit() {
    this.getExpenses();   
  }

  getExpenses() : void{

    var _this = this;
    this.spinner.show();
     this.expenseService.getExpenses().subscribe(expenses => this.expenses = expenses,
     error => console.log("Error: ", error),
     () => {
       this.calculateTotalExpense();
       this.spinner.hide();
       this.toasterService.success("Expenses App", "Data fetched successfully");
     }
    );

  }

  calculateTotalExpense(){

    let sum_THB : number = 0;
    let sum_INR : number = 0;
    for (let i of this.expenses) {
      if(i.currency === 'THB'){
        sum_THB = sum_THB + i.amount;
      }
      if(i.currency === 'INR'){
        sum_INR = sum_INR + i.amount;
      }
    }
    this.totalExpense_THB =  sum_THB;
    this.totalExpense_INR =  sum_INR;
  }

  deleteExpense(expense_){

     this.expenseService.deleteExpense(expense_.id).subscribe(response => {
      if(response.status === 204){
        this.toasterService.success("Expenses App", "Data deleted successfully");

        // successfully deleted from server - now remove from client

        for (var i = 0; i < this.expenses.length; i++){
          if (this.expenses[i].id === expense_.id) { 
          this.expenses.splice(i, 1);
          break;
          }
        }
        this.calculateTotalExpense();
      }
    });    
    
  }

}
