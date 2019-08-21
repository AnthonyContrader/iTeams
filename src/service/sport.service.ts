import { Injectable } from '@angular/core';
import { AbstractService } from './abstractservice';
import { SportDTO } from 'src/dto/sportdto';
import { HttpClient } from '@angular/common/http';


@Injectable({
  providedIn: 'root'
})
export class SportService extends AbstractService<SportDTO>{

  constructor(http: HttpClient) {
    super(http);
    this.type = 'sport';
  }
}
