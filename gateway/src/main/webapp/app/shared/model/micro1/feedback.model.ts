export interface IFeedback {
    id?: number;
    creatorName?: string;
    rate?: number;
    sportId?: number;
}

export class Feedback implements IFeedback {
    constructor(public id?: number, public creatorName?: string, public rate?: number, public sportId?: number) {}
}
