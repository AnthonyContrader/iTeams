import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-user-menu',
  templateUrl: './user-menu.component.html',
  styleUrls: ['./user-menu.component.css']
})
export class UserMenuComponent implements OnInit {

  isClientCollapsed = false;
  isAccountCollapsed = false;
  isEventCollapsed = false;
  isSportCollapsed = false;
  isTeamCollapsed = false;


  constructor(private router: Router) {
  }

  ngOnInit() {
  }

  logout() {
    localStorage.clear();
    this.router.navigateByUrl('');
  }


  sportscollapse() {
    if (this.isSportCollapsed === false) {
      this.isSportCollapsed = true;
    } else { this.isSportCollapsed = false; }
  }

  eventscollapse() {
    if (this.isEventCollapsed === false) {
      this.isEventCollapsed = true;
    } else { this.isEventCollapsed = false; }
  }

  teamscollapse() {
    if (this.isTeamCollapsed === false) {
      this.isTeamCollapsed = true;
    } else { this.isTeamCollapsed = false; }
  }

  accountcollapse() {
    if (this.isAccountCollapsed === false) {
      this.isAccountCollapsed = true;
    } else { this.isAccountCollapsed = false; }
  }
}
