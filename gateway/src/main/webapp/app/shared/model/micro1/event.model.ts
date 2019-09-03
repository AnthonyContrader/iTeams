import { Moment } from 'moment';

export interface IEvent {
    id?: number;
    rate?: number;
    city?: string;
    address?: string;
    status?: boolean;
    matchtime?: Moment;
    sportName?: string;
    sportId?: number;
}

export class Event implements IEvent {
    constructor(
        public id?: number,
        public rate?: number,
        public city?: string,
        public address?: string,
        public status?: boolean,
        public matchtime?: Moment,
        public sportName?: string,
        public sportId?: number
    ) {
        this.status = this.status || false;
    }
}
