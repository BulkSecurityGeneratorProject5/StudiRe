export interface IStudent {
    id?: number;
    matrikelNummer?: number;
    nachname?: string;
    vorname?: string;
    street?: string;
    plz?: number;
    location?: string;
}

export class Student implements IStudent {
    constructor(
        public id?: number,
        public matrikelNummer?: number,
        public nachname?: string,
        public vorname?: string,
        public street?: string,
        public plz?: number,
        public location?: string
    ) {}
}
