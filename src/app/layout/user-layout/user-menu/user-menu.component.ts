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
  isFeedbackCollapsed = false;
  isMessageCollapsed = false;
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

      this.isClientCollapsed = false;
      this.isAccountCollapsed = false;
      this.isEventCollapsed = false;
      this.isFeedbackCollapsed = false;
      this.isTeamCollapsed = false;
      this.isMessageCollapsed = false;

    } else { this.isSportCollapsed = false; }
  }

  eventscollapse() {
    if (this.isEventCollapsed === false) {
      this.isEventCollapsed = true;

      this.isSportCollapsed = false;
      this.isClientCollapsed = false;
      this.isAccountCollapsed = false;
      this.isFeedbackCollapsed = false;
      this.isTeamCollapsed = false;
      this.isMessageCollapsed = false;

    } else { this.isEventCollapsed = false; }
  }

  teamscollapse() {
    if (this.isTeamCollapsed === false) {
      this.isTeamCollapsed = true;

      this.isSportCollapsed = false;
      this.isClientCollapsed = false;
      this.isAccountCollapsed = false;
      this.isEventCollapsed = false;
      this.isFeedbackCollapsed = false;
      this.isMessageCollapsed = false;

    } else { this.isTeamCollapsed = false; }
  }

  feedbackscollapse() {
    if (this.isFeedbackCollapsed === false) {
      this.isFeedbackCollapsed = true;

      this.isSportCollapsed = false;
      this.isClientCollapsed = false;
      this.isAccountCollapsed = false;
      this.isEventCollapsed = false;
      this.isTeamCollapsed = false;
      this.isMessageCollapsed = false;

    } else { this.isFeedbackCollapsed = false; }
  }

  messagescollapse() {
    if (this.isMessageCollapsed === false) {
      this.isMessageCollapsed = true;

      this.isSportCollapsed = false;
      this.isClientCollapsed = false;
      this.isAccountCollapsed = false;
      this.isEventCollapsed = false;
      this.isTeamCollapsed = false;
      this.isFeedbackCollapsed = false;

    } else { this.isMessageCollapsed = false; }
  }

  accountcollapse() {
    if (this.isAccountCollapsed === false) {
      this.isAccountCollapsed = true;

      this.isSportCollapsed = false;
      this.isClientCollapsed = false;
      this.isEventCollapsed = false;
      this.isFeedbackCollapsed = false;
      this.isTeamCollapsed = false;
      this.isMessageCollapsed = false;


    } else { this.isAccountCollapsed = false; }
  }
}
