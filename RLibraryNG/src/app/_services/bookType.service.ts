/**
 * Created by manromero on 06/11/2017.
 */
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs/Observable';
import { Http, Response } from '@angular/http';
import { Constants } from '../utils/constants';
import 'rxjs/add/operator/catch';
import 'rxjs/add/operator/map';

@Injectable()
export class BookTypeService {

  constructor(private http: Http) {
  }

  /**
   * Devuelve todos los tipos de libros ordenados por descripcion desc
   * @returns {Observable<R|T>}
   */
  findAllByDescriptionDesc(): Observable<String[]> {
    const url = Constants.API_ENDPOINT + 'bookType/findAllByDescriptionDesc';
    return this.http.get(url)
      .map((response: Response) => response.json())
      .catch(error => Promise.reject(error));
  }

}
