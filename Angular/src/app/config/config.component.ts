import { Component, OnInit } from '@angular/core';
import { ConfigService, Config } from './config.service';
import { GestureConfig } from '@angular/material/core';

@Component({
  selector: 'app-config',
  templateUrl: './config.component.html',
  styleUrls: ['./config.component.css']
})
export class ConfigComponent implements OnInit {

  configService: ConfigService;
  constructor() { }

  ngOnInit() {
  }






}
