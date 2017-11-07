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

  /**
   * Elimina un libro fichero de un libro
   * @param idBookFile
   * @returns {Observable<R|T>}
   */
  delete(idBookFile: any) {
    const url = Constants.API_ENDPOINT + 'bookFile/delete/' + idBookFile;
    return this.http.get(url)
      .map((response: Response) => response.json())
      .catch(error => Promise.reject(error));
  }

  /**
   * Call to to upload a file to the book
   * @param idBook
   * @param format
   * @param file
   */
  uploadFile(idBook: any, format: any, file: any) {
    const url = Constants.API_ENDPOINT + 'bookFile/uploadFile/' + idBook + '/' + format;
    const response = this.http.post(url, file).map(res => res.json()).catch(error => Promise.reject(error));
    return response;
  }

}
