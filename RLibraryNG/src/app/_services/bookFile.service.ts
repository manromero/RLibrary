/**
 * Created by manromero on 07/11/2017.
 */
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs/Observable';
import { Http, Response } from '@angular/http';
import { Constants } from '../utils/constants';
import 'rxjs/add/operator/catch';
import 'rxjs/add/operator/map';

@Injectable()
export class BookFileService {

  constructor(private http: Http) {
  }

  /**
   * Devuelve todos los archivos subidos de un determinado book
   * @param book seleccionado
   * @returns {Observable<R|T>}
   */
  findByIdBook(idBook): Observable<String[]> {
    const url = Constants.API_ENDPOINT + 'bookFile/findByIdBook/' + idBook;
    return this.http.get(url)
      .map((response: Response) => response.json())
      .catch(error => Promise.reject(error));
  }

}