export interface IMessage {
    id?: number;
    text?: string;
}

export class Message implements IMessage {
    constructor(public id?: number, public text?: string) {}
}
