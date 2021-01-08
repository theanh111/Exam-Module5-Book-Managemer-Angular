import { Component, OnInit } from '@angular/core';
import {BookService} from '../service/book.service';
import {Router} from '@angular/router';
import {Ibook} from '../interface/ibook';

@Component({
  selector: 'app-list',
  templateUrl: './list.component.html',
  styleUrls: ['./list.component.css']
})
export class ListComponent implements OnInit {

  bookList: Ibook[];
  constructor(
    private bookService: BookService,
    private router: Router
  ) { }

  ngOnInit(): void {
    this.getAllBooks();
  }

  getAllBooks(): Ibook[] {
    this.bookService.getAllBooks().subscribe((result: any) =>  {
      this.bookList = result;
    });
    return this.bookList;
  }

}
