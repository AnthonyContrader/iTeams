import { UserDTO } from './userdto';

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
    teamDTO: ;
}