import { UserDTO } from './userdto';


export class MessageDTO {

    id:number;
    text: string;    
    sender: UserDTO;
    receiver: UserDTO;
    
}