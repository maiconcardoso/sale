export class Client {
    id: number;
    name: string;
    cpf: string;
    registaryDate: string;

    constructor(id: number, name: string, cpf: string, registaryDate: string) {
        this.id = id;
        this.name = name;
        this.cpf = cpf;
        this.registaryDate = registaryDate;
    }
}