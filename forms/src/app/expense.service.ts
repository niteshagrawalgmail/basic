import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders, HttpResponse } from '@angular/common/http';

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


//   addExpense (expense: Expenses): void {
//   console.log(expense);
//   this.http.post<Expenses>(this.expenseUrl, expense, httpOptions).subscribe(r=>{});

// }

addExpense (expense: Expenses): Observable<HttpResponse<Object>>  {
  console.log(expense);
  return this.http.post(this.expenseUrl, expense, { observe: 'response' } );
}

deleteExpense (id: number): Observable<HttpResponse<Object>> {
  const url = `${this.expenseUrl}/${id}`;
  return this.http.delete(url, { observe: 'response' });
}

/** GET expenses from the server */
getExpenses (): Observable<Expenses[]> {
  return this.http.get<Expenses[]>(this.expenseUrl)
}


}
