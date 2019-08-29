import { browser, ExpectedConditions as ec } from 'protractor';
import { NavBarPage, SignInPage } from '../../../page-objects/jhi-page-objects';

import { SportComponentsPage, SportUpdatePage } from './sport.page-object';

describe('Sport e2e test', () => {
    let navBarPage: NavBarPage;
    let signInPage: SignInPage;
    let sportUpdatePage: SportUpdatePage;
    let sportComponentsPage: SportComponentsPage;

    beforeAll(async () => {
        await browser.get('/');
        navBarPage = new NavBarPage();
        signInPage = await navBarPage.getSignInPage();
        await signInPage.autoSignInUsing('admin', 'admin');
        await browser.wait(ec.visibilityOf(navBarPage.entityMenu), 5000);
    });

    it('should load Sports', async () => {
        await navBarPage.goToEntity('sport');
        sportComponentsPage = new SportComponentsPage();
        expect(await sportComponentsPage.getTitle()).toMatch(/Sports/);
    });

    it('should load create Sport page', async () => {
        await sportComponentsPage.clickOnCreateButton();
        sportUpdatePage = new SportUpdatePage();
        expect(await sportUpdatePage.getPageTitle()).toMatch(/Create or edit a Sport/);
        await sportUpdatePage.cancel();
    });

    it('should create and save Sports', async () => {
        await sportComponentsPage.clickOnCreateButton();
        await sportUpdatePage.setNameInput('name');
        expect(await sportUpdatePage.getNameInput()).toMatch('name');
        await sportUpdatePage.setPlayersInput('5');
        expect(await sportUpdatePage.getPlayersInput()).toMatch('5');
        await sportUpdatePage.save();
        expect(await sportUpdatePage.getSaveButton().isPresent()).toBeFalsy();
    });

    afterAll(async () => {
        await navBarPage.autoSignOut();
    });
});
