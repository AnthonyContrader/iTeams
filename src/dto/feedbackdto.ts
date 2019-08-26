import { UserDTO } from './userdto';

export class FeedbackDTO {

    id:number;
    sportName: string;
    creatorName: string;
    rate: number;
    user: UserDTO;
}