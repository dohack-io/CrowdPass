import 'hammerjs';
import { enableProdMode } from '@angular/core';
import { platformBrowserDynamic } from '@angular/platform-browser-dynamic';
import { environment } from './environments/environment';
import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { ShoppingListComponent } from './app/shopping-list/shopping-list.component';
import {MatListModule} from '@angular/material/list';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import {MatDialogModule, MatDialog, MatDialogRef, MAT_DIALOG_DATA} from '@angular/material/dialog';
import { DialogComponent } from './app/dialog/dialog.component';
import { BarecodeScannerLivestreamModule } from 'ngx-barcode-scanner';

import { AppComponent } from './app/app.component';

@NgModule({
  declarations: [
    AppComponent,
    ShoppingListComponent,
    DialogComponent
  ],
  entryComponents: [
    AppComponent
  ],
  imports: [
    BrowserModule,
    MatDialogModule,
    MatListModule,
    BrowserAnimationsModule,
    BarecodeScannerLivestreamModule
    ],
  providers: [ShoppingListComponent,  {provide: MatDialogRef, useValue: {}}],
  bootstrap: [AppComponent]
})
export class AppModule {}

if (environment.production) {
  enableProdMode();
}

platformBrowserDynamic().bootstrapModule(AppModule)
  .catch(err => console.error(err));
