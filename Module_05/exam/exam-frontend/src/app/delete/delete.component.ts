import { Component, OnInit } from '@angular/core';
import {BookService} from '../service/book.service';
import {ActivatedRoute, Router} from '@angular/router';
import {Ibook} from '../interface/ibook';

@Component({
  selector: 'app-delete',
  templateUrl: './delete.component.html',
  styleUrls: ['./delete.component.css']
})
export class DeleteComponent implements OnInit {

  book: Ibook;
  bookId: number;
  constructor(
    private bookService: BookService,
    private activatedRouter: ActivatedRoute,
    private router: Router
  ) { }

  ngOnInit(): void {
    this.activatedRouter.paramMap.subscribe(params => {
      const id = params.get('id');
      this.bookId = Number(id);
      this.getBookById(this.bookId);
    });
  }

  deleteBook() {
    this.bookService.deleteBook(this.bookId).subscribe(() => {
      this.router.navigate(['']);
    });
  }

  getBookById(id) {
    this.bookService.getBookById(id).subscribe(result => {
      this.book = result;
    });
  }
}
