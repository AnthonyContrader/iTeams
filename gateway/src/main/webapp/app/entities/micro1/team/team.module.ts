import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { RouterModule } from '@angular/router';

import { GatewaySharedModule } from 'app/shared';
import {
    TeamComponent,
    TeamDetailComponent,
    TeamUpdateComponent,
    TeamDeletePopupComponent,
    TeamDeleteDialogComponent,
    teamRoute,
    teamPopupRoute
} from './';

const ENTITY_STATES = [...teamRoute, ...teamPopupRoute];

@NgModule({
    imports: [GatewaySharedModule, RouterModule.forChild(ENTITY_STATES)],
    declarations: [TeamComponent, TeamDetailComponent, TeamUpdateComponent, TeamDeleteDialogComponent, TeamDeletePopupComponent],
    entryComponents: [TeamComponent, TeamUpdateComponent, TeamDeleteDialogComponent, TeamDeletePopupComponent],
    schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class GatewayTeamModule {}
