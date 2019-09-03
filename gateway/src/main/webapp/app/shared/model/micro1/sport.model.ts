import { IEvent } from 'app/shared/model/micro1/event.model';
import { IFeedback } from 'app/shared/model/micro1/feedback.model';

export interface ISport {
    id?: number;
    name?: string;
    players?: number;
    events?: IEvent[];
    feeds?: IFeedback[];
}

export class Sport implements ISport {
    constructor(public id?: number, public name?: string, public players?: number, public events?: IEvent[], public feeds?: IFeedback[]) {}
}
