import { HttpClientModule } from '@angular/common/http';
import { NgModule } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';
import { RouterModule } from '@angular/router';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './login/login.component';
import { RegistrationComponent } from './registration/registration.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MatToolbarModule } from '@angular/material/toolbar';
import { MatButtonModule } from '@angular/material/button';
import { MatIconModule } from '@angular/material/icon';
import { MatCheckboxModule } from '@angular/material/checkbox';
import { MatDialogModule } from '@angular/material/dialog';
import { MatExpansionModule } from '@angular/material/expansion';
import { MatInputModule } from '@angular/material/input';
import { TodosComponent } from './todos/todos.component';
import { MatFormFieldModule } from '@angular/material/form-field';
import { TodoDialog } from './dialogs/todo-dialog';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    RegistrationComponent,
    TodosComponent,
    TodoDialog,
  ],
  imports: [
    BrowserModule,
    RouterModule,
    BrowserAnimationsModule,
    FormsModule,
    MatFormFieldModule,
    ReactiveFormsModule,
    HttpClientModule,
    AppRoutingModule,
    MatToolbarModule,
    MatButtonModule,
    MatIconModule,
    MatCheckboxModule,
    MatDialogModule,
    MatExpansionModule,
    MatInputModule,
  ],
  providers: [],
  bootstrap: [AppComponent],
})
export class AppModule {}
