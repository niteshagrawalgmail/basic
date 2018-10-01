import { Component, ViewContainerRef  } from '@angular/core';

/* Importing ToastsManager library starts*/
//import { ToastsManager } from 'ng2-toastr/ng2-toastr';
/* Importing ToastsManager library ends*/

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'forms';

// constructor( private toastr: ToastsManager, private _vcr: ViewContainerRef) {
//     this.toastr.setRootViewContainerRef(_vcr);
// }

// private showSuccess(){
//     this.toastr.success("Success", 'You are on right track.');
// }


}
