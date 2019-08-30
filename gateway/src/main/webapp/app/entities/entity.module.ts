import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';

import { GatewaySportModule as Micro1SportModule } from './micro1/sport/sport.module';
import { GatewayEventModule as Micro1EventModule } from './micro1/event/event.module';
import { GatewayFeedbackModule as Micro1FeedbackModule } from './micro1/feedback/feedback.module';
import { GatewayTeamModule as Micro1TeamModule } from './micro1/team/team.module';
import { GatewayMessageModule as Micro1MessageModule } from './micro1/message/message.module';
/* jhipster-needle-add-entity-module-import - JHipster will add entity modules imports here */

@NgModule({
    // prettier-ignore
    imports: [
        Micro1SportModule,
        Micro1EventModule,
        Micro1FeedbackModule,
        Micro1TeamModule,
        Micro1MessageModule,
        /* jhipster-needle-add-entity-module - JHipster will add entity modules here */
    ],
    declarations: [],
    entryComponents: [],
    providers: [],
    schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class GatewayEntityModule {}
