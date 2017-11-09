import { Component, OnInit, ElementRef, ViewChild } from '@angular/core';
import { BookTypeService, BookService, BookFileService } from '../_services/index';
import { BsModalRef } from 'ngx-bootstrap/modal/bs-modal-ref.service';
import { BsModalService } from 'ngx-bootstrap/modal';
import { FormGroup } from '@angular/forms';
import { FileReaderEvent } from '../utils/fileReaderInterface';
import { saveAs } from 'file-saver/FileSaver';

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
  // Modal
  modalRef: BsModalRef;
  // Book seleccionado
  bookDto: any;
  // Lista de archivos de un determinado book
  listBookFile: any;
  // Variable que indica si se está editando un book
  isBeingEdited = false;
  // Indica si un book se ha eliminado correctamente
  deletedBook = false;
  // Indica si se ha producido un error al guardar el book
  errorSaveBook: any
  // Indica si se esta procesando el guardado del book
  loadingBook = false;
  // Indica si la serie esta guardada en base de datos
  bookSaved = false;
  // Indica si una serie se ha guardado correctamente
  bookModified = false;
  // previsualizacion imagen
  imagePreview: any;
  // Activara y desactivara el boton de guardar imagen cuando se esté editando
  loadingImage = false;
  // Error al subir imagen
  errorImage: any;
  // Imagen añadida correctamente
  okImageAdd = false;

  constructor(
    private bookTypeService: BookTypeService,
    private bookService: BookService,
    private bookFileService: BookFileService,
    private modalService: BsModalService
  ) {
    console.log('Constructor BooksComponent');
    // Cargamos los tipos de book
    this.bookTypeService.findAllByDescriptionDesc().subscribe(data => this.listBookType = data);
    // Por defecto no habrá ningún tipo de book seleccionada
    this.bookTypeSelected = 0;
    // Recuperamos todos los books
    this.bookService.findAllByTitleAsc().subscribe(
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
   * @param bookTypeSelectedId
   */
  changeBookTypeSelected(bookTypeSelectedId: any) {
    this.bookTypeSelected = bookTypeSelectedId;
    this.filterBooksByIdBookTypeAndTitle();
  }

  /**
   * Filtra los books que se encuentran en el listado
   */
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

  /**
   * Abrir modal al seleccionar un libro
   * @param {TemplateRef<any>} templateRef
   * @param idBook
   */
  public openViewModal(templateRef, idBook) {
    this.bookService.findById(idBook).subscribe(
      data => {
        console.log('se ha recuperado el video seleccionado');
        this.bookDto = data;
        // Recuperamos los ficheros de descarga asociados al libro
        this.bookFileService.findByIdBook(idBook).subscribe(data2 => this.listBookFile = data2);
        // El modal no se mostrará en formato edicion
        this.isBeingEdited = false;
        this.modalRef = this.modalService.show(templateRef, Object.assign({class: 'modal-lg'}));
      },
      error => {
        console.log(error);
      },
      () => {
        console.log('Llamada a recuperar book terminada');
      }
    );
  }

  /**
   * Abre el modal para crear un nuevo libro
   * @param templateRef
   */
  createBook(templateRef) {
    // Inicializamos el bookDto
    this.bookDto = {};
    this.bookDto.bookTypeDto = {id: null};
    // El listado de ficheros en un primer momento es vacio
    this.listBookFile = [];
    // Muestra el modal en modo edicion
    this.isBeingEdited = true;
    // Indica que un book se ha eliminado
    this.deletedBook = false;
    // Indica si se ha producido algun error al guardar el book
    this.errorSaveBook = null;
    // Indica si se está procesando el guardado del book
    this.loadingBook = false;
    // El book proviene de base de datos
    this.bookSaved = false;
    // Indica si una serie se ha guardado correctamente
    this.bookModified = false;
    // Indica si una imagen se ha añadido correctamente
    this.okImageAdd = false;
    // Indica si se ha producido un error al añadir una imagen
    this.errorImage = null;
    // No habra ninguna imagen en la preview, al pulsar sobre editar
    this.imagePreview = null;
    // Abre el modal
    this.modalRef = this.modalService.show(templateRef, Object.assign({class: 'modal-lg'}));
  }

  /**
   * Abrir modal
   * @param {TemplateRef<any>} referenciaModal
   */
  public openModal(referenciaModal) {
    this.modalRef = this.modalService.show(referenciaModal);
  }

  /**
   * El modal de visualizacion pasa a verse en modo editicion
   */
  changeToEditMode() {
    // Muestra el modal en modo edicion
    this.isBeingEdited = true;
    // Indica que un book se ha eliminado
    this.deletedBook = false;
    // Indica si se ha producido algun error al guardar el book
    this.errorSaveBook = null;
    // Indica si se está procesando el guardado del book
    this.loadingBook = false;
    // El book proviene de base de datos
    this.bookSaved = true;
    // Indica si una serie se ha guardado correctamente
    this.bookModified = false;
    // Indica si una imagen se ha añadido correctamente
    this.okImageAdd = false;
    // Indica si se ha producido un error al añadir una imagen
    this.errorImage = null;
    // No habra ninguna imagen en la preview, al pulsar sobre editar
    this.imagePreview = null;
  }

  /**
   * Guarda/Actualiza un book si tiene los datos rellenados correctamente
   * @param bookForm
   */
  saveBook(bookForm: FormGroup) {
    console.log('Llamada a saveBook');
    this.errorSaveBook = null;
    if (bookForm.valid) {
      // Desactivaremos el botón de guardar hasta que la llamada al web service haya finalizado
      this.loadingBook = true;
      // Si tiene id y no tiene la version, es porque su valor vale 0
      if (bookForm.value.id && !bookForm.value.version) {
        bookForm.value.version = 0;
      }
      // Creamos el bookTypeDto dentro de bookDto
      const idBookType = bookForm.value.bookTypeDto;
      bookForm.value.bookTypeDto = {id: idBookType};
      this.bookService.save(bookForm.value).subscribe(
        data => {
          this.bookDto = data;
          // Estará bien guardado si no devuelve errores
          this.bookSaved = this.bookDto.errores.length === 0;
          this.bookModified = this.bookSaved;
          if (!this.bookSaved) {
            this.errorSaveBook = 'Se ha producido un error al guardar la seriea';
          } else {
            // Actualizamos el listado de libros
            this.bookService.findAllByTitleAsc().subscribe(
              data2 => {
                this.listFullBook = data2;
                this.filterBooksByIdBookTypeAndTitle();
              },
              error => {
                console.log(error);
              }
            );
          }
        },
        error => {
          this.loadingBook = false;
          this.bookModified = false;
          this.errorSaveBook = 'Se ha producido un error al guardar el libro';
          console.log(error);
        },
        () => {
          this.loadingBook = false;
          console.log('LLamada terminada');
        }
      );

    } else {
      this.errorSaveBook = 'Se ha producido un error al guardar el libro';
      console.log('Error en el formulario de guardar book');
    }
  }

  /**
   * Realiza la llamada al servicio para eliminar un libro
   */
  deleteBook() {
    this.bookService.delete(this.bookDto.id).subscribe(
      result => {
        this.modalRef.hide();
        this.deletedBook = true;
        // Actualizamos el listado de libros
        this.bookService.findAllByTitleAsc().subscribe(
          data => {
            this.listFullBook = data;
            this.filterBooksByIdBookTypeAndTitle();
          },
          error => {
            console.log(error);
          }
        );
      },
      error => {
        console.log(error);
      },
      () => {
        console.log('Llamada terminada');
      }
    );
  }

  /**
   * Previsualizamos imagen
   * @param {Event} imageInput
   */
  previewImage(imageInput: Event) {
    const target = (<HTMLInputElement>imageInput.target);
    if (target.files && target.files[0]) {
      // Imagen a premostrar
      const reader = new FileReader();
      reader.onload = (event: FileReaderEvent) => {
        this.imagePreview = event.target.result;
      };
      reader.readAsDataURL(target.files[0]);
    }
  }

  /**
   * Subir imagen al servidor
   */
  uploadImage() {
    const inputEl: HTMLInputElement = <HTMLInputElement> document.getElementById('portada');
    if (inputEl.files && inputEl.files[0]) {
      this.loadingImage = true;
      const formData = new FormData();
      formData.append('file', inputEl.files[0]);
      this.errorImage = null;
      this.bookService.uploadImage(this.bookDto.id, formData)
        .subscribe(
          result => {
            this.bookDto = result;
            this.okImageAdd = this.bookDto.cover !== undefined && this.bookDto.cover != null;
            if (!this.okImageAdd) {
              this.errorImage = 'Se ha producido un error al subir la imagen';
            }
            this.loadingImage = false;
            // Actualizamos el listado de libros
            this.bookService.findAllByTitleAsc().subscribe(
              data => {
                this.listFullBook = data;
                this.filterBooksByIdBookTypeAndTitle();
              },
              error => {
                console.log(error);
              }
            );
            console.log('File Upload');
          },
          error => {
            this.okImageAdd = false;
            this.errorImage = 'Se ha producido un error al subir la imagen';
            this.loadingImage = false;
            console.log(error);
          },
          () => {
            this.loadingImage = false;
            console.log('Llamada terminada');
          }
        );
    }
  }

  /**
   * Sbuir un fichero asociado a un book
   * @param event
   */
  uploadBookFile(event) {
    const inputEl: HTMLInputElement = <HTMLInputElement> document.getElementById('bookFile');
    if (inputEl.files && inputEl.files[0]) {
      const fileName = inputEl.files[0].name;
      const partsToFormat = fileName.split('.');
      if (partsToFormat != null && partsToFormat.length > 1) {
        const format = partsToFormat[partsToFormat.length - 1];
        const formData = new FormData();
        formData.append('file', inputEl.files[0]);
        this.bookFileService.uploadFile(this.bookDto.id, format, formData).subscribe(
          result => {
            // El fichero se ha subido correctamente
            // Actualizamos la lista de ficheros
            this.bookFileService.findByIdBook(this.bookDto.id).subscribe(data => this.listBookFile = data);
          },
          error => {
            console.log(error);
          },
          () => {
            console.log('Llamada a subir fichero finalizada')
          }
        );
      }
    }
  }

  /**
   * Descarga un book file
   * @param bookFile
   */
  downloadBookFile(bookFileDto) {
    const filename = this.bookDto.title + ' (' + this.bookDto.author + ').' + bookFileDto.format;
    fetch('data:application/' + bookFileDto.format + ';base64,' + bookFileDto.file)
      .then(function(resp) {return resp.blob()})
      .then(function(blob) {
        saveAs(blob, filename)
      });
  }

  /**
   * Elimina un bookFile
   * @param idBookFile
   */
  deleteBookFile(idBookFile) {
    this.bookFileService.delete(idBookFile).subscribe(
      data => {
        // Actualizamos la lista de fichero de un book
        this.bookFileService.findByIdBook(this.bookDto.id).subscribe(data2 => this.listBookFile = data2);
      },
      error => {
        console.log(error)
      }
    );
  }

}
