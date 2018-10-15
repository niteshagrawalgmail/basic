import { Injectable } from '@angular/core';

declare var toastr:any;

@Injectable({
  providedIn: 'root'
})
export class ToasterService {

  constructor() { }

  success(title: string, message: string ){
    toastr.success(title, message, {timeOut : 1000, positionClass: 'toast-bottom-center'})
  }
}
