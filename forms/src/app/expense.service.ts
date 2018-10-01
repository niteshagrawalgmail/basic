import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';

import { Expenses } from './expenses';
import { Observable, of } from 'rxjs';
import { catchError, map, tap } from 'rxjs/operators';


const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};

@Injectable({
  providedIn: 'root'
})
export class ExpenseService {

  private expenseUrl = 'api/1.0/expenses'; 

  constructor(private http: HttpClient) { }


  addExpense (expense: Expenses): void {
  console.log(expense);
  this.http.post<Expenses>(this.expenseUrl, expense, httpOptions).subscribe(r=>{});

}

/** GET expenses from the server */
getExpenses (): Observable<Expenses[]> {
  return this.http.get<Expenses[]>(this.expenseUrl)
}

}
