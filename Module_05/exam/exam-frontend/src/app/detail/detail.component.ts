import { Component, OnInit } from '@angular/core';
import {Ibook} from '../interface/ibook';
import {BookService} from '../service/book.service';
import {ActivatedRoute} from '@angular/router';

@Component({
  selector: 'app-detail',
  templateUrl: './detail.component.html',
  styleUrls: ['./detail.component.css']
})
export class DetailComponent implements OnInit {

  book: Ibook;
  constructor(
    private bookService: BookService,
    private activatedRouter: ActivatedRoute
  ) { }

  ngOnInit(): void {
    this.activatedRouter.paramMap.subscribe(params => {
      const id = params.get('id');
      this.getBookById(id);
    });
  }

  getBookById(id) {
    this.bookService.getBookById(id).subscribe(result =>{
      this.book = result;
    });
  }
}
