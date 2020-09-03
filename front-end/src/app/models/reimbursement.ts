import { User } from './user';
import { Type } from '@angular/core';

export class Reimbursement {
    public id: number;
    public amount: number;
    public timeSubmitted: number;
    public timeResolved: number;
    public description: string;
    public author: User;
    public resolver: User;
    public status: RStatus;
    public type: RType;
}

export class RStatus {
    public id: number;
    public name: string;
}

export class RType {
    public id: number;
    public name: string;
}
