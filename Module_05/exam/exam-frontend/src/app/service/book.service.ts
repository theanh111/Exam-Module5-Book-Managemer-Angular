import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Ibook} from '../interface/ibook';
import {Observable} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class BookService {

  private API_URL = 'http://localhost:3000/books';
  constructor(private http: HttpClient) { }

  getAllBooks(): Observable<any> {
    return this.http.get(this.API_URL);
  }

  getBookById(id: number): Observable<any> {
    return this.http.get(this.API_URL + `/${id}`);
  }

  createBook(book: Ibook): Observable<any> {
    return this.http.post(this.API_URL, book);
  }

  updateBook(book: Ibook): Observable<any> {
    return this.http.put(this.API_URL + `/${book.id}`, book);
  }

  deleteBook(id: number): Observable<any> {
    return this.http.delete(this.API_URL + `/${id}`);
  }
}
