import { Component, OnInit } from '@angular/core';
import { BookTypeService, BookService } from '../_services/index';

@Component({
  templateUrl: './books.component.html',
  styleUrls: ['./books.component.css']
})
export class BooksComponent implements OnInit {

  // Listado de tipos de books
  listBookType: any;
  // Tipo de book seleccionado
  bookTypeSelected: any;
  // Listado de books
  listFullBook: any;
  // Listado de books que se muestran
  listBook: any;
  // Filtro por el titulo
  filtroTitle: any;

  constructor(
    private bookTypeService: BookTypeService,
    private bookService: BookService
  ) {
    console.log('Constructor BooksComponent');
    // Cargamos los tipos de book
    this.bookTypeService.findAllByDescriptionDesc().subscribe(data => this.listBookType = data);
    // Por defecto no habrá ningún tipo de book seleccionada
    this.bookTypeSelected = 0;
    // Recuperamos todos los books
    this.bookService.findAllByTitleDesc().subscribe(
      data => {
        this.listFullBook = data;
        this.listBook = data;
      },
      error => {
        console.log(error);
      }
    );
    // En un primer momento el filtro del title
    this.filtroTitle = '';
  }

  ngOnInit() {
    console.log('NgOnInit BooksComponent');
  }

  /**
   * Cambia el tipo de categoria seleccionada
   * @param typeFilmSelectedId
   */
  changeBookTypeSelected(bookTypeSelectedId: any) {
    this.bookTypeSelected = bookTypeSelectedId;
    this.filterBooksByIdBookTypeAndTitle();
  }

  filterBooksByIdBookTypeAndTitle() {
    console.log('Filtro Books');
    // Si el filtro por title es vacio solo filtro por tipo
    if (this.filtroTitle === '') {
      // Si el filtro por tipo es 0 devuelvo todas los libros, si no filtro por tipo
      if (this.bookTypeSelected === 0) {
        this.listBook = this.listFullBook;
      } else {
        this.listBook = [];
        for (const book of this.listFullBook) {
          if (book.bookTypeDto.id === this.bookTypeSelected ) {
            this.listBook.push(book);
          }
        }
      }
    }else {
      // Si el filtro de title no es vacio y el filtro de tipo es 0, solo filtro por su title
      if (this.bookTypeSelected === 0) {
        this.listBook = [];
        for (const book of this.listFullBook) {
          if (book.title.toLowerCase().includes(this.filtroTitle.toLowerCase())) {
            this.listBook.push(book);
          }
        }
      } else {
        // Si el filtro de title no es vacio y el de tipo no es 0, filtro por los dos tipos
        this.listBook = [];
        for (const book of this.listFullBook) {
          if (book.bookTypeDto.id === this.bookTypeSelected &&  book.title.toLowerCase().includes(this.filtroTitle.toLowerCase())) {
            this.listBook.push(book);
          }
        }
      }
    }
  }

}
