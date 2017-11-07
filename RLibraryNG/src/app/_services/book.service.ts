/**
 * Created by manromero on 06/11/2017.
 */
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs/Observable';
import { Http, Response, Headers, RequestOptions } from '@angular/http';
import { Constants } from '../utils/constants';
import 'rxjs/add/operator/catch';
import 'rxjs/add/operator/map';

@Injectable()
export class BookService {

  constructor(private http: Http) {
  }

  /**
   * Devuelve todos los libros ordenados por title asc
   * @returns {Observable<R|T>}
   */
  findAllByTitleAsc(): Observable<String[]> {
    const url = Constants.API_ENDPOINT + 'book/findAllByTitleAsc';
    return this.http.get(url)
      .map((response: Response) => response.json())
      .catch(error => Promise.reject(error));
  }

  /**
   * Devuelve un book por su id
   * @param idBook
   * @returns {Observable<R|T>}
   */
  findById(idBook): Observable<String[]> {
    const url = Constants.API_ENDPOINT + 'book/findById/' + idBook;
    return this.http.get(url)
      .map((response: Response) => response.json())
      .catch(error => Promise.reject(error));
  }

  /**
   * Call to save a book
   * @param filmDto
   */
  save(bookDto: any) {
    const body = JSON.stringify(bookDto);
    const headers = new Headers({'Content-Type': 'application/json'});
    const options = new RequestOptions({ headers: headers });
    const url = Constants.API_ENDPOINT + 'book/save';
    const response = this.http.post(url, body, options).map(res => res.json()).catch(error => Promise.reject(error));
    return response;
  }

  /**
   * Elimina un libro
   * @param idBook
   * @returns {Observable<R|T>}
   */
  delete(idBook: any) {
    const url = Constants.API_ENDPOINT + 'book/delete/' + idBook;
    return this.http.get(url)
      .map((response: Response) => response.json())
      .catch(error => Promise.reject(error));
  }

  /**
   * Call to to upload an image of a books
   * @param idBook
   * @param imageFile
   */
  uploadImage(idBook: any, imageFile: any) {
    const url = Constants.API_ENDPOINT + 'book/uploadImage/' + idBook;
    const response = this.http.post(url, imageFile).map(res => res.json()).catch(error => Promise.reject(error));
    return response;
  }

}
