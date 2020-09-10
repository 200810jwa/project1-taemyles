import { User } from './user';
import { Type } from '@angular/core';

export class Reimbursement {
    public id: number;
    public amount: number;
    public timeSubmitted: Date;
    public timeResolved: Date;
    public description: string;
    public receipt: Uint8Array;
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