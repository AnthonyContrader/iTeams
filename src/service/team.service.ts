import { Injectable } from '@angular/core';
import { AbstractService } from './abstractservice';
import { HttpClient } from '@angular/common/http';
import { TeamDTO } from 'src/dto/teamdto';

@Injectable({
  providedIn: 'root'
})
export class TeamService extends AbstractService<TeamDTO>{


  constructor(http: HttpClient) { 
    super(http);
    this.type = 'team';
  }
}
