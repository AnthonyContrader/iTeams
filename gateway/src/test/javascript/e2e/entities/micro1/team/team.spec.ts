import { browser, ExpectedConditions as ec } from 'protractor';
import { NavBarPage, SignInPage } from '../../../page-objects/jhi-page-objects';

import { TeamComponentsPage, TeamUpdatePage } from './team.page-object';

describe('Team e2e test', () => {
    let navBarPage: NavBarPage;
    let signInPage: SignInPage;
    let teamUpdatePage: TeamUpdatePage;
    let teamComponentsPage: TeamComponentsPage;

    beforeAll(async () => {
        await browser.get('/');
        navBarPage = new NavBarPage();
        signInPage = await navBarPage.getSignInPage();
        await signInPage.autoSignInUsing('admin', 'admin');
        await browser.wait(ec.visibilityOf(navBarPage.entityMenu), 5000);
    });

    it('should load Teams', async () => {
        await navBarPage.goToEntity('team');
        teamComponentsPage = new TeamComponentsPage();
        expect(await teamComponentsPage.getTitle()).toMatch(/gatewayApp.micro1Team.home.title/);
    });

    it('should load create Team page', async () => {
        await teamComponentsPage.clickOnCreateButton();
        teamUpdatePage = new TeamUpdatePage();
        expect(await teamUpdatePage.getPageTitle()).toMatch(/gatewayApp.micro1Team.home.createOrEditLabel/);
        await teamUpdatePage.cancel();
    });

    it('should create and save Teams', async () => {
        await teamComponentsPage.clickOnCreateButton();
        await teamUpdatePage.setNameInput('name');
        expect(await teamUpdatePage.getNameInput()).toMatch('name');
        await teamUpdatePage.save();
        expect(await teamUpdatePage.getSaveButton().isPresent()).toBeFalsy();
    });

    afterAll(async () => {
        await navBarPage.autoSignOut();
    });
});
