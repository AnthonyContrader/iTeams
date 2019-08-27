import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { UserLayoutComponent } from '../layout/user-layout/user-layout.component';
import { UserDashboardComponent } from './user-dashboard/user-dashboard.component';
//import { UsersComponent } from './users/users.component';
import { SportsComponent } from './sports/sports.component';
import { SportsLikedComponent } from './sports/sports-liked.component';
import { EventsComponent } from './events/events.component';
import { TeamsComponent } from './teams/teams.component';
import { FeedbacksComponent } from './feedbacks/feedbacks.component';
import { AccountsComponent } from './accounts/accounts.component';
import { FeedbacksReceivedComponent } from './feedbacks/feedbacks-received.component';
import { MessagesSentComponent } from './messages/messages-sent.component';
import { MessagesSendComponent } from './messages/messages-send.component';
import { MessagesReceivedComponent } from './messages/messages-received.component';
import { WorkInProgressComponent } from './work-in-progress/work-in-progress.component';


/**
 * Modulo di routing dell'admin. Qui ci sono i percorsi che un admin può seguire:
 * appena fa il login viene caricato nel <router-outlet> di app-component il layout e nel 
 * <router-outlet> del layout (come percorsi "children") vengono visualizzati gli altri 
 * (qui sotto sono indentati).
 * 
 * @author Vittorio Valent
 * 
 * @see AdminLayoutComponent
 * 
 * @see layout
 */
const routes: Routes = [
  { path: 'user-dashboard', component: UserLayoutComponent, children:[
    { path: '', component: UserDashboardComponent},
    { path: 'accounts', component: AccountsComponent},
    { path: 'sports', component: SportsComponent},
    { path: 'sports-liked', component: SportsLikedComponent }, 
    { path: 'events', component: EventsComponent},
    { path: 'teams', component: TeamsComponent},
    { path: 'feedbacks', component: FeedbacksComponent},
    { path: 'feedbacks-received', component: FeedbacksReceivedComponent},
    { path: 'messages-sent', component: MessagesSentComponent},
    { path: 'messages-received', component: MessagesReceivedComponent},
    { path: 'messages-send', component: MessagesSendComponent},
    { path: 'work-in-progress', component: WorkInProgressComponent}
  ]}
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class UserRoutingModule { }