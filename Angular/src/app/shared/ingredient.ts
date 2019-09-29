export class Ingredient {
  name: string;
  barcode: string;
  amount: number;

  constructor( name: string, barcode: string, amount: number) {
    this.name = name;
    this.barcode = barcode;
    this.amount = amount;
  }
}
