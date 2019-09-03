import { UserDTO } from './userdto';
import { SportDTO } from './sportdto';

export class FeedbackDTO {

    id:number;
    sportName: string;
    creatorName: string;
    rate: number;
    user: UserDTO;
    sport: SportDTO;
}