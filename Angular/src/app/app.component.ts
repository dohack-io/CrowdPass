import { Component, OnInit } from '@angular/core';
import { RestApiService } from './shared/rest-api.service';
import { Nutzer } from './shared/nutzer';



@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})

export class AppComponent implements OnInit {

  constructor(public restApi: RestApiService) {}

  nutzer: any[];
  /*Dummy Data
  Nutzer[] = [new Nutzer('Iwan', 'Kornilow', 'korni'),
  new Nutzer('Valentin', 'Saks', 'russe'),
  new Nutzer('Denise', 'Schwarze', 'desch'),
  new Nutzer('Dimitri', 'Simonow', 'dimi')];
  */


 ngOnInit() {
  this.loadNutzer();
}

 loadNutzer() {
  /*const result = this.restApi.getNutzers().subscribe((data: {}) => {
    this.nutzer = [data];
  });
  if (result == null){*/
    const n: Nutzer[] = [new Nutzer('Iwan', 'Kornilow', 'korni'),
    new Nutzer('Valentin', 'Saks', 'russe'),
    new Nutzer('Denise', 'Schwarze', 'desch'),
    new Nutzer('Dimitri', 'Simonow', 'dimi')];
    return n;
  /*} else {
    return result;
  }*/
}

}
