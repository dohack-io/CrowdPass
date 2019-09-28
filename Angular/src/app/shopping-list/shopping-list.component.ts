import { Component, OnInit } from '@angular/core';
import { DialogComponent } from '../dialog/dialog.component';
import {MatDialog, MatDialogRef, MAT_DIALOG_DATA} from '@angular/material/dialog';

@Component({
  selector: 'app-shopping-list',
  templateUrl: './shopping-list.component.html',
  styleUrls: ['./shopping-list.component.css']
})
export class ShoppingListComponent {

  constructor(public dialog: MatDialog) { }
  ingredients: string[] = ['Paprika', 'Knoppers', 'Nusskuchen', 'Hühnersuppe', 'Mate', 'Cola', 'Süßigkeiten'];


  vorname = 'Denise';
  name = 'Schwarze';


  barcode: string;


  openDialog(shoe: string): void {
    const dialogRef = this.dialog.open(DialogComponent,
      {
        width: '500px', data: { shoeName: shoe }
    });

    dialogRef.afterClosed().subscribe(result => {
      console.log('The dialog was closed');
      this.barcode = result;
    });
  }
}
