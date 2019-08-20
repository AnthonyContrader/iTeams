import { EventDTO } from './eventdto';
import { UserDTO } from './userdto';
import { FeedbackDTO } from './feedbackdto';

export class SportDTO {

    id: number;
 
    name: string;
 
    players: number;

    eventsDTO: EventDTO;
    likesDTO: UserDTO;
    sportfeedDTO: FeedbackDTO;
 
 }