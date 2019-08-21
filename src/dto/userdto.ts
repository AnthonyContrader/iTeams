import {Usertype} from './usertype';
import { EventDTO } from './eventdto';
import { TeamDTO } from './teamdto';
import { SportDTO } from './sportdto';
import { FeedbackDTO } from './feedbackdto';

/**
 * Classe DTO di User. DEVE essere uguale (stesso nome classe, stessi attributi e stessi nomi) a
 * quello nel backend. 
 * 
 * @see Usertype
 * 
 * @author Vittorio Valent
 */
export class UserDTO {

   id: number;

   username: string;

   password: string;

   usertype: Usertype;

   status: boolean;

   createdEventsDTO: EventDTO;

   joinEventDTO: EventDTO;

   invitedEventDTO: EventDTO;

   memberOfDTO: TeamDTO;

   likeDTO: SportDTO;

   givedDTO: FeedbackDTO;

   receivedDTO: FeedbackDTO;
}