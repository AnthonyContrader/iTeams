import { FeedbackDTO } from './feedbackdto';
import { UserDTO } from './userdto';

export class SportDTO {

    id: number;
    name: string;
    players: number;
    sportfeedDTO: FeedbackDTO[];
    likes: UserDTO[];
}