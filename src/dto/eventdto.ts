import { UserDTO } from './userdto';
import { TeamDTO } from './teamdto';

export class EventDTO {

    id: number;
    sportName: string;
    rate: number;
    city: string;
    address: string;
    matchtime: string;
    status: boolean;
    joinersInt: number;
    joinersDTO: UserDTO;
    invitedDTO: UserDTO;
    teamDTO: TeamDTO;
    
}