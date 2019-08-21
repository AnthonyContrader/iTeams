import { Injectable } from '@angular/core';
import { AbstractService } from './abstractservice';
import { TeamDTO } from 'src/dto/teamdto';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class TeamServiceextends extends AbstractService<TeamDTO>{

  constructor(http: HttpClient) { 
    super(http);
    this.type = 'team';
  }
}
