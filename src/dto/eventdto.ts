import { UserDTO } from './userdto';
import { SportDTO } from './sportdto';

export class EventDTO {

   id: number;

   sportName: string;

   rate: number;

   city: string;

   address: string;

   matchtime: string;

   status: boolean;

   creator: UserDTO;
}

