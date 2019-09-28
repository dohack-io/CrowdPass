import { Component, ViewChild, AfterViewInit, Inject, OnInit } from '@angular/core';
import {MAT_DIALOG_DATA} from '@angular/material/dialog';
import { BarecodeScannerLivestreamComponent } from 'ngx-barcode-scanner';

declare var Quagga: any;
//const Quagga = require('quagga').default;

@Component({
  selector: 'app-dialog',
  templateUrl: './dialog.component.html',
  styleUrls: ['./dialog.component.css']
})
export class DialogComponent implements AfterViewInit {
  constructor(@Inject(MAT_DIALOG_DATA) public data: any) { }

  @ViewChild(BarecodeScannerLivestreamComponent, {static: false})
    barecodeScanner: BarecodeScannerLivestreamComponent;

    barcodeValue;

    ngAfterViewInit() {
        this.barecodeScanner.start();
    }

    onValueChanges(result) {
        this.barcodeValue = result.codeResult.code;
    }
}
