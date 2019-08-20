import { HasEventTargetAddRemove } from 'rxjs/internal/observable/fromEvent';
import { UserDTO } from './userdto';
import { EventDTO } from './eventdto';

export class TeamDTO {

    id: number;
    name: string;
    eventDTO: EventDTO;
    componentsDTO: UserDTO;
    
}