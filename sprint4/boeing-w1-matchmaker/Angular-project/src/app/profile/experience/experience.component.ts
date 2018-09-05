import { Component, OnInit } from '@angular/core';
import { UserService } from '../../user.service';
import { UserExp } from '../../userExp';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { FormControl } from '@angular/forms';
import { AutocompleteService } from '../../autocomplete.service';


@Component({
 selector: 'app-experience',
 templateUrl: './experience.component.html',
 styleUrls: ['./experience.component.css'],
 providers: [UserService]
})
export class ExperienceComponent implements OnInit {
 private newPost_Exp ;
 private getPost_Exp;
 private editPost_Exp;
 searchTerm: FormControl = new FormControl();
 company = <any>[];
 private firstTime_check = false;
 UserData: any = [];

 constructor(private userService: UserService, private http: HttpClient,
   private autocomplete: AutocompleteService) {
  }

 ngOnInit() {
  this.searchTerm.valueChanges.subscribe(term => {
    if (term !== '') {
      this.autocomplete.searchCompany(term).subscribe(data => {
        this.company = data as any[];
      });
    }
  });
   this.newPost_Exp = new UserExp();
   this.editPost_Exp = new UserExp();
   this.getExperience();
 }

  addPost_Exp() {
   this.newPost_Exp.profileId = JSON.parse(localStorage.getItem('currentUser'));
   this.newPost_Exp.message = 'save';
   this.userService.addPost_Exp(this.newPost_Exp).subscribe(() => {});
   setTimeout(() => {
    this.getExperience();
    }, 1000);
   }
   update(j) {
     this.editPost_Exp[j].profileId = JSON.parse(localStorage.getItem('currentUser'));
     this.editPost_Exp[j].message = 'update' + j;
     this.userService.addPost_Exp(this.editPost_Exp[j]).subscribe(() => {  });
   }

   delete(j) {
     this.editPost_Exp[j].profileId = JSON.parse(localStorage.getItem('currentUser'));
     this.editPost_Exp[j].message = 'delete' + j;
     this.userService.addPost_Exp(this.editPost_Exp[j]).subscribe(() => {  });
     setTimeout(() => {
      this.getExperience();
      }, 1000);
  }

   getExperience() {
     this.get().subscribe( data => {
        this.UserData = data;
        this.editPost_Exp = data.experience;
        if (this.UserData.experience == null) {
          this.firstTime_check = false;
        } else {
          this.firstTime_check = true;
        }
      });

}
get(): Observable<any> {
 return this.http.get(`http://13.232.19.29:8092/downstream/api/v1/user/${JSON.parse(localStorage.getItem('currentUser'))}`);
}
}
