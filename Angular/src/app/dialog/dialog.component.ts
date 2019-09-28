import { Component, Inject } from '@angular/core';
import {MAT_DIALOG_DATA} from '@angular/material/dialog';
import Quagga from 'quagga'; // ES6

//const Quagga = require('quagga').default;

@Component({
  selector: 'app-dialog',
  templateUrl: './dialog.component.html',
  styleUrls: ['./dialog.component.css']
})
export class DialogComponent {
  constructor(@Inject(MAT_DIALOG_DATA) public data: any) { }
}
