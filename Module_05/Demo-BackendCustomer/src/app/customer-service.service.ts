import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {ICustomer} from './icustomer';

@Injectable({
  providedIn: 'root'
})
export class CustomerServiceService {
  private URL_API = 'http://localhost:8080/users-list';
  private URL_API_CREATE = 'http://localhost:8080/users-create';
  constructor(private http: HttpClient) { }
  getAllCustomers(): Observable<any> {
    return this.http.get(this.URL_API);
  }

  create(customer: ICustomer): Observable<ICustomer> {
    return this.http.post<ICustomer>(this.URL_API_CREATE, customer);
  }
}
