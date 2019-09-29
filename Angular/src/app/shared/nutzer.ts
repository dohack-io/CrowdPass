export class Nutzer {
  lastName: string;
  firstName: string;
  username: string;

  constructor(firstName: string, name: string, username: string) {
    this.lastName = name;
    this.firstName = firstName;
    this.username = username;
  }
}
