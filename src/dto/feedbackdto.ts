import { UserDTO } from './userdto';
import { SportDTO } from './sportdto';

export class FeedbackDTO {
    id: number;
    sportDTO: SportDTO;
    userDTO: UserDTO;
    creatorDTO: UserDTO;
    rate: number;





}