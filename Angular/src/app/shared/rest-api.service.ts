import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable, throwError } from 'rxjs';
import { retry, catchError } from 'rxjs/operators';
import { Ingredient } from './ingredient';
import { Nutzer } from './nutzer';

@Injectable({
  providedIn: 'root'
})

export class RestApiService {

  // Define API
  apiURL = 'http://localhost:3000';

  constructor(private http: HttpClient) { }

  /*========================================
    CRUD Methods for consuming RESTful API
  =========================================*/

  // Http Options
  httpOptions = {
    headers: new HttpHeaders({
      'Content-Type': 'application/json'
    })
  }

  // HttpClient API get() method => Fetch nutzer list
  getNutzers(): Observable<Nutzer> {
    return this.http.get<Nutzer>(this.apiURL + '/nutzer')
    .pipe(
      retry(1),
      catchError(this.handleError)
    );
  }

// HttpClient API get() method => Fetch ingredient list
  getIngredients(): Observable<Ingredient> {
  return this.http.get<Ingredient>(this.apiURL + '/ingredients')
  .pipe(
    retry(1),
    catchError(this.handleError)
  );
}


 // HttpClient API get() method => Fetch nutzer
 getNutzer(id): Observable<Nutzer> {
  return this.http.get<Nutzer>(this.apiURL + '/nutzer/' + id)
  .pipe(
    retry(1),
    catchError(this.handleError)
  );
}

// HttpClient API get() method => Fetch ingredient
getIngredient(id): Observable<Ingredient> {
  return this.http.get<Ingredient>(this.apiURL + '/ingredients/' + id)
  .pipe(
    retry(1),
    catchError(this.handleError)
  );
}

// HttpClient API post() method => Create employee
createNutzer(nutzer): Observable<Nutzer> {
  return this.http.post<Nutzer>(this.apiURL + '/employees', JSON.stringify(nutzer), this.httpOptions)
  .pipe(
    retry(1),
    catchError(this.handleError)
  )
}

// HttpClient API post() method => Create ingredient
createIngredient(ingredient): Observable<Ingredient> {
  return this.http.post<Ingredient>(this.apiURL + '/ingredients', JSON.stringify(ingredient), this.httpOptions)
  .pipe(
    retry(1),
    catchError(this.handleError)
  )
}


// HttpClient API put() method => Update nutzer
updateNutzer(id, nutzer): Observable<Nutzer> {
  return this.http.put<Nutzer>(this.apiURL + '/nutzer/' + id, JSON.stringify(nutzer), this.httpOptions)
  .pipe(
    retry(1),
    catchError(this.handleError)
  );
}

// HttpClient API put() method => Update ingredient
updateIngredient(id, ingredient): Observable<Ingredient> {
  return this.http.put<Ingredient>(this.apiURL + '/ingredients/' + id, JSON.stringify(ingredient), this.httpOptions)
  .pipe(
    retry(1),
    catchError(this.handleError)
  );
}



// HttpClient API delete() method => Delete nutzer
deleteNutzer(id){
  return this.http.delete<Nutzer>(this.apiURL + '/nutzer/' + id, this.httpOptions)
  .pipe(
    retry(1),
    catchError(this.handleError)
  );
}


// HttpClient API delete() method => Delete ingredients
deleteIngredient(id){
  return this.http.delete<Ingredient>(this.apiURL + '/ingredients/' + id, this.httpOptions)
  .pipe(
    retry(1),
    catchError(this.handleError)
  )
}

// Error handling
handleError(error) {
  let errorMessage = '';
  if(error.error instanceof ErrorEvent) {
    // Get client-side error
    errorMessage = error.error.message;
  } else {
    // Get server-side error
    errorMessage = `Error Code: ${error.status}\nMessage: ${error.message}`;
  }
  window.alert(errorMessage);
  return throwError(errorMessage);
}

}
