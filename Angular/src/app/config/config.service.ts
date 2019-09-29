import { Injectable } from '@angular/core';
import { HttpClient, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs';


export interface Config {
  nutzerUrl: string;
  textfile: string;
}


@Injectable()
export class ConfigService {
  configService: any;
  headers: any;
  constructor(private http: HttpClient) { }

  configUrl = 'assets/config.json';
  config: Config;


  getConfig() {
    // now returns an Observable of Config
    //return this.http.get<Config>(this.configUrl);
  }


showConfig() {
  this.configService.getConfig()
    // clone the data object, using its known Config shape
    .subscribe(data => this.config = {
      nutzerUrl: (data as any).nutzerUrl,
      textfile:  (data as any).textfile,
     });
    }


  getConfigResponse(): Observable<HttpResponse<Config>> {
      return this.http.get<Config>(
        this.configUrl, { observe: 'response' });
  }

  showConfigResponse() {
    this.configService.getConfigResponse()
      // resp is of type `HttpResponse<Config>`
      .subscribe(resp => {
        // display its headers
        const keys = resp.headers.keys();
        this.headers = keys.map(key =>
          `${key}: ${resp.headers.get(key)}`);

        // access the body directly, which is typed as `Config`.
        this.config = { ... resp.body };
      });
  }
}

