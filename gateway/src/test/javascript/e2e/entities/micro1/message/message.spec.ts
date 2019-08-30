import { browser, ExpectedConditions as ec } from 'protractor';
import { NavBarPage, SignInPage } from '../../../page-objects/jhi-page-objects';

import { MessageComponentsPage, MessageUpdatePage } from './message.page-object';

describe('Message e2e test', () => {
    let navBarPage: NavBarPage;
    let signInPage: SignInPage;
    let messageUpdatePage: MessageUpdatePage;
    let messageComponentsPage: MessageComponentsPage;

    beforeAll(async () => {
        await browser.get('/');
        navBarPage = new NavBarPage();
        signInPage = await navBarPage.getSignInPage();
        await signInPage.autoSignInUsing('admin', 'admin');
        await browser.wait(ec.visibilityOf(navBarPage.entityMenu), 5000);
    });

    it('should load Messages', async () => {
        await navBarPage.goToEntity('message');
        messageComponentsPage = new MessageComponentsPage();
        expect(await messageComponentsPage.getTitle()).toMatch(/Messages/);
    });

    it('should load create Message page', async () => {
        await messageComponentsPage.clickOnCreateButton();
        messageUpdatePage = new MessageUpdatePage();
        expect(await messageUpdatePage.getPageTitle()).toMatch(/Create or edit a Message/);
        await messageUpdatePage.cancel();
    });

    it('should create and save Messages', async () => {
        await messageComponentsPage.clickOnCreateButton();
        await messageUpdatePage.setTextInput('text');
        expect(await messageUpdatePage.getTextInput()).toMatch('text');
        await messageUpdatePage.save();
        expect(await messageUpdatePage.getSaveButton().isPresent()).toBeFalsy();
    });

    afterAll(async () => {
        await navBarPage.autoSignOut();
    });
});
