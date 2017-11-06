import { Component, OnInit } from '@angular/core';
import { BookTypeService } from '../_services/index';

@Component({
  templateUrl: './books.component.html',
  styleUrls: ['./books.component.css']
})
export class BooksComponent implements OnInit {

  constructor(
    private bookTypeService: BookTypeService
  ) {
    console.log('Constructor BooksComponent');
  }

  ngOnInit() {
    console.log('NgOnInit BooksComponent');
  }

}
