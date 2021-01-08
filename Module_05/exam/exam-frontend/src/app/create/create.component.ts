import { Component, OnInit } from '@angular/core';
import {BookService} from '../service/book.service';
import {FormBuilder, FormGroup} from '@angular/forms';
import {Router} from '@angular/router';
import {Ibook} from '../interface/ibook';

@Component({
  selector: 'app-create',
  templateUrl: './create.component.html',
  styleUrls: ['./create.component.css']
})
export class CreateComponent implements OnInit {

  createBookForm: FormGroup;
  constructor(
    private bookService: BookService,
    private router: Router,
    private fb: FormBuilder
  ) {}

  ngOnInit(): void {
    this.createBookForm = this.fb.group({
      title: [null],
      author: [null],
      description: [null]
    });
  }

  createBook() {
    let newBook: Ibook;
    newBook = this.createBookForm.value;
    this.bookService.createBook(newBook).subscribe(() => {
      alert('Thêm mới sách thành công!');
      this.router.navigate(['']);
    }, error => {
      alert('Lỗi!');
    });
  }
}
