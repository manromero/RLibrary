import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpModule } from '@angular/http';
import { RouterModule, Routes } from '@angular/router';
import { FormsModule } from '@angular/forms';
import { CustomFormsModule } from 'ng2-validation';

import { ButtonsModule } from 'ngx-bootstrap/buttons';
import { ModalModule } from 'ngx-bootstrap/modal';

import { AppComponent } from './app.component';

import { Constants } from './utils/constants';
import { BooksComponent } from './books/books.component';
import { BookTypeService, BookService, BookFileService } from './_services/index';

const appRoutes: Routes = [
  { path: '', component: BooksComponent },
  { path: Constants.RUTA_LISTADO_BOOKS, component: BooksComponent },
  { path: '**', redirectTo: Constants.RUTA_LISTADO_BOOKS }
];

@NgModule({
  declarations: [
    AppComponent,
    BooksComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    CustomFormsModule,
    HttpModule,
    RouterModule.forRoot(appRoutes),
    ButtonsModule.forRoot(),
    ModalModule.forRoot()
  ],
  providers: [
    BookTypeService,
    BookService,
    BookFileService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
