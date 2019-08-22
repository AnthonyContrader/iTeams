import { Component, OnInit } from '@angular/core';
import { SportDTO } from 'src/dto/sportdto';
import { UserDTO } from 'src/dto/userdto';
import { EventDTO } from 'src/dto/eventdto';

/**
 * Componente della dashboard admin. Nell'ngOnInit recupera
 * l'utente loggato per il messaggio di benvenuto.
 */
@Component({
  selector: 'app-user-dashboard',
  templateUrl: './user-dashboard.component.html',
  styleUrls: ['./user-dashboard.component.css']
})
export class UserDashboardComponent implements OnInit {

  //sport: SportDTO;
  user: UserDTO;
  constructor() { }

  ngOnInit() {
	this.user = JSON.parse(localStorage.getItem('currentUser'));
    //this.sport = JSON.parse(localStorage.getItem('currentSport'));
  }

}
