import { Employee } from './employee';
import { Type } from '@angular/core';

export class Reimbursement {
    public id: number;
    public amount: number;
    public timeSubmitted: number;
    public timeResolved: number;
    public description: string;
    public author: Employee;
    public resolver: Employee;
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
