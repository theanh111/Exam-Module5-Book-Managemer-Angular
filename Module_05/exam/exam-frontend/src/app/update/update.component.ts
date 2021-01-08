import { Component, OnInit } from '@angular/core';
import {Ibook} from '../interface/ibook';
import {BookService} from '../service/book.service';
import {ActivatedRoute, Router} from '@angular/router';
import {FormBuilder, FormGroup} from '@angular/forms';

@Component({
  selector: 'app-update',
  templateUrl: './update.component.html',
  styleUrls: ['./update.component.css']
})
export class UpdateComponent implements OnInit {

  bookId: number;
  book: Ibook;
  updateBookForm: FormGroup;

  constructor(
    private bookService: BookService,
    private router: Router,
    private activatedRouter: ActivatedRoute,
    private fb: FormBuilder
  ) {}

  ngOnInit(): void {
    this.updateBookForm = this.fb.group({
      title: [''],
      author: [''],
      description: ['']
    });
    this.activatedRouter.params.subscribe(params => {
      this.bookId = params.id;
      this.bookService.getBookById(this.bookId).subscribe(result => {
        this.book = result;
        this.updateBookForm.setValue({
          title: result.title,
          author: result.author,
          description: result.description
        });
      });
    });
  }

  updateBook() {
    this.book.title = this.updateBookForm.value.title;
    this.book.author = this.updateBookForm.value.author;
    this.book.description = this.updateBookForm.value.description;
    this.bookService.updateBook(this.book).subscribe(() => {
      alert('Cập nhật sách thành công!');
      this.router.navigate(['']);
    }, error => {
      alert('Lỗi!');
    });
  }
}
