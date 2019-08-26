import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { UserRoutingModule } from './user-routing.module';
import { UserDashboardComponent } from './user-dashboard/user-dashboard.component';
import { SportsComponent } from './sports/sports.component';
import { EventsComponent } from './events/events.component';
import { TeamsComponent } from './teams/teams.component';
import { AccountsComponent } from './accounts/accounts.component';
import { FeedbacksComponent } from './feedbacks/feedbacks.component';
import { FeedbacksReceivedComponent } from './feedbacks/feedbacks-received.component';
import { WorkInProgressComponent } from './work-in-progress/work-in-progress.component';

/**
 * Modulo dell'admin, qui vengono dichiarate le component che utilizza 
 * l'admin. Questo modulo importa AdminRoutingModule.
 * 
 * @author Vittorio Valent
 * 
 * @see AdminRoutingModule
 */
@NgModule({
  declarations: [UserDashboardComponent, /*UsersComponent,*/ WorkInProgressComponent, SportsComponent, 
    AccountsComponent, EventsComponent, FeedbacksReceivedComponent, TeamsComponent, FeedbacksComponent],
  imports: [
    CommonModule,
    UserRoutingModule,
    FormsModule
  ]
})
export class UserModule { }
