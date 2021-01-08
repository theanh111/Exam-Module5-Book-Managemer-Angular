import {NgModule} from '@angular/core';
import {ListComponent} from './list/list.component';
import {RouterModule, Routes} from '@angular/router';
import {CreateComponent} from './create/create.component';
import {UpdateComponent} from './update/update.component';
import {DeleteComponent} from './delete/delete.component';
import {DetailComponent} from './detail/detail.component';

const routes: Routes = [
  {
    path: '',
    component: ListComponent
  },
  {
    path: 'create',
    component: CreateComponent
  },
  {
    path: 'update/:id',
    component: UpdateComponent
  },
  {
    path: 'delete/:id',
    component: DeleteComponent
  },
  {
    path: 'detail/:id',
    component: DetailComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
