import { browser, ExpectedConditions as ec, protractor } from 'protractor';
import { NavBarPage, SignInPage } from '../../../page-objects/jhi-page-objects';

import { EventComponentsPage, EventUpdatePage } from './event.page-object';

describe('Event e2e test', () => {
    let navBarPage: NavBarPage;
    let signInPage: SignInPage;
    let eventUpdatePage: EventUpdatePage;
    let eventComponentsPage: EventComponentsPage;

    beforeAll(async () => {
        await browser.get('/');
        navBarPage = new NavBarPage();
        signInPage = await navBarPage.getSignInPage();
        await signInPage.autoSignInUsing('admin', 'admin');
        await browser.wait(ec.visibilityOf(navBarPage.entityMenu), 5000);
    });

    it('should load Events', async () => {
        await navBarPage.goToEntity('event');
        eventComponentsPage = new EventComponentsPage();
        expect(await eventComponentsPage.getTitle()).toMatch(/gatewayApp.micro1Event.home.title/);
    });

    it('should load create Event page', async () => {
        await eventComponentsPage.clickOnCreateButton();
        eventUpdatePage = new EventUpdatePage();
        expect(await eventUpdatePage.getPageTitle()).toMatch(/gatewayApp.micro1Event.home.createOrEditLabel/);
        await eventUpdatePage.cancel();
    });

    /* it('should create and save Events', async () => {
        await eventComponentsPage.clickOnCreateButton();
        await eventUpdatePage.setRateInput('5');
        expect(await eventUpdatePage.getRateInput()).toMatch('5');
        await eventUpdatePage.setCityInput('city');
        expect(await eventUpdatePage.getCityInput()).toMatch('city');
        await eventUpdatePage.setAddressInput('address');
        expect(await eventUpdatePage.getAddressInput()).toMatch('address');
        const selectedStatus = eventUpdatePage.getStatusInput();
        if (await selectedStatus.isSelected()) {
            await eventUpdatePage.getStatusInput().click();
            expect(await eventUpdatePage.getStatusInput().isSelected()).toBeFalsy();
        } else {
            await eventUpdatePage.getStatusInput().click();
            expect(await eventUpdatePage.getStatusInput().isSelected()).toBeTruthy();
        }
        await eventUpdatePage.setMatchtimeInput('01/01/2001' + protractor.Key.TAB + '02:30AM');
        expect(await eventUpdatePage.getMatchtimeInput()).toContain('2001-01-01T02:30');
        await eventUpdatePage.sportSelectLastOption();
        await eventUpdatePage.save();
        expect(await eventUpdatePage.getSaveButton().isPresent()).toBeFalsy();
    });*/

    afterAll(async () => {
        await navBarPage.autoSignOut();
    });
});
