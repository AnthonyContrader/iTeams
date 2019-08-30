export interface IFeedback {
    id?: number;
    sportName?: string;
    creatorName?: string;
    rate?: number;
    sportId?: number;
    feedsportId?: number;
}

export class Feedback implements IFeedback {
    constructor(
        public id?: number,
        public sportName?: string,
        public creatorName?: string,
        public rate?: number,
        public sportId?: number,
        public feedsportId?: number
    ) {}
}
