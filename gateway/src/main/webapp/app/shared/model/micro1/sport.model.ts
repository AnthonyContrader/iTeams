export interface ISport {
    id?: number;
    name?: string;
    players?: number;
}

export class Sport implements ISport {
    constructor(public id?: number, public name?: string, public players?: number) {}
}
