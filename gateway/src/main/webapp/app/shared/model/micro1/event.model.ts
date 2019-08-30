export interface IEvent {
    id?: number;
    sportName?: string;
    rate?: number;
    city?: string;
    address?: string;
    matchtime?: string;
    status?: boolean;
    sportId?: number;
    eventsportId?: number;
}

export class Event implements IEvent {
    constructor(
        public id?: number,
        public sportName?: string,
        public rate?: number,
        public city?: string,
        public address?: string,
        public matchtime?: string,
        public status?: boolean,
        public sportId?: number,
        public eventsportId?: number
    ) {
        this.status = this.status || false;
    }
}
