import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AdminactivitiesComponent } from './components/adminactivities/adminactivities.component';
import { AdminregComponent } from './components/adminreg/adminreg.component';
import { SetupComponent } from './components/setup/setup.component';
import { ClientpageComponent} from './components/clientpage/clientpage.component';

const routes: Routes = [{ path:'setup', component: SetupComponent},
                        {path:'adminreg',component: AdminregComponent},
                      {path:'adminactivities',component:AdminactivitiesComponent},
                    {path:'clientpage',component: ClientpageComponent}];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
