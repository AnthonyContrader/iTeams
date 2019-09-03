import { Component, OnInit } from '@angular/core';
import { UserDTO } from 'src/dto/userdto';
import { SportDTO } from 'src/dto/sportdto';

/**
 * Componente della dashboard admin. Nell'ngOnInit recupera
 * l'utente loggato per il messaggio di benvenuto.
 */
@Component({
  selector: 'app-admin-dashboard',
  templateUrl: './admin-dashboard.component.html',
  styleUrls: ['./admin-dashboard.component.css']
})
export class AdminDashboardComponent implements OnInit {

  user: UserDTO;
  sport: SportDTO;

  constructor() { }

  ngOnInit() {
    this.user = JSON.parse(localStorage.getItem('currentUser'));
    this.sport = JSON.parse(localStorage.getItem('currentSport'));
  }

}
