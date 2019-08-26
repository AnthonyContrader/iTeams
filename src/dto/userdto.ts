import {Usertype} from './usertype';
import { FeedbackDTO } from './feedbackdto';
import { SportDTO } from './sportdto';

/**
 * Classe DTO di User. DEVE essere uguale (stesso nome classe, stessi attributi e stessi nomi) a
 * quello nel backend. 
 * 
 * @see Usertype
 * 
 * @author Vittorio Valent
 */
export class UserDTO {

   id: number;

   username: string;

   password: string;

   usertype: Usertype;

   status: boolean;

   received: FeedbackDTO[];

   like: SportDTO[];
}

