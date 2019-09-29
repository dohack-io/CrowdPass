import { Component, OnInit } from '@angular/core';
import { Nutzer } from './shared/nutzer';
//import { RestApiService } from '../shared/rest-api.service';


@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})

export class AppComponent implements OnInit {

  //public restApi: RestApiService (in constructor)
  constructor() {}

  nutzer: Nutzer[] = [new Nutzer('Iwan', 'Kornilow', 'korni'),
  new Nutzer('Valentin', 'Saks', 'russe'),
  new Nutzer('Denise', 'Schwarze', 'desch'),
  new Nutzer('Dimitri', 'Simonow', 'dimi')];



 ngOnInit() {
  //this.loadNutzer();
}

 /*loadNutzer() {
    return this.restApi.getNutzers().subscribe((data: {}) => {
      this.nutzer = [data];
    });
  }*/

}
