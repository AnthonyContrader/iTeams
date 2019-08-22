import { Injectable } from '@angular/core';
import { AbstractService } from './abstractservice';
import { HttpClient } from '@angular/common/http';
import { SportDTO } from 'src/dto/sportdto';


@Injectable({
  providedIn: 'root'
})
export class SportService extends AbstractService<SportDTO>{

  constructor(http: HttpClient) { 
    super(http);
    this.type = 'sport';
  }
}
