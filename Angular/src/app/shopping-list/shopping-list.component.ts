import { Component, OnInit } from '@angular/core';
import { DialogComponent } from '../dialog/dialog.component';
import {MatDialog, MatDialogRef, MAT_DIALOG_DATA} from '@angular/material/dialog';
import { RestApiService } from '../shared/rest-api.service';
import { Ingredient } from '../shared/ingredient';


@Component({
  selector: 'app-shopping-list',
  templateUrl: './shopping-list.component.html',
  styleUrls: ['./shopping-list.component.css']
})
export class ShoppingListComponent implements OnInit {

  constructor(public dialog: MatDialog, public restApi: RestApiService) {  }
  ingredients: any[];

  vorname = 'Denise';
  name = 'Schwarze';



  ngOnInit() {
    this.loadIngredients();
  }


  loadIngredients() {
    /*const result = this.restApi.getIngredients().subscribe((data: {}) => {
      this.ingredients = [data];
    });
    if (result == null){*/
      const ingr: Ingredient[] = [
        new Ingredient('Paprika', '', 1),
        new Ingredient('Knoppers', '',  4),
        new Ingredient('Nusskuchen', '', 2),
        new Ingredient('Hühnersuppe', '', 1),
        new Ingredient( 'Mate', '', 10),
        new Ingredient('Cola', '', 1)];
      return ingr;
    /*} else {
          return result;
    }*/

  }

  openDialog(ingr: Ingredient): void {
    const dialogRef = this.dialog.open(DialogComponent,
      {
        width: '500px', data: { ingrName: ingr }
    });

    dialogRef.afterClosed().subscribe(result => {
      console.log('The dialog was closed');
      ingr.barcode = result;
    });
  }




}
